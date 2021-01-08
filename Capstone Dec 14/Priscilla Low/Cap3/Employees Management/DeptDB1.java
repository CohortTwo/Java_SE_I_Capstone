//Menu based 
//Add / edit / delete / read 
//records from the Db
//
//Generate a ID automatically --> go to the database and create a sequence for employee_id, then add employee_seq.nextval not null as default.
//
//ID rules..
//non repeating
//auto Increment by 1

package JDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Department {

    int id;
    String name;

    public Department(int id, String name) {
        //super();
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    static ArrayList<Department> dept_m = new ArrayList<Department>();

    class Dep_Mgmt {

        void addDep() {

//            dept_m.add(new Department(10, "HR"));
//            dept_m.add(new Department(20, "Sales"));
//            dept_m.add(new Department(30, "Engineering"));

           
            int id;
            String name;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Department ID: ");
            id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Department Name: ");
            name = sc.nextLine();
            
            try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "xx", "xx");
            
                String insertQuery = "INSERT INTO departments(department_id,department_name)" + "VALUES(?,?)";
                PreparedStatement pst = conn.prepareStatement(insertQuery);
                pst.setInt(1,id);
                pst.setString(2, name);
                pst.executeUpdate();

                pst.close();
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            showDep();
            DeptDB1.options();
        }

        void showDep() {
             try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "xx", "xx");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select department_id,department_name "
                    + "from departments");
            //System.out.println(" ID \t\t\t First Name \t\t\t Deptno \t\t\t Deptname");

            while (rs.next()) {
                System.out.println("Department ID: " + rs.getInt("department_id") + " " + "Department Name: "+ rs.getString("department_name"));

            }
//close the connection object  
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
            DeptDB1.options();
        }
        
        void deleteDep() {
            
            int id;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Department ID: ");
            id = sc.nextInt();
            
            try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "xx", "xx");
            
                String deleteQuery = "delete from departments " + "where department_id=?";
                PreparedStatement pst = conn.prepareStatement(deleteQuery);
                pst.setInt(1,id);
                pst.executeUpdate();

                pst.close();
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            showDep();
            DeptDB1.options();
        
    }
        
        void updateDep() {     
            int id;
            String name;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Department ID: ");
            id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Department Name (new): ");
            name = sc.nextLine();
            
            try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "xx", "xx");
            
                String updateQuery = "update departments " + "set department_name=? " + "where department_id=?";
                PreparedStatement pst = conn.prepareStatement(updateQuery);
                pst.setString(1,name);
                pst.setInt(2, id);
                pst.executeUpdate();

                pst.close();
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            showDep();
            DeptDB1.options();
        }
    }

    class Employee {

        int eid;
        String efname;
        String elname;
        int deptid;
        String email;
        String jobid;
        String hiredate;

        public Employee(int eid, String efname, String elname, int deptid, String email, String jobid, String hiredate) {
            this.eid = eid;
            this.efname = efname;
            this.elname = elname;
            this.deptid = deptid;
            this.email = email;
            this.jobid = jobid;
            this.hiredate = hiredate;
        }

        public int getEid() {
            return eid;
        }

        public void setEid(int eid) {
            this.eid = eid;
        }

        public String getEfname() {
            return efname;
        }

        public void setEfname(String efname) {
            this.efname = efname;
        }

        public String getElname() {
            return elname;
        }

        public void setElname(String elname) {
            this.elname = elname;
        }

        public int getDeptid() {
            return deptid;
        }

        public void setDeptid(int deptid) {
            this.deptid = deptid;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getJobid() {
            return jobid;
        }

        public void setJobid(String jobid) {
            this.jobid = jobid;
        }


        public String getHiredate() {
            return hiredate;
        }

        public void setHiredate(String hiredate) {
            this.hiredate = hiredate;
        }


    }
    
    static ArrayList<Employee> emp_m = new ArrayList<Employee>();

    class Emp_Mgmt {

        void addEmp() {

//            emp_m.add(new Employee(100, "James",10));
//            emp_m.add(new Employee(101, "Tom",20));
//            emp_m.add(new Employee(102, "Harry",30));
            
//            int eid;
            String efname;
            String elname;
            int deptid;
            String email;
            String jobid;
            String hiredate;
            Scanner sc = new Scanner(System.in);
//            System.out.println("Enter the Emp ID: ");
//            eid = sc.nextInt();
//            sc.nextLine();
            System.out.println("Enter the Emp First Name: ");
            efname = sc.nextLine();
            System.out.println("Enter the Emp Last Name: ");
            elname = sc.nextLine();
            System.out.println("Enter the Dept ID: ");
            deptid = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Emp Email: ");
            email = sc.nextLine();
            System.out.println("Enter the Job ID: ");
            jobid = sc.nextLine();
            System.out.println("Enter the Hire Date: ");
            hiredate = sc.nextLine();
            
                        
            try {
                Connection conn = DriverManager
                        .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "xx", "xx");

//                String insertQuery = "INSERT INTO employees(employee_id,first_name,last_name,department_id,email,job_id,hire_date) "
//                        + "values(?,?,?,(select department_id from departments "
//                        + "where department_id=?),?,?,?)";
                String insertQuery = "INSERT INTO employees(first_name,last_name,department_id,email,job_id,hire_date) "
                        + "values(?,?,(select department_id from departments "
                        + "where department_id=?),?,?,?)";
                PreparedStatement pst = conn.prepareStatement(insertQuery);
//                pst.setInt(1, eid);
//                pst.setString(2, efname);
//                pst.setString(3, elname);
//                pst.setInt(4, deptid);
//                pst.setString(5, email);
//                pst.setString(6, jobid);
//                pst.setString(7, hiredate);

                pst.setString(1, efname);
                pst.setString(2, elname);
                pst.setInt(3, deptid);
                pst.setString(4, email);
                pst.setString(5, jobid);
                pst.setString(6, hiredate);

                pst.executeUpdate();
                pst.close();

                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            showEmp();
            DeptDB1.options();
        }

        void showEmp() {
            
             try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "xx", "xx");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(""
                    + "select e.employee_id,e.first_name,e.last_name,e.department_id,d.department_name "
                    + "from employees e, departments d "
                    + "where e.department_id=d.department_id "
                    + "order by e.employee_id");
            //System.out.println(" ID \t\t\t First Name \t\t\t Deptno \t\t\t Deptname");

            while (rs.next()) {
                //System.out.println(rs.getInt(1) + " \t" + rs.getString(2) + " \t" + rs.getInt(3));
                System.out.println(rs.getString("FIRST_NAME") + " " + rs.getString("LAST_NAME") + " has an employee id of " + rs.getInt("EMPLOYEE_ID") + ", works in " + rs.getString("DEPARTMENT_NAME") + " department.");

            }
//close the connection object  
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
            DeptDB1.options();
        }
        
        void deleteEmp() {
            
            int eid;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Employee ID: ");
            eid = sc.nextInt();
            
            try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "xx", "xx");
            
                String deleteQuery = "delete from employees " + "where employee_id=?";
                PreparedStatement pst = conn.prepareStatement(deleteQuery);
                pst.setInt(1,eid);
                pst.executeUpdate();

                pst.close();
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            showEmp();
            DeptDB1.options();
        
    }
        
        void updateEmp() {     
            int eid;
            String efname;
            String elname;
            int deptid;
            String email;
            String jobid;
            String hiredate;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Emp ID: ");
            eid = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Emp First Name (new): ");
            efname = sc.nextLine();
            System.out.println("Enter the Emp Last Name (new): ");
            elname = sc.nextLine();
            System.out.println("Enter the Dept ID (new): ");
            deptid = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Emp Email (new): ");
            email = sc.nextLine();
            System.out.println("Enter the Job ID (new): ");
            jobid = sc.nextLine();
            System.out.println("Enter the Hire Date (new): ");
            hiredate = sc.nextLine();
            
            try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "xx", "xx");
            
                String updateQuery = "update employees " + "set first_name=?,last_name=?,department_id=(select department_id from departments "
                        + "where department_id=?),email=?,job_id=?,hire_date=? " + "where employee_id=?";
                PreparedStatement pst = conn.prepareStatement(updateQuery);
                pst.setString(1,efname);
                pst.setString(2,elname);
                pst.setInt(3,deptid);
                pst.setString(4,email);
                pst.setString(5, jobid);
                pst.setString(6, hiredate);
                pst.setInt(7,eid);
                
                pst.executeUpdate();

                pst.close();
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            showEmp();
            DeptDB1.options();
        }
    }
}

public class DeptDB1 {

    public static void main(String[] args) {
           
      options();  
    }
    
    public static void options() {
    
        Department dept = new Department(40, "Admin");
        var manage_d = dept.new Dep_Mgmt();
        var manage_e = dept.new Emp_Mgmt();

        System.out.println("======HR System======");
        System.out.println("Choose one of the following options by typing the number indicated next to it:");
        System.out.println("1. Add Dept");
        System.out.println("2. Show Dept");
        System.out.println("3. Add Employee details");
        System.out.println("4. Show Employee details");
        System.out.println("5. Delete Dept by ID");
        System.out.println("6. Delete Employee record by ID");
        System.out.println("7. Update Dept by ID");
        System.out.println("8. Update Employee record by ID");
        System.out.println("9. Exit System");

        System.out.println("Enter your chosen option below (1-9):");
        try { 
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()) {
                case 1:
                    manage_d.addDep();
                    break;
                case 2:
                    manage_d.showDep();
                    break;
                case 3:
                    manage_e.addEmp();
                    break;
                case 4:
                    manage_e.showEmp();
                    break;
                case 5:
                    manage_d.deleteDep();
                    break;
                case 6:
                    manage_e.deleteEmp();
                    break;
                case 7:
                    manage_d.updateDep();
                    break;
                case 8:
                    manage_e.updateEmp();
                    break;   
                case 9:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Please only enter digits 1 to 9.");
                    options();
                    break;
            }
        } catch (InputMismatchException inputmme) {
            System.out.println("Please only enter digits 1 to 9.");
            options();
        }
    }

}

//    private static Connection connection;
//
//    public static void Connection() throws SQLException {
//        if (connection == null) {
//            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "hr", "hr");
//        }
//    }
//    public static void addRecordDept() {
//        try {
//            String addRecord = "INSERT INTO DEPARTMENTS(department_id, department_name, manager_id, location_id) VALUES (?, ?, ?, ?)";
//            PreparedStatement pstmt = connection.prepareStatement(addRecord);
//
////            System.out.println("Please enter new department_id: ");
////            Scanner in = new Scanner(System.in);
//            pstmt.setInt(1, 101);
//
////            System.out.println("Please enter new department_name: ");
//            pstmt.setString(2, "Gaming");
//
////            System.out.println("Please enter new manager_id: ");
//            pstmt.setInt(3, 201);
//
////            System.out.println("Please enter new location_id: ");
//            pstmt.setInt(4, 2000);
//            pstmt.executeUpdate();
//
////close the connection object  
//            connection.close();
//            pstmt.close();
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        DisplayHeader();
//        System.out.println("Enter any key to return to main menu.");
//        Scanner in = new Scanner(System.in);
//        if (in.hasNext(CHARS) == true) {
//            menu();
//        }
//    }
//}
