/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Scanner;

/**
 *
 * @author chiangyong
 */
public class LibSystem {

    /**
     * @param args the command line arguments
     */
    public static void dispMenu() {
        System.out.println("Book Library Management System");
        System.out.println("1. Add new book");
        System.out.println("2. Update book");
        System.out.println("3. Delete book");
        System.out.println("4. Query a book");
        System.out.println("5. Exit");
        System.out.print("Enter < 1 - 5 > : ");
    }

    public static void main(String[] args) {
        // TODO code application logic here

        boolean exitFlag = false;
        BookManage bookMan = new BookManage();
        
        while(!exitFlag) {
            dispMenu();
            

            Scanner inp = new Scanner(System.in);

            switch (inp.nextInt()) {
                case 1:
                    bookMan.AddBook();
                    break;
                case 2:
                    bookMan.UpdateBook();
                    break;
                case 3:
                    bookMan.DeleteBook();
                    break;
                case 4:
                    bookMan.QueryBook();
                    break;
                case 5:
                    exitFlag = true;
                    break;
            }

        } 

    }
    
}
