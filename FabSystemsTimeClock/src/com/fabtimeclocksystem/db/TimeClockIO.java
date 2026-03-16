/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabtimeclocksystem.db;

import com.fabsystems.db.DBConnection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author faith
 */
public class TimeClockIO {

    private DBConnection dbc = new DBConnection();
    private ResultSet rs;

    public void timePunch(String badge, String punchType, java.sql.Timestamp time) throws ClassNotFoundException, SQLException, ParseException {

        dbc.connect();

        dbc.createPreparedStatement("SELECT employee_Id FROM employees WHERE employee_Badge=?");
        dbc.getPreparedStatement().setString(1, badge);

        rs = dbc.getPreparedStatement().executeQuery();

        if (rs.next()) {
            int empId = rs.getInt("employee_Id");
            
//            double newHours = calculateHours(jst, jst1);
            dbc.createPreparedStatement("INSERT INTO timeclock(clock_PunchType, clock_Time, employee_Id) VALUES(?,?,?)");
            dbc.getPreparedStatement().setString(1, punchType);
            dbc.getPreparedStatement().setTimestamp(2, time);
            dbc.getPreparedStatement().setInt(3, empId);

            dbc.getPreparedStatement().executeUpdate();

            JOptionPane.showMessageDialog(null, "Punch Accepted");
        } else {
            JOptionPane.showMessageDialog(null, "Error punch not accepted.", "Database Error.", JOptionPane.ERROR_MESSAGE);
        }
        rs.close();
        dbc.closePreparedStatement();
        dbc.closeConnection();
    }

    public Double calculateHours(java.sql.Timestamp jst, java.sql.Timestamp jst1) throws ParseException {

        long minDiff = (jst1.getTime() - jst.getTime());
        long diffSeconds = minDiff / 1000 % 60;
        long diffMinutes = minDiff / (60 * 1000) % 60;
        long diffHours = minDiff / (60 * 60 * 1000) % 24;

        String time = diffHours + ":" + diffMinutes + ":" + diffSeconds;

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        long ms = sdf.parse(time).getTime();

        java.sql.Time newTime = new java.sql.Time(ms);

        double hr = newTime.getHours();
        double mn = newTime.getMinutes();
        double sc = newTime.getSeconds();

        double minCalc = mn * 1 / 60;

        double secCalc = sc * 1 / 3600;

        double hrCalc = hr + minCalc + secCalc;
        return hrCalc;
    }

}
