/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicFunctions;

import Design.LMS;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Desmond
 */
public class LMSLogic {

    static ArrayList<LMS> arr = new ArrayList<LMS>();

    //main method
    public static void main(String[] args) {
        menu();
    }

    //menu method
    public static void menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== Welcome to a Random Library Management System ==========");

        System.out.println("1. Query all\n2. Add new book details\n3. Modify an existing record\n4. Delete an existing record\n5. Exit ");
        beautify();
        System.out.println("Please enter the number of your selection: ");
        switch (sc.nextInt()) {
            case 1:
                queryAll();
                break;
            case 2:
                add();
                break;
            case 3:
                mod();
                break;
            case 4:
                del();
                break;
            case 5:
                break;
        }

    }

    public static void beautify() {
        System.out.println("===================================================================");
    }

    //query method
    public static void queryAll() {
        //check the array whether is zero
        if (arr.isEmpty()) {
            beautify();
            System.out.println("There is no existing book information. Please return to main to add some");
            beautify();
            menu();
        } else {
            //loop the array
            for (int i = 0; i < arr.size(); i++) {
                beautify();
                System.out.println("The details of Book ID: " + arr.get(i).getBookID() + " is\nBookID: " + arr.get(i).getBookTitle()
                        + "\nAuthor: " + arr.get(i).getAuthor());
                beautify();
            }
        }
        menu();

    }

    //add method
    public static void add() {
        int bookID;
        String bookTitle;
        String author;
        String custName;
        int custNo;

        beautify();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Book ID (Numbers only!): ");
        bookID = Integer.parseInt(sc.nextLine());
        System.out.println("Please enter the Book Title:  ");
        bookTitle = sc.nextLine();
        System.out.println("Please enter the Author's name: ");
        author = sc.nextLine();
        System.out.println("Please enter the Customer's No.: ");
        custNo = Integer.parseInt(sc.nextLine());
        System.out.println("Please enter the Customer's name: ");
        custName = sc.nextLine();
        arr.add(new LMS(bookID, bookTitle, author, custName, custNo));

        beautify();
        System.out.println("*****Added*****");
        beautify();
        menu();
    }

    //delete method
    public static void del() {
        if (arr.isEmpty()) {
            beautify();
            System.out.println("There is no existing book information. Please return to main to add some");
            beautify();
            menu();
        } else {
            //loop the array
            beautify();
            System.out.println("Please enter ID of the Book");
            Scanner sc = new Scanner(System.in);
            int bookID = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getBookID() == (bookID)) {
                    int temp = arr.get(i).getBookID();
                    arr.remove(i);
                    beautify();
                    System.out.println("Book id " + temp + " has been successfully deleted.");
                    beautify();
                }
            }
        }

        menu();

    }

    //modify method
    public static void mod() {
        if (arr.isEmpty()) {
            beautify();
            System.out.println("There is no existing book information. Please return to main to add some");
            beautify();
            menu();
        } else {
            //loop the array
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the book ID for the book you wish to modify: ");
            int bookID = sc.nextInt();

            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getBookID() == bookID) {

                    System.out.println("What do you want to change for this entry?");
                    System.out.println("1. Book ID\n2. Book Title details\n3. Author Name\n4. Customer ID\n5. Customer Name\n6. Exit to main");
                    switch (sc.nextInt()) {
                        case 1:
                            System.out.println("Please enter the new ID number: ");
                            int newBookID = sc.nextInt();
                            String newBookTitle = arr.get(i).getBookTitle();
                            String Author = arr.get(i).getAuthor();
                            String custName = arr.get(i).getCustName();
                            int custNo = arr.get(i).getCustNo();
                            arr.set(i, new LMS(newBookID, newBookTitle, Author, custName, custNo));
                            beautify();
                            System.out.println("*****Modified ID*****");
                            break;
                        case 2:
                            System.out.println("Please enter the new Book Title: ");
                            String newBookTitle1 = sc.nextLine();
                            int newBookID1 = arr.get(i).getBookID();
                            String newAuthor1 = arr.get(i).getAuthor();
                            String custName1 = arr.get(i).getCustName();
                            int custNo1 = arr.get(i).getCustNo();
                            arr.set(i, new LMS(newBookID1, newBookTitle1, newAuthor1, custName1, custNo1));
                            beautify();
                            System.out.println("*****Modified Book Title*****");
                            break;

                        case 3:
                            System.out.println("Please enter the new Author name: ");
                            String newAuthor2 = sc.nextLine();
                            String newBookTitle2 = arr.get(i).getBookTitle();
                            int newBookID2 = arr.get(i).getBookID();
                            String custName2 = arr.get(i).getCustName();
                            int custNo2 = arr.get(i).getCustNo();
                            arr.set(i, new LMS(newBookID2, newBookTitle2, newAuthor2, custName2, custNo2));
                            beautify();
                            System.out.println("*****Modified Author*****");
                            break;
                        case 4:
                            System.out.println("Please enter the new Customer ID: ");
                            int custNo3 = sc.nextInt();
                            String newBookTitle3 = arr.get(i).getBookTitle();
                            int newBookID3 = arr.get(i).getBookID();
                            String newAuthor3 = arr.get(i).getAuthor();
                            String custName3 = arr.get(i).getCustName();
                            arr.set(i, new LMS(newBookID3, newBookTitle3, newAuthor3, custName3, custNo3));
                            beautify();
                            System.out.println("*****Modified Customer ID*****");
                            break;
                        case 5:
                            System.out.println("Please enter the new Customer Name: ");
                            String custName4 = sc.nextLine();
                            int custNo4 = arr.get(i).getCustNo();
                            String newBookTitle4 = arr.get(i).getBookTitle();
                            int newBookID4 = arr.get(i).getBookID();
                            String newAuthor4 = arr.get(i).getAuthor();
                            arr.set(i, new LMS(newBookID4, newBookTitle4, newAuthor4, custName4, custNo4));
                            beautify();
                            System.out.println("*****Modified Customer Name*****");
                            break;
                        case 6:
                            menu();
                            break;

                    }
                }
            }
        }

    }

}
