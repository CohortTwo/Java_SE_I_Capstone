/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.sql.SQLException;

/**
 *
 * @author User
 */
public class EmployeeClass {

    /**
     * @param args the command line arguments
     */
    private int deptID;
    private String deptName;
    private int managerID;
    private String managerName;

    public EmployeeClass(int deptID, String deptName, int managerID, String managerName) {
        this.deptID = deptID;
        this.deptName = deptName;
        this.managerID = managerID;
        this.managerName = managerName;
    }

    public EmployeeClass() {
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public int getDeptID() {
        return deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public int getManagerID() {
        return managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    // this is the inner class
    class Employees {

        private int empID;
        private String empName;
        private double salary;
        private String designation;

        public Employees(int empID, String empName, float salary, String designation) {
            this.empID = empID;
            this.empName = empName;
            this.salary = salary;
            this.designation = designation;
        }

        public void setEmpID(int empID) {
            this.empID = empID;
        }

        public void setEmpName(String empName) {
            this.empName = empName;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public int getEmpID() {
            return empID;
        }

        public String getEmpName() {
            return empName;
        }

        public double getSalary() {
            return salary;
        }

        public String getDesignation() {
            return designation;
        }

    }

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        EmployeeMenu.Connection();
        EmployeeMenu.menu();
    }

}
