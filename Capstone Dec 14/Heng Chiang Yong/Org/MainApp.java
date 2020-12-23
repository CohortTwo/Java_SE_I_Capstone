/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Org;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @ Heng Chiang Yong, 026D
 * @author chiangyong
 */
public class MainApp {
    
    public static void MainMenu() {
        System.out.println("************************************");
        System.out.println("*  Organisation Management System  *");
        System.out.println("************************************");
        System.out.println("************************************");
        System.out.println("*    HR Management System          *");
        System.out.println("************************************");
        System.out.println("* 1. Add new Employee ID           *");
        System.out.println("* 2. Update Empolyee record        *");
        System.out.println("* 3. Delete Employee record        *");
        System.out.println("* 4. Query a Employee record       *");
        System.out.println("* 5. Query all Employee record     *");
        System.out.println("************************************");
        System.out.println("*    Department Management System  *");
        System.out.println("************************************");
        System.out.println("* 6. Add new Department ID         *");
        System.out.println("* 7. Update Department record      *");
        System.out.println("* 8. Delete Department record      *");
        System.out.println("* 9. Query a Department            *");
        System.out.println("* 10. Query all Department record  *");
        System.out.println("* 11. Exit                         *");
        System.out.println("************************************");
        System.out.print("  Enter your choice from < 1 - 9 > : ");

    }
    
    public static void dispDeptMenu() {
        boolean exitFlag = false;
        Scanner inp = new Scanner(System.in);
        Organisation coy = new Organisation();
        Organisation.DeptManage dept = coy.new DeptManage();
        
        System.out.println("\n"+coy.getCompany()+", "+coy.getHQLocation());
        System.out.println("************************************");
        System.out.println("*    Department Management System  *");
        System.out.println("************************************");
        System.out.println("* 1. Add new Department ID         *");
        System.out.println("* 2. Update Department record      *");
        System.out.println("* 3. Delete Department record      *");
        System.out.println("* 4. Query a Department            *");
        System.out.println("* 5. Exit                          *");
        System.out.println("************************************");
        System.out.print("  Enter your choice from < 1 - 5 > : ");
       // inp.nextLine();
        while(!exitFlag){
            System.out.println("\n"+coy.getCompany()+", "+coy.getHQLocation());
           // System.out.println("");
            dispDeptMenu();
            switch(inp.nextInt()){
                case 1:
                    dept.addDept();
                    break;
                case 2:
                    dept.updateDept();
                    break;
                case 3:
                    dept.delDept();
                    break;
                case 4:
                    dept.deptQuery();
                    break;
                case 5:
                    exitFlag = true;
                    break;
                default:
                    System.out.println("Enter only 1 to 5 : ");
                    break;
            }
            
            
        }
    }
    
    public static void dispEmpMenu() {
         boolean exitFlag = false;
        Scanner inp = new Scanner(System.in);
        Organisation coy = new Organisation();
        Organisation.manageEmp em = coy.new manageEmp();
        System.out.println("\n"+coy.getCompany()+", "+coy.getHQLocation());
        
        System.out.println("************************************");
        System.out.println("*    HR Management System  *");
        System.out.println("************************************");
        System.out.println("* 1. Add new Employee ID           *");
        System.out.println("* 2. Update Empolyee record        *");
        System.out.println("* 3. Delete Employee record        *");
        System.out.println("* 4. Query a Employee record       *");
        System.out.println("* 5. Exit                          *");
        System.out.println("************************************");
        System.out.print("  Enter your choice from < 1 - 5 > : ");
      //  inp.nextLine();
        while(!exitFlag){
            System.out.println("\n"+coy.getCompany()+", "+coy.getHQLocation());
           // System.out.println("");
            dispEmpMenu();
            int ops = inp.nextInt();
            inp.reset();
            switch(ops){
                case 1:
                    em.addEmpRec();
                    break;
                case 2:
                    em.updateEmpRec();
                    break;
                case 3:
                    em.delEmpRec();
                    break;
                case 4:
                    em.queryEmpRec();
                    break;
                case 5:
                    exitFlag = true;
                    break;
                default:
                    System.out.println("Enter only 1 to 5 : ");
                    break;
            }
            
            
        }
        
    }
    
    public static void main(String args[])
    {
        boolean exitFlag = false;
        Scanner in = new Scanner(System.in);
        Organisation coy = new Organisation();
        Organisation.DeptManage dept = coy.new DeptManage();
        Organisation.manageEmp em = coy.new manageEmp();
//        Organisation.Department department = coy.new Department();
//        Organisation.Employee employee = coy.new Employee();
        
        while(!exitFlag){
            System.out.println("\n"+coy.getCompany()+", "+coy.getHQLocation());
           // System.out.println("");
            MainMenu();
        try{    
            int option = in.nextInt();
            in.nextLine();
            
            switch(option){
                case 1:
                    em.addEmpRec();
                    break;
                case 2:
                    em.updateEmpRec();
                    break;
                case 3:
                    em.delEmpRec();
                    break;
                case 4:
                    em.queryEmpRec();
                    break;
                case 5:
                    em.queryAllRec();
                    break;
                case 6:
                    dept.addDept();
                    break;
                case 7:
                    dept.updateDept();
                    break;
                case 8:
                    dept.delDept();
                    break;
                case 9:
                    dept.deptQuery();
                    break;
                case 10:
                    dept.QueryAllDept();
                    break;
                case 11:
                    exitFlag = true;
                    break;
                default:
                    //in.nextLine();
                    System.out.println("Enter only 1 to 11 : ");
                    break;
            }
            
        }catch(InputMismatchException e){
                System.err.println("Enter only Integer from 1 to 11!");
                in.nextLine();
                }
        }
        
    }
}
