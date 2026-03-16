/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabsystems.main;

/**
 *
 * @author faith
 */
public class Product {

    //attributes
    private int productID;
    private String productName;
    private String productSku;
    private String productDescription;
    private String productSupplier;
    private Double productUnitCost;
    private Double productSalePrice;
    private int productQuantity;
    private Double productTotalValue;

    //constructors
    public Product() {
        productID = 0;
        productName = "N/A";
        productSku = "N/A";
        productDescription = "N/A";
        productSupplier = "N/A";
        productUnitCost = 0.0;
        productSalePrice = 0.0;
        productQuantity = 0;
        productTotalValue = 0.0;
    }

    public Product(int pID, String pName, String pSku, String pDesc, String pSupp,
            Double pUC, Double pSP, int pQ, Double pTV) {
        this.productID = pID;
        this.productName = pName;
        this.productSku = pSku;
        this.productDescription = pDesc;
        this.productSupplier = pSupp;
        this.productUnitCost = pUC;
        this.productSalePrice = pSP;
        this.productQuantity = pQ;
        this.productTotalValue = pTV;
    }

    //behaviors
    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName="
                + productName + ", productSku=" + productSku + ", productDescription="
                + productDescription + ", productSupplier=" + productSupplier
                + ", productUnitCost=" + productUnitCost + ", productSalePrice="
                + productSalePrice + ", productQuantity=" + productQuantity
                + ", productTotalValue=" + productTotalValue + '}';
    }

    //getters and setters
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductSupplier() {
        return productSupplier;
    }

    public void setProductSupplier(String productSupplier) {
        this.productSupplier = productSupplier;
    }

    public Double getProductUnitCost() {
        return productUnitCost;
    }

    public void setProductUnitCost(Double productUnitCost) {
        this.productUnitCost = productUnitCost;
    }

    public Double getProductSalePrice() {
        return productSalePrice;
    }

    public void setProductSalePrice(Double productSalePrice) {
        this.productSalePrice = productSalePrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Double getProductTotalValue() {
        return productTotalValue;
    }

    public void setProductTotalValue(Double productTotalValue) {
        this.productTotalValue = productTotalValue;
    }

}
