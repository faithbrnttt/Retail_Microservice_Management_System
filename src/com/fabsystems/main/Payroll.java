/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabsystems.main;


/**
 *
 * @author faith
 */
public class Payroll {

    private String payrollFirstName;
    private String payrollLastName;
    private String payrollSsec;
    private String payrollAddress;
    private String payrollAddress2;
    private String payrollCity;
    private String payrollState;
    private String payrollZip;
    private String payrollBegin;
    private String payrollEnd;
    private String payrollType;
    private Double hourlyRate;
    private Double hoursWorked;
    private Double YTDHoursWorked;
    private Double salary;
    private Double gross;
    private Double YTDGross;
    private Double med;
    private Double YTDMed;
    private Double ss;
    private Double YTDSs;
    private Double fedTax;
    private Double YTDFedTax;
    private Double stateTax;
    private Double YTDStateTax;
    private Double deductions;
    private Double YTDDeductions;
    private Double netPay;
    private Double YTDNetPay;

    public Payroll() {
     
        payrollFirstName = "N/A";
        payrollLastName = "N/A";
        payrollSsec = "N/A";
        payrollAddress = "N/A";
        payrollAddress2 = "N/A";
        payrollCity = "N/A";
        payrollState = "N/A";
        payrollZip = "N/A";
        payrollBegin = "N/A";
        payrollEnd = "N/A";
        payrollType = "N/A";
        salary = 0.0;
        hourlyRate = 0.0;
        hoursWorked = 0.0;
        YTDHoursWorked = 0.0;
        gross = 0.0;
        YTDGross = 0.0;
        med = 0.0;
        YTDMed = 0.0;
        ss = 0.0;
        YTDSs = 0.0;
        fedTax = 0.0;
        YTDFedTax = 0.0;
        stateTax = 0.0;
        YTDStateTax = 0.0;
        deductions = 0.0;
        YTDDeductions = 0.0;
        netPay = 0.0;
        YTDNetPay = 0.0;
       
    }

    public Payroll(String payrollFirstName, String payrollLastName, String payrollSsec, String payrollAddress, String payrollAddress2, String payrollCity, String payrollState, String payrollZip, String payrollBegin, String payrollEnd, String payrollType, Double salary, Double hourlyRate, Double hoursWorked, Double YTDHoursWorked, Double gross, Double YTDGross,
            Double med, Double YTDMed, Double ss,Double YTDSs,
            Double fedTax, Double YTDFedTax, Double stateTax, Double YTDStateTax,
            Double deductions, Double YTDDeductions, Double netPay, Double YTDNetPay) {
   
        this.payrollFirstName = payrollFirstName;
        this.payrollLastName = payrollLastName;
        this.payrollSsec = payrollSsec;
        this.payrollAddress = payrollAddress;
        this.payrollAddress2 = payrollAddress2;
        this.payrollCity = payrollCity;
        this.payrollState = payrollState;
        this.payrollZip = payrollZip;
        this.payrollBegin = payrollBegin;
        this.payrollEnd = payrollEnd;
        this.payrollType = payrollType;
         this.salary = salary;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.YTDHoursWorked = YTDHoursWorked;
        this.gross = gross;
        this.YTDGross = YTDGross;
        this.med = med;
        this.YTDMed = YTDMed;
        this.ss = ss;
        this.YTDSs = YTDSs;
        this.fedTax = fedTax;
        this.YTDFedTax = YTDFedTax;
        this.stateTax = stateTax;
        this.YTDStateTax = YTDStateTax;
        this.deductions = deductions;
        this.YTDDeductions = YTDDeductions;
        this.netPay = netPay;
        this.YTDNetPay = YTDNetPay;
    }

    //calculates gross pay based off hours retrieved from timeclock table in mysql * hourly rate found in employee table
    public Double calculateYTDHoursWorked(){
        this.YTDHoursWorked+=hoursWorked;
        return YTDHoursWorked;
    }
    
    public Double calculateYTDGross(){
        this.YTDGross+=gross;
        return YTDGross;
    }
    public Double calculateHourlyGrossPay(Double hourlyRate, Double hoursWorked) {
        this.gross = hourlyRate * hoursWorked;
        return this.gross;
    }

    //calculates gross pay based off value of salary divided by 26 weeks since it is a bi-weekly pay structure
    public Double calculateSalaryGrossPay(Double salary) {
        this.gross = salary / 26;
        return this.gross;
    }
    
    public Double calculateMedicareTax() {
        this.med = this.gross * 0.02;
        return this.med;
    }
    
    public Double calculateYTDMed(){
        this.YTDMed+=med;
        return YTDMed;
    }

    public Double calculateSSTax() {
        this.ss = this.gross * 0.06;
        return this.ss;
    }
    
    public Double calculateYTDSocial(){
        this.YTDSs+=ss;
        return YTDSs;
    }

    public Double calculateFedTax() {
        this.fedTax = this.gross * 0.14;
        return this.fedTax;
    }
    
    public Double calculateYTDFed(){
        this.YTDFedTax+=fedTax;
        return YTDFedTax;
    }

    public Double calculateStateTax() {
        this.stateTax = this.gross * 0.05;
        return this.stateTax;
    }
    
    public Double calculateYTDState(){
       this.YTDStateTax+=stateTax;
        return YTDStateTax;
    }

    public Double calculateTotalDeductions() {
        this.deductions = this.med + this.ss + this.fedTax + this.stateTax;
        return this.deductions;
    }
    
    public Double calculateYTDDeductions(){
        this.YTDDeductions+=deductions;
        return YTDDeductions;
    }

    public Double calculateNetPay() {
        this.netPay = this.gross - this.deductions;
        return this.netPay;
    }
    
    public Double calculateYTDNet() {
        this.YTDNetPay+=netPay;
        return YTDNetPay;
    }

    @Override
    public String toString() {
        return "Payroll{" + "payrollFirstName=" + payrollFirstName + ", payrollLastName=" + payrollLastName + ", payrollSsec=" + payrollSsec + ", payrollAddress=" + payrollAddress + ", payrollAddress2=" + payrollAddress2 + ", payrollCity=" + payrollCity + ", payrollState=" + payrollState + ", payrollZip=" + payrollZip + ", payrollBegin=" + payrollBegin + ", payrollEnd=" + payrollEnd + ", payrollType=" + payrollType + ", hourlyRate=" + hourlyRate + ", hoursWorked=" + hoursWorked + ", YTDHoursWorked=" + YTDHoursWorked + ", salary=" + salary + ", gross=" + gross + ", YTDGross=" + YTDGross + ", med=" + med + ", YTDMed=" + YTDMed + ", ss=" + ss + ", YTDSs=" + YTDSs + ", fedTax=" + fedTax + ", YTDFedTax=" + YTDFedTax + ", stateTax=" + stateTax + ", YTDStateTax=" + YTDStateTax + ", deductions=" + deductions + ", YTDDeductions=" + YTDDeductions + ", netPay=" + netPay + ", YTDNetPay=" + YTDNetPay + '}';
    }

    public Double getYTDHoursWorked() {
        return YTDHoursWorked;
    }

    public void setYTDHoursWorked(Double YTDHoursWorked) {
        this.YTDHoursWorked = YTDHoursWorked;
    }

    public Double getYTDGross() {
        return YTDGross;
    }

    public void setYTDGross(Double YTDGross) {
        this.YTDGross = YTDGross;
    }

    public Double getYTDMed() {
        return YTDMed;
    }

    public void setYTDMed(Double YTDMed) {
        this.YTDMed = YTDMed;
    }

    public Double getYTDSs() {
        return YTDSs;
    }

    public void setYTDSs(Double YTDSs) {
        this.YTDSs = YTDSs;
    }

    public Double getYTDFedTax() {
        return YTDFedTax;
    }

    public void setYTDFedTax(Double YTDFedTax) {
        this.YTDFedTax = YTDFedTax;
    }

    public Double getYTDStateTax() {
        return YTDStateTax;
    }

    public void setYTDStateTax(Double YTDStateTax) {
        this.YTDStateTax = YTDStateTax;
    }

    public Double getYTDDeductions() {
        return YTDDeductions;
    }

    public void setYTDDeductions(Double YTDDeductions) {
        this.YTDDeductions = YTDDeductions;
    }

    public Double getYTDNetPay() {
        return YTDNetPay;
    }

    public void setYTDNetPay(Double YTDNetPay) {
        this.YTDNetPay = YTDNetPay;
    }

    

    

    public String getPayrollType() {
        return payrollType;
    }

    public void setPayrollType(String payrollType) {
        this.payrollType = payrollType;
    }

    

    public String getPayrollAddress() {
        return payrollAddress;
    }

    public void setPayrollAddress(String payrollAddress) {
        this.payrollAddress = payrollAddress;
    }

    public String getPayrollAddress2() {
        return payrollAddress2;
    }

    public void setPayrollAddress2(String payrollAddress2) {
        this.payrollAddress2 = payrollAddress2;
    }

    public String getPayrollCity() {
        return payrollCity;
    }

    public void setPayrollCity(String payrollCity) {
        this.payrollCity = payrollCity;
    }

    public String getPayrollState() {
        return payrollState;
    }

    public void setPayrollState(String payrollState) {
        this.payrollState = payrollState;
    }

    public String getPayrollZip() {
        return payrollZip;
    }

    public void setPayrollZip(String payrollZip) {
        this.payrollZip = payrollZip;
    }

    

    public String getPayrollSsec() {
        return payrollSsec;
    }

    public void setPayrollSsec(String payrollSsec) {
        this.payrollSsec = payrollSsec;
    }


    public String getPayrollFirstName() {
        return payrollFirstName;
    }

    public void setPayrollFirstName(String payrollFirstName) {
        this.payrollFirstName = payrollFirstName;
    }

    public String getPayrollLastName() {
        return payrollLastName;
    }

    public void setPayrollLastName(String payrollLastName) {
        this.payrollLastName = payrollLastName;
    }

    public String getPayrollBegin() {
        return payrollBegin;
    }

    public void setPayrollBegin(String payrollBegin) {
        this.payrollBegin = payrollBegin;
    }

    public String getPayrollEnd() {
        return payrollEnd;
    }

    public void setPayrollEnd(String payrollEnd) {
        this.payrollEnd = payrollEnd;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getGross() {
        return gross;
    }

    public void setGross(Double gross) {
        this.gross = gross;
    }


    public Double getMed() {
        return med;
    }

    public void setMed(Double med) {
        this.med = med;
    }


    public Double getSs() {
        return ss;
    }

    public void setSs(Double ss) {
        this.ss = ss;
    }


    public Double getFedTax() {
        return fedTax;
    }

    public void setFedTax(Double fedTax) {
        this.fedTax = fedTax;
    }


    public Double getStateTax() {
        return stateTax;
    }

    public void setStateTax(Double stateTax) {
        this.stateTax = stateTax;
    }


    public Double getDeductions() {
        return deductions;
    }

    public void setDeductions(Double deductions) {
        this.deductions = deductions;
    }

    public Double getNetPay() {
        return netPay;
    }

    public void setNetPay(Double netPay) {
        this.netPay = netPay;
    }


}
