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
/**
 *
 * @author chiangyong
 */
public class OrcaleConn {

    /**
     * @param args the command line arguments
     */
    
    public Connection connDbase(){
        try 
        {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "heng", "heng");
        
           return conn; 
        }
        
        catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        
    }
    public static void main(String args[]) {
        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "heng", "heng");
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("select employee_id, first_name, department_name from emp, departments where emp.department_id = departments.department_id");
            System.out.println(" ID \tFirst Name \t Deptno");

            while (rs.next()) {
               //System.out.println(rs.getInt(1) + " \t" + rs.getString(2) + " \t" + rs.getInt(3));
               System.out.println(rs.getInt("EMPLOYEE_ID")+ " \t" + rs.getString("FIRST_NAME") + "     \t " + rs.getString("Department_name") );
            }

//close the connection object  
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
