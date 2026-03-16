/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabpointofsalesystem.main;

/**
 *
 * @author faith
 */
public class Order {
    private Double subTotal, tax, total;
    
    
    public Order(){
        subTotal = 0.0;
        tax = 0.3;
        total = 0.0;
    }
    
    public Order(Double subTotal, Double tax, Double total){
        this.subTotal = subTotal;
        this.tax = tax;
        this.total = total;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
}
