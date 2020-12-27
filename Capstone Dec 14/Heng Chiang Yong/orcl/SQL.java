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
     PreparedStatement ps;
     
    public SQL() throws SQLException {
        this.stmt = conn.createStatement();
     //   this.ps = conn.prepareStatement();
        
    }
     
    public void AddEmpRec() throws SQLException{
        //ArrayList<EmpRecord> arrEmpRec = new ArrayList<EmpRecord>();
        
        try {

            System.out.print("Enter Employee ID: ");
            int empID = inp.nextInt();
            inp.nextLine();
            String statement = "select employee_id,first_name from emp where employee_id =" + Integer.toString(empID);
         //   System.out.println(statement);
            ResultSet rs = stmt.executeQuery(statement);
            //rs.afterLast();
           // System.out.println("rs.next() = "+rs.next());
            if (rs.next()) {
                System.err.println("Employee ID is already taken!");
                System.out.println(rs.getInt("Employee_id") + " \t  " + rs.getString("first_name"));
            } 
            else {
                System.out.print("Enter First Name: ");
                String firstName = inp.nextLine();
                System.out.print("Enter Last Name: ");
                String lastName = inp.nextLine();
                System.out.print("Enter Email: ");
                String eMail = inp.nextLine();
                System.out.print("Enter Phone Number: ");
                String phoneNum = inp.nextLine();
                System.out.print("Enter Hire Date as <dd-MON-yyyy: ");
                String hireDate = inp.nextLine();
//                System.out.println(Date.valueOf(hireDate));
                System.out.print("Enter Job ID: ");
                String jobID = inp.nextLine();
                System.out.print("Enter Salary: ");
                float empSalary = inp.nextFloat();
                System.out.print("Enter Commission %: ");
                float comPct = inp.nextFloat();
                System.out.print("Enter Manager ID: ");
                int mgrID = inp.nextInt();
                System.out.print("Enter Department ID: ");
                int deptID = inp.nextInt();
                
                statement = "Insert into emp VALUES ("+empID + ", '"+ firstName+"','"+
                        lastName+"','"+eMail+"','"+phoneNum+"','"+hireDate+"','"+
                        jobID+"',"+empSalary+","+comPct+","+mgrID+","+deptID+",'no grading')";
               // statement = "Insert into emp (employee_id,first_name,last_name,email) VALUES("+Integer.toString(empID)+","+"'"+firstName+"'"+","+"'"+lastName+"'"+",'abc.abc')";
                System.out.println(statement);
                rs = stmt.executeQuery(statement);
                rs.next();
                
                statement = "select employee_id, first_name, last_name from emp where employee_id ="+Integer.toString(empID);
                System.out.println(statement);
                rs=stmt.executeQuery(statement);
                rs.next();
                System.out.println(" ID \tFirst Name   \t Last Name   \t   HIRE Date");
                System.out.println(rs.getInt("EMPLOYEE_ID")+ " \t" + rs.getString("FIRST_NAME") + "     \t " + rs.getString("last_name")+ "   \t  " +rs.getDate(hireDate));
                System.out.println("New record has successully inserted.");
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public void ShowAllEmp() throws SQLException{
        String prnStr;
        printFormat prn = new printFormat();
        
        try{
            ResultSet rs = stmt.executeQuery("select employee_id, first_name, department_name from emp, departments where emp.department_id = departments.department_id");
           // System.out.println(" ID \tFirst Name \t Deptno");
            prnStr = "EmpID FirstName DeptID";
            prn.printEmpRec(prnStr, 3);
//            ResultSet rs = stmt.executeQuery("select * from emp");
//            prnStr = "EmpID FirstName LastName Email PhoneNo HireDate JobID Salary Comm% MgrID DeptId Stars";
//            prn.printEmpRec(prnStr, 12);
            
            while (rs.next()) {
                //System.out.println(rs.getInt("EMPLOYEE_ID")+ " \t" + rs.getString("FIRST_NAME") + "     \t " + rs.getString("Department_name") );
                prnStr = rs.getInt("EMPLOYEE_ID")+ " " + rs.getString("FIRST_NAME") + " " + rs.getString("Department_name");
                prn.printEmpRec(prnStr, 3);
            }
        }
        catch(SQLException e)
        {
            System.err.println(e);  
        } 
    }
    
    public void QueryEmpRec(){
        
        String dispRec;
        printFormat prn = new printFormat();
        
        
        System.out.print("Enter your Query :");
        try
        {
           String inStr = inp.nextLine();
           ResultSet rs = stmt.executeQuery(inStr);
           dispRec = "EmpID FirstName LastName Salary DeptID";
           
           prn.printEmpRec(dispRec, 5);
           while(rs.next())
           {
               dispRec = rs.getInt("employee_id")+" "+rs.getString("first_name")+" "+rs.getString("last_name")+
                       " "+rs.getFloat("salary")+ " "+rs.getInt("department_id");
               prn.printEmpRec(dispRec, 5);
           }
            
        }
        catch(InputMismatchException e)
        {
            System.err.println("Input Mismatch");
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public void AddDepRec() {
       try
       {
          System.out.println("Enter Department ID:");
          int deptID = inp.nextInt();
          inp.nextLine();
          String statement = "select Department_id, department_name from departments where department_id =" + Integer.toString(deptID);
          ResultSet rs = stmt.executeQuery(statement);
          if(rs.next())
          {
              System.err.println("Deaprtment ID is already taken!");
              System.out.println(rs.getInt("department_id") + " \t  " + rs.getString("department_name")); 
          }
          else
          {
              System.out.println("Enter Department Name:  ");
              String deptName = inp.nextLine();
              System.out.println("Enter Manager ID:  ");
              int dMgrID = inp.nextInt();
              System.out.println("Enter Location ID:  ");
              int dLocID = inp.nextInt();
              
              statement = "insert into departments values(" + deptID + ",'"+deptName+"',"+dMgrID+","+dLocID+")";
              rs = stmt.executeQuery(statement);
              rs.next();
              
              statement = "select * from departments where department_id =" +Integer.toString(deptID);
              rs = stmt.executeQuery(statement);
              rs.next();
              System.out.println("Dept ID   \t Dept Name     \t Manger ID   \t Location ID");
              System.out.println(rs.getInt("department_id")+ " \t " + rs.getString("department_name")+ "  \t  "+ rs.getInt("manager_id")+ "  \t  "+rs.getInt("location_id"));
          }
       }
       catch(SQLException e)
       {
           System.err.println(e); 
       }
    }
    
    public void QueryDepRec(){
        String dispRec;
        printFormat prn = new printFormat();
        
        
        System.out.print("Enter your Query :");
        try
        {
           String inStr = inp.nextLine();
           ResultSet rs = stmt.executeQuery(inStr);
           dispRec = "DeptID DeptName MgrID LocationID";
           
           prn.printDeptRec(dispRec, 4);
           while(rs.next())
           {
               dispRec = rs.getInt("department_id")+" "+rs.getString("department_name")+" "+rs.getInt("manager_id")+
                       " "+rs.getInt("location_id");
               prn.printDeptRec(dispRec, 4);
           }
            
        }
        catch(InputMismatchException e)
        {
            System.err.println("Input Mismatch");
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }
    
    public void showAllDept()
    {
        printFormat prnRec = new printFormat();
        try
        {
              String dispRec;
              String statement = "select * from departments ";
              ResultSet rs = stmt.executeQuery(statement);
             
              prnRec.printDeptRec("DeptID DeptName MangerID LocationID", 4);
              
              while(rs.next())
              {
              dispRec = rs.getInt("department_id")+ " " + rs.getString("department_name")+ " "+ rs.getInt("manager_id")+ " "+rs.getInt("location_id");
              prnRec.printDeptRec(dispRec, 4);
              }
        }
        catch(SQLException e)
        {
            System.err.println(e); 
        }
    }
    
    public void exitRec() throws SQLException{
        stmt.close();
        conn.close();
    }
}
