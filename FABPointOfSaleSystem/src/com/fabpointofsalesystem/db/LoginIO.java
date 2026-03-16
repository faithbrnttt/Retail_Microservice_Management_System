/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabpointofsalesystem.db;

//package imports
import com.fabpointofsalesystem.login.GeneralUser;
import com.fabpointofsalesystem.main.PointOfSaleForm;
import com.fabsystems.db.DBConnection;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
//swing imports
import javax.swing.JOptionPane;

//exception imports
import java.sql.SQLException;

//database imports
import java.sql.ResultSet;

/**
 *
 * @author faith
 */
public class LoginIO {

    //attributes 
    private ResultSet rs;
    private DBConnection dbc = new DBConnection();

    //behaviors
    //method authenticates users stored in database and if authenticated navigates to the main page
    public void loginAuth(GeneralUser u) throws ClassNotFoundException, SQLException {

        try {
            
            dbc.connect();
           
            dbc.createPreparedStatement("SELECT employee_Username, employee_Password FROM employees WHERE employee_Username=? AND employee_Password=?");
            
            dbc.getPreparedStatement().setString(1, u.getUsername());
            dbc.getPreparedStatement().setString(2, u.getPassword());

            rs = dbc.getPreparedStatement().executeQuery();
          
            if (rs.next() == false) {

                dbc.createPreparedStatement("SELECT admin_Username, admin_Password FROM adminprivilege WHERE admin_Username=? AND admin_Password=?");
                dbc.getPreparedStatement().setString(1, u.getUsername());
                dbc.getPreparedStatement().setString(2, u.getPassword());

                rs = dbc.getPreparedStatement().executeQuery();

                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(null, "Access Denied");
                } else {
                    PointOfSaleForm posf = new PointOfSaleForm();
                    String user = u.getUsername();
                    posf.username(user);
                    posf.setVisible(true);
                }
            } else{
                
                PointOfSaleForm posf = new PointOfSaleForm();
                String user = u.getUsername();
                posf.username(user);
                posf.setVisible(true);

            }
            rs.close();
            dbc.closePreparedStatement();
            dbc.closeConnection();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
        }
    }
}
