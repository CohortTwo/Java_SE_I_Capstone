/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dapp;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author amutha
 */
public class LibManage {
    
    static ArrayList<LibraryCust> arr = new ArrayList<LibraryCust>();
    
    
    public static void main (String [] args){
        menu();
    }

    public static void menu() {
        System.out.println("--------------Library Management System-----------");
        System.out.println("1.Query all book information\n2. Query according to Customer ID\n3. Add Book Entry\n4. Modify Book information\n5. Delete entry\n6. Exit");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                findAll();
                break;
            case 2:
                findId();
                break;
            case 3:
                add();
                break;
            case 4:
                change();
                break;
            case 5:
                delete();
                break;

        }
    }

    public static void findAll() {
        if (arr.size() != 0)
        {
            for (int i = 0; i < arr.size(); i++) {
                System.out.println("The book information for customer ID:" + arr.get(i).getBookId() + " is: \n------------------ --\n"
                        + "Book Name:" + arr.get(i).getBookName() + "\nAuthor Name is:" + arr.get(i).getAuthor() + "\n Book ID is :"
                        + arr.get(i).getCustId() + "\n--------------------\n\n");
            }
        } else {
            System.out.println("This system has no customer information temporarily!");
            
        }
        menu();

    }

    public static void findId() {
        int i;
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter Customer id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (i = 0; i < arr.size(); i++) {
                if (arr.get(i).getCustId() == id) {
                    j++;
                    System.out.println("The book information for customer ID:" + arr.get(i).getCustId() + " is: \n------------------ --\n"
                        + "Book Name:" + arr.get(i).getBookName() + "\nAuthor Name is:" + arr.get(i).getAuthor() + "\n Book ID is :"
                        + arr.get(i).getBookId() + "\n--------------------\n\n");

                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system temporarily has no such id customer information!");
            }
        } else {
            System.out.println("This system has no customer information temporarily!");
        }
        menu();

    }
    
    public static void add() {
        int BookId;
        String BookName;
        String Author;
        int CustId;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Book id (integer):");
        BookId = sc.nextInt();
        System.out.println("Please enter the Book Name:");
        BookName = sc.next();
        System.out.println("Please enter the Author:");
        Author = sc.next();
        System.out.println("Please enter the Customer ID:");
        CustId = sc.nextInt();
        arr.add(new LibraryCust(BookId, BookName, Author, CustId));
        menu();
    }
 
    public static void change() {
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter Customer id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getCustId() == id) {
                    
                    int BookId;
                    String BookName;
                    String Author;
                    //int CustId;
                    System.out.println("Please enter the modified Book id (integer:");
                    BookId = sc.nextInt();
                    System.out.println("Please enter the modified Book Name:");
                    BookName = sc.next();
                    System.out.println("Please enter the modified Author Name:");
                    Author = sc.next();
                    arr.set(i, new LibraryCust(BookId, BookName, Author, id));
                    //arr.set(i, new Student(id, name, age, gender));
                    j++;
                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system has no such id customer information!");
            }
        } else {
            System.out.println("This system has no customer information temporarily!");
        }
        menu();
    }

    public static void delete() {
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter Customer id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getCustId() == id) {
                    int oid = arr.get(i).getCustId();
                    arr.remove(i);
                    System.out.println("Customer ID:" + oid + "The customer information has been deleted successfully!");
                    menu();
                    break;
                }
                j++;
            }
            if (j == 0) {
                System.out.println("This system has no such id customer information!");
            }
        } else {
            System.out.println("This system has no customer information temporarily!");
        }
        menu();
    }
}
