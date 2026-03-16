/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabsystems.db;

//exception imports
import java.sql.SQLException;

//database imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author faith
 */
public class DBConnection {
    //attributes
    String driver = "com.mysql.cj.jdbc.Driver";
    String path = "jdbc:mysql://localhost:3306/fabdb";
    String username = "root";
    String password = "faith123";
    Connection con = null;
    Statement stmt = null;
    PreparedStatement ps = null;
    
    //method connect to database
    public void connect() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        con = (Connection) DriverManager.getConnection(path, username, password);
    }
    
    //close connections
    public void closeConnection() throws SQLException{
        con.close();
    }
    
    public void closePreparedStatement() throws SQLException{
        ps.close();
    }
    
    public void closeStatement() throws SQLException{
        stmt.close();
    }
    
    //create statements and prepared statements
    public void createStatement() throws SQLException{
        stmt = con.createStatement();
    }
    
    public void createPreparedStatement(String query) throws SQLException{
        ps = con.prepareStatement(query);
    }
    
    //get statements and prepared statements
    public PreparedStatement getPreparedStatement(){
        return ps;
    }
    
    public Statement getStatement(){
        return stmt;
    }
    
    //get database connection
    public Connection getConnection(){
        return con;
    }
}
