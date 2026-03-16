/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabpointofsalesystem.db;

//package imports
import com.fabsystems.db.DBConnection;
import com.fabsystems.main.Product;

//exception imports
import java.sql.SQLException;

//database imports
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**
 *
 * @author faith
 */
public class OrderIO {

    //attributes
    private ResultSet rs;
    private DBConnection dbc = new DBConnection();

    //behaviors
    //compares the logged in user to users in mysql admin privilege table to see if they get access to the pos page
    public void pointOfSaleAuth(String u, JPanel mainPanel, JPanel panel) throws ClassNotFoundException, NullPointerException {

        try {
            dbc.connect();
            dbc.createPreparedStatement("SELECT admin_Username FROM adminPrivilege WHERE admin_Username=?");
            dbc.getPreparedStatement().setString(1, u);
            rs = dbc.getPreparedStatement().executeQuery();

            if (rs.next() == true) {

                mainPanel.removeAll();
                mainPanel.add(panel);
                mainPanel.revalidate();
                mainPanel.validate();
            } else {
                JOptionPane.showMessageDialog(null, "You need admin privileges to use this application.");

            }
            rs.close();
            dbc.closePreparedStatement();
            dbc.closeConnection();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //getting the row count of database orders table to set the current order to row count + 1
    public int retrieveOrderRowCount() throws ClassNotFoundException, SQLException{
        dbc.connect();
        dbc.createStatement();
        String query = "SELECT COUNT(*) FROM orders";
        rs = dbc.getStatement().executeQuery(query);
        
        rs.next();
        
        int count = rs.getInt(1);
        return count;
    }  
    
    //verify sku and quantity input with data in the mysql products table and then grab id, name, sku, and price from products table
    public ArrayList<Product> getOrderProduct(String sku, int q) throws SQLException, ClassNotFoundException {

        //create the arraylist to return
        ArrayList<Product> pOrderList = new ArrayList<Product>();

        //connect to database
        dbc.connect();

        dbc.createPreparedStatement("SELECT product_Id, product_Name, product_Sku, product_Quantity, product_SalePrice FROM products WHERE product_Sku=?");
        dbc.getPreparedStatement().setString(1, sku);
        
        rs = dbc.getPreparedStatement().executeQuery();
        
        if(rs.next() == true) {
            int lId = rs.getInt("product_Id");
            String lName = rs.getString("product_Name");
            String lSku = rs.getString("product_Sku");
            int lQuan = rs.getInt("product_Quantity");
            Double lPrice = rs.getDouble("product_SalePrice");
            
            
            if(lQuan == 0){ 
                JOptionPane.showMessageDialog(null, "Out of Stock");
            }else if(q > lQuan || q < 0){ 
                 JOptionPane.showMessageDialog(null, "The total quantity on hand is " + lQuan + ". Enter an amount within this range.");
            }else{
                Product p = new Product();
                p.setProductID(lId);
                p.setProductName(lName);
                p.setProductSku(lSku);
                p.setProductQuantity(lQuan);
                p.setProductSalePrice(lPrice);
                
                pOrderList.add(p);
            }
        }else if(rs.next() == false){
            JOptionPane.showMessageDialog(null, "The sku you entered is not in the system.");
        }
        

        //close connection
        rs.close();
        dbc.closePreparedStatement();
        dbc.closeConnection();
        return pOrderList;
    }
    
    //add order data to mysql order table
    public void addOrder(int oId, Double oT, String oDT) throws ClassNotFoundException, SQLException{
        
        dbc.connect();
        dbc.createPreparedStatement("INSERT INTO orders(order_Id, order_Total, order_DateTime) VALUES(?,?,?)");
        dbc.getPreparedStatement().setInt(1, oId);
        dbc.getPreparedStatement().setDouble(2, oT);
        dbc.getPreparedStatement().setString(3, oDT);

        dbc.getPreparedStatement().executeUpdate();
        
        dbc.closePreparedStatement();
        dbc.closeConnection();
    }
    
    //when order data saved update mysql product table by subtracting product quantities in cart from quantities stored in product table
    public void updateProductCounts(int q, String lName) throws ClassNotFoundException, SQLException{
        dbc.connect();
        
        dbc.createPreparedStatement("SELECT product_Quantity FROM products WHERE product_Name=?");
        dbc.getPreparedStatement().setString(1, lName);
        rs = dbc.getPreparedStatement().executeQuery();
        int quan = 0;
        while(rs.next()){
            quan = rs.getInt("product_Quantity");
        }
        dbc.createPreparedStatement("UPDATE products SET product_Quantity=? WHERE product_Name=?");
        int newQuan = quan - q;
        dbc.getPreparedStatement().setInt(1, newQuan);
        dbc.getPreparedStatement().setString(2, lName);
        

        dbc.getPreparedStatement().executeUpdate();
        JOptionPane.showMessageDialog(null, "Product updated successfully!");
        rs.close();
        
        dbc.closePreparedStatement();
        dbc.closeConnection();

    }
    
    
    //add order item data to mysql order_items table/ order_quantity, product_Id, order_Id
    public void addOrderItems(int qty, int pid, int oid) throws ClassNotFoundException, SQLException{
        
        dbc.connect();
        dbc.createPreparedStatement("INSERT INTO order_items(order_items_Qty, product_Id, order_Id) VALUES(?,?,?)");
        dbc.getPreparedStatement().setInt(1, qty);
        dbc.getPreparedStatement().setInt(2, pid);
        dbc.getPreparedStatement().setInt(3, oid);
        
        dbc.getPreparedStatement().executeUpdate();
        
        dbc.closePreparedStatement();
        dbc.closeConnection();
    }
    
    //add payment data to mysql payment table
    public void addPayment(String paymentType) throws ClassNotFoundException, SQLException{
        
        dbc.connect();
        
        dbc.createPreparedStatement("SELECT order_Id FROM orders");
        rs = dbc.getPreparedStatement().executeQuery();
        int oId = 0;
        while(rs.next()){
            oId = rs.getInt("order_Id");
        }
        dbc.createPreparedStatement("INSERT INTO payments(payment_Type, order_Id) VALUES(?,?)");
        dbc.getPreparedStatement().setString(1, paymentType);
        dbc.getPreparedStatement().setInt(2, oId);

        dbc.getPreparedStatement().executeUpdate();
        
        dbc.closePreparedStatement();
        dbc.closeConnection();
    }
        
}
