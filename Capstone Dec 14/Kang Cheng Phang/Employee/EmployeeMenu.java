/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author User
 */
public class EmployeeMenu {

    //inserting line break
    static void DisplayHeader() {
        System.out.println("                                ");
    }
    static Scanner in = new Scanner(System.in);
    private static final Pattern CHARS = Pattern.compile(".*");

    static ArrayList<EmployeeClass> Dept = new ArrayList<EmployeeClass>();
    static ArrayList<EmployeeClass.Employees> Emp = new ArrayList<EmployeeClass.Employees>();

    //declaring connection
    private static Connection connection;

    //method to connect to SQL Database
    public static void Connection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "hr", "hr");
        }
    }

    //menu navigation
    public static void menu() {
        System.out.println("**********************ABC Company Management System**********************");
        System.out.println("1. Query all employee records.\n2. Add new employee record.\n3. Update existing employee record.\n4. Delete existing employee record.\n0. To exit program.\n\nPlease enter the corresponding numeric value to navigate:");
        Scanner in = new Scanner(System.in);
        try {
            switch (in.nextInt()) {
                case 1:
                    queryEmp();
                    break;
                case 2:
                    addEmpRec();
                    break;
                case 3:
                    updateEmpSalary();
                    break;
                case 4:
                    deleteEmpRec();
                    break;
                default:
                    System.exit(0);//exit program
                    break;
            }
        } catch (InputMismatchException im) {
            menu();
            System.out.print("Please enter the corresponding numeric value to navigate:");
            DisplayHeader();
        }
    }

    public static void queryEmp() {
        try {
            connection.beginRequest();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, JOB_ID, SALARY, MANAGER_ID, DEPARTMENT_ID from EMPLOYEES");

            while (rs.next()) {

                System.out.println(rs.getInt("EMPLOYEE_ID") + "\t" + rs.getString("FIRST_NAME") + "\t" + rs.getString("LAST_NAME") + "\t"
                        + rs.getString("JOB_ID") + "\t" + rs.getInt("SALARY") + "\t" + rs.getInt("MANAGER_ID") + "\t" + rs.getInt("DEPARTMENT_ID"));
            }

//close the connection object  
//            connection.close();
//            rs.close();
//            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        DisplayHeader();
        System.out.println("Enter any key to return to main menu.");
        Scanner in = new Scanner(System.in);
        if (in.hasNext(CHARS) == true) {
            menu();
        }
    }

    public static void addEmpRec() {
        try {
            connection.beginRequest();
            String addRecord = "INSERT INTO employees(employee_id, first_name, last_name, job_id, salary, manager_id, department_id ) VALUES(emp_id_sequence.nextval, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(addRecord);

            System.out.println("Please enter new employee's first name: ");
            pstmt.setString(1, in.next());

            System.out.println("Please enter new employee's last name: ");
            pstmt.setString(2, in.next());

            System.out.println("Please enter new employee's job id: ");
            pstmt.setString(3, in.next());

            System.out.println("Please enter new employee's salary: ");
            pstmt.setInt(4, in.nextInt());

            System.out.println("Please enter new employee's manager id: ");
            pstmt.setInt(5, in.nextInt());

            System.out.println("Please enter new employee's department: ");
            pstmt.setInt(6, in.nextInt());
            pstmt.executeUpdate();

//close the connection object  
//            connection.close();
//            pstmt.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        DisplayHeader();
        System.out.println("Enter any key to return to main menu.");
        Scanner in = new Scanner(System.in);
        if (in.hasNext(CHARS) == true) {
            menu();
        }
    }

    public static void updateEmpSalary() {
        try {
            connection.beginRequest();
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter employee id to update record: ");
            int emp_id = sc.nextInt();
            sc.nextLine();
            System.out.println("Please enter new value to update salary");
            int emp_salary = sc.nextInt();
            
            String updateRecord = "UPDATE employees SET salary = ? WHERE employee_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(updateRecord);

            pstmt.setInt(2, emp_id);
            pstmt.setInt(1, emp_salary);

            pstmt.executeUpdate();

//close the connection object  
//            connection.close();
//            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        DisplayHeader();
        System.out.println("Enter any key to return to main menu.");
        Scanner in = new Scanner(System.in);
        if (in.hasNext(CHARS) == true) {
            menu();
        }
    }

    public static void deleteEmpRec() {
        try {
            connection.beginRequest();
            String delRecord = "delete from employees where employee_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(delRecord);

            System.out.println("Please enter employee id to delete record: ");
            pstmt.setInt(1, in.nextInt());
            pstmt.executeUpdate();

//close the connection object  
//            connection.close();
//            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        DisplayHeader();
        System.out.println("Enter any key to return to main menu.");
        Scanner in = new Scanner(System.in);
        if (in.hasNext(CHARS) == true) {
            menu();
        }
    }
}
