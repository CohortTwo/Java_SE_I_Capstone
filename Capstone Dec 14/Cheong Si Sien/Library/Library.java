package library;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    static ArrayList<Book> arr = new ArrayList<Book>(); // Book as ArrayList type

    public static void main(String[] args) {
        display();
    }

    public static void display() {
        System.out.println("\033[0;31m" + "\u001B[43m|            Library System                 |\n");
        System.out.println("\033[0;34m" + "1. Query all Books information\n\033[0;34m2. Query according to Book ID\n\033[0;34m3. Add Book\n\033[0;34m4. Modify book information\n\033[0;34m5. Delete book\n\033[0;34m6. Loaning book\n\033[0;34m7. Exit");

        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1:
                queryAll();
                break;
            case 2:
                queryId();
                break;
            case 3:
                addBook();
                break;
            case 4:
                changeBook(4);
                break;
            case 5:
                delBook();
                break;
            case 6:
                changeBook(6);
                break;
            case 7:
                System.out.println("Exiting Library System");
                break;
        }
    }

    public static void queryAll() {
        if (arr.size() != 0) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.println("The Book information for Book ID:" + arr.get(i).getId() + " is: \n-----------------------------------------------\n"
                        + "Title:" + arr.get(i).getTitle() + "\nAuthot is:" + arr.get(i).getAuthor() + "\nBorrower is:"
                        + arr.get(i).getborrowerid() + "\n-----------------------------------------------\n\n");
            }
        } else {
            System.out.println("\033[0;31m This system has no Book information temporarily!\n");
        }
        display();

    }

    public static void queryId() {
        int i;
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter Book id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    j++;
                    System.out.println("The Book information for Book ID:" + arr.get(i).getId() + " is: \n------------------ --\n"
                            + "Title:" + arr.get(i).getTitle() + "\nAuthor is:" + arr.get(i).getAuthor() + "\nborrower is:"
                            + arr.get(i).getborrowerid() + "\n--------------------\n\n");

                    break;
                }
            }
            if (j == 0) {
                System.out.println("\033[0;31mThis system temporarily has no such id Book information!\n");
            }
        } else {
            System.out.println("\033[0;31mThis system has no Book information temporarily!\n");
        }
        display();

    }

    public static void addBook() {
        int id;
        String title;
        int borrowerid;
        String author;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Book id (integer):");
        id = sc.nextInt();
        System.out.println("Please enter the Book name:");
        title = sc.next();
        System.out.println("Please enter the Borrowerid(integer), key in 0 if not loaned:");
        borrowerid = sc.nextInt();
        System.out.println("Please enter author name:");
        author = sc.next();
        arr.add(new Book(id, title, borrowerid, author));
        display();
    }

    public static void changeBook(int x) {
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter Book id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    String title;
                    String author;
                    int borrowerid;
                    if (x == 4){
                    System.out.println("Please enter the updated Book name:");
                    title = sc.next();
                    System.out.println("Please enter the updated Author:");
                    author = sc.next();
                    borrowerid = arr.get(i).getborrowerid();
                    }
                    else {
                          System.out.println("Please enter the new Borrower: (key in 0 if returned with no borrower)");
                          borrowerid = sc.nextInt();
                          author = arr.get(i).getAuthor();
                          title = arr.get(i).getTitle();
                    }
                    
                    arr.set(i, new Book(id, title, borrowerid, author));
                    j++;
                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system has no such Book information!");
            }
        } else {
            System.out.println("This system has no Book information temporarily!");
        }
        display();
    }

    public static void delBook() {
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter Book id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    int oid = arr.get(i).getId();
                    arr.remove(i);
                    System.out.println("Book ID:" + oid + "The Book information has been deleted successfully!");
                    display();
                    break;
                }
                j++;
            }
            if (j == 0) {
                System.out.println("This system has such Book information!");
            }
        } else {
            System.out.println("This system has no Book information temporarily!");
        }
        display();
    }
}
