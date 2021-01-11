package JDataBase;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Company {

    class Department {

        int deptID;
        String deptName;
        
        public Department(int deptID, String deptName) {
            this.deptID = deptID;
            this.deptName = deptName;
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

        @Override
        public String toString() {
            return "Department{" + "deptID=" + deptID + ", deptName=" + deptName + '}';
        }
    }

    class Employee {

        int empId;
        String empName;
        String empMail;
        String empContact;
        int empSal;

        public String getEmpContact() {
            return empContact;
        }

        public void setEmpContact(String empContact) {
            this.empContact = empContact;
        }

        public int getEmpSal() {
            return empSal;
        }

        public void setEmpSal(int empSal) {
            this.empSal = empSal;
        }

        public Employee(int empId, String empName, String empMail, String empContact, int empSal) {
            this.empId = empId;
            this.empName = empName;
            this.empMail = empMail;
            this.empContact = empContact;
            this.empSal = empSal;
        }

        public Employee(int empId, String empName, String empMail) {
            this.empId = empId;
            this.empName = empName;
            this.empMail = empMail;
        }

       
        public int getEmpId() {
            return empId;
        }

        public void setEmpId(int empId) {
            this.empId = empId;
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName) {
            this.empName = empName;
        }

        public String getEmpMail() {
            return empMail;
        }

        public void setEmpMail(String empMail) {
            this.empMail = empMail;
        }
 
        @Override
        public String toString() {
            return "Employee{" + "empId=" + empId + ", empName=" + empName + ", empMail=" + empMail + ", empContact=" + empContact + ", empSal=" + empSal + '}';
        }
       
    }
    static ArrayList<Department> deptD = new ArrayList<Department>();
    static ArrayList<Employee> empE = new ArrayList<Employee>();
    
    public static void main(String[] args) {
       
        try{
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "wooi", "wooi");
            System.out.println("<Database connect Success！>\n");
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from employees");
                  
            Company comp = new Company();
            
            while(rs.next()){
                
                empE.add(comp.new Employee(rs.getInt("employee_id"),rs.getString("first_name"),rs.getString("email"),rs.getString("phone_number"),rs.getInt("salary")));
            }
            
            ResultSet joinTab = stmt.executeQuery("select employees.employee_id, employees.first_name, employees.email, "
                    + "departments.department_name "
                    + "from employees "
                    + "inner join departments "
                    + "on employees.department_id=departments.department_id");
            System.out.println("|------------------Employee & Department Table---------------|");
            System.out.println("|Employee ID |\tFirst Name |\tEmail\t |\tDepartment   |");
            System.out.println("|------------------------------------------------------------|");
            while(joinTab.next()){
                System.out.println("|  "+joinTab.getInt("employee_id")+"\t\t"+joinTab.getString("first_name")+"\t\t"+joinTab.getString("email")+"\t\t"+joinTab.getString("department_name"));
            }
            
            ResultSet depTab = stmt.executeQuery("select * from departments");
            while(depTab.next()){
                deptD.add(comp.new Department(depTab.getInt("department_id"),depTab.getString("department_name")));
            }
                             
            conn.close();
            rs.close();
            stmt.close();  
            joinTab.close();
            
        } catch (SQLException e){
            System.out.println(e);
            System.out.println("<Database connect error！>" + e.getMessage());
        }
            menu();
    }
    
    public static void menu(){
            System.out.println("|----------------------------------|");
            System.out.println("|     Company Management System    |");
            System.out.println("|----------------------------------|");
            System.out.println("|1. Query all Employee information |\n|2. Query according to Employee ID |\n|3. Query all Department info      |\n|4. Query according to Dept ID     |\n|5. Adding New Department          |\n|6. Adding New Employee            |\n|7. Delete Department              |\n|8. Delete Employee                |\n|9. Exit                           |");
            System.out.println("------------------------------------");
            Scanner input = new Scanner(System.in);
            System.out.print("Enter action 1-9 pls : ");
            try{
                switch(input.nextInt()){
                    case 1:
                        System.out.println("---------All Employee information--------");
                        searchAllEmp();
                        break;
                    case 2:
                        System.out.println("-------Employee personal detail-------");
                        searchEmpId();
                        break;
                    case 3:
                        System.out.println("--------All Department information--------");
                        searchAllDept();
                        break;
                    case 4:
                        System.out.println("-----------Department detail------------");
                        searchDeptId();
                        break;
                    case 5:
                        System.out.println("-----------Add New Department-------------");
                        addDept();
                        break;
                    case 6:
                        System.out.println("-----------Add New Employee-------------");
                        addEmp();
                        break;
                    case 7:
                        System.out.println("--------Delete Department By ID----------");
                        delDepById();
                        break;
                    case 8:
                        System.out.println("--------Delete Employee By ID-----------");
                        delEmpById();
                        break;
                    default:
                    System.out.println("Please enter number 1 to 9 only!! ");
                    menu();
                    break;
                }              
            }catch (java.util.InputMismatchException e) {
            System.out.println(e + "\n" + "Please enter number <1-9> only!! ");  
            } 
            menu();
        }
        public static void searchAllEmp(){
            if(!empE.isEmpty()){
                for(int i=0; i< empE.size(); i++){
                    
                    System.out.println("ID no:<"+empE.get(i).empId+"> "+empE.get(i).empName);
                }
            }else{
                        System.out.println("This system has no Employee information temporarily!");
                        }
                menu();
            }
         public static void searchEmpId(){
             int i;
             if(!empE.isEmpty()){
                 int j =0;
                 System.out.print("Employee ID your enter is : "); 
                 Scanner input = new Scanner(System.in);
                 int id = input.nextInt();
                 for(i=0; i< empE.size();i++){
                     if(empE.get(i).getEmpId()==id){
                         j++;
                         System.out.println("-----------------------------------\n"+"Employee ID    : "+empE.get(i).getEmpId()+ "\n" 
                                 +"Employee Name  : "+empE.get(i).getEmpName()+"\n"+"Employee Email : "+empE.get(i).getEmpMail()+"\n"+"Employee Phone : "+empE.get(i).getEmpContact()+"\n"+"Employee Salary : "+empE.get(i).getEmpSal());
                         break;
                     }
                 }
                 if (j==0){
                     System.out.println("The employee ID is not available!");
                 }
             }
             else{
                 System.out.println("This system not has this employee!");
             }
             menu();
         } 
         
         public static void searchAllDept(){
             if(!deptD.isEmpty()){
                 for(int i=0; i<deptD.size(); i++){
                     System.out.println(deptD.get(i).deptID+" "+ deptD.get(i).deptName);  
                 }  
             }
             else{
                     System.out.println("This system has no Department information temporarily!");
             }
             menu();
         }
         public static void searchDeptId(){
             int i;
             if(!deptD.isEmpty()){
                 int j = 0;
                 System.out.print("Please enter department ID :");
                 Scanner input = new Scanner(System.in);
                 int id = input.nextInt();
                 for(i=0; i<deptD.size(); i++){
                     if(deptD.get(i).getDeptID()== id){
                         j++;
                         System.out.println("Department ID : "+deptD.get(i).getDeptID()+"\n Department Name : "+deptD.get(i).getDeptName());
                         break;
                     }   
                 }
                 if (j==0){
                     System.out.println("The department ID is not available!");
                 }
             } 
             else{
                 System.out.println("This system not have this Department!");
             } 
             menu();
         }  
         
      public static void addDept() {
        int deptID;
        String deptName;
       
        Scanner in = new Scanner(System.in);
        {
            try {
                System.out.println("Please enter the department id number: ");
                deptID = in.nextInt();
                in.nextLine();
                System.out.println("Please enter the department name: ");
                deptName = in.nextLine();                      
                deptD.add(new Company().new Department(deptID, deptName));
                System.out.println("New department list added!");
            } catch (InputMismatchException im) {   
                System.out.println("Input wrong data type!");
                System.out.println("Please enter input again.");    
                menu();
            }
        }
    }
      
      public static void addEmp() {
        int empId;
        String empName;
        String empMail;
        String empContact;
        int empSal;
        Scanner input = new Scanner(System.in);
        {
            try {
                System.out.println("Please enter the employee ID number: ");
                empId = input.nextInt();
                input.nextLine();
                System.out.println("Please enter the employee name: ");
                empName = input.nextLine();
                System.out.println("Please enter the employee email: ");
                empMail = input.nextLine();
                System.out.println("Please enter the employee contact number: ");
                empContact = input.nextLine();
                System.out.println("Please enter the employee salary: ");
                empSal = input.nextInt();
                input.nextLine();          
                empE.add(new Company().new Employee(empId, empName, empMail, empContact, empSal));                           
                System.out.println("New employee added!");
            } catch (InputMismatchException im) {
                System.out.println("Input wrong data type!");
                System.out.println("Please enter input again.");      
                menu();
            }
        }
    }
      public static void delDepById() {
        if (!deptD.isEmpty()) {
            int j = 0; 
            System.out.println("Please enter department id: ");
            Scanner in = new Scanner(System.in);
            int DeptId = in.nextInt();
            for (int i = 0; i < deptD.size(); i++) {
                if (deptD.get(i).getDeptID() == DeptId) {
                    j++;
                    int delDeptId = deptD.get(i).getDeptID();
                    String delDeptName = deptD.get(i).getDeptName();
                    deptD.remove(i);
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("ID of " + delDeptId + " Department name <" + delDeptName +">"+ " has deleted from the system !");
                    System.out.println("-----------------------------------------------------------------");
                    break;
                } 
            }
                if (j==0){
                     System.out.println("The department ID is not available!");
                }
            }
                 else{
                     System.out.println("This system not have this Department!");
              
                }
                 menu();
        }  
            
     public static void delEmpById() {
        if (!empE.isEmpty()) {
            int j = 0;  
            System.out.println("Please enter employee id: ");
            Scanner input = new Scanner(System.in);
            int EmpId = input.nextInt();
            for (int i = 0; i < empE.size(); i++) {
                if (empE.get(i).getEmpId() == EmpId) {
                    j++;
                    int delEmpId = empE.get(i).getEmpId();
                    String delEmpName = empE.get(i).getEmpName();
                    empE.remove(i);
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("ID of " + delEmpId + ", Employee Name <" + delEmpName + ">" +" has deleted from the system !");
                    System.out.println("-----------------------------------------------------------------");
                    break;
                  } 
             }
                 if (j == 0) { 
                     System.out.println("The employee ID is not available!");    
                 }
             } 
                 else {     
                    System.out.println("This system not has this employee!");
                 }      
                  menu();
        }  
}