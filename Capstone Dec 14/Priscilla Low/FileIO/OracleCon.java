/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileIO;

/**
 *
 * @author blueg
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class OracleCon {

    public static void main(String args[]) {
        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "xx", "xx");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from EMPLOYEES");
            System.out.println(" ID \t First Name \t Deptno");

            while (rs.next()) {
                //System.out.println(rs.getInt(1) + " \t" + rs.getString(2) + " \t" + rs.getInt(3));
                System.out.println(rs.getInt("EMPLOYEE_ID")+ " \t" + rs.getString("FIRST_NAME") + " \t" + rs.getInt("DEPARTMENT_ID") );
            }

//close the connection object  
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}