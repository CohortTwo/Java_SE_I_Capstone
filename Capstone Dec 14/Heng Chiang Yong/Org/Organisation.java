/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Org;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author chiangyong
 */
public class Organisation {
    static String Company = "Learning Academy";
    static String HQLocation = "Singapore";
    static ArrayList<Department> arrDeptRec = new ArrayList<Department>();
    static ArrayList<Employee> arrEmpRec = new ArrayList<Employee>();
    
    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getHQLocation() {
        return HQLocation;
    }

    public void setHQLocation(String HQLocation) {
        this.HQLocation = HQLocation;
    }
    
    class Department{
        int deptID;
        String deptName;
        String deptLocation;
        int deptMgrID;
        
        
        public Department(int deptID, String deptName, String deptLocation, int deptMgrID) {
            this.deptID = deptID;
            this.deptName = deptName;
            this.deptLocation = deptLocation;
            this.deptMgrID = deptMgrID;
        }

        Department() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String toString() {
            return "Department{" + "deptID=" + deptID + ", deptName=" + deptName + ", deptLocation=" + deptLocation + ", deptMgrID=" + deptMgrID + '}';
        }
        
        
        public int getDeptID() {
            return deptID;
        }

        public void setDeptID(int deptID) {
            this.deptID = deptID;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getDeptLocation() {
            return deptLocation;
        }

        public void setDeptLocation(String deptLocation) {
            this.deptLocation = deptLocation;
        }

        public int getDeptMgrID() {
            return deptMgrID;
        }

        public void setDeptMgrID(int deptMgrID) {
            this.deptMgrID = deptMgrID;
        }
        
    }
    
    class DeptManage{
        Scanner inp = new Scanner(System.in);
        
        public void updateRec(int deptID,String mode, int i) {

            inp.nextLine();
            System.out.print("Enter the Department Name: ");
            String deptName = inp.nextLine();
            System.out.print("Enter the Department Location: ");
            String deptLoc = inp.nextLine();
            System.out.print("Enter the Manager ID: ");
            int mgrID = inp.nextInt();
            if(mode=="add")
            arrDeptRec.add(new Department(deptID, deptName, deptLoc, mgrID));
            else if(mode == "update")
                arrDeptRec.set(i, new Department(deptID, deptName, deptLoc, mgrID));

        }
        
        public void addDept() {
            if (arrDeptRec.size() != 0) {
                System.out.print("Enter the Department ID: ");
                int deptID = inp.nextInt();
                for (int i = 0; i < arrDeptRec.size(); i++) {
                    if (arrDeptRec.get(i).getDeptID() == deptID) {
                        System.err.println("Departmen ID is already exist!");
                        break;
                    } else {
//                    inp.nextLine();
//                    System.out.print("Enter the Department Name: ");
//                    String deptName = inp.nextLine();
//                    System.out.print("Enter the Department Location: ");
//                    String deptLoc = inp.nextLine();
//                    System.out.print("Enter the Manager ID: ");
//                    int mgrID = inp.nextInt();
//                    arrDeptRec.add(new Department(deptID, deptName, deptLoc, mgrID));
                        updateRec(deptID,"add",0);
                        break;
                    }
                }
           }
            else 
            {
                System.out.print("Enter the Department ID: ");
                int deptID = inp.nextInt();
                updateRec(deptID,"add",0);

            }

        }
        
        public void updateDept() {
            if (arrDeptRec.size() != 0) {
                try {
                    System.out.print("Enter the Department ID: ");
                    int deptID = inp.nextInt();
                    for (int i = 0; i < arrDeptRec.size(); i++) {
                        if (arrDeptRec.get(i).getDeptID() == deptID) {
                            updateRec(deptID, "update", i);
                            break;
                        } else {
                            System.out.println("No such record found");
                        }
                    }
                } catch (InputMismatchException ex) {
                    System.err.println("Integer only");
                    inp.nextLine();

                } catch (IndexOutOfBoundsException e) {
                    System.err.println("No such Department ID! ");

                }
            } else {
                System.out.println("Empty record found");
            }
        }
        
        public void delDept() {
            if (arrDeptRec.size() != 0) {
                try {

                    System.out.print("Enter the Department ID: ");
                    int deptID = inp.nextInt();
                    for (int i = 0; i < arrDeptRec.size(); i++) {
                        if (arrDeptRec.get(i).getDeptID() == deptID) {
                            arrDeptRec.remove(i);
                            System.out.println("Department ID :" + deptID + " , "
                                    + arrDeptRec.get(i).getDeptName() + " is removed.");
                            break;
                        } else {
                            System.out.println("No such record found");
                        }
                    }
                } catch (InputMismatchException ex) {
                    System.err.println("Integer only");
                    inp.nextLine();

                } catch (IndexOutOfBoundsException e) {
                    System.err.println("No such Department ID! ");

                }
            }
        }
        
        public void deptQuery() {
            if (arrDeptRec.size() != 0) {
                try {

                    System.out.print("Enter the Department ID: ");
                    int deptID = inp.nextInt();
                    for (int i = 0; i < arrDeptRec.size(); i++) {
                        if (arrDeptRec.get(i).getDeptID() == deptID) {
                            System.out.println("Department ID :" + deptID + " , "
                                    + arrDeptRec.get(i).getDeptName() + ", Location: "
                                    + arrDeptRec.get(i).getDeptLocation()
                                    + ", Department Manager ID: " + arrDeptRec.get(i).getDeptMgrID());
                            break;
                        } else {
                            System.out.println("No such record found");
                        }
                    }
                } catch (InputMismatchException ex) {
                    System.err.println("Integer only");
                    inp.nextLine();
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("No such Department ID! ");

                }
            } else {
                System.out.println("Empty record found");
            }
        }
        
        
        public void QueryAllDept() {
            if (arrDeptRec.size() != 0) {
                try {
                    System.out.println("\nDept ID\t\tName\t\tLocation\t\tManager ID");
                    for (int i = 0; i < arrDeptRec.size(); i++) {
                       
                        System.out.println(arrDeptRec.get(i).getDeptID() + "\t\t"
                                + arrDeptRec.get(i).getDeptName() + "\t\t"
                                + arrDeptRec.get(i).getDeptLocation()
                                + "\t\t" + arrDeptRec.get(i).getDeptMgrID());
                    }

                } catch (InputMismatchException ex) {
                    System.err.println("Integer only");
                    inp.nextLine();
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("No such Department ID! ");

                }
            } else {
                System.out.println("Empty record found");
            }
        }

    }
    
    class Employee{
        int empID;
        String empName;
        int empDeptID;
        float empSalary;

       
        
        public Employee(int empID, String empName, int empDeptID, float empSalary) {
            this.empID = empID;
            this.empName = empName;
            this.empDeptID = empDeptID;
            this.empSalary = empSalary;
        }

        public Employee() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String toString() {
            return "Employee{" + "ID=" + empID + ", Name=" + empName + ", DeptID=" + empDeptID + ", Salary=" + empSalary + '}';
        }
        
        public int getEmpID() {
            return empID;
        }

        public void setEmpID(int empID) {
            this.empID = empID;
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName) {
            this.empName = empName;
        }

        public int getEmpDeptID() {
            return empDeptID;
        }

        public void setEmpDeptID(int empDeptID) {
            this.empDeptID = empDeptID;
        }

        public float getEmpSalary() {
            return empSalary;
        }

        public void setEmpSalary(float empSalary) {
            this.empSalary = empSalary;
        }
  
    }
   
    class manageEmp {

        Scanner inp = new Scanner(System.in);

        public void dispRec(int eID) {
            if (arrEmpRec.size() != 0) {
                System.out.println("\nEID\tName\t\tDept ID\t\tSalary");
                for (int i = 0; i < arrEmpRec.size(); i++) {
                    if (arrEmpRec.get(i).getEmpID() == eID) {
                        System.out.println(arrEmpRec.get(i).getEmpID() + "\t"
                                + arrEmpRec.get(i).getEmpName() + "\t\t"
                                + arrEmpRec.get(i).getEmpDeptID() + "\t\t"
                                + arrEmpRec.get(i).getEmpSalary());
                    }
                }
            }

        }

        public void updateRec(int eID, String mode, int i) {
            try {
                inp.nextLine();
                System.out.print("Enter the Employee Name: ");
                String eName = inp.nextLine();
                System.out.print("Enter the Department ID: ");
                int deptID = inp.nextInt();
                inp.nextLine();
                System.out.print("Enter the Employee Salary: ");
                float salary = inp.nextFloat();

                if (mode == "add") {
                    arrEmpRec.add(new Employee(eID, eName, deptID, salary));
                } else if (mode == "update") {
                    arrEmpRec.set(i, new Employee(eID, eName, deptID, salary));
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter the input accordingly!");
            } catch (Exception e) {
                System.out.println("Other exception");
            }
        }
        
        public void addEmpRec()
        {
            if (arrEmpRec.size() != 0) {
                System.out.print("Enter the Employee ID: ");
                int eID = inp.nextInt();
                for (int i = 0; i < arrEmpRec.size(); i++) {
                    if (arrEmpRec.get(i).getEmpID()== eID) {
                        System.err.println("Employee ID is already exist!");
                        break;
                    } else {
                        updateRec(eID,"add",0);
                        dispRec(eID);
                        break;
                    }
                }
           }
            else 
            {
                System.out.print("Enter the Employee ID: ");
                int eID = inp.nextInt();
                updateRec(eID,"add",0);
                dispRec(eID);
            }
           
        }
        
        public void updateEmpRec() {
            if (arrEmpRec.size() != 0) {
                try {
                    System.out.print("Enter the Employee ID: ");
                    int eID = inp.nextInt();
                    for (int i = 0; i < arrEmpRec.size(); i++) {
                        if (arrEmpRec.get(i).getEmpID() == eID) {
                            updateRec(eID, "update", i);
                            dispRec(eID);
                            break;
                        } else {
                            System.out.println("No such record found");
                        }
                    }
                } catch (InputMismatchException ex) {
                    System.err.println("Integer only");
                    inp.nextLine();

                }
                catch(IndexOutOfBoundsException e){
                    System.err.println("No such Employee ID! ");
                    
                    
                }
            } else {
                System.out.println("Empty record found");
            }
        }
    

        public void delEmpRec() {
            if (arrEmpRec.size() != 0) {
                try {
                    System.out.print("Enter the Employee ID: ");
                    int eID = inp.nextInt();
                    for (int i = 0; i < arrEmpRec.size(); i++) {
                        if (arrDeptRec.get(i).getDeptID() == eID) {
                            arrDeptRec.remove(i);
                            System.out.println("Employee ID :" + eID + " , "
                                    + arrEmpRec.get(i).getEmpName() + " is removed.");
                            break;
                        } else {
                            System.out.println("No such record found");
                        }
                    }
                } catch (InputMismatchException ex) {
                    System.err.println("Integer only");
                    inp.nextLine();

                }
                catch(IndexOutOfBoundsException e){
                    System.err.println("No such Employee ID! ");
                    
                    
                }
            }
        }

        
        public void queryEmpRec(){
             if (arrEmpRec.size() != 0) {
                try {

                    System.out.print("Enter the Employee ID: ");
                    int eID = inp.nextInt();
                    for (int i = 0; i < arrEmpRec.size(); i++) {
                        if (arrEmpRec.get(i).getEmpID() == eID) {
                            dispRec(eID);
                            break;
                        } else {
                            System.out.println("No such record found");
                        }
                    }
                } catch (InputMismatchException ex) {
                    System.err.println("Integer only");
                    inp.nextLine();

                }
                catch(IndexOutOfBoundsException e){
                    System.err.println("No such Employee ID! ");
                    
                    
                }
            }
        }
        
        public void queryAllRec() {
            try {
                System.out.println("\nEID\tName\t\t\tDept ID\t\tSalary");
                if (arrEmpRec.size() != 0) {
                    for (int i = 0; i < arrEmpRec.size(); i++) {
                        //dispRec(arrEmpRec.get(i).getEmpID());
                        System.out.println(arrEmpRec.get(i).getEmpID() + "\t"
                                + arrEmpRec.get(i).getEmpName() + "\t\t"
                                + arrEmpRec.get(i).getEmpDeptID() + "\t\t"
                                + arrEmpRec.get(i).getEmpSalary());
                    }
                }
            } catch (InputMismatchException ex) {
                System.err.println("Integer only");
                inp.nextLine();

            } catch (IndexOutOfBoundsException e) {
                System.err.println("No such Employee ID! ");

            }
        }
    }
 
    public void display(int eid,String empN,int empDID,float empS, int dID, String dName, String dLoc, int dMID){
      
        Organisation org = new Organisation();                      //Main class instance of Organisation
        Organisation.Department dept = org.new Department();        //Inner class instance of Department
        Organisation.Employee emp = org.new Employee();             //Inner class instance of Employee
       
        class inDisplay{
            public void dispEmpInfo(){                                  //inner method to display employee information
//                System.out.println("Employee ID: " + emp.empID);
//                System.out.println("Employee Name: " + emp.empName);
//                System.out.println("employee Department ID: "+emp.empDeptID);
//                System.out.println("Employee Salary: " + emp.empSalary);
                System.out.println(emp.toString());
            }
            
            public void dispDeptInfo(){                                         //another inner method to display department information
//                System.out.println("Department ID: " + dept.deptID);
//                System.out.println("Department Name: " + dept.deptName);
//                System.out.println("Department Location: "+dept.deptLocation);
//                System.out.println("Department Manager ID: " + dept.deptMgrID); 
                System.out.println(dept.toString());
            }
        }
        
        inDisplay inD = new inDisplay();
        inD.dispEmpInfo();
        inD.dispDeptInfo();
        
    }

   
  
    
}
