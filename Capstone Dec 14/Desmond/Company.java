/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companyRecords;

/**
 *
 * @author Desmond
 */
public class Company {

    //employee inner class here
    class employee {

//private ArrayList<employee> empList = new ArrayList<employee>();
        private int empId;
        private String empFname;
        private String empLname;
        private String email;

        private int salary;
        private String jobID;
        private int depId;

        @Override
        public String toString() {
            return "\n[empId = " + empId + ", \tempName = " + empFname + empLname + ", \t\temail = " + email + ", \t\tsalary = " + salary + ", \tdesignation = " + jobID + ", \tdepId=" + depId + "]";
        }

        public employee(int empId, String empFname, String empLname, String email, int salary, String jobID, int depId) {
            this.empId = empId;
            this.empFname = empFname;
            this.empLname = empLname;
            this.email = email;
            this.salary = salary;
            this.jobID = jobID;
            this.depId = depId;
        }

        public int getEmpId() {
            return empId;
        }

        public String getEmpFname() {
            return empFname;
        }

        public String getEmpLname() {
            return empLname;
        }

        public String getEmail() {
            return email;
        }

        public int getSalary() {
            return salary;
        }

        public String getJobID() {
            return jobID;
        }

        public int getDepId() {
            return depId;
        }

    }

    //department inner class
    class department {

//private ArrayList<department> depList = new ArrayList<department>();
        private int depId;
        private String depName;
        private int managerId;
        private int locationId;

        @Override
        public String toString() {
            return "\n[depId = " + depId + ", depName = " + depName + ", location = " + locationId + ", manager=" + managerId + "]";
        }

        //Requirement of dynamic data entry so scanner required
        public department(int depId, String depName, int locationId, int managerId) {
            this.depId = depId;
            this.depName = depName;
            this.locationId = locationId;
            this.managerId = managerId;
        }

        public int getDepId() {
            return depId;
        }

        public String getDepName() {
            return depName;
        }

        public int getLocation() {
            return locationId;
        }

        public int getManagerId() {
            return managerId;
        }

//        public ArrayList<department> getDepList() {
//            return depList;
//        }
    }

}
