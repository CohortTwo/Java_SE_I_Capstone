package InnerClasses;

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
            System.out.println("Enter the Dept ID: ");
            id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Dept Name: ");
            name = sc.nextLine();
            dept_m.add(new Department(id, name));
            showDep();
            Dept.options();
        }

        void showDep() {
            if (dept_m.isEmpty()) {
                System.out.println("There are currently no departments in the system.");
            } else {
                for (int i = 0; i < dept_m.size(); i++) {
                    System.out.println("Dept Id: " + dept_m.get(i).id + "; Dept Name: " + dept_m.get(i).name);

                }
            }
            Dept.options();
        }
    }

    class Employee {

        int eid;
        String ename;
        int deptid;

        public Employee(int eid, String ename, int deptid) {
            //super();
            this.eid = eid;
            this.ename = ename;
            this.deptid = deptid;
        }

        public Integer getId() {
            return eid;
        }

        public void setId(int id) {
            this.eid = eid;
        }

        public String getName() {
            return ename;
        }

        public void setName(String name) {
            this.ename = ename;
        }

        public int getDeptid() {
            return deptid;
        }

        public void setDeptid(int deptid) {
            this.deptid = deptid;
        }
        
        
    }
    
    static ArrayList<Employee> emp_m = new ArrayList<Employee>();

    class Emp_Mgmt {

        void addEmp() {

//            emp_m.add(new Employee(100, "James",10));
//            emp_m.add(new Employee(101, "Tom",20));
//            emp_m.add(new Employee(102, "Harry",30));
            
            int eid;
            String ename;
            int deptid;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Emp ID: ");
            eid = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the Emp Name: ");
            ename = sc.nextLine();
            System.out.println("Enter the Dept ID: ");
            deptid = sc.nextInt();
            
            int j = 0;
            for (int i = 0; i < dept_m.size(); i++) {
                    if (dept_m.get(i).getId() == deptid) {
                        emp_m.add(new Employee(eid,ename,deptid));
                        j++;
                        break;
                    }
                    
            }
            if (j == 0) {
                    System.out.println("There is no such department id.");
                }
//            emp_m.add(new Employee(eid,ename,deptid));
            showEmp();
            Dept.options();
        }

        void showEmp() {
            if (emp_m.isEmpty()) {
                System.out.println("There are currently no employee records in the system.");
            } else {
                for (int i = 0; i < emp_m.size(); i++) {
                    System.out.println("Emp Id: " + emp_m.get(i).eid + "; Emp Name: " + emp_m.get(i).ename + "; Dept Id: " + emp_m.get(i).deptid);

                }
            }
            Dept.options();
        }
    }
}

public class Dept {

    public static void main(String[] args) {
//        Department dept = new Department(40, "Admin");
//        var manage_d = dept.new Dep_Mgmt();
//        var manage_e = dept.new Emp_Mgmt();
//        manage_d.addDep();
//        manage_d.showDep();
//        manage_e.addEmp();
//        manage_e.showEmp();
        
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
        System.out.println("5. Exit System");

        System.out.println("Enter your chosen option below (1-5):");
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
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Please only enter digits 1 to 5.");
                    options();
                    break;
            }
        } catch (InputMismatchException inputmme) {
            System.out.println("Please only enter digits 1 to 5.");
            options();
        }
    }

}

