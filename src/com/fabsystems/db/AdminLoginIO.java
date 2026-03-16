/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabsystems.db;

import com.fabsystems.main.MainForm;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author faith
 */
public class AdminLoginIO {
    //attributes 
    private ResultSet rs;
    private DBConnection dbc = new DBConnection();

    //behaviors
    //method authenticates users stored in database and if authenticated navigates to the main page
    public void adminAuth(String username, String password) throws ClassNotFoundException, SQLException {
        
       
        try {
            
            dbc.connect();
            
            dbc.createPreparedStatement("SELECT admin_Username, admin_Password FROM adminprivilege WHERE admin_Username=? AND admin_Password=?");

            dbc.getPreparedStatement().setString(1, username);
            dbc.getPreparedStatement().setString(2, password);
            
            rs = dbc.getPreparedStatement().executeQuery();

            if (rs.next() == false) {
                JOptionPane.showMessageDialog(null, "Access Denied");
            } else {

                MainForm mf = new MainForm();
                mf.username(username);
                mf.setVisible(true);

            }
            rs.close();
            dbc.closePreparedStatement();
            dbc.closeConnection();
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
        }
    }
}
