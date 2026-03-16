/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabsystems.db;

//package imports
import com.fabsystems.db.DBConnection;
import com.fabsystems.main.Payroll;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


/**
 *
 * @author faith
 */
public class PayrollIO {

    //sql attributes
    
    private DBConnection dbc = new DBConnection();

    public void retrieveHoursWorked() throws ClassNotFoundException, SQLException {

        dbc.connect();

       
        dbc.createPreparedStatement("SELECT employee_Id, TIMESTAMPDIFF(SECOND, MIN(clock_Time), MAX(clock_Time)) / 3600 AS total_hours FROM timeclock GROUP BY employee_Id");

        ResultSet rs = dbc.getPreparedStatement().executeQuery();

        while (rs.next()) {
            int eId = rs.getInt("employee_Id");
            java.sql.Timestamp t = rs.getTimestamp("clock_Time");

            System.out.println(eId);
            System.out.println(t);
        }
        rs.close();
        dbc.closePreparedStatement();
        dbc.closeConnection();
    }
    
    public void addPayroll() throws ClassNotFoundException, SQLException{
        dbc.connect();
        dbc.createPreparedStatement("SELECT employee_Id, employee_Fname, employee_Lname, employee_Ssec, employee_Address, employee_Address2, employee_City,"
                + "employee_State, employee_Zip, employee_PayType, employee_Salary, employee_PayRate FROM employees");
        
        ResultSet rs = dbc.getPreparedStatement().executeQuery();
       
        while(rs.next()){
                Payroll p = new Payroll();
                p.setPayrollFirstName(rs.getString("employee_Fname"));
                p.setPayrollLastName(rs.getString("employee_Lname"));
                p.setPayrollSsec(rs.getString("employee_Ssec"));
                p.setPayrollAddress(rs.getString("employee_Address"));
                p.setPayrollAddress2(rs.getString("employee_Address2"));
                p.setPayrollCity(rs.getString("employee_City"));
                p.setPayrollState(rs.getString("employee_City"));
                p.setPayrollZip(rs.getString("employee_Zip"));
                p.setPayrollBegin(getStartDateForPayroll());
                p.setPayrollEnd(getEndDateForPayroll());
                p.setPayrollType(rs.getString("employee_PayType"));
                p.setSalary(rs.getDouble("employee_Salary"));
                p.setHourlyRate(rs.getDouble("employee_PayRate"));
                p.setHoursWorked(p.getHoursWorked());
                p.setYTDHoursWorked(p.getYTDHoursWorked());
                
                if(rs.getString("employee_PayType").equals("Hourly")){
                    p.setGross(p.calculateHourlyGrossPay(rs.getDouble("employee_PayRate"), p.getHoursWorked()));
                }else{
                    p.setGross(p.calculateSalaryGrossPay(rs.getDouble("employee_Salary")));
                }
                p.setYTDGross(p.getYTDGross());
                p.setMed(p.calculateMedicareTax());
                p.setYTDMed(p.getYTDMed());
                p.setSs(p.calculateSSTax());
                p.setYTDSs(p.getYTDSs());
                p.setFedTax(p.calculateFedTax());
                p.setYTDFedTax(p.getYTDFedTax());
                p.setStateTax(p.calculateStateTax());
                p.setYTDStateTax(p.getYTDStateTax());
                p.setDeductions(p.calculateTotalDeductions());
                p.setYTDDeductions(p.getYTDDeductions());
                p.setNetPay(p.calculateNetPay());
                p.setYTDNetPay(p.getYTDNetPay());
               
                dbc.createPreparedStatement("INSERT INTO payroll(payroll_Fname,"
                        + " payroll_Lname, payroll_Ssec, payroll_Address, payroll_Address2,"
                        + "payroll_City, payroll_State, payroll_Zip, payroll_Start, payroll_End,"
                        + " payroll_Type, payroll_Salary, payroll_Hourly, payroll_HoursWorked,"
                        + " payroll_YTDHoursWorked, payroll_Gross, payroll_YTDGross,"
                        + " payroll_MedicareTax, payroll_YTDMed, payroll_SocialTax, payroll_YTDSocial,"
                        + " payroll_FederalTax, payroll_YTDFed, payroll_StateTax, payroll_YTDState,"
                        + " payroll_Deductions, payroll_YTDDed, payroll_NetPay, payroll_YTDNet,"
                        + "employee_Id)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
                dbc.getPreparedStatement().setString(1, p.getPayrollFirstName());
                dbc.getPreparedStatement().setString(2, p.getPayrollLastName());
                dbc.getPreparedStatement().setString(3, p.getPayrollSsec());
                dbc.getPreparedStatement().setString(4, p.getPayrollAddress());
                dbc.getPreparedStatement().setString(5, p.getPayrollAddress2());
                dbc.getPreparedStatement().setString(6, p.getPayrollCity());
                dbc.getPreparedStatement().setString(7, p.getPayrollState());
                dbc.getPreparedStatement().setString(8, p.getPayrollZip());
                dbc.getPreparedStatement().setString(9, p.getPayrollBegin());
                dbc.getPreparedStatement().setString(10, p.getPayrollEnd());
                dbc.getPreparedStatement().setString(11, p.getPayrollType());
                dbc.getPreparedStatement().setDouble(12, p.getSalary());
                dbc.getPreparedStatement().setDouble(13, p.getHourlyRate());
                dbc.getPreparedStatement().setDouble(14, p.getHoursWorked());
                dbc.getPreparedStatement().setDouble(15, p.getYTDHoursWorked());
                dbc.getPreparedStatement().setDouble(16, p.getGross());
                dbc.getPreparedStatement().setDouble(17, p.getYTDGross());
                dbc.getPreparedStatement().setDouble(18, p.getMed());
                dbc.getPreparedStatement().setDouble(19, p.getYTDMed());
                dbc.getPreparedStatement().setDouble(20, p.getSs());
                dbc.getPreparedStatement().setDouble(21, p.getYTDSs());
                dbc.getPreparedStatement().setDouble(22, p.getFedTax());
                dbc.getPreparedStatement().setDouble(23, p.getYTDFedTax());
                dbc.getPreparedStatement().setDouble(24, p.getStateTax());
                dbc.getPreparedStatement().setDouble(25, p.getYTDStateTax());
                dbc.getPreparedStatement().setDouble(26, p.getDeductions());
                dbc.getPreparedStatement().setDouble(27, p.getYTDDeductions());
                dbc.getPreparedStatement().setDouble(28, p.getNetPay());
                dbc.getPreparedStatement().setDouble(29, p.getYTDNetPay());
                dbc.getPreparedStatement().setInt(30, rs.getInt("employee_Id"));
                
                dbc.getPreparedStatement().executeUpdate();
        }    
        rs.close();
        dbc.closePreparedStatement();
        dbc.closeConnection();
         
    }
    
    public String getStartDateForPayroll(){
        final int NUMBER_OF_DAYS_AGO = -14;
        DateFormat format = new SimpleDateFormat("mm-dd-yyyy");
        format.setLenient(true);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        cal.add(Calendar.DATE, NUMBER_OF_DAYS_AGO);
        String startDate = DateFormat.getDateInstance().format(cal.getTime());
        
        return startDate;
    }
    
    public String getEndDateForPayroll(){
        DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
        Calendar cal = Calendar.getInstance();
        String stopDate = dateFormat.getInstance().format(cal.getTime());
        
        return stopDate;
    }

}