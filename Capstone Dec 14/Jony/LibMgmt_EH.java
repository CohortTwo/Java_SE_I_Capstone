/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jony
 */
public class LibMgmt_EH {
    
    
    static ArrayList<LibBook> arrLib = new ArrayList<LibBook>();
    
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu(){
        try {
        System.out.println("------------ Library Books Management System -----------");
        System.out.println("1.Query all books information\n2. Query according to book id\n3. Add book\n4. Modify book information\n5. Delete book\n6. Exit\n----------------\nWhat would you like to do? (Enter a number):");
        Scanner sc = new Scanner(System.in);
        
        switch (sc.nextInt()) {
            case 1:
                findAll();
                break;
            case 2:
                findById();
                break;
            case 3:
                add();
                break;
            case 4:
                modify();
                break;
            case 5:
                delete();
                break;
                
        }
        }  
        
        catch(java.util.InputMismatchException e){
                        System.out.println("Please enter a number from 1 - 6 corresponding to the options");
                        }
        menu();

        }
        
    
    
    
     public static void findAll() {
        if (arrLib.size() != 0) {
            for (int i = 0; i < arrLib.size(); i++) {
                System.out.println("The book information for book number: " + arrLib.get(i).getBookId() + " is: \n------------------ --\n"
                        + "\nTitle: " + arrLib.get(i).getbTitle() + "\n Author is: " + arrLib.get(i).getbAuthor() + "\n Borrower is: "
                        + arrLib.get(i).getCustId() + "\n--------------------\n\n");
            }
        } else {
            System.out.println("This system has no book information temporarily!");

        }
        menu();

    }
     
     
     public static void findById() {
        int i;
        if (arrLib.size() != 0) {
            int j = 0;
            System.out.println("Please enter book id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (i = 0; i < arrLib.size(); i++) {
                if (arrLib.get(i).getBookId() == id) {
                    j++;
                    System.out.println("The book information for book number:" + arrLib.get(i).getBookId() + " is: \n------------------ --\n"
                            + "Title:" + arrLib.get(i).getbTitle() + "\n Author is:" + arrLib.get(i).getbAuthor() + "\n Borrower is: "
                        + arrLib.get(i).getCustId() + "\n--------------------\n\n");

                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system temporarily has no such book id information!");
            }
        } else {
            System.out.println("This system has no book information temporarily!");
        }
        menu();

    }
     
     
     
     public static void add() {
        int id;
        String title;
        String author;
        int custid;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the book id (integer):");
        id = sc.nextInt();
        System.out.println("Please enter the book title:");
        title = sc.next();
        System.out.println("Please enter the author name:");
        author = sc.next(); 
        System.out.println("Please enter borrower id:");
        custid = sc.nextInt();
        arrLib.add(new LibBook(id, title, author, custid));
        menu();
    }
     
     
     
     public static void modify() {
        if (arrLib.size() != 0) {
            int j = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter book id!");
            //Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < arrLib.size(); i++) {
                if (arrLib.get(i).getBookId() == id) {
                    String title;
                    String author;
                    int custid;
                    
                    System.out.println("Please enter the modified book title:");
                    title = sc.next();
                    System.out.println("Please enter the modified book author:");
                    author = sc.next();
                    System.out.println("Please enter the modified borrower id:");
                    custid = sc.nextInt();
                    arrLib.set(i, new LibBook(id, title, author, custid));
                    j++;
                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system has no such book id information!");
            }
        } else {
            System.out.println("This system has no book information temporarily!");
        }
        menu();
    }

    public static void delete() {
        if (arrLib.size() != 0) {
            int j = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter book id!");
            //Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < arrLib.size(); i++) {
                if (arrLib.get(i).getBookId() == id) {
                    int oid = arrLib.get(i).getBookId();
                    arrLib.remove(i);
                    System.out.println("Book ID: " + oid + " This book information has been deleted successfully!");
                    menu();
                    break;
                }
                j++;
            }
            if (j == 0) {
                System.out.println("This system has no such book id information!");
            }
        } else {
            System.out.println("This system has no book information temporarily!");
        }
        menu();
    }

    
    
    
}
 