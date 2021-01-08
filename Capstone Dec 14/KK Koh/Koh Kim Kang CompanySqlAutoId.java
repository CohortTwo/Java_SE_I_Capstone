package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CompanySqlAutoId {

    static Scanner sc = new Scanner(System.in);
    static String sqlCmd;
    static ArrayList<String> colTypes = new ArrayList<>();
    static ArrayList<Integer> empIds = new ArrayList<>();
    static HashMap<String, Integer> depNames = new HashMap<>();
    static int lastEmpId = 0;

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static int empCol, depCol;
    static int select;

    public static void main(String[] args) {

        try {
            conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "kk", "kk");
            conn.setAutoCommit(false);  // need to set autocommit to off to implement savepoint.
            stmt = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();

            rs = dbm.getTables(null, null, ("JAVADEPARTMENTS").toUpperCase(), null);    // Table name needs to be uppercase.
            if (rs.next()) {
                stmt.executeUpdate("Drop Table JAVADEPARTMENTS");
            }

            rs = dbm.getTables(null, null, ("JAVAEMPLOYEES").toUpperCase(), null);    // Table name needs to be uppercase.
            if (rs.next()) {
                stmt.executeUpdate("Drop Table JAVAEMPLOYEES");
            }

            sqlCmd = "Create Table JavaDepartments as Select department_id, department_name from Departments";
            stmt.executeUpdate(sqlCmd);
            sqlCmd = "Create Table JavaEmployees as Select employee_id, first_name, last_name, salary, department_id from Employees";
//            sqlCmd = "Create Table JavaEmployees as Select employee_id, first_name, last_name, salary, department_id from Employees where employee_id=0";
            stmt.executeUpdate(sqlCmd);

            do {
                try {
                    System.out.print("\n1. Show All Employee Data\n"
                            + "2. Add Employee Data\n"
                            + "3. Delete Employee Data\n"
                            + "4. Update Employee Data\n"
                            + "5. SQL Command Prompt\n"
                            + "9. EXIT\n"
                            + "\nSelect : ");

                    select = sc.nextInt();
                    sc.nextLine();

                    switch (select) {
                        case 1:
                            System.out.println();
                            employeeData();
                            rs.close();
                            break;
                        case 2:
                            System.out.println();
                            addEmployeeData();
                            rs.close();
                            break;
                        case 3:
                            System.out.println();
                            deleteEmployeeData();
                            rs.close();
                            break;
                        case 4:
                            System.out.println();
                            updateEmployeeData();
                            rs.close();
                            break;
                        case 5:
                            sqlCommand();
                            rs.close();
                            break;
                        case 9:
                            break;
                        default:
                            select = 0;
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage() + ", Invalid Input");
                    select = 0;
                } catch (Exception e) {
                    sc.nextLine();
                    System.out.println(e.getMessage() + ", Invalid Input");
                    select = 0;
                } finally {

                }

            } while (select != 9);

            rs = dbm.getTables(null, null, ("JAVADEPARTMENTS").toUpperCase(), null);    // Table name needs to be uppercase.
            if (rs.next()) {
                stmt.executeUpdate("Drop Table JAVADEPARTMENTS");
            }

            rs = dbm.getTables(null, null, ("JAVAEMPLOYEES").toUpperCase(), null);
            if (rs.next()) {
                stmt.executeUpdate("Drop Table JAVAEMPLOYEES");
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteEmployeeData() throws SQLException {
        int empId;
        boolean empExist = false;

        employeeData();
        System.out.print("\nEmployee ID to delete : ");
        empId = sc.nextInt();
        sc.nextLine();
        for (var x : empIds) {
            if (x == empId) {
                empExist = true;
                break;
            }
        }
        if (!empExist) {
            System.out.println("Empolyee ID " + empId + " does not exist.");
        } else {
            sqlCmd = "Delete From JavaEmployees where employee_id = " + empId;
//            stmt.executeQuery(sqlCmd);    // this statement works, but exception occurs if you attempt to access the ResultSet.
            System.out.println("Number of rows deleted = " + stmt.executeUpdate(sqlCmd));
        }
    }

    public static void updateEmployeeData() throws SQLException {
        int empId;
        int depId = 0;
        boolean empExist = false;
        boolean depExist = false;
        String fName = "";
        String lName = "";
        String depName = "";
        double sal = 0.0;

        employeeData();
        System.out.print("\nEmployee ID to update : ");
        empId = sc.nextInt();
        sc.nextLine();

        for (var x : empIds) {
            if (x == empId) {
                empExist = true;
                break;
            }
        }
        if (!empExist) {
            System.out.println("Empolyee ID " + empId + " does not exist.");
        } else {
            sqlCmd = "select employee_id \"EMPLOYEE ID\", first_name \"FIRST NAME\", last_name \"LAST NAME\", salary, department_name Department "
                    + "From Javaemployees left join Javadepartments using(department_id) where employee_id = " + empId;
            rs = stmt.executeQuery(sqlCmd);

            while (rs.next()) {
                fName = rs.getString("FIRST NAME");
                lName = rs.getString("LAST NAME");
                sal = rs.getDouble("salary");
                depName = rs.getString("DEPARTMENT");
            }

            System.out.println();
            departmentData();
            System.out.print("\nUpdate Department Name to [" + depName + "] : ");
            var depname = sc.nextLine();
            if (!depname.isEmpty()) {
                depName = depname;
            }

            for (var x : depNames.entrySet()) {
                if (x.getKey().equalsIgnoreCase(depName)) {
                    depExist = true;
                    depId = x.getValue();
                    break;
                }
            }
            if (!depExist) {
                System.out.println("Department Name " + depName + " does not exist.");
            } else {
                System.out.print("Update First Name to [" + fName + "] : ");
                var fname = sc.nextLine();
                if (!fname.isEmpty()) {
                    fName = fname;
                }

                System.out.print("Update Last Name to [" + lName + "] : ");
                var lname = sc.nextLine();
                if (!lname.isEmpty()) {
                    lName = lname;
                }

                System.out.print("Update Salary to [" + sal + "] : ");
                var saL = sc.nextLine();

                if (!saL.isEmpty()) {
                    sal = Double.parseDouble(saL);
                }

                sqlCmd = "Update JavaEmployees Set first_name = '" + fName + "', last_name = '" + lName + "', salary = " + sal + ", department_id = " + depId
                        + " where employee_id = " + empId;
//                stmt.executeQuery(sqlCmd);    // this statement works, but exception occurs if you attempt to access the ResultSet.
                System.out.println("Number of rows updated = " + stmt.executeUpdate(sqlCmd));
            }
        }
    }

    public static void addEmployeeData() throws SQLException {
        int empId;
        int depId = 0;
        boolean empExist = false;
        boolean depExist = false;
        String fName, lName, depName;
        double sal;

        employeeData();
        System.out.println();
        departmentData();
        System.out.print("\nDepartment Name : ");
        depName = sc.nextLine();

        for (var x : depNames.entrySet()) {
            if (x.getKey().equalsIgnoreCase(depName)) {
                depExist = true;
                depId = x.getValue();
                break;
            }
        }
        if (!depExist) {
            System.out.println("Department Name " + depName + " does not exist.");
        } else {
            System.out.print("First Name : ");
            fName = sc.nextLine();
            System.out.print("Last Name : ");
            lName = sc.nextLine();
            System.out.print("Salary : ");
            sal = sc.nextDouble();

            int lastEmpIdFromQuery = lastEmployeeId();
            lastEmpId = lastEmpIdFromQuery>lastEmpId? lastEmpIdFromQuery : lastEmpId;
            sqlCmd = "Insert Into JavaEmployees (employee_id, first_name, last_name, salary, department_id) Values(" + (++lastEmpId) + ", '" + fName + "', '" + lName + "', " + sal + ", " + depId + ")";
//                stmt.executeQuery(sqlCmd);   // this statement works, but exception occurs if you attempt to access the ResultSet.
            System.out.println("Number of rows added = " + stmt.executeUpdate(sqlCmd));
        }
    }

    public static void sqlCommand() throws SQLException {
        do {
            System.out.print("\nSQL> ");
            sqlCmd = sc.nextLine();
            if (!sqlCmd.equalsIgnoreCase("exit")) {
                if (sqlCmd.toUpperCase().startsWith("SELECT")) {
                    System.out.println();
                    exeQueryStatement(sqlCmd);
                } else {
                    System.out.println("Number of rows affected = " + stmt.executeUpdate(sqlCmd));
                }
            }
        } while (!sqlCmd.equalsIgnoreCase("exit"));
    }

    public static void employeeData() throws SQLException {
        sqlCmd = "select employee_id \"EMPLOYEE ID\", first_name \"FIRST NAME\", last_name \"LAST NAME\", salary, department_name Department "
                + "From Javaemployees left join Javadepartments using(department_id) Order By \"EMPLOYEE ID\"";
        exeQueryStatement(sqlCmd);
    }

    public static void departmentData() throws SQLException {
        sqlCmd = "select department_id \"DEPARTMENT ID\", department_name \"DEPARTMENT NAME\" from Javadepartments";
        exeQueryStatement(sqlCmd);
    }

    public static void exeQueryStatement(String sqlCmd) throws SQLException {
        empIds.clear();
        depNames.clear();
        colTypes.clear();
        int rowCount = 1;
        ArrayList<ArrayList<String>> columns = new ArrayList<>();

        rs = stmt.executeQuery(sqlCmd);
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            colTypes.add(rsmd.getColumnTypeName(i));
        }

        columns.add(new ArrayList());
        columns.get(0).add("S/N");

        for (var i = 1; i <= rsmd.getColumnCount(); i++) {
            columns.add(new ArrayList());
            columns.get(i).add(rsmd.getColumnName(i));
        }

        while (rs.next()) {
            columns.get(0).add("" + rowCount);
            for (var i = 1; i <= rsmd.getColumnCount(); i++) {
                columns.get(i).add(rs.getString(rsmd.getColumnName(i)));
            }
            rowCount++;
        }

        int[] maxLength = new int[rsmd.getColumnCount() + 1];
        for (var i = 0; i < rowCount; i++) {
            for (var j = 0; j <= rsmd.getColumnCount(); j++) {
                if (columns.get(j).get(i) == null) {
                } else if (i == 0) {
                    maxLength[j] = columns.get(j).get(i).length();
                } else {
                    maxLength[j] = maxLength[j] > columns.get(j).get(i).length() ? maxLength[j] : columns.get(j).get(i).length();
                }
            }
        }

        if (columns.get(1).get(0).equalsIgnoreCase("EMPLOYEE ID")) {
            for (var i = 1; i < rowCount; i++) {
                empIds.add(Integer.parseInt(columns.get(1).get(i)));
            }
        }

        if (columns.get(1).get(0).equalsIgnoreCase("DEPARTMENT ID")) {
            for (var i = 1; i < rowCount; i++) {
                depNames.put(columns.get(2).get(i), Integer.parseInt(columns.get(1).get(i)));
            }
        }

        for (var i = 0; i < rowCount; i++) {
            for (var j = 0; j <= rsmd.getColumnCount(); j++) {
                if (columns.get(j).get(i) == null) {
                    for (var k = 0; k < maxLength[j] + 3; k++) {
                        System.out.print(" ");
                    }
                } else {
                    System.out.print(columns.get(j).get(i));
                    for (var k = 0; k < maxLength[j] + 3 - columns.get(j).get(i).length(); k++) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    static int lastEmployeeId() throws SQLException {
        sqlCmd = "select max(employee_id) From Javaemployees";
        rs = stmt.executeQuery(sqlCmd);
        rs.next();
        return rs.getInt(1);
    }
}
