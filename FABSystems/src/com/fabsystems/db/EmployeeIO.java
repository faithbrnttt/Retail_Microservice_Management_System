package com.fabsystems.db;

//package imports
import com.fabsystems.main.Employee;


//general imports
import javax.swing.JOptionPane;

//exception imports
import java.sql.SQLException;


//database imports
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author faith
 */
public class EmployeeIO {

    //jframe attributes
    private JPanel panel;
    private JPanel mainPanel;
    private DefaultTableModel employeeModel;
    private JTable tblEmployees;

    //sql attributes
    private ResultSet rs;
    private final DBConnection dbc = new DBConnection();

    //adds employee entered by user to mysql employees table
    public void addEmployees(Employee e, JTextField efn) throws ClassNotFoundException, SQLException,                 ParseException {

        dbc.connect();
        dbc.createPreparedStatement("SELECT employee_Id FROM employees WHERE employee_Id=?");
        dbc.getPreparedStatement().setInt(1, e.getEmpId());

        rs = dbc.getPreparedStatement().executeQuery();

        if (rs.next() == true) {
            rs.getInt("employee_Id");
            JOptionPane.showMessageDialog(null, "This person is already an employee.");
            efn.requestFocus();

        } else {
            try {

                dbc.createPreparedStatement("INSERT INTO employees(employee_Fname, employee_Lname, employee_Ssec, employee_Address, employee_Address2, "
                        + "employee_City, employee_State, employee_Zip, employee_Phone, employee_Position, employee_Type, employee_HireDate, "
                        + "employee_PayType, employee_Salary, employee_PayRate, employee_Username, employee_Password, employee_Badge, employee_Admin) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                dbc.getPreparedStatement().setString(1, e.getEmpFName());
                dbc.getPreparedStatement().setString(2, e.getEmpLName());
                dbc.getPreparedStatement().setString(3, e.getEmpSsec());
                dbc.getPreparedStatement().setString(4, e.getEmpAddress());
                dbc.getPreparedStatement().setString(5, e.getEmpAddress2());
                dbc.getPreparedStatement().setString(6, e.getEmpCity());
                dbc.getPreparedStatement().setString(7, e.getEmpState());
                dbc.getPreparedStatement().setString(8, e.getEmpZip());
                dbc.getPreparedStatement().setString(9, e.getEmpPhone());
                dbc.getPreparedStatement().setString(10, e.getEmpPosition());
                dbc.getPreparedStatement().setString(11, e.getEmpType());
                dbc.getPreparedStatement().setString(12, e.getEmpHireDate());
                dbc.getPreparedStatement().setString(13, e.getEmpPayType());
                dbc.getPreparedStatement().setDouble(14, e.getEmpSalary());
                dbc.getPreparedStatement().setDouble(15, e.getEmpPayRate());
                dbc.getPreparedStatement().setString(16, e.getEmpUsername());
                dbc.getPreparedStatement().setString(17, e.getEmpPassword());
                dbc.getPreparedStatement().setString(18, e.getEmpBadge());
                dbc.getPreparedStatement().setBoolean(19, e.getEmpAdmin());

                dbc.getPreparedStatement().executeUpdate();

                JOptionPane.showMessageDialog(null, "Employee added successfully.");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            dbc.closePreparedStatement();
            dbc.closeConnection();
        }

    }

    //adds employee to adminprivilege if admin checkbox selected
    public void addEmployeeAdmin(Employee e) throws SQLException, ClassNotFoundException {
        if (e.getEmpAdmin() == true) {
            try {
                dbc.connect();
                int empId = 0;
                dbc.createPreparedStatement("SELECT employee_Id FROM employees WHERE employee_Fname=? AND employee_Lname=?");
                dbc.getPreparedStatement().setString(1, e.getEmpFName());
                dbc.getPreparedStatement().setString(2, e.getEmpLName());

                rs = dbc.getPreparedStatement().executeQuery();

                if (rs.next()) {
                    empId = rs.getInt("employee_Id");
                }
                System.out.println(empId);
                dbc.createPreparedStatement("INSERT INTO adminprivilege(admin_Username, admin_Password, employee_Id) VALUES(?,?,?)");
                dbc.getPreparedStatement().setString(1, e.getEmpUsername());
                dbc.getPreparedStatement().setString(2, e.getEmpPassword());
                dbc.getPreparedStatement().setInt(3, empId);

                dbc.getPreparedStatement().executeUpdate();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error.", JOptionPane.ERROR_MESSAGE);
            }
            rs.close();
            dbc.closePreparedStatement();
            dbc.closeConnection();
        }
    }

    //retrieves employee data stored in mysql employees table for displaying in employee Jtable
    public ArrayList<Employee> getEmployeeList() throws SQLException, ClassNotFoundException {

        //create the arraylist to return
        ArrayList<Employee> eList = new ArrayList<Employee>();

        //connect to database
        dbc.connect();

        dbc.createStatement();
        String query = "SELECT * FROM employees";
        rs = dbc.getStatement().executeQuery(query);

        while (rs.next()) {
            Employee e = new Employee();
            e.setEmpId(rs.getInt(1));
            e.setEmpFName(rs.getString(2));
            e.setEmpLName(rs.getString(3));
            e.setEmpSsec(rs.getString(4));
            e.setEmpAddress(rs.getString(5));
            e.setEmpAddress2(rs.getString(6));
            e.setEmpCity(rs.getString(7));
            e.setEmpState(rs.getString(8));
            e.setEmpZip(rs.getString(9));
            e.setEmpPhone(rs.getString(10));
            e.setEmpPosition(rs.getString(11));
            e.setEmpType(rs.getString(12));
            e.setEmpHireDate(rs.getString(13));
            e.setEmpPayType(rs.getString(14));
            e.setEmpSalary(rs.getDouble(15));
            e.setEmpPayRate(rs.getDouble(16));
            e.setEmpUsername(rs.getString(17));
            e.setEmpPassword(rs.getString(18));
            e.setEmpBadge(rs.getString(19));
            e.setEmpAdmin(rs.getBoolean(20));

            eList.add(e);
        }

        //close connection
        rs.close();
        dbc.closeStatement();
        dbc.closeConnection();

        //return list
        return eList;
    }

    //updates product to mysql products table after user makes changes
    public void updateEmployee(Employee e, int eId) throws ClassNotFoundException, SQLException {

        dbc.connect();

        dbc.createPreparedStatement("UPDATE employees SET employee_Fname=?, employee_Lname=?, employee_Ssec=?, employee_Address=?, employee_Address2=?,"
                + "employee_City=?, employee_State=?, employee_Zip=?, employee_Phone=?, employee_Position=?, employee_Type=?, employee_HireDate=?,"
                + "employee_PayType=?, employee_Salary=?, employee_PayRate=?, employee_Username=?, employee_Password=?, employee_Badge=?, employee_Admin=? "
                + "WHERE employee_Id=?");
        dbc.getPreparedStatement().setString(1, e.getEmpFName());
        dbc.getPreparedStatement().setString(2, e.getEmpLName());
        dbc.getPreparedStatement().setString(3, e.getEmpSsec());
        dbc.getPreparedStatement().setString(4, e.getEmpAddress());
        dbc.getPreparedStatement().setString(5, e.getEmpAddress2());
        dbc.getPreparedStatement().setString(6, e.getEmpCity());
        dbc.getPreparedStatement().setString(7, e.getEmpState());
        dbc.getPreparedStatement().setString(8, e.getEmpZip());
        dbc.getPreparedStatement().setString(9, e.getEmpPhone());
        dbc.getPreparedStatement().setString(10, e.getEmpPosition());
        dbc.getPreparedStatement().setString(11, e.getEmpType());
        dbc.getPreparedStatement().setString(12, e.getEmpHireDate());
        dbc.getPreparedStatement().setString(13, e.getEmpPayType());
        dbc.getPreparedStatement().setDouble(14, e.getEmpSalary());
        dbc.getPreparedStatement().setDouble(15, e.getEmpPayRate());
        dbc.getPreparedStatement().setString(16, e.getEmpUsername());
        dbc.getPreparedStatement().setString(17, e.getEmpPassword());
        dbc.getPreparedStatement().setString(18, e.getEmpBadge());
        dbc.getPreparedStatement().setBoolean(19, e.getEmpAdmin());
        dbc.getPreparedStatement().setInt(20, eId);

        dbc.getPreparedStatement().executeUpdate();

      
        dbc.closePreparedStatement();
        dbc.closeConnection();

        JOptionPane.showMessageDialog(null, "Employee updated successfully!");

    }

    //removes product from mysql products table
    public void removeEmployee(int eId) throws SQLException, ClassNotFoundException {

        dbc.connect();

        dbc.createPreparedStatement("DELETE FROM employees WHERE employee_Id=?");
        dbc.getPreparedStatement().setInt(1, eId);
        dbc.getPreparedStatement().executeUpdate();


        dbc.closePreparedStatement();
        dbc.closeConnection();

        JOptionPane.showMessageDialog(null, "Employee removed successfully!");

    }
   
   
}
