package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 * @author Andrew Tan Hwee Song
 */
class EmpDetails {
 int emp_id;
 String f_nam;
 String l_nam;
 String email;
 float salary;
 int dept_id;
 String dept_nam;

    public EmpDetails(int emp_id, String f_nam, String l_nam, String email, float salary, int dept_id, String dept_nam) {
        this.emp_id = emp_id;
        this.f_nam = f_nam;
        this.l_nam = l_nam;
        this.email = email;
        this.salary = salary;
        this.dept_id = dept_id;
        this.dept_nam = dept_nam;
    }

    public int getEmp_id() {
        return emp_id;
    }
    public String getF_nam() {
        return f_nam;
    }
    public String getL_nam() {
        return l_nam;
    }
    public String getEmail() {
        return email;
    }
    public float getSalary() {
        return salary;
    }
    public int getDept_id() {
        return dept_id;
    }
    public String getDept_nam() {
        return dept_nam;
    }  

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setF_nam(String f_nam) {
        this.f_nam = f_nam;
    }

    public void setL_nam(String l_nam) {
        this.l_nam = l_nam;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public void setDept_nam(String dept_nam) {
        this.dept_nam = dept_nam;
    }

    @Override
    public String toString() {
        return "EmpDetails{" + "emp_id=" + emp_id + ", f_nam=" + f_nam + ", l_nam=" + l_nam + ", email=" + email + ", salary=" + salary + ", dept_id=" + dept_id + ", dept_nam=" + dept_nam + '}';
    }
        
    
}

class Empjdbc {
    

    public static void main(String args[]) {
        
            //int Latest_EmpID;
            //create arraylist to hold emp details
            ArrayList<EmpDetails> Empdata = new ArrayList<>();
            
            
        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "andrew", "andrew");
            Statement stmt = conn.createStatement();
            
   ResultSet rs = stmt.executeQuery("select employee_id,first_name,last_name,email,salary,employees.department_id,department_name\n" +
                                    "from employees, departments\n" +
                                    "where employees.department_id=departments.department_id");
                
            
           while (rs.next()) {
                EmpDetails staff = new EmpDetails (rs.getInt("employee_id"), rs.getString("first_name"),
                rs.getString("last_name"),rs.getString("email"), rs.getFloat("salary"),rs.getInt("department_id"), rs.getString("department_name"));
                Empdata.add(staff);
    }
            

//close the connection object  
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
      
        Show_Menu(Empdata);
    }
    
 
public static void Show_Menu(ArrayList<EmpDetails> Edata) {
        System.out.println("--------------Employee Query System-----------");
        System.out.println("1. Show Employee records\n2. Add record\n3. Edit record \n4. Delete record \n5. Exit");
        Scanner sc = new Scanner(System.in);
    try {
        switch (sc.nextInt()) {
            case 1:
                Show_SubMenu(Edata);
                 break;
            case 2:
                AddData(Edata);
                break;
            case 3:
                EditData(Edata);
                break;
            case 4:
                DelData(Edata);
                break;
            case 5:
                System.exit(0);
                break;
        }
    } catch (java.util.InputMismatchException e)
            {
            System.out.println(e+"\n"+"Input a number <1 to 5>\n");
            }
        Show_Menu(Edata);
    }


public static void Show_SubMenu(ArrayList<EmpDetails> Edata) {
        System.out.println("\n\n--------------Employee Sub Menu-----------");
        System.out.println("1. Show all records by Employee id\n2. Show all Employee records by Full Name"
                + "\n3. Show all Employee records by Salary\n4. Show all Employee records by Department id"
                + "\n5. Show all Employee records by Department Name\n6. Search by Column field\n7. Back to Main Menu");
        Scanner sc = new Scanner(System.in);
    try {    
        switch (sc.nextInt()) {
            case 1:
                Collections.sort(Edata, (a,b) -> {   return a.emp_id-b.emp_id;  });
                displayRec(Edata);
                break;
            case 2: //sort by Full name
                Comparator<EmpDetails> SortbyFull_nam = Comparator
                                                 .comparing(EmpDetails::getF_nam)
                                                 .thenComparing(EmpDetails::getL_nam);
                Collections.sort(Edata,SortbyFull_nam );
                displayRec(Edata);
                break;
            case 3:
                Collections.sort(Edata, (a,b) -> {   return (int) (a.salary-b.salary);  });
                displayRec(Edata);
                break;
            case 4:
                Collections.sort(Edata, (a,b) -> {   return a.dept_id-b.dept_id;  });
                displayRec(Edata);
                break;
            case 5:
                Collections.sort(Edata, (a,b) -> {   return a.dept_nam.compareTo(b.dept_nam);  });
                displayRec(Edata);
                break;
            case 6:// Search by Column Field Function
                Show_SubMenu2(Edata);
                break;    
            case 7:
                Show_Menu(Edata);
                break;
        }
    } catch (java.util.InputMismatchException e)
            {
            System.out.println(e+"\n"+"Input a number <1 to 7>\n");
            }
        Show_SubMenu(Edata);
    }


public static void Show_SubMenu2(ArrayList<EmpDetails> Edata) {
        System.out.println("\n\n--------------Employee Search by Column Sub Menu-----------");
        System.out.println("1. Search by Employee id\n2. Search by Full Name"
                + "\n3. Search by Salary > Amount" + "\n4. Search by Salary < Amount"
                + "\n5. Search by Department ID" + "\n6. Search by Department Name\n7. Back to Sub Menu");
        int sal, e_id, results=0;
        
        Scanner sc = new Scanner(System.in);
    try {    
        switch (sc.nextInt()) {
            case 1:
                Search_ByEId(Edata);
                break;
            case 2: //sort by Full name
                Search_ByFName(Edata);
                break;
            case 3:
                Search_SalaryGreaterT(Edata);
                break;
            case 4:
                Search_SalaryLesserT(Edata);
                break;
            case 5:
                Search_ByDeptId(Edata);
                break;
            case 6:
                Search_ByDeptNam(Edata);
                break; 
            case 7:
                Show_SubMenu(Edata);
                break;
        }
    } catch (java.util.InputMismatchException e)
            {
            System.out.println(e+"\n"+"Input a number <1 to 7>\n");
            }
        Show_SubMenu2(Edata);
    }

public static void AddData(ArrayList<EmpDetails> Empdata){
    System.out.println("\n\n--------------Add Employee Data-----------------");
        int e_id, sal, d_id,Latest_EmpID ;
        String f_n, l_n, e_m,d_n, answer ;

        
        Collections.sort(Empdata, (a,b) -> {   return a.emp_id-b.emp_id;  });
        Latest_EmpID = Empdata.get(Empdata.size()-1).getEmp_id();
        Latest_EmpID++;
        System.out.println(Latest_EmpID);
        
        Scanner inp = new Scanner(System.in);
    try {    
        System.out.println("Employee ID is auto generated : " 
        + Latest_EmpID);
        e_id = Latest_EmpID;
        System.out.println("Please enter First name:");
        f_n = inp.nextLine();
        System.out.println("Please enter Last name:");
        l_n = inp.nextLine();
        System.out.println("Please enter email:");
        e_m = inp.nextLine();
        System.out.println("Please enter Salary:");
        sal = Integer.parseInt(inp.nextLine());
        System.out.println("Please enter dept ID:");
        d_id = Integer.parseInt(inp.nextLine());
        System.out.println("Please enter Dept name:");
        d_n = inp.nextLine();
        
        System.out.println("Please confirm to add the above record: [Y/N]");
        //System.out.println("Emp Id: "+e_id+"First name: "+f_n+"Last name: "+l_n+"Email : "+e_m+"Salary : "+sal+"Dept ID: "+d_id+"Dept: "+d_n);
        
        answer = inp.nextLine();
        if ((answer.equals("Y")) || (answer.equals("y"))  ){ 
        Empdata.add(new EmpDetails(e_id, f_n, l_n, e_m, sal, d_id, d_n)); //update array
        UpdDb(e_id, f_n, l_n, e_m, sal, d_id); // update dbase
        dispRange(Empdata,(Empdata.size()-1),Empdata.size());
        }
    } catch (Exception e)
            {
            System.out.println(e+"\n");
            }
        Show_Menu(Empdata);
}

public static void EditData(ArrayList<EmpDetails> Edata){
    System.out.println("\n\n--------------Edit Employee Data-----------------");
    int e_id, sal, d_id, rec_num=0;
    String f_n, l_n, e_m,d_n, answer ;
        
        Scanner inp = new Scanner(System.in);
    try {    
        System.out.println("Please enter Employee ID:");
                e_id = Integer.parseInt(inp.nextLine());
                //System.out.println("e_id"+e_id);
                Collections.sort(Edata, (a,b) -> {   return a.emp_id-b.emp_id;  });
                for (int i=0; i<Edata.size();i++)    
                {
                    if (Edata.get(i).getEmp_id() == e_id) 
                    {
                        dispRange(Edata,i,i+1);
                        rec_num =i;
                        break;
                    }
                }
        System.out.println("Please confirm to edit the above record: [Y/N]\n");
        
        answer = inp.nextLine();
        
        if ( (answer.equals("Y")) || (answer.equals("y")) ){ 
        
            System.out.println("Please enter First name:");
            f_n = inp.nextLine();
            System.out.println("Please enter Last name:");
            l_n = inp.nextLine();
            System.out.println("Please enter email:");
            e_m = inp.nextLine();
            System.out.println("Please enter Salary:");
            sal = Integer.parseInt(inp.nextLine());
            System.out.println("Please enter dept ID:");
            d_id = Integer.parseInt(inp.nextLine());
            System.out.println("Please enter Dept name:");
            d_n = inp.nextLine();
            
            EditDb(e_id, f_n, l_n, e_m, sal, d_id); // update dbase
       
            Edata.get(rec_num).setEmp_id(e_id);
            Edata.get(rec_num).setF_nam(f_n);
            Edata.get(rec_num).setL_nam(l_n);
            Edata.get(rec_num).setEmail(e_m);
            Edata.get(rec_num).setSalary(sal);
            Edata.get(rec_num).setDept_id(d_id);
            Edata.get(rec_num).setDept_nam(d_n);
           
        }
    } catch (Exception e)
            {
            System.out.println(e+"\n");
            }
        Show_Menu(Edata);        
}

public static void DelData(ArrayList<EmpDetails> Edata){
        System.out.println("\n\n--------------Delete Employee Data-----------------");
        int e_id, rec_num=0;
        String answer;
        
        Scanner inp = new Scanner(System.in);
    try {    
        System.out.println("Please enter Employee ID:");
                e_id = Integer.parseInt(inp.nextLine());
                //System.out.println("e_id"+e_id);
                Collections.sort(Edata, (a,b) -> {   return a.emp_id-b.emp_id;  });
                for (int i=0; i<Edata.size();i++)    
                {
                    if (Edata.get(i).getEmp_id() == e_id) 
                    {
                        dispRange(Edata,i,i+1);
                        rec_num =i;
                        break;
                    }
                }
        if (rec_num ==0 )
        { 
            System.out.println("No record found!\n");
            Show_Menu(Edata);
        }        
        System.out.println("Please confirm to delete the above record: [Y/N]\n");
        answer = inp.nextLine();
        //System.out.println(answer);
        if ( (answer.equals("Y")) || (answer.equals("y")) ){ 
            
        Edata.remove(rec_num); // delete array element
        DelDbRec(e_id); // delete dbase element
        }
    } catch (Exception e)
            {
            System.out.println(e+"\n");
            }
        Show_Menu(Edata);        
}

public static void UpdDb(int emp_id, String f_nam, String l_nam,String email, float salary, int dept_id){
 try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "andrew", "andrew");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("insert into employees\n" +
"values(" + emp_id + "," +"'"+ f_nam +"'"+ ",'"+ l_nam +"','"+email+"',0,'01-Jan-20','ST_MAN'," +salary+",0,149,"+dept_id+")");
          
         System.out.println("Record updated successfully..."+emp_id+f_nam);
            
//close the connection object  
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

}


public static void DelDbRec(int emp_id){
 try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "andrew", "andrew");
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("delete employees\n" +
                                "where employee_id =" + emp_id);
          
            
         System.out.println("Record deleted successfully..."+emp_id);
            
//close the connection object  
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

}


public static void EditDb(int emp_id, String f_nam, String l_nam,String email, float salary, int dept_id){
 try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:prod", "andrew", "andrew");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("update employees\n"+
                                 "set first_name ='"+f_nam+"',"+
                                 "last_name ='"+l_nam+"',"+
                                 "email ='"+email+"',"+
                                 "salary ="+salary+","+
                                 "department_id ="+dept_id+
                                 "where employee_id="+emp_id);
          
         System.out.println("Record updated successfully..."+emp_id+f_nam);
            
//close the connection object  
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

}

public static void Search_ByEId(ArrayList<EmpDetails> Edata){
    int e_id; 
    
                Scanner inp = new Scanner(System.in);
                System.out.println("Please enter Employee ID:");
        try {        
                e_id = Integer.parseInt(inp.nextLine());
                //System.out.println("e_id"+e_id);
                Collections.sort(Edata, (a,b) -> {   return a.emp_id-b.emp_id;  });
                Edata.stream()  
                    .filter(p ->p.emp_id == e_id)   // filtering e_id  
                    .forEach(x -> {
                    System.out.printf("%6d \t %20s \t  %25s \t %25s \t %10f \t %4d \t %s \n", 
                            x.emp_id,x.f_nam,x.l_nam,x.email,x.salary,x.dept_id,x.dept_nam);
                });
        } catch (Exception e)
            {
            System.out.println(e+"\n");
            }
}

public static void Search_ByFName(ArrayList<EmpDetails> Edata){
    String f_n, l_n;
    
                Scanner inp = new Scanner(System.in);
    try {            
                System.out.println("Please enter First Name");
                f_n = inp.nextLine();
                System.out.println("Please enter Last Name");
                l_n = inp.nextLine();
                Comparator<EmpDetails> SortbyFull_nam = Comparator
                                                 .comparing(EmpDetails::getF_nam)
                                                 .thenComparing(EmpDetails::getL_nam);
                Collections.sort(Edata,SortbyFull_nam );
                //stream data
                    Edata.stream()  
                    .filter(p -> p.f_nam.equals(f_n))   // filtering by f_n
                    .filter(p -> p.l_nam.equals(l_n))   // filtering by f_n        
                    .forEach(x -> {
                    System.out.printf("%6d \t %20s \t  %25s \t %25s \t %10f \t %4d \t %s \n", 
                            x.emp_id,x.f_nam,x.l_nam,x.email,x.salary,x.dept_id,x.dept_nam);
                }); 
    } catch (Exception e)
            {
            System.out.println(e+"\n");
            }
    
}
public static void Search_SalaryGreaterT(ArrayList<EmpDetails> Edata){
    int sal;
                
                Scanner inp = new Scanner(System.in);
    try {
                System.out.println("Please enter Salary:");
                sal = Integer.parseInt(inp.nextLine());
                Collections.sort(Edata, (a,b) -> {   return (int) (a.salary-b.salary);  });
                //stream data
                     Edata.stream()  
                    .filter(p ->p.salary> sal)   // filtering salary  
                    .forEach(x -> {
                    System.out.printf("%6d \t %20s \t  %25s \t %25s \t %10f \t %4d \t %s \n", 
                            x.emp_id,x.f_nam,x.l_nam,x.email,x.salary,x.dept_id,x.dept_nam);
                }); 
    } catch (Exception e)
            {
            System.out.println(e+"\n");
            }                
}

public static void Search_SalaryLesserT(ArrayList<EmpDetails> Edata){
    int sal;
                Scanner inp = new Scanner(System.in);
    try {
                System.out.println("Please enter Salary:");
                sal = Integer.parseInt(inp.nextLine());
                Collections.sort(Edata, (a,b) -> {   return (int) (a.salary-b.salary);  });
                //stream data
                     Edata.stream()  
                    .filter(p ->p.salary < sal)   // filtering salary  
                    .forEach(x -> {
                    System.out.printf("%6d \t %20s \t  %25s \t %25s \t %10f \t %4d \t %s \n", 
                            x.emp_id,x.f_nam,x.l_nam,x.email,x.salary,x.dept_id,x.dept_nam);
                }); 
    } catch (Exception e)
            {
            System.out.println(e+"\n");
            }                 
}


public static void Search_ByDeptId(ArrayList<EmpDetails> Edata){
    int d_id;        
                Scanner inp = new Scanner(System.in);
    try {            
                System.out.println("Please enter Dept Id:");
                d_id = Integer.parseInt(inp.nextLine());
                Collections.sort(Edata, (a,b) -> {   return a.dept_id-b.dept_id;  });
                
                Edata.stream()  
                    .filter(p ->p.dept_id == d_id)   // filtering e_id  
                    .forEach(x -> {
                    System.out.printf("%6d \t %20s \t  %25s \t %25s \t %10f \t %4d \t %s \n", 
                            x.emp_id,x.f_nam,x.l_nam,x.email,x.salary,x.dept_id,x.dept_nam);
                }); 
    } catch (Exception e)
            {
            System.out.println(e+"\n");
            }
}

public static void Search_ByDeptNam(ArrayList<EmpDetails> Edata){
String d_n;        
                Scanner inp = new Scanner(System.in);
    try {            
                System.out.println("Please enter Dept Name:");
                d_n = inp.nextLine();
                Collections.sort(Edata, (a,b) -> {   return a.dept_nam.compareTo(b.dept_nam);  });
                Edata.stream()  
                    .filter(p ->p.dept_nam.equals(d_n))   // filtering d_n  
                    .forEach(x -> {
                    System.out.printf("%6d \t %20s \t  %25s \t %25s \t %10f \t %4d \t %s \n", 
                            x.emp_id,x.f_nam,x.l_nam,x.email,x.salary,x.dept_id,x.dept_nam);
                }); 
    } catch (Exception e)
            {
            System.out.println(e+"\n");
            }            
}

public static String rPad(String str, int num) {
      //%[argument_index$][flags][width][.precision]conversion
      // %1$ from the first argument index 0; add space to width provided +"s-string format"
    return String.format("%1$-" + num + "s", str);
  }

public static void displayRec(ArrayList<EmpDetails> data){
    System.out.println(    rPad("ROW",6)+
                       "|"+rPad("EID",6)+
                           rPad("FIRST NAME",20 )+
                           rPad("LAST NAME",25 )+
                           rPad("EMAIL",25 )+
                           rPad("SALARY",10)+
                           rPad("DID",4)+
                           rPad("DEPARTMENT NAME",30 )+"|"
                            );        
    for(int i = 0; i < data.size(); i++) {  
 
       System.out.println( rPad(String.valueOf(i+1),6)+
                           "|"+rPad(String.valueOf(data.get(i).getEmp_id()),6)+
                           rPad(data.get(i).getF_nam(),20 )+
                           rPad(data.get(i).getL_nam(),25 )+
                           rPad(data.get(i).getEmail(),25 )+
                           rPad(String.valueOf(data.get(i).getSalary()),10)+
                           rPad(String.valueOf(data.get(i).getDept_id()),4)+
                           rPad(data.get(i).getDept_nam(),30 )+"|"
                            );
            } 
}

public static void dispRange(ArrayList<EmpDetails> data, int start, int stop){
    System.out.println(    rPad("ROW",6)+
                       "|"+rPad("EID",6)+
                           rPad("FIRST NAME",20 )+
                           rPad("LAST NAME",25 )+
                           rPad("EMAIL",25 )+
                           rPad("SALARY",10)+
                           rPad("DID",4)+
                           rPad("DEPARTMENT NAME",30 )+"|"
                            ); 
    int index =1;
    for(int i = start; i < stop; i++) {  
        //System.out.println("i : "+i+"start : "+start+"stop : "+stop);
 
       System.out.println( rPad(String.valueOf(index),6)+
                           "|"+rPad(String.valueOf(data.get(i).getEmp_id()),6)+
                           rPad(data.get(i).getF_nam(),20 )+
                           rPad(data.get(i).getL_nam(),25 )+
                           rPad(data.get(i).getEmail(),25 )+
                           rPad(String.valueOf(data.get(i).getSalary()),10)+
                           rPad(String.valueOf(data.get(i).getDept_id()),4)+
                           rPad(data.get(i).getDept_nam(),30 )+"|"
                            );
    index++;        
    } 
}


}


