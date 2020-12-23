package testing;
import java.util.ArrayList;
import java.util.Scanner;

class Department {
    static ArrayList<Department> dept_m = new ArrayList<Department>();
    int id;
    String name;

    public ArrayList<Department> getDept_m() {
        return dept_m;
    }

    public void setDept_m(ArrayList<Department> dept_m) {
        this.dept_m = dept_m;
    }

    public Department() {
      }
    
    public Department(int id, String name) {
        //super();
        this.id = id;
        this.name = name;
    }
     
    class Dep_Mgmt {
    
        void addDep() {
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Dept id (integer):");
        id = sc.nextInt();
        
        System.out.println("Please enter the Department name:");
        name = sc.next();
        Department.dept_m.add(new Department(id, name));
        System.out.println("\033[0;35m" + "\n\u001B[42mDepartment entered: id = " + id + " name = " + name +"\n");
        }

        void showDep() {
            System.out.println("\n\nDEPARTMENTS LISTING");
            for (int i = 0; i < dept_m.size(); i++) {
                System.out.println(dept_m.get(i).id + " " + dept_m.get(i).name);
        
            }
        }
    }
}
   
public class Employee_innerclass {

    public static void main(String[] args) {
        Department dept = new Department();
        var manage_d = dept.new Dep_Mgmt();
        display();
         //manage_d.addDep();
        //manage_d.showDep();
    }

    
    
    public static void display() {
        System.out.println("\033[0;31m" + "\u001B[43m|            Human Resource System                 |\n");
        System.out.println("\033[0;34m" + "1. Add Department\n\033[0;34m2. List Department \n\033[0;34m3. Exit");
        
        Scanner sc = new Scanner(System.in);
        
        Department dept = new Department();
        var manage_d = dept.new Dep_Mgmt();
        switch (sc.nextInt()) {
            case 1:
                manage_d.addDep();
                display();
            
            case 2:
                manage_d.showDep();
                display();
                break; 
            
            case 3:
                System.out.println("thanks for using HR system");
                display();
                break;

   }
}
}

// public Integer getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }