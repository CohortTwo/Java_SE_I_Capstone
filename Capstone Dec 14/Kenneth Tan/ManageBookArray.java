
package Collections;

import java.util.ArrayList;
import java.util.Scanner;


public class ManageBookArray {

    static ArrayList<Book> arr = new ArrayList<Book>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("--------------Book Management System-----------");
        System.out.println("1.Query all books information\n2. Query according to book number\n3. Add book\n4. Modify book information\n5. Delete book\n6. Exit");
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
        if (arr.size() != 0) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.println("Book number:" + arr.get(i).getId() + " is: \n------------------ --\n"
                        + "Title:" + arr.get(i).getTitle() + "\n custID:" + arr.get(i).getCustID() + "\n author:"
                        + arr.get(i).getAuthor() + "\n--------------------\n\n");
            }
        } else {
            System.out.println("This system has no book information at the moment");

        }
        menu();

    }

    public static void findId() {
        int i;
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter book id");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    j++;
                    System.out.println("The student information for book number:" + arr.get(i).getId() + " is: \n------------------ --\n"
                            + "Title:" + arr.get(i).getTitle() + "\n custID is:" + arr.get(i).getCustID() + "\n author is:"
                            + arr.get(i).getAuthor() + "\n--------------------\n\n");

                    break;
                }
            }
            if (j == 0) {
                System.out.println("System has no such id book information");
            }
        } else {
            System.out.println("System has no book information");
        }
        menu();

    }

    public static void add() {
        int id;
        String title;
        int custID;
        String author;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the book id (integer):");
        id = sc.nextInt();
        System.out.println("Please enter the book title:");
        title = sc.next();
        System.out.println("Please enter the custID (integer):");
        custID = sc.nextInt();
        System.out.println("Please enter book author:");
        author = sc.next();
        arr.add(new Book(id, title, custID, author));
        menu();
    }

    public static void change() {
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter book id");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    String title;
                    int custID;
                    String author;
                    System.out.println("Please enter the modified book title:");
                    title = sc.next();
                    System.out.println("Please enter the modified book custID:");
                    custID = sc.nextInt();
                    System.out.println("Please enter the modified book author:");
                    author = sc.next();
                    arr.set(i, new Book(id, title, custID, author));
                    j++;
                    break;
                }
            }
            if (j == 0) {
                System.out.println("System has no such book information");
            }
        } else {
            System.out.println("System has no book information");
        }
        menu();
    }

    public static void delete() {
        if (arr.size() != 0) {
            int j = 0;
            System.out.println("Please enter book id");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getId() == id) {
                    int oid = arr.get(i).getId();
                    arr.remove(i);
                    System.out.println("Book ID:" + oid + "Book information has been deleted successfully!");
                    menu();
                    break;
                }
                j++;
            }
            if (j == 0) {
                System.out.println("System has no such book information");
            }
        } else {
            System.out.println("System has no book information");
        }
        menu();
    }

}
