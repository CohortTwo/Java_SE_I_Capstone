/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LaiYing
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Book> arr = new ArrayList<Book>();
    public static void main(String[] args) {
                menu();
    }

    public static void menu() {
        // TODO code application logic here
        System.out.println("*********************  Library System  *********************");
        System.out.println("1. Query all book information\n2. Query by book number\n3. Add book\n4. Modify book information\n5. Delete book\n6. Borrow book\n7. Exit");
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
                borrow();
                break;
        }
        
    }
    
    public static void findAll() {

        if (!arr.isEmpty()) {
            System.out.println("----------------------------------------------------------------------------------------");
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getCustId() > 0) {
                    System.out.println("Book ID:" + arr.get(i).getId()
                            + " title: " + arr.get(i).getTitle() + " author:" + arr.get(i).getAuthor() + " borrowed by customer id :"
                            + arr.get(i).getCustId());
                } else {
                    System.out.println("Book ID:" + arr.get(i).getId()
                            + " title: " + arr.get(i).getTitle() + " author:" + arr.get(i).getAuthor() + " Available");
                }
            }
        } else {
            System.out.println("This system has no book!");

        }
        menu();

    }

    public static void findId() {
        int i;
        if (!arr.isEmpty()) {
            int j = 0;
            System.out.println("Please enter book id!");
            Scanner sc = new Scanner(System.in);
            int id = Integer.valueOf(sc.nextLine());
            for (i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    j++;
                    if (arr.get(i).getCustId() > 0) {
                        System.out.println("Book ID:" + arr.get(i).getId()
                                + " title: " + arr.get(i).getTitle() + " author:" + arr.get(i).getAuthor() + " borrowed by customer id :"
                                + arr.get(i).getCustId());
                    } else {
                        System.out.println("Book ID:" + arr.get(i).getId()
                                + " title: " + arr.get(i).getTitle() + " author:" + arr.get(i).getAuthor() + " Available");
                    }
                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system has no such book!");
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the book id (integer):");
        id = Integer.valueOf(sc.nextLine());
        
        System.out.println("Please enter the title:");
        title = sc.nextLine();
        
        System.out.println("Please enter author");
        author = sc.nextLine();
        arr.add(new Book(id, title, author));
        menu();
    }

    public static void change() {
        if (!arr.isEmpty()) {
            int j = 0;
            System.out.println("Please enter book id!");
            Scanner sc = new Scanner(System.in);
            int id = Integer.valueOf(sc.nextLine());
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    if (arr.get(i).getCustId() > 0) {
                        System.out.println("This book has been borrowed out by " + arr.get(i).getCustId());
                    }
                    String title;
                    int custid = arr.get(i).getCustId();
                    String author;
                    System.out.println("Please enter the title:");
                    title = sc.nextLine();
                    System.out.println("Please enter the author:");
                    author = sc.nextLine();

                    arr.set(i, new Book(id, title, custid, author));
                    j++;
                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system has no such id book information!");
            }
        } else {
            System.out.println("This system has no book information temporarily!");
        }
        menu();
    }

    public static void delete() {
        if (!arr.isEmpty()) {
            int j = 0;
            System.out.println("Please enter book id!");
            Scanner sc = new Scanner(System.in);
            int id = Integer.valueOf(sc.nextLine());
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    int oid = arr.get(i).getId();
                    int custid = arr.get(i).getCustId();
                    if (custid > 0) {
                        System.out.println("Book ID:" + oid + " has been borrowed out so cannot delete!");
                    } else {
                        arr.remove(i);
                        System.out.println("Book ID:" + oid + "The book information has been deleted successfully!");
                    }
                    menu();
                    break;
                }
                j++;
            }
            if (j == 0) {
                System.out.println("This system has no such id information!");
            }
        } else {
            System.out.println("This system has no book information temporarily!");
        }
        menu();
    }

    public static void borrow() {
        int i;
        if (!arr.isEmpty()) {
            int j = 0;
            System.out.println("Please enter book id!");
            Scanner sc = new Scanner(System.in);
            int id = Integer.valueOf(sc.nextLine());

            for (i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    j++;
                    if (arr.get(i).getCustId() == 0) {
                        System.out.println("Please enter cust id!");
                        int custid = Integer.valueOf(sc.nextLine());
                        String author = arr.get(i).getAuthor();
                        String title = arr.get(i).getTitle();

                        arr.set(i, new Book(id, title, custid, author));
                        System.out.println("Book ID:" + arr.get(i).getId()
                                + " title: " + arr.get(i).getTitle() + " author:" + arr.get(i).getAuthor() + " borrowed by customer id :"
                                + arr.get(i).getCustId());
                    } else {
                        System.out.println("This book has been borrowed out by " + arr.get(i).getCustId());
                    }
                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system has no such book!");
            }
        } else {
            System.out.println("This system has no book information temporarily!");
        }
        menu();

    }
}
