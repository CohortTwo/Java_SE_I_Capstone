
package connectoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// include ojdbc8.jar in the library path of the source code in Netbean

class OracleCon {

    public static void main(String args[]) {
        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "hr");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employees");   //table is employees
            System.out.println(" ID \t First Name \t Department no");

            while (rs.next()) {
                //System.out.println(rs.getInt(1) + " \t" + rs.getString(2) + " \t" + rs.getInt(3));
                System.out.println(rs.getInt("employee_id")+ " \t" + rs.getString("first_name") + " \t" + rs.getInt("department_id") );
            }

//close the connection object  
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
