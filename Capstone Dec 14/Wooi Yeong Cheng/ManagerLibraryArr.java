package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerLibraryArr {

    static ArrayList<Book> arr = new ArrayList<Book>();

    public static void main(String[] args) {

        arr.add(new Book(100, "Java World", "Action", "Wooi"));

        System.out.println(arr.get(0).bkId);
        System.out.println(arr.get(0).bkName);
        System.out.println(arr.get(0).getBkTitle());
        System.out.println(arr.get(0).getAuthor());

        menu();
    }

    public static void menu() {
        System.out.println("--------------Library Management System-----------");
        System.out.println("1. Query all book information\n2. Query according to book ID\n3. Add New book\n4. Modify book information\n5. Delete book\n6. Exit");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter action 1-6 pls : ");
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
        if (!arr.isEmpty()) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.println("All Book information : \n------------------------------\n" + " Book ID is     : " + arr.get(i).getBkId() + "\n Book Name is   : "
                        + arr.get(i).getBkName() + "\n Book Title is  : " + arr.get(i).getBkTitle() + "\n Book Author is : "
                        + arr.get(i).getAuthor() + "\n------------------------------\n\n");
            }
        } else {
            System.out.println("This system has no book information temporarily!");

        }
        menu();

    }

    public static void findId() {
        int i;
        if (!arr.isEmpty()) {
            int j = 0;
            System.out.print("Please enter book Id : ");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (i = 0; i < arr.size(); i++) {
                if (arr.get(i).getBkId() == id) {
                    j++;
                    System.out.println("The information book ID " + arr.get(i).getBkId() + "  \n---------------------------\n"
                            + " Book Name  : " + arr.get(i).getBkName() + "\n Book Title : " + arr.get(i).getBkTitle() + "\n Author     : "
                            + arr.get(i).getAuthor() + "\n---------------------------\n\n");

                    break;
                }
            }
            if (j == 0) {
                System.out.println("This system temporarily has no such id book information!");
            }
        } else {
            System.out.println("This system has no book information temporarily!");
        }
        menu();

    }

    public static void add() {
        int bkId;
        String bkName;
        String bkTitle;
        String author;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Book ID (integer):");
        bkId = sc.nextInt();
        System.out.println("Please enter the Book Name:");
        bkName = sc.next();
        System.out.println("Please enter the Book Title:");
        bkTitle = sc.next();
        System.out.println("Please enter Book Author:");
        author = sc.next();
        arr.add(new Book(bkId, bkName, bkTitle, author));
        menu();
    }

    public static void change() {
        if (!arr.isEmpty()) {
            int j = 0;
            System.out.println("Please enter Book ID!");
            Scanner sc = new Scanner(System.in);
            int bkId = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getBkId() == bkId) {
                    String bkName;
                    String bkTitle;
                    String author;
                    System.out.println("Please enter the modified Book Name:");
                    bkName = sc.next();
                    System.out.println("Please enter the modified Book Title:");
                    bkTitle = sc.next();
                    System.out.println("Please enter the modified Book Author:");
                    author = sc.next();
                    arr.set(i, new Book(bkId, bkName, bkTitle, author));
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
            System.out.println("Please enter Book ID!");
            Scanner sc = new Scanner(System.in);
            int bkId = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getBkId() == bkId) {
                    int oid = arr.get(i).getBkId();
                    arr.remove(i);
                    System.out.println("Book ID:" + oid + " This book information has been deleted successfully!");
                    menu();
                    break;
                }
                j++;
            }
            if (j == 0) {
                System.out.println("This system has no such id book information!");
            }
        } else {
            System.out.println("This system has no book information temporarily!");
        }
        menu();
    }

}
