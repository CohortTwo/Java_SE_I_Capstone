package com.library;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageLibraryMain{

    static ArrayList<Library> arr = new ArrayList<>();

    public static void main(String[] args) {
        arr.add(new Library(1,"ABC",1,"PROGRAMMER1"));
        arr.add(new Library(2,"ABCD",2,"PROGRAMMER"));
        arr.add(new Library(3,"ABC",1,"PROGRAMMER"));
        arr.add(new Library(4,"Kid Book",4,"Jane"));
        arr.add(new Library(5,"School Book",1,"Annie"));
        arr.add(new Library(6,"Student Book",6,"Bob"));
        menu();
    }

    public static void menu() {
        System.out.println("--------------Library Management System-----------");
        System.out.println(
                "1. Query all library information\n" +
                "2. Query according to library number\n" +
                "3. Add library\n" +
                "4. Modify library information\n" +
                "5. Delete library\n" +
                "6. Query according to author name\n" +
                "7. Exit");
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
            case 6:
                findBookByByAuthor();
            case 7:
                break;
            default:
                System.out.println("Invalid number called");
                menu();
                break;
        }
    }

    public static void findAll() {
        if (arr.size() != 0) {
            for (int i = 0; i < arr.size(); i++) {
                printInfo(arr.get(i));
            }
        } else {
            System.out.println("This system has no library information temporarily!");

        }
        menu();

    }

    private static void printInfo(Library library){
        System.out.println(
                "The library information for book number " + library.getBookId() + " is: \n" +
                "----------------------" +
                "\n Title: " + library.getBookTitle() +
                "\n CustomerId: " + library.getCustId() +
                "\n Author: " + library.getAuthor() +
                "\n----------------------\n");
    }

    public static void findId() {
        int i;
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter book id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (i = 0; i < arr.size(); i++) {
                if (arr.get(i).getBookId() == id) {
                    j++;
                    printInfo(arr.get(i));

                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system temporarily has no such id student information!");
            }
        } else {
            System.out.println("This system has no student information temporarily!");
        }

        menu();

    }

    public static void add() {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the book id (integer):");
        library.setBookId(Integer.valueOf(sc.nextLine().trim()));
        System.out.println("Please enter the book title:");
        library.setBookTitle(sc.nextLine());
        System.out.println("Please enter the cust id (integer):");
        library.setCustId(Integer.valueOf(sc.nextLine().trim()));
        System.out.println("Please enter author name:");
        library.setAuthor(sc.nextLine());
        arr.add(library);
        menu();
    }

    public static void change() {
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter book id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getBookId() == id) {
                    System.out.println("Please enter the modified book title:");
                    arr.get(i).setBookTitle(sc.next());
                    System.out.println("Please enter the modified customer id:");
                    arr.get(i).setCustId(sc.nextInt());
                    System.out.println("Please enter the modified author name:");
                    arr.get(i).setAuthor(sc.next());
                    j++;
                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system has no such book id information!");
            }
        } else {
            System.out.println("This system has no library information temporarily!");
        }
        menu();
    }

    public static void delete() {
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter book id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getBookId() == id) {
                    int oid = arr.get(i).getBookId();
                    arr.remove(i);
                    System.out.println("Book ID: " + oid + " library information has been deleted successfully!");
                    menu();
                    break;
                }
                j++;
            }
            if (j == 0) {
                System.out.println("This system has no such book id information!");
            }
        } else {
            System.out.println("This system has no library information temporarily!");
        }
        menu();
    }

    public static void findBookByByAuthor(){
        int numFound = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter author name : ");
        String author = scanner.next();
        for(Library l : arr){
            if(l.getAuthor().equalsIgnoreCase(author)){
                printInfo(l);
            }
        }
        if(numFound == 0){
            System.out.println("This system has no library information for this author : " + author);
        }
        menu();
    }
}
