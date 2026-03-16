/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabsystems.db;

//package imports
import com.fabsystems.db.DBConnection;
import com.fabsystems.main.Product;


//general imports
import java.util.ArrayList;

//exception imports
import java.sql.SQLException;

//database imports
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;


//swing imports
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author faith
 */
public class ProductIO {

    //attributes
    private ResultSet rs;
    private DBConnection dbc = new DBConnection();

    //retrieves product data stored in mysql products table for displaying in product Jtable
    public ArrayList<Product> getProductList() throws SQLException, ClassNotFoundException {

        //create the arraylist to return
        ArrayList<Product> pList = new ArrayList<Product>();

        //connect to database
        dbc.connect();

        dbc.createStatement();
        String query = "SELECT * FROM products";
        rs = dbc.getStatement().executeQuery(query);

        while (rs.next()) {
            Product p = new Product();
            p.setProductID(rs.getInt(1));
            p.setProductName(rs.getString(2));
            p.setProductSku(rs.getString(3));
            p.setProductDescription(rs.getString(4));
            p.setProductSupplier(rs.getString(5));
            p.setProductUnitCost(rs.getDouble(6));
            p.setProductSalePrice(rs.getDouble(7));
            p.setProductQuantity(rs.getInt(8));
            p.setProductTotalValue(rs.getDouble(9));

            pList.add(p);
        }

        //close connection
        rs.close();
        dbc.closeStatement();
        dbc.closeConnection();

        //return list
        return pList;
    }

    //adds product entered by user to mysql products table
    public void addProducts(Product p, JTextField tpa) throws ClassNotFoundException, SQLException {

        dbc.connect();
        dbc.createPreparedStatement("SELECT product_Name, product_Sku FROM products WHERE product_Name=? OR product_Sku=?");
        dbc.getPreparedStatement().setString(1, p.getProductName());
        dbc.getPreparedStatement().setString(2, p.getProductSku());

        rs = dbc.getPreparedStatement().executeQuery();

        if (rs.next() == true) {
            JOptionPane.showMessageDialog(null, "The product you entered is already in the system.");
            tpa.requestFocus();
  
        } else {
            try {

                dbc.createPreparedStatement("INSERT INTO products(product_Name, product_Sku, product_Description, "
                        + "product_Supplier, product_UnitCost, product_SalePrice, product_Quantity, product_TotalValue) "
                        + "VALUES(?,?,?,?,?,?,?,?)");

                dbc.getPreparedStatement().setString(1, p.getProductName());
                dbc.getPreparedStatement().setString(2, p.getProductSku());
                dbc.getPreparedStatement().setString(3, p.getProductDescription());
                dbc.getPreparedStatement().setString(4, p.getProductSupplier());
                dbc.getPreparedStatement().setDouble(5, p.getProductUnitCost());
                dbc.getPreparedStatement().setDouble(6, p.getProductSalePrice());
                dbc.getPreparedStatement().setInt(7, p.getProductQuantity());
                dbc.getPreparedStatement().setDouble(8, p.getProductTotalValue());

                dbc.getPreparedStatement().executeUpdate();
                JOptionPane.showMessageDialog(null, "Product entered successfully.");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            dbc.closePreparedStatement();
            dbc.closeConnection();
        }

    }

    //updates product to mysql products table after user makes changes
    public void updateProduct(Product p) throws ClassNotFoundException, SQLException {

        dbc.connect();
        dbc.createPreparedStatement("UPDATE products SET product_Name=?, product_Sku=?, product_Description=?, product_Supplier=?,"
                + " product_UnitCost=?, product_SalePrice=?, product_Quantity=?, product_TotalValue=? WHERE product_Name=?");
        dbc.getPreparedStatement().setString(1, p.getProductName());
        dbc.getPreparedStatement().setString(2, p.getProductSku());
        dbc.getPreparedStatement().setString(3, p.getProductDescription());
        dbc.getPreparedStatement().setString(4, p.getProductSupplier());
        dbc.getPreparedStatement().setDouble(5, p.getProductUnitCost());
        dbc.getPreparedStatement().setDouble(6, p.getProductSalePrice());
        dbc.getPreparedStatement().setInt(7, p.getProductQuantity());
        dbc.getPreparedStatement().setDouble(8, p.getProductTotalValue());
        dbc.getPreparedStatement().setString(9, p.getProductName());

        dbc.getPreparedStatement().executeUpdate();

        dbc.closePreparedStatement();
        dbc.closeConnection();

        JOptionPane.showMessageDialog(null, "Product updated successfully!");

    }

    //removes product from mysql products table
    public void removeProduct(String value) throws SQLException, ClassNotFoundException {

        dbc.connect();
        
        dbc.createPreparedStatement("DELETE FROM products WHERE product_Name=?");
        dbc.getPreparedStatement().setString(1, value);
        dbc.getPreparedStatement().executeUpdate();
        
        dbc.closePreparedStatement();
        dbc.closeConnection();
        
        JOptionPane.showMessageDialog(null, "Product deleted successfully!");

    }
}
