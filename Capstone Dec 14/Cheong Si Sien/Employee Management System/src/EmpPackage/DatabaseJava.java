package EmpPackage;

import static EmpPackage.DatabaseJava.display;
import static EmpPackage.DatabaseJava.emplist;
import static EmpPackage.DatabaseJava.queryAll;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
//import javax.swing.table.DefaultTableModel;

public class DatabaseJava {

    static ArrayList<Emp> emplist = new ArrayList<>();

    public static void main(String args[]) {
        display();
    }

    public static void display() {
        emplist.clear();
        System.out.println("\033[0;31m" + "\u001B[43m|            Employee Management System                 |\n");
        System.out.println("\033[0;34m" + "1. Query all Employees information\n\033[0;34m2. Query according to Employee ID\n\033[0;34m3. Add Employee\n\033[0;34m4. Modify Employee information\n\033[0;34m5. Delete Employee\n\033[0;34m6. Exit");
       
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                queryAll(1);
                break;
            case 2:
                queryId(2);
                break;
            case 3:
                addEmployee();
                queryAll(0);

                break;
            case 4:
                changeEmployee();
                break;
            case 5:
                queryId(5);
                break;
            case 6:
                System.out.println("Exiting Library System");
                break;
        }
    }

    public static void queryAll(int x) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "javadb", "javadb");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from javaemp order by empid");
            //       ArrayList<rs> customerList = new ArrayList<>();
            System.out.println(" ID \t firstName");
            while (rs.next()) {
                Emp emp = new Emp();
                emp.setEmpId(rs.getInt("empid"));
                emp.setName(rs.getString("name"));
                emp.setDeptId(rs.getInt("deptid"));
                emp.setPhone(rs.getString("phone"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setCommPct(rs.getDouble("commpct"));
                emp.setEmail(rs.getString("email"));
                emplist.add(emp);

            }

            stmt.close();

            //method 1
//close the connection object
        } catch (SQLException e) {
            System.out.println(e);
        }

        if (x == 1) {
            if (emplist.size() != 0) {
                for (int i = 0; i < emplist.size(); i++) {

                    System.out.println("The employee information for employee ID:" + emplist.get(i).getEmpId()
                            + " is: \n-----------------------------------------------\n"
                            + "Name:" + emplist.get(i).getName() + "\nPhone is:" + emplist.get(i).getPhone() + "\nEmail is:"
                            + emplist.get(i).getEmail() + "\nDepartment ID is:"
                            + emplist.get(i).getDeptId() + "\nSalary is:" + emplist.get(i).getSalary() + "\nCommission Percentage is:"
                            + emplist.get(i).getCommPct() + "\n-----------------------------------------------\n\n");
                }
            } else {
                System.out.println("\033[0;31m This system has no Employee information temporarily!\n");
            }
        }

        if (x != 2) {
            display();
        }
    }

    public static void queryId(int y) {
        queryAll(2);

//close the connection object
        int i;
        if (emplist.size() != 0) {
            int j = 0;
            System.out.println("Please enter Employee id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (i = 0; i < emplist.size(); i++) {
                if (emplist.get(i).getEmpId() == id) {
                    j++;
                    System.out.println("The employee information for employee ID:" + emplist.get(i).getEmpId()
                            + " is: \n-----------------------------------------------\n"
                            + "Name:" + emplist.get(i).getName() + "\nPhone is:" + emplist.get(i).getPhone() + "\nEmail is:"
                            + emplist.get(i).getEmail() + "\nDepartment ID is:"
                            + emplist.get(i).getDeptId() + "\nSalary is:" + emplist.get(i).getSalary() + "\nCommission Percentage is:"
                            + emplist.get(i).getCommPct() + "\n-----------------------------------------------\n\n");

                    if (y == 5) {
                        try {
                            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "javadb", "javadb");
                            String sql = "DELETE FROM javaemp WHERE empid = ?";

                            PreparedStatement statement = conn.prepareStatement(sql);

                            statement.setInt(1, id);

                            //  System.out.println(statement.getParameterMetaData());
                            int x = statement.executeUpdate();

                            if (x > 0) {
                                System.out.println("Successfully deleted");
                            } else {
                                System.out.println("delete Failed");
                            }
                        } //close the connection object
                        catch (SQLException e) {
                            System.out.println("ECEPTION ERROR");
                            System.out.println(e);
                        }

                    }

                    break;

                }
            }
            if (j == 0) {
                System.out.println("\033[0;31mThis system temporarily has no such Employee id information!\n");
            }
        } else {
            System.out.println("\033[0;31mThis system has no such Employee information temporarily!\n");
        }
        display();
    }

    public static void addEmployee() {

        String name;
        String phone;
        int deptid = 0;
        double salary = 0;
        double commpct = 0;
        String email;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name:");
        name = sc.next();

        System.out.println("Please enter the phone number:");
        phone = sc.next();

        System.out.println("Please enter the email:");
        email = sc.next();

        while (true) {
            try {
                System.out.println("Please enter the Department id(integer), key in 0 if not assigned department:");
                deptid = sc.nextInt();
                break;
                //} catch (InputMismatchException ie) {
            } catch (Exception ie) {
                sc.next();
                System.out.println("\033[0;31mDepartment ID must be a number");
            }
        }

        while (true) {
            try {
                System.out.println("Please enter the salary:");
                salary = sc.nextDouble();
                break;
                //} catch (InputMismatchException ie) {
            } catch (Exception ie) {
                sc.next();
                System.out.println("\033[0;31mSalary must be a decimal number");
            }
        }

        while (true) {
            try {
                System.out.println("Please enter the commision:");
                commpct = sc.nextDouble();
                break;
                //} catch (InputMismatchException ie) {
            } catch (Exception ie) {
                sc.next();
                System.out.println("\033[0;31mCommision must be a decimal number");
            }
        }

        //    INSERT INTO "JAVADB"."JAVAEMP" (NAME, EMAIL, PHONE, SALARY, COMMPCT, DEPTID) VALUES ('css3', 'cssss', 'csssssss', '10000', '0.2', '87');
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "javadb", "javadb");

            String sql = "insert into javaemp (NAME, EMAIL, PHONE, SALARY, COMMPCT, DEPTID) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.setDouble(4, salary);
            statement.setDouble(5, commpct);
            statement.setInt(6, deptid);

            int x = statement.executeUpdate();

            if (x > 0) {
                System.out.println("Successfully Inserted");
            } else {
                System.out.println("Insert Failed");
            }
        } //close the connection object
        catch (SQLException e) {
            System.out.println("ECEPTION ERROR");
            System.out.println(e);
        }

        display();
    }

    public static void changeEmployee() {

        queryAll(2);
        String name;
        String phone;
        int deptid = 0;
        double salary = 0;
        double commpct = 0;
        String email;
        int empid = 0;

        int i;
        if (emplist.size() != 0) {
            int j = 0;
            System.out.println("Please enter Employee id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (i = 0; i < emplist.size(); i++) {
                if (emplist.get(i).getEmpId() == id) {
                    j++;

                    empid = emplist.get(i).getEmpId();
                    System.out.println("EMPLOYEE ID IS: " + empid);
                    name = emplist.get(i).getName();
                    phone = emplist.get(i).getPhone();
                    email = emplist.get(i).getEmail();
                    deptid = emplist.get(i).getDeptId();
                    salary = emplist.get(i).getSalary();
                    commpct = emplist.get(i).getCommPct();

                    System.out.println("old name : " + name + " Please enter the new name: ");
                    name = sc.next();

                    System.out.println("old phone : " + phone + " Please enter the phone number: ");
                    phone = sc.next();

                    System.out.println("old email : " + email + " Please enter the email: ");
                    email = sc.next();

                    while (true) {
                        try {
                            System.out.println("old dept id : " + deptid + " Please enter the Department id(integer), key in 0 if not assigned department:");
                            deptid = sc.nextInt();
                            break;
                            //} catch (InputMismatchException ie) {
                        } catch (Exception ie) {
                            sc.next();
                            System.out.println("\033[0;31mDepartment ID must be a number");
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("Old salary : " + salary + " Please enter the salary :");
                            salary = sc.nextDouble();
                            break;
                            //} catch (InputMismatchException ie) {
                        } catch (Exception ie) {
                            sc.next();
                            System.out.println("\033[0;31mSalary must be a decimal number");
                        }
                    }

                    while (true) {
                        try {
                            System.out.println("old commission:" + commpct + "Please enter the commision:");
                            commpct = sc.nextDouble();
                            break;
                            //} catch (InputMismatchException ie) {
                        } catch (Exception ie) {
                            sc.next();
                            System.out.println("\033[0;31mCommision must be a decimal number");
                        }
                    }

                    //    INSERT INTO "JAVADB"."JAVAEMP" (NAME, EMAIL, PHONE, SALARY, COMMPCT, DEPTID) VALUES ('css3', 'cssss', 'csssssss', '10000', '0.2', '87');
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "javadb", "javadb");
                        String sql = "update javaemp set NAME=?, EMAIL=?, PHONE=?, SALARY=?, COMMPCT=?, DEPTID=? where empid = ?";

                        PreparedStatement statement = conn.prepareStatement(sql);
                        statement.setString(1, name);
                        statement.setString(2, email);
                        statement.setString(3, phone);
                        statement.setDouble(4, salary);
                        statement.setDouble(5, commpct);
                        statement.setInt(6, deptid);
                        statement.setInt(7, empid);

                        //  System.out.println(statement.getParameterMetaData());
                        int x = statement.executeUpdate();

                        if (x > 0) {
                            System.out.println("Successfully Amended");
                        } else {
                            System.out.println("Insert Failed");
                        }
                    } //close the connection object
                    catch (SQLException e) {
                        System.out.println("ECEPTION ERROR");
                        System.out.println(e);
                    }
                }
            }
            if (j == 0) {
                System.out.println("\033[0;31mThis system temporarily has no such Employee id information!\n");
            }
        } else {
            System.out.println("\033[0;31mThis system has no such Employee information temporarily!\n");
        }
        display();

    }

}
