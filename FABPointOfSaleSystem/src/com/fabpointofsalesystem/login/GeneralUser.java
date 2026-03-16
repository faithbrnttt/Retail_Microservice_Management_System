/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabpointofsalesystem.login;

/**
 *
 * @author faith
 */
public class GeneralUser {

    //attributes
    private String username;
    private String password;

    //constructors
    public GeneralUser() {
        username = "n/a";
        password = "n/a";
       
    }

    public GeneralUser(String username, String password) {
        this.username = username;
        this.password = password;
       
    }

    //behaviors

    @Override
    public String toString() {
        return "Users{" + "username=" + username + ", password=" + password + '}';
    }
    
    
    //getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
