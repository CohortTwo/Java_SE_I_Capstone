/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sridh
 */

class OracleCon {

    public static void main(String args[]) {
        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "sridhar", "simon");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from emp");
            System.out.println(" ID \t EName \t Deptno");

            while (rs.next()) {
                //System.out.println(rs.getInt(1) + " \t" + rs.getString(2) + " \t" + rs.getInt(3));
                System.out.println(rs.getInt("empno")+ " \t" + rs.getString("ename") + " \t" + rs.getInt("deptno") );
            }

//close the connection object  
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
