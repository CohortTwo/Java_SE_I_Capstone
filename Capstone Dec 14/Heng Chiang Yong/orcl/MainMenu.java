/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orcl;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 *
 * @author chiangyong
 */
public class MainMenu {

    public static void dispMenu() {
            

        System.out.println("\n    Employee Management System    ");
        System.out.println("__________________________________");
        System.out.println("|  1. Show All Employees record   |");
        System.out.println("|  2. Add Employee record         |");
        System.out.println("|  3. Query Employee record       |");
        System.out.println("|  4. Delete Employee record      |");
        System.out.println("|  5. Edit Employee record        |");
        System.out.println("|  6. Add Department record       |");
        System.out.println("|  7. Delete Department record    |");
        System.out.println("|  8. Show Department record      |");
        System.out.println("|  9. Exit                        |");
        System.out.println("___________________________________");
        System.out.print("Enter the Integer <1 to 9> : ");
    }

    public static void main(String args[]) throws SQLException {
        boolean exitFlag = false;
        SQL sql = new SQL();

        Scanner inp = new Scanner(System.in);
        try {
            while (!exitFlag) {
                dispMenu();
                int ops = inp.nextInt();
                inp.nextLine();
                System.out.println("");
                switch (ops) {
                    case 1:
                        //sql.maxID();
                        sql.ShowAllEmp();
                        break;
                    case 2:
                        sql.AddEmpRec();
                        break;
                    case 3:
                        sql.QueryEmpRec();
                        break;
                    case 4:
                        sql.delEmpRec();
                        break;
                    case 5:
                        sql.updateEmpRec();
                        break;
                    case 6:    
                        sql.AddDepRec();
                        break;
                    case 7:  
                        sql.delDepRec();
                        break;
                    case 8:
                        sql.showAllDept();
                        break;
                    case 9:
                        sql.exitRec();
                        exitFlag = true;
                        break;
                    default:
                        System.err.println("\n Enter integer from 1 to 9!");
                        inp.nextLine();
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Enter Integer Only!");
        }
    }
}
