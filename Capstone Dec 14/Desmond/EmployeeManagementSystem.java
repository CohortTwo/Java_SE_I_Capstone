/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companyRecords;

import companyRecords.Company.employee;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Desmond
 */
public class EmployeeManagementSystem {

    static ArrayList<Company.department> depList = new ArrayList<Company.department>();
    static ArrayList<Company.employee> empList = new ArrayList<Company.employee>();

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "desmond", "desmond");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from empdupe");

            Company comp = new Company();

            while (rs.next()) {
                //System.out.println(rs.getInt(1) + " \t" + rs.getString(2) + " \t" + rs.getInt(3));
                System.out.println(rs.getInt("employee_id") + " \n"
                        + rs.getString("first_name").toUpperCase() + " \n"
                        + rs.getString("last_name").toUpperCase() + " \n"
                        + rs.getString("email") + " \n"
                        + " \t\t"
                        + rs.getInt("department_id"));
                empList.add(comp.new employee(rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getInt("salary"),
                        rs.getString("job_id"),
                        rs.getInt("department_id")));

            }
            conn.close();
            rs.close();

            System.out.println(empList);
        } catch (SQLException e) {
            System.out.println(e);
        }

        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "desmond", "desmond");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from departments");

            Company comp = new Company();

            while (rs.next()) {

                System.out.println(rs.getInt("department_id") + " \t" + rs.getString("department_name").toUpperCase() + "\t" + rs.getInt("manager_id") + " \t\t" + rs.getInt("location_id"));
                depList.add(comp.new department(rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getInt("manager_id"),
                        rs.getInt("location_id")));

            }
            conn.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
//Use to get the latest employee number and just add 1 to do some sort of auto generation
//System.out.println(empList.stream().max(Comparator.comparing(employee::getEmpId)).get().getEmpId());
        menu();

    }

    public static void queryDep() {
        //check the array whether is zero
        if (depList.isEmpty()) {
            beautify();
            System.out.println("There is no existing department.");
            beautify();
            menu();
        } else {
            //loop the array
            for (int i = 0; i < depList.size(); i++) {
                beautify();
                System.out.println("The department ID is : " + depList.get(i).getDepId()
                        + " \nThe department name is : " + depList.get(i).getDepName()
                        + "\nLocation: " + depList.get(i).getLocation()
                        + "\nThe Manager is : " + depList.get(i).getManagerId()
                );
                beautify();
            }
            menu();
        }
    }

    public static void addDep() {
        Scanner sc = new Scanner(System.in);

        int depId;
        String depName;
        int locationId;
        int managerId;

        beautify();

        System.out.println("Please enter a department ID: ");
        depId = Integer.parseInt(sc.nextLine());

        if (depList.isEmpty()) {

            System.out.println("Please enter a department name: ");
            depName = sc.nextLine();

            System.out.println("Please enter the location of this department: ");
            locationId = Integer.parseInt(sc.nextLine());

            System.out.println("Please enter the manager's ID: ");
            managerId = Integer.parseInt(sc.nextLine());

            Company comp = new Company();
            depList.add(comp.new department(depId, depName, locationId, managerId));

            beautify();
            System.out.println("*****Added*****");
            System.out.println(depList);

            beautify();

            menu();
        } else {

            int x = validation(depId);

            if (x == 1) {
                System.out.println("Please enter a department name: ");
                depName = sc.nextLine();

                System.out.println("Please enter the location of this department: ");
                locationId = Integer.parseInt(sc.nextLine());

                System.out.println("Please enter the manager's ID: ");
                managerId = Integer.parseInt(sc.nextLine());

                Company comp = new Company();
                depList.add(comp.new department(depId, depName, locationId, managerId));

                try {
                    Connection conn = DriverManager
                            .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "desmond", "desmond");

                    String insertDepValues = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, LOCATION_ID, MANAGER_ID)"
                            + "VALUES (?,?,?,?)";

                    PreparedStatement update = conn.prepareStatement(insertDepValues);

                    update.setInt(1, depId);
                    update.setString(2, depName);
                    update.setInt(3, locationId);
                    update.setInt(4, managerId);

                    conn.close();

                } catch (SQLException e) {
                    System.out.println(e);
                }

                beautify();
                System.out.println("*****Added*****");
                System.out.println(depList);
                beautify();

                menu();

            } else {

                beautify();
                System.out.println("The department number is not valid!");
                beautify();
                menu();
            }
        }
    }

    public static void queryEmp() {
        if (empList.isEmpty()) {
            beautify();
            System.out.println("There are no existing employees.");
            beautify();
            menu();
        } else {
            //loop the array
            for (int i = 0; i < empList.size(); i++) {
                beautify();
//                System.out.println(empList);
                System.out.println("Employee ID is : " + empList.get(i).getEmpId()
                        + "\nEmployee First Name: " + empList.get(i).getEmpFname()
                        + "\nEmployee Last Name: " + empList.get(i).getEmpLname()
                        + "\nEmployee Email: " + empList.get(i).getEmail()
                        //                        + "\nEmployee Hire Date: " + empList.get(i).gethDate()
                        + "\nSalary: " + empList.get(i).getSalary()
                        + "\nJob: " + empList.get(i).getJobID()
                        + "\nDepartment ID: " + empList.get(i).getDepId()
                );
                beautify();
            }
            menu();
        }
    }

    public static void addEmp() {
        if (depList.isEmpty()) {
            beautify();
            System.out.println("There is no existing department.");
            beautify();
            menu();
        } else {

            Scanner sc = new Scanner(System.in);

            int empId;
            String empFname;
            String empLname;
            String email;

            int salary;
            String jobID;
            int depId;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            beautify();
//to do auto increment here
            empId = (empList.stream().max(Comparator.comparing(employee::getEmpId)).get().getEmpId()) + 1;

//  Originally needed user input for the Employee ID
//            System.out.println("Please enter an employee ID: ");
//            empId = Integer.parseInt(sc.nextLine());
            System.out.println("Please enter employee's first name: ");
            empFname = sc.nextLine();

            System.out.println("Please enter employee's last name: ");
            empLname = sc.nextLine();

            System.out.println("Please enter employee's email address: ");
            email = sc.nextLine();

// Work in Progress.. date compatibility hindering            
//            System.out.println("Please enter employee's hire date: ");
//            hDate = sdf.parse(sc.nextLine());
            System.out.println("Please enter the salary: ");
            salary = Integer.parseInt(sc.nextLine());

            System.out.println("Please enter the employee's designation: ");
            jobID = sc.nextLine();

            System.out.println("Please enter employee's department ID: ");
            depId = Integer.parseInt(sc.nextLine());

            int x = validation(depId);

            if (x == 1) {

                Company comp = new Company();
                empList.add(comp.new employee(empId, empFname, empLname, email, salary, jobID, depId));

                try {

                    Connection conn = DriverManager
                            .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "desmond", "desmond");

                    String insertEmpValues = "INSERT INTO EMPDUPE (employee_id, first_name, last_name,email, salary, job_id, department_id)"
                            + "VALUES (?,?,?,?,?,?,? )";

                    PreparedStatement update = conn.prepareStatement(insertEmpValues);

                    update.setInt(1, empId);
                    update.setString(2, empFname);
                    update.setString(3, empLname);
                    update.setString(4, email);
                    update.setInt(5, salary);
                    update.setString(6, jobID);
                    update.setInt(7, depId);
                    update.executeUpdate();

// If I use the statement method to do some update.
//                    String insertEmpValues = "INSERT INTO EMPDUPE() VALUES()";
//                    Statement stmt = conn.createStatement();
//                    int count = stmt.executeUpdate(insertEmpValues);
//                    System.out.println("Number of Rows Updated: " + count);
                    conn.close();

// To check if my list has been updated
//                    System.out.println(empList);
                } catch (SQLException e) {
                    System.out.println(e);
                }

                beautify();
                System.out.println("*****Added*****");
                beautify();

                menu();
            } else {
                beautify();
                System.out.println("The department number is not valid!");
                beautify();
                System.out.println("Returning to main menu");
                beautify();
                menu();
            }
        }

    }

    public static void menu() {

        Scanner sc = new Scanner(System.in);

        System.out.println("================ Welcome to a Random Employee Management System =================");
        System.out.println("1. Query Department\n2. Add Department\n3. Query Employee\n4. Add Employee\n5. Exit ");
        beautify();
        try {
            System.out.println("Please enter the number of your selection: ");
            int input = Integer.parseInt(sc.nextLine());
            if (input > 5 | input < 1) {
                beautify();
                System.out.println("Invalid Input!");
                System.out.println("Please enter a selection between 1 to 5");
                beautify();
                menu();
            } else {
                switch (input) {
                    case 1:
                        queryDep();
                        break;
                    case 2:
                        addDep();
                        break;
                    case 3:
                        queryEmp();
                        break;
                    case 4:
                        addEmp();
                        break;
                    case 5:
                        modEmp();
                        break;
                    case 6:
                        delEmp();
                        break;
                    case 7:
                        //exit program
                        break;
                }
            }
        } catch (InputMismatchException | NumberFormatException e) {
            beautify();
            System.out.println("Please enter a valid input (1-5)");
            beautify();
            menu();
        } catch (Exception e) {
            beautify();
            System.out.println("An exception has occured at the menu level");
            beautify();
            System.out.println("\n[{(.......Exiting the program now.......]})");
        }

    }

    //modify method
    public static void modEmp() {
        if (empList.isEmpty()) {
            beautify();
            System.out.println("There is no existing information to modify. Please return to main to add some");
            beautify();
            menu();
        } else {
            //loop the array
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter the employee ID you wish to modify: ");
                int empId = Integer.parseInt(sc.nextLine());

                for (int i = 0; i < empList.size(); i++) {
                    if (empList.get(i).getEmpId() == empId) {

                        System.out.println("What do you want to change for this Employee?");
                        System.out.println("1. First Name\n2. Last Name\n3. Email\n4. Salary\n5. Job ID\n6. Department ID\n7. Exit to main");
                        int input = Integer.parseInt(sc.nextLine());
                        if (input < 1 | input > 7) {
                            beautify();
                            System.out.println("Invalid Input!");
                            System.out.println("Please enter a selection between 1 to 7");
                            beautify();
                            menu();
                        } else {
                            switch (input) {
                                case 1:
                                    System.out.println("Please enter new First Name: ");
                                    String first_name = sc.nextLine();
                                    try {
                                        Connection conn = DriverManager
                                                .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "desmond", "desmond");

                                        String insertEmpValues = "UPDATE EMPDUPE"
                                                + "SET FIRST_NAME = ?"
                                                + "WHERE EMPLOYEE_ID = ?";

                                        PreparedStatement update = conn.prepareStatement(insertEmpValues);

                                        update.setString(1, first_name);
                                        update.setInt(2, empId);

                                        conn.close();

                                    } catch (SQLException e) {
                                        System.out.println(e);
                                    }
                                    beautify();
                                    System.out.println("*****Modified ID*****");
                                    break;

                                case 2:
                                    System.out.println("Please enter new Last Name: ");
                                    String last_name = sc.nextLine();
                                    try {
                                        Connection conn = DriverManager
                                                .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "desmond", "desmond");

                                        String insertEmpValues = "UPDATE EMPDUPE"
                                                + "SET LAST_NAME = ?"
                                                + "WHERE EMPLOYEE_ID = ?";

                                        PreparedStatement update = conn.prepareStatement(insertEmpValues);

                                        update.setString(1, last_name);
                                        update.setInt(2, empId);

                                        conn.close();

                                    } catch (SQLException e) {
                                        System.out.println(e);
                                    }
                                    beautify();
                                    System.out.println("*****Modified ID*****");
                                    break;

                                case 3:
                                    System.out.println("Please enter new Email: ");
                                    String email = sc.nextLine();
                                    try {
                                        Connection conn = DriverManager
                                                .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "desmond", "desmond");

                                        String insertEmpValues = "UPDATE EMPDUPE"
                                                + "SET EMAIL = ?"
                                                + "WHERE EMPLOYEE_ID = ?";

                                        PreparedStatement update = conn.prepareStatement(insertEmpValues);

                                        update.setString(1, email);
                                        update.setInt(2, empId);

                                        conn.close();

                                    } catch (SQLException e) {
                                        System.out.println(e);
                                    }
                                    beautify();
                                    System.out.println("*****Modified ID*****");
                                    break;
                                case 4:
                                    System.out.println("Please enter new Salary: ");
                                    int salary = Integer.parseInt(sc.nextLine());
                                    try {
                                        Connection conn = DriverManager
                                                .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "desmond", "desmond");

                                        String insertEmpValues = "UPDATE EMPDUPE"
                                                + "SET SALARY = ?"
                                                + "WHERE EMPLOYEE_ID = ?";

                                        PreparedStatement update = conn.prepareStatement(insertEmpValues);

                                        update.setInt(1, salary);
                                        update.setInt(2, empId);

                                        conn.close();

                                    } catch (SQLException e) {
                                        System.out.println(e);
                                    }
                                    beautify();
                                    System.out.println("*****Modified ID*****");
                                    break;

                                case 5:
                                    System.out.println("Please enter new Job ID: ");
                                    String jobId = sc.nextLine();
                                    try {
                                        Connection conn = DriverManager
                                                .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "desmond", "desmond");

                                        String insertEmpValues = "UPDATE EMPDUPE"
                                                + "SET JOB_ID = ?"
                                                + "WHERE EMPLOYEE_ID = ?";

                                        PreparedStatement update = conn.prepareStatement(insertEmpValues);

                                        update.setString(1, jobId);
                                        update.setInt(2, empId);

                                        conn.close();

                                    } catch (SQLException e) {
                                        System.out.println(e);
                                    }
                                    beautify();
                                    System.out.println("*****Modified ID*****");
                                    break;
                                case 6:
                                    System.out.println("Please enter new Department ID: ");
                                    int depId = Integer.parseInt(sc.nextLine());
                                    try {
                                        Connection conn = DriverManager
                                                .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "desmond", "desmond");

                                        String insertEmpValues = "UPDATE EMPDUPE"
                                                + "SET DEPARTMENT_ID = ?"
                                                + "WHERE EMPLOYEE_ID = ?";

                                        PreparedStatement update = conn.prepareStatement(insertEmpValues);

                                        update.setInt(1, depId);
                                        update.setInt(2, empId);

                                        conn.close();

                                    } catch (SQLException e) {
                                        System.out.println(e);
                                    }
                                    beautify();
                                    System.out.println("*****Modified ID*****");
                                    break;

                                case 7:
                                    menu();
                                    break;
                            }
                            menu();
                        }
                    } else {
                        beautify();
                        System.out.println("You have entered an invalid employee number. Please check and before trying again.");
                        beautify();
                        menu();
                    }

                }
            } catch (InputMismatchException | NumberFormatException e) {
                beautify();
                System.out.println("Please enter a valid input (1-7)");
                beautify();
                modEmp();
            } catch (Exception e) {
                beautify();
                System.out.println("An exception has occured. Returning to main menu...");
                beautify();
                menu();
            }
        }

    }

    public static void delEmp() {
        try {

            System.out.println("Please enter Employee ID you wish to delete: ");
            int empId = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < empList.size(); i++) {
                if (empList.get(i).getEmpId() == empId) {
                    System.out.println("Do you wish to continue with deleting this record? (Y/N)");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("y")) {
                        try {
                            Connection conn = DriverManager
                                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "desmond", "desmond");

                            String delstmt = "DELETE FROM EMPDUPE WHERE EMPLOYEE_ID = " + empId;

                            Statement stmt = conn.createStatement();

                            int count = stmt.executeUpdate(delstmt);
                            System.out.println("Number of rows deleted: " + count);

                        } catch (SQLException e) {
                            System.out.println(e);
                        }

                    } else {
                        beautify();
                        System.out.println("Returning to main menu...");
                        beautify();
                    }

                } else {
                    beautify();
                    System.out.println("You have entered an invalid Employee ID. Please check and try again.");
                    beautify();
                    menu();
                }
            }

        } catch (InputMismatchException | NumberFormatException e) {
            beautify();
            System.out.println("Please enter a valid input type");
            beautify();
            menu();
        } catch (Exception e) {
            beautify();
            System.out.println("An exception has occured. Returning to main menu...");
            beautify();
            menu();
        }

    }

    //to add lines to separate stuff. not very efficient but limited to my technical knowledge
    public static void beautify() {
        System.out.println("=================================================================================");
    }

    //validate my department whether it is already present
    //should be able to use to this to validate whether particular employee number is present to avoid another entry
    //but should be noted that employee numbering is now the largest empNo + 1 so should not be an issue at the moment
    public static int validation(int depId) {
        System.out.println(depList);
        int count = 0;
        for (int i = 0; i < depList.size(); i++) {
            int j = depList.get(i).getDepId();
            if (depId == j) {
                count++;
            }
        }
        return count;
    }

}
