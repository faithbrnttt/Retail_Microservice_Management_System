/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabsystems.main;


/**
 *
 * @author faith
 */
public class Employee {
    private int empId;
    private String empFName;
    private String empLName;
    private String empSsec;
    private String empAddress;
    private String empAddress2;
    private String empCity;
    private String empState;
    private String empZip;
    private String empPhone;
    private String empPosition;
    private String empType;
    private String empHireDate;
    private String empPayType;
    private Double empSalary;
    private Double empPayRate;
    private String empUsername;
    private String empPassword;
    private String empBadge;
    private Boolean empAdmin;

    
    public Employee(){
        empId = 0;
        empFName = "N/A";
        empLName = "N/A";
        empSsec = "N/A";
        empAddress = "N/A";
        empAddress2 = "N/A";
        empCity = "N/A";
        empState = "N/A";
        empZip = "N/A";
        empPhone = "N/A";
        empPosition = "N/A";
        empType = "N/A";
        empHireDate = "N/A";
        empPayType = "N/A";
        empSalary = 0.0;
        empPayRate = 0.0;
        empUsername = "N/A";
        empPassword = "N/A";
        empBadge = "N/A";
        empAdmin = false;
        
    }

    public Employee(int empId, String empFName, String empLName, String empSsec, String empAddress, 
            String empAddress2, String empCity, String empState, String empZip, 
            String empPhone, String empPosition, String empType, String empHireDate, 
            String empPayType, Double empSalary, Double empPayRate, 
            String empUsername, String empPassword, String empBadge, Boolean empAdmin) {
        this.empId = empId;
        this.empFName = empFName;
        this.empLName = empLName;
        this.empSsec = empSsec;
        this.empAddress = empAddress;
        this.empAddress2 = empAddress2;
        this.empCity = empCity;
        this.empState = empState;
        this.empZip = empZip;
        this.empPhone = empPhone;
        this.empPosition = empPosition;
        this.empType = empType;
        this.empHireDate = empHireDate;
        this.empPayType = empPayType;
        this.empSalary = empSalary;
        this.empPayRate = empPayRate;
        this.empUsername = empUsername;
        this.empPassword = empPassword;
        this.empBadge = empBadge;
        this.empAdmin = empAdmin;
    }

    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", empFName=" + empFName + ", empLName=" + 
                empLName + ", empSsec=" + empSsec + ", empAddress=" + empAddress + ", empAddress2=" + empAddress2 + 
                ", empCity=" + empCity + ", empState=" + empState + ", empZip=" + empZip + ", empPhone=" 
                + empPhone + ", empPosition=" + empPosition + ", empType=" + empType + ", empHireDate=" 
                + empHireDate + ", empPayType=" + empPayType +  ", empSalary=" + empSalary + ", empPayRate="
                + empPayRate + ", empUsername=" + empUsername + ", empPassword=" + empPassword 
                + ", empBadge=" + empBadge + ", empAdmin=" + empAdmin + '}';
    }

    public String getEmpSsec() {
        return empSsec;
    }

    public void setEmpSsec(String empSsec) {
        this.empSsec = empSsec;
    }
 
    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }

    public String getEmpPayType() {
        return empPayType;
    }

    public void setEmpPayType(String empPayType) {
        this.empPayType = empPayType;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }
    
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpFName() {
        return empFName;
    }

    public void setEmpFName(String empFName) {
        this.empFName = empFName;
    }

    public String getEmpLName() {
        return empLName;
    }

    public void setEmpLName(String empLName) {
        this.empLName = empLName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpAddress2() {
        return empAddress2;
    }

    public void setEmpAddress2(String empAddress2) {
        this.empAddress2 = empAddress2;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public String getEmpState() {
        return empState;
    }

    public void setEmpState(String empState) {
        this.empState = empState;
    }

    public String getEmpZip() {
        return empZip;
    }

    public void setEmpZip(String empZip) {
        this.empZip = empZip;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public String getEmpHireDate() {
        return empHireDate;
    }
    
    public void setEmpHireDate(String empHireDate){
        this.empHireDate = empHireDate;
    }

    public Double getEmpPayRate() {
        return empPayRate;
    }

    public void setEmpPayRate(Double empPayRate) {
        this.empPayRate = empPayRate;
    }

    public String getEmpUsername() {
        return empUsername;
    }

    public void setEmpUsername(String empUsername) {
        this.empUsername = empUsername;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpBadge() {
        return empBadge;
    }

    public void setEmpBadge(String empBadge) {
        this.empBadge = empBadge;
    }
    
    

    public Boolean getEmpAdmin() {
        return empAdmin;
    }

    public void setEmpAdmin(Boolean empAdmin) {
        this.empAdmin = empAdmin;
    }

}
