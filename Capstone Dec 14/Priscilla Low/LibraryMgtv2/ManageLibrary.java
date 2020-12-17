package library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author blueg
 */
public class ManageLibrary {

    static ArrayList<Library> arrlib = new ArrayList<Library>();

    public static void main(String[] args) {
        options();

    }

    public static void options() {
        System.out.println("======This is a Library Management System======");
        System.out.println("Choose one of the following options by typing the number indicated next to it:");
        System.out.println("1. Query all the records in the system");
        System.out.println("2. Search for record by Book ID");
        System.out.println("3. Search for record by Customer ID");
        System.out.println("4. Add a record");
        System.out.println("5. Update record by Book ID");
        System.out.println("6. Update record by Customer ID");
        System.out.println("7. Delete record by Book ID");
        System.out.println("8. Delete record by Customer ID");
        System.out.println("9. Exit System");

        System.out.println("Enter your chosen option below (1-9):");
        try {
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()) {
                case 1:
                    queryall();
                    break;
                case 2:
                    findBookId();
                    break;
                case 3:
                    findCustId();
                    break;
                case 4:
                    addRecord();
                    break;
                case 5:
                    updateRecordbyBookID();
                    break;
                case 6:
                    updateRecordbyCustID();
                    break;
                case 7:
                    deletebyBookID();
                    break;
                case 8:
                    deletebyCustID();
                    break;
                case 9:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Please only enter digits 1 to 9.");
                    options();
                    break;
            }
        } catch (InputMismatchException inputmme) {
            System.out.println("Please only enter digits 1 to 9.");
            options();
        }

    }

    public static void queryall() {
            if (arrlib.isEmpty()) {
                System.out.println("There are currently no records in the management system.");
            } else {
                for (int i = 0; i < arrlib.size(); i++) {
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++ ");
                    System.out.println("Book ID: " + arrlib.get(i).getBookID());
                    System.out.println("Customer ID: " + arrlib.get(i).getCustID());
                    System.out.println("Book Title: " + arrlib.get(i).getBookTitle());
                    System.out.println("Author Name: " + arrlib.get(i).getAuthorName());
                    System.out.println("Year Published: " + arrlib.get(i).getYearPublished());
                }
            }
            options();

    }

    public static void findBookId() {
        try {
            if (arrlib.isEmpty()) {
                System.out.println("There are currently no books in the management system.");
            } else {
                int j = 0;
                System.out.println("Please enter the Book ID");
                Scanner sc = new Scanner(System.in);
                int bookID = sc.nextInt();
                for (int i = 0; i < arrlib.size(); i++) {
                    if (arrlib.get(i).getBookID() == bookID) {
                        j++;
                        System.out.println("Book ID: " + arrlib.get(i).getBookID());
                        System.out.println("Customer ID: " + arrlib.get(i).getCustID());
                        System.out.println("Book Title: " + arrlib.get(i).getBookTitle());
                        System.out.println("Author Name: " + arrlib.get(i).getAuthorName());
                        System.out.println("Year Published: " + arrlib.get(i).getYearPublished());
                        break;
                    }
                }
                if (j == 0) {
                    System.out.println("This system currently has no such book id information.");
                }
            }
            options();
        } catch (InputMismatchException inputmme) {
            System.out.println("Please only enter digits only.");
            options();
        }
        

    }

    public static void findCustId() {
        try {
            if (arrlib.isEmpty()) {
                System.out.println("There are currently no customers in the management system.");
            } else {
                int j = 0;
                System.out.println("Please enter the Customer ID");
                Scanner sc = new Scanner(System.in);
                int custID = sc.nextInt();
                for (int i = 0; i < arrlib.size(); i++) {
                    if (arrlib.get(i).getCustID() == custID) {
                        j++;
                        System.out.println("Book ID: " + arrlib.get(i).getBookID());
                        System.out.println("Customer ID: " + arrlib.get(i).getCustID());
                        System.out.println("Book Title: " + arrlib.get(i).getBookTitle());
                        System.out.println("Author Name: " + arrlib.get(i).getAuthorName());
                        System.out.println("Year Published: " + arrlib.get(i).getYearPublished());
                        break;

                    }
                }
                if (j == 0) {
                    System.out.println("This system currently has no such customer id information.");
                }
            }
            options();
        } catch (InputMismatchException inputmme) {
            System.out.println("Please only enter digits only.");
            options();
        }
        

    }

    public static void addRecord() {
        int bookID;
        int custID;
        String bookTitle;
        String authorName;
        String yearPublished;

        Scanner sc = new Scanner(System.in);
        try{
        System.out.println("Enter the Book ID: ");
        bookID = sc.nextInt();
        System.out.println("Enter the Customer ID: ");
        custID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Book Title: ");
        bookTitle = sc.nextLine();
        System.out.println("Enter the Author Name: ");
        authorName = sc.nextLine();
        System.out.println("Enter the year of publication: ");
        yearPublished = sc.nextLine();
        arrlib.add(new Library(bookID, custID, bookTitle, authorName, yearPublished));
        options();
        }catch(InputMismatchException inputmme){
            System.out.println("Please only enter digits only.");
            options();
        }
        

    }

    public static void updateRecordbyBookID() {
        try {
            if (arrlib.isEmpty()) {
                System.out.println("There are currently no books in the management system.");
            } else {
                int j = 0;
                System.out.println("Please enter the Book ID");
                Scanner sc = new Scanner(System.in);
                int bookID = sc.nextInt();
                for (int i = 0; i < arrlib.size(); i++) {
                    if (arrlib.get(i).getBookID() == bookID) {
                        int custID;
                        String bookTitle;
                        String authorName;
                        String yearPublished;

                        System.out.println("Enter the Customer ID: ");
                        custID = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the Book Title: ");
                        bookTitle = sc.nextLine();
                        System.out.println("Enter the Author Name: ");
                        authorName = sc.nextLine();
                        System.out.println("Enter the year of publication: ");
                        yearPublished = sc.nextLine();
                        arrlib.set(i, new Library(bookID, custID, bookTitle, authorName, yearPublished));
                        j++;
                        break;

                    }
                }
                if (j == 0) {
                    System.out.println("This system currently has no such book id information.");
                }
            }
            options();
        } catch (InputMismatchException inputmme) {
            System.out.println("Please only enter digits only.");
            options();
        }
        

    }

    public static void updateRecordbyCustID() {
        try {
            if (arrlib.isEmpty()) {
                System.out.println("There are currently no customers in the management system.");
            } else {
                int j = 0;
                System.out.println("Please enter the Customer ID");
                Scanner sc = new Scanner(System.in);
                int custID = sc.nextInt();
                for (int i = 0; i < arrlib.size(); i++) {
                    if (arrlib.get(i).getCustID() == custID) {
                        int bookID;
                        String bookTitle;
                        String authorName;
                        String yearPublished;

                        System.out.println("Enter the Book ID: ");
                        bookID = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the Book Title: ");
                        bookTitle = sc.nextLine();
                        System.out.println("Enter the Author Name: ");
                        authorName = sc.nextLine();
                        System.out.println("Enter the year of publication: ");
                        yearPublished = sc.nextLine();
                        arrlib.set(i, new Library(bookID, custID, bookTitle, authorName, yearPublished));
                        j++;
                        break;

                    }
                }
                if (j == 0) {
                    System.out.println("This system currently has no such customer id information.");
                }
            }
            options();
        } catch (InputMismatchException inputmme) {
            System.out.println("Please only enter digits only.");
            options();
        }
        

    }

    public static void deletebyBookID() {
        try {
            if (arrlib.isEmpty()) {
                System.out.println("There are currently no books in the management system.");
            } else {
                int j = 0;
                System.out.println("Enter Book ID:");
                Scanner sc = new Scanner(System.in);
                int bookID = sc.nextInt();
                for (int i = 0; i < arrlib.size(); i++) {
                    if (arrlib.get(i).getBookID() == bookID) {
                        int oldBookID = arrlib.get(i).getBookID();
                        arrlib.remove(i);
                        System.out.println("Book ID " + oldBookID + " has been deleted successfully from the system.");
                        j++;
                        break;
                    }

                }
                if (j == 0) {
                    System.out.println("This system has no such book id information!");
                }
            }
            options();
        } catch (InputMismatchException inputmme) {
            System.out.println("Please only enter digits only.");
            options();
        }
        
    }

    public static void deletebyCustID() {
        try {
            if (arrlib.isEmpty()) {
                System.out.println("There are currently no customers in the management system.");
            } else {
                int j = 0;
                System.out.println("Enter Customer ID:");
                Scanner sc = new Scanner(System.in);
                int custID = sc.nextInt();
                for (int i = 0; i < arrlib.size(); i++) {
                    if (arrlib.get(i).getCustID() == custID) {
                        int oldCustID = arrlib.get(i).getCustID();
                        arrlib.remove(i);
                        System.out.println("Customer ID " + oldCustID + " has been deleted successfully from the system.");
                        j++;
                        break;
                    }

                }
                if (j == 0) {
                    System.out.println("This system has no such customer id information!");
                }
            }
            options();
        } catch (InputMismatchException inputmme) {
            System.out.println("Please only enter digits only.");
            options();
        }
        
    }

}
