/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
import java.util.InputMismatchException;

/**
 *
 * @author chiangyong
 */
public class SQL {

    /**
     *
     * @return
     */
    OrcaleConn dBase = new OrcaleConn();
    Connection conn = dBase.connDbase();
    Statement stmt;
    Scanner inp = new Scanner(System.in);
    //  PreparedStatement ps;

    public SQL() throws SQLException {
        this.stmt = conn.createStatement();
        //   this.ps = conn.prepareStatement();

    }

    //Add employee record
    public void AddEmpRec() throws SQLException {
        //ArrayList<EmpRecord> arrEmpRec = new ArrayList<EmpRecord>();
        printFormat prn = new printFormat();
        String dispRec;
        String firstName = "";
        String lastName = "";
        String eMail = "";
        String phoneNum = "";
        String hireDate = "";
        String jobID = "";
        float empSalary = 0;
        float comPct = 0;
        int mgrID = 0;
        int deptID = 0;

        try {
            int empID = maxID("emp") + 1;
            System.out.println("Auto Generated Employee ID is " + empID);
            String statement = "select employee_id,first_name from emp "
                    + "where employee_id =" + Integer.toString(empID) 
                    + " order by employee_id";
            ResultSet rs = stmt.executeQuery(statement);

            if (rs.next()) {
                System.err.println("Employee ID is already taken!");
                System.out.println(rs.getInt("Employee_id") + " \t  " 
                        + rs.getString("first_name"));
            } else {
                System.out.print("Enter First Name: ");
                firstName = inp.nextLine();
                firstName = firstName.substring(0, 1).toUpperCase() 
                        + firstName.substring(1,firstName.length()).toLowerCase();

                System.out.print("Enter Last Name: ");
                lastName = inp.nextLine();
                lastName = lastName.substring(0, 1).toUpperCase() 
                        + lastName.substring(1, lastName.length()).toLowerCase();

                //System.out.print("Enter Email: ");
                eMail = firstName.substring(0, 1).toUpperCase() 
                        + lastName.toUpperCase();

                System.out.print("Enter Phone Number: ");
                phoneNum = inp.nextLine();

                System.out.print("Enter Hire Date as <dd-MON-yyyy: ");
                hireDate = inp.nextLine();

                System.out.print("Enter Job ID: ");
                jobID = inp.nextLine();

                System.out.print("Enter Salary: ");
                empSalary = inp.nextFloat();
                inp.nextLine();

                if (jobID.matches("SA_MAN") || jobID.matches("SA_REP")) {
                    System.out.print("Enter Commission %: ");
                    comPct = inp.nextFloat();
                    inp.nextLine();
                }
//                System.out.print("Enter Manager ID: ");
//                mgrID = inp.nextInt();
//                inp.nextLine();

                System.out.print("Enter Department ID: ");
                deptID = inp.nextInt();
                inp.nextLine();
                switch (deptID) {
                    case 10:
                        mgrID = 200;
                        break;
                    case 20:
                        mgrID = 201;
                        break;
                    case 50:
                        mgrID = 124;
                        break;
                    case 60:
                        mgrID = 103;
                        break;
                    case 80:
                        mgrID = 149;
                        break;
                    case 90:
                        mgrID = 100;
                        break;
                    case 110:
                        mgrID = 205;
                        break;
                    case 190:
                        mgrID = 0;
                        break;
                    default:
                        mgrID = 0;
                        break;

                }

                System.out.print("Confirm adding new record? Y/N : ");
                String confirm = inp.nextLine();

                if (confirm.matches("Y") || confirm.matches("y")) {
                    statement = "Insert into emp VALUES (" + empID + ", '" 
                            + firstName + "','"+ lastName + "','" 
                            + eMail + "','" + phoneNum + "','" 
                            + hireDate + "','"+ jobID + "'," 
                            + empSalary + "," + comPct + "," 
                            + mgrID + "," + deptID + ",'no grading')";

                    System.out.println(statement);
                    rs = stmt.executeQuery(statement);
                    rs.next();

                    statement = "select employee_id, first_name, "
                            + "last_name,hire_date from emp "
                            + "where employee_id =" + Integer.toString(empID);
                    // System.out.println(statement);
                    rs = stmt.executeQuery(statement);
                    rs.next();

                    dispRec = "ID FirstName LastName Hire_Date";
                    prn.printEmpRec(dispRec, 4);

                    dispRec = rs.getInt("EMPLOYEE_ID") + " " 
                            + rs.getString("FIRST_NAME")
                            + " " + rs.getString("last_name") + " " 
                            + rs.getDate("hire_date");
                    prn.printEmpRec(dispRec, 4);

                    System.out.println("New record has successully added.");
                } else {
                    System.out.println("Record is not added to Employee Table!");
                }
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    //Display All Employees Record
    public void ShowAllEmp() throws SQLException {
        String prnStr;
        printFormat prn = new printFormat();

        try {

            ResultSet rs = stmt.executeQuery("select employee_id, first_name, "
                    + "department_name from emp, departments "
                    + "where emp.department_id = departments.department_id "
                    + "order by employee_id");
            // System.out.println(" ID \tFirst Name \t Deptno");
            prnStr = "EmpID FirstName DeptID";
            prn.printEmpRec(prnStr, 3);

            while (rs.next()) {
                prnStr = rs.getInt("EMPLOYEE_ID") + " " 
                        + rs.getString("FIRST_NAME")
                        + " " + rs.getString("Department_name");
                prn.printEmpRec(prnStr, 3);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void updateEmpRec() {
        String dispRec;
        printFormat prn = new printFormat();
        int empID;
        float salary = 0;
        float commPct = 0;
        String jobID = "";
        int deptID = 0;
        int mgrID = 0;
        String st;
        String upStr;
        boolean done = false;

        try {
            System.out.print("Enter the employee ID for editing : ");
            empID = inp.nextInt();
            inp.nextLine();

            st = "select employee_id, first_name, last_name, job_id, salary, "
                    + "commission_pct, department_id, manager_id from emp "
                    + "where employee_id = " + Integer.toString(empID);
            ResultSet rs = stmt.executeQuery(st);

            prn.printEmpRec("EmpID FirstName LastName JobID Salary "
                    + "CommPCT MgrID DeptID", 8);
            if (rs.next()) {
                jobID = rs.getString("job_id");
                salary = rs.getFloat("salary");
                commPct = rs.getFloat("commission_pct");
                mgrID = rs.getInt("manager_id");
                deptID = rs.getInt("department_id");

                prn.printEmpRec(rs.getInt("employee_id") + " "
                        + rs.getString("first_name") + " "
                        + rs.getString("last_name")
                        + " " + jobID + " " + salary + " " + commPct
                        + " " + mgrID + " " + deptID, 8);

                do {
                    System.out.println("Enter the items to update "
                            + "<job_id / salary / maanager ID / department_id "
                            + "/ commisson_pct> : ");
                    String item = inp.nextLine();
                    switch (item.toLowerCase()) {
                        case "job_id":
                            System.out.print("Enter new Job ID :");
                            jobID = inp.nextLine();
                            break;
                        case "salary":
                            System.out.print("Enter new Salary : ");
                            salary = inp.nextFloat();
                            inp.nextLine();
                            break;
                        case "department_id":
                            System.out.print("Enter new department ID : ");
                            deptID = inp.nextInt();
                            inp.nextLine();
                            break;
                        case "manager_id":
                            System.out.print("Enter new manager ID : ");
                            mgrID = inp.nextInt();
                            inp.nextLine();
                            break;
                        case "commission_pct":
                            System.out.print("Enter new commission % : ");
                            commPct = inp.nextFloat();
                            inp.nextLine();
                            break;
                        default:
                            System.out.println("Select the correct items to be update");
                            break;
                    }

                    System.out.print("Are you done with the update? : (Y/N) ");
                    String updone = inp.nextLine();
                    if (updone.matches("Y") || updone.matches("y")) {
                        done = true;
                    } else {
                        done = false;
                    }

                } while (!done);

                System.out.print("Confirm updating the record : (Y/N) ");
                String confirm = inp.nextLine();
                if (confirm.matches("Y") || confirm.matches("y")) {
                    st = "update emp"
                            + " set job_id = '" + jobID + "', salary = " + salary
                            + ", manager_id = " + mgrID + ", department_id = "
                            + deptID + ", commission_pct = " + commPct
                            + " where employee_id =" + Integer.toString(empID);

                    rs = stmt.executeQuery(st);
                    if (rs.next()) {
                        System.out.println("The record is successfully updated!");
                    } else {
                        System.out.println("No record is updated!");
                    }
                } else {
                    System.out.println("Updating record is cancelled!");
                }
            } else {
                System.err.println("Record Employee ID : " 
                        + empID + " is not found!");
            }

        } catch (SQLException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //Query an Employee record
    public void QueryEmpRec() {

        String dispRec;
        printFormat prn = new printFormat();

        System.out.print("Enter your Query :");
        try {
            String inStr = inp.nextLine();
            ResultSet rs = stmt.executeQuery(inStr);
            
            dispRec = "EmpID FirstName LastName Salary DeptID";
            prn.printEmpRec(dispRec, 5);
            
            while (rs.next()) {
                dispRec = rs.getInt("employee_id") + " " 
                        + rs.getString("first_name") + " " 
                        + rs.getString("last_name")+ " " 
                        + rs.getFloat("salary") + " " 
                        + rs.getInt("department_id");
                prn.printEmpRec(dispRec, 5);
            }

        } catch (InputMismatchException e) {
            System.err.println("Input Mismatch");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Delete Employee Record
    public void delEmpRec() {
        String dispRec;
        String firstname;
        String st;
        int IDEmp = 0;
        printFormat prn = new printFormat();

        try {
            System.out.print("Enter Employee ID to be deleted: ");
            IDEmp = inp.nextInt();
            inp.nextLine();

            st = "select employee_id, first_name, last_name from emp "
                    + "where employee_id = " + Integer.toString(IDEmp);

            ResultSet rs = stmt.executeQuery(st);

            dispRec = "EmpID FirstName LastName";

            if (rs.next()) {
                prn.printEmpRec(dispRec, 3);
                dispRec = rs.getInt("employee_id") + " " 
                        + rs.getString("first_name")
                        + " " + rs.getString("last_name");
                prn.printEmpRec(dispRec, 3);
                System.out.print("Confirm deleting the record: (Y/N) ");
                String inpStr = inp.nextLine();
                if (inpStr.matches("Y") || inpStr.matches("y")) {
                    st = "delete from emp where employee_id = " 
                            + Integer.toString(IDEmp);
                    rs = stmt.executeQuery(st);
                    if (rs.next()) {
                        System.out.println("Record " + dispRec);
                    }
                }
            } else {
                System.err.println("Record of " + IDEmp + " is not found!");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    //Add Department Record
    public void AddDepRec() {

        String dispRec;
        printFormat prn = new printFormat();
        String st;
        int deptID;
        int dMgrID;
        int dLocID;
        String deptName;
        String confirm;

        try {
            deptID = maxID("dept") + 1;       //find the last department ID and add 1 to it
            st = "select Department_id, department_name from departments "
                    + "where department_id =" + Integer.toString(deptID);
            ResultSet rs = stmt.executeQuery(st);
            if (rs.next()) {
                System.err.println("Deaprtment ID is already taken!");
                System.out.println(rs.getInt("department_id") + " \t  " 
                        + rs.getString("department_name"));
            } else {
                System.out.println("Auto generated Department ID is " + deptID);
                System.out.println("Enter Department Name:  ");
                deptName = inp.nextLine();
                deptName = deptName.substring(0, 1).toUpperCase() 
                        + deptName.substring(1, deptName.length()).toLowerCase();
                System.out.println("Enter Manager ID:  ");
                dMgrID = inp.nextInt();
                inp.nextLine();
                System.out.println("Enter Location ID:  ");
                dLocID = inp.nextInt();
                inp.nextLine();

                System.out.print("Confirm adding new record? Y/N : ");
                confirm = inp.nextLine();
                if (confirm.matches("Y") || confirm.matches("y")) {
                    st = "insert into departments values(" + deptID + ",'" 
                            + deptName + "'," + dMgrID + "," + dLocID + ")";
                    rs = stmt.executeQuery(st);
                    rs.next();

                    st = "select * from departments where department_id =" 
                            + Integer.toString(deptID);
                    rs = stmt.executeQuery(st);
                    rs.next();
                    
                    dispRec = "Dept_ID Dept_Name Manager_ID Location_D";
                    prn.printDeptRec(dispRec, 4);
                    
                    dispRec = rs.getInt("department_id") + " " 
                            + rs.getString("department_name")
                            + " " + rs.getInt("manager_id") + " " 
                            + rs.getInt("location_id");
                    prn.printDeptRec(dispRec, 4);
                   

                } else {
                    System.out.println("Add new record is cancelled!");
                }
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void QueryDepRec() {
        String dispRec;
        printFormat prn = new printFormat();

        System.out.print("Enter your Query :");
        try {
            String inStr = inp.nextLine();
            ResultSet rs = stmt.executeQuery(inStr);
            dispRec = "DeptID DeptName MgrID LocationID";

            prn.printDeptRec(dispRec, 4);
            while (rs.next()) {
                dispRec = rs.getInt("department_id") + " " 
                        + rs.getString("department_name") + " " 
                        + rs.getInt("manager_id")
                        + " " + rs.getInt("location_id");
                prn.printDeptRec(dispRec, 4);
            }

        } catch (InputMismatchException e) {
            System.err.println("Input Mismatch");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void delDepRec() {
        String dispRec;
        printFormat prn = new printFormat();
        int DeptID;
        String st;

        try {
            System.out.print("Enter Department ID to be deleted: ");
            DeptID = inp.nextInt();
            inp.nextLine();
            st = "Select * from departments where department_id = " 
                    + Integer.toString(DeptID);
            ResultSet rs = stmt.executeQuery(st);
            dispRec = "DeptID DeptName MgrID LocationID";
            prn.printDeptRec(dispRec, 4);
            if (rs.next()) {
                dispRec = rs.getInt("department_id") + " " 
                        + rs.getString("department_name")
                        + " " + rs.getInt("manager_id") + " " 
                        + rs.getInt("location_id");
                prn.printEmpRec(dispRec, 4);
                System.out.print("Confirm deleting the record: (Y/N) ");
                String inpStr = inp.nextLine();
                if (inpStr.matches("Y") || inpStr.matches("y")) {
                    st = "delete from departments where department_id = " 
                            + Integer.toString(DeptID);
                    rs = stmt.executeQuery(st);
                    if (rs.next()) {
                        System.out.println("Record " + dispRec);
                    }
                }
            } else {
                System.err.println("Department ID = " 
                        + DeptID + " is not found!");
            }

        } catch (SQLException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void showAllDept() {
        printFormat prnRec = new printFormat();
        try {
            String dispRec;
            String statement = "select * from departments ";
            ResultSet rs = stmt.executeQuery(statement);

            prnRec.printDeptRec("DeptID DeptName MangerID LocationID", 4);

            while (rs.next()) {
                dispRec = rs.getInt("department_id") + " " 
                        + rs.getString("department_name") 
                        + " " + rs.getInt("manager_id") + " " 
                        + rs.getInt("location_id");
                prnRec.printDeptRec(dispRec, 4);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public int maxID(String inS) {
        String st;
        if (inS.matches("emp")) {
            st = "Select employee_id from emp "
                    + "where employee_id = (select max(employee_id) from emp)";
        } else if (inS.matches("dept")) {
            st = "select department_id from departments"
                    + " where department_id = (select max(department_id) "
                    + "from departments)";
        } else {
            return 0;
        }

        int idMax = 0;
        try {
            ResultSet rs = stmt.executeQuery(st);
            rs.next();

            if (inS.matches("emp")) {
                idMax = rs.getInt("employee_id");
                System.out.println("The Last Employee ID is " + idMax);
            } else if (inS.matches("dept")) {
                idMax = rs.getInt("department_id");
                System.out.println("The Last Department ID is " + idMax);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return idMax;
    }

    public void exitRec() throws SQLException {
        stmt.close();
        conn.close();
    }
}
