/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InnerClasses;

import java.util.ArrayList;

/**
 *
 * @author sridh
 */
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
    ArrayList<Department> dept_m = new ArrayList<Department>();

    class Dep_Mgmt {

        void addDep() {

            dept_m.add(new Department(101, "hr"));
            dept_m.add(new Department(102, "Sales"));
            dept_m.add(new Department(103, "Engineering"));
        }

        void showDep() {
            for (int i = 0; i < dept_m.size(); i++) {
                System.out.println(dept_m.get(i).id + " " + dept_m.get(i).name);

            }
        }
    }

    class Employee {

        int eid;
        String ename;
      

        public Employee(int eid, String ename) {
            //super();
            this.eid = eid;
            this.ename = ename;
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
    }
    ArrayList<Employee> emp_m = new ArrayList<Employee>();

    class Emp_Mgmt {

        void addEmp() {

            emp_m.add(new Employee(1001, "James"));
            emp_m.add(new Employee(1002, "Tom"));
            emp_m.add(new Employee(1003, "Harry"));
        }

        void showEmp() {
            for (int i = 0; i < emp_m.size(); i++) {
                System.out.println(emp_m.get(i).eid + " " + emp_m.get(i).ename);

            }
        }
    }
}

public class ProjInner {

    public static void main(String[] args) {
        Department dept = new Department(10, "Admin");
        var manage_d = dept.new Dep_Mgmt();
        var manage_e = dept.new Emp_Mgmt();
        manage_d.addDep();
        manage_d.showDep();
        manage_e.addEmp();
        manage_e.showEmp();
    }
}
