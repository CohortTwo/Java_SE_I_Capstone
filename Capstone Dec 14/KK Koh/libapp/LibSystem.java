package libapp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibSystem {

    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        int select;
        do {
            System.out.println("-------------- Book Library System-----------");
            System.out.print("1. Show all books information"
                    + "\n2. Show book information by book id"
                    + "\n3. Add book to Library System"
                    + "\n4. Update book information"
                    + "\n5. Delete book by book id"
                    + "\n6. Loan book by book id"
                    + "\n7. Return book by book id"
                    + "\n9. Exit Book Library System"
                    + "\n\nSelection ? ");
            try {
                Scanner sc = new Scanner(System.in);
                select = sc.nextInt();
            } catch (InputMismatchException e) {
                select = 999;
            }
            switch (select) {
                case 1:
                    showAllBooks();
                    break;
                case 2:
                    showBookById();
                    break;
                case 3:
                    addBook();
                    break;
                case 4:
                    updateBookInfo();
                    break;
                case 5:
                    deleteBook();
                    break;
                case 6:
                    loanBook();
                    break;
                case 7:
                    returnBook();
                    break;
                case 9:
                    System.out.println("Exit Book Library System......");
                    break;
                default:
                    System.out.println("Invalid Input!\n\n");
            }
        } while (select != 9);
    }

    static void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("RESULT : =========== No Book in the Library System! ==============\n\n");
        } else {
            System.out.println("RESULT :");
            books.forEach(book -> {
                System.out.print("Book{id=" + book.getId() + ", Title=" + book.getTitle()
                        + ", Author=" + book.getAuthor());
                if (book.getCusId() == 0) {
                    System.out.println(", Available for loan}");
                } else {
                    System.out.println(", Customer id=" + book.getCusId() + "}");
                }
            });
            System.out.println("\n\n");
        }
    }

    static void showBookById() {
        if (books.isEmpty()) {
            System.out.println("RESULT : ============== No Book in the Library System! ============\n\n");
        } else {
            boolean bIdFound = false;
            System.out.print("Book id ? ");
            try {
                Scanner sc = new Scanner(System.in);
                int id = sc.nextInt();

                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getId() == id) {
                        bIdFound = true;
                        System.out.print("RESULT :\tBook{id=" + books.get(i).getId()
                                + ", Title=" + books.get(i).getTitle() + ", Author="
                                + books.get(i).getAuthor());
                        if (books.get(1).getCusId() == 0) {
                            System.out.println(", Available for loan}\n\n");
                        } else {
                            System.out.println(", Customer id=" + books.get(i).getCusId() + "}\n\n");
                        }
                        break;
                    }
                }
                if (!bIdFound) {
                    System.out.println("RESULT : ============== No Such Book id ============\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("RESULT : ============== No Such Book id ============\n\n");
            }
        }
    }

    static void addBook() {
        boolean bIdFound = false;
        System.out.print("Book id ? ");
        Scanner sc = new Scanner(System.in);
        try {
            int id = sc.nextInt();
            sc.nextLine();

            if (id > 0) {
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getId() == id) {
                        bIdFound = true;
                        System.out.println("RESULT :\tBook id=" + id + " already in use!\n\n");
                        break;
                    }
                }

                if (!bIdFound) {
                    System.out.print("Book Title ? ");
                    String title = sc.nextLine();
                    System.out.print("Author ? ");
                    String author = sc.nextLine();

                    Book newBook = new Book(id, title, author);
                    books.add(newBook);
                    System.out.println("RESULT :\tBook Added{id=" + id + ", Title=" + title + ", Author=" + author + "}\n\n");
                }
            } else {
                System.out.println("RESULT : =============== Invalid Book id ==============\n\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("RESULT : =============== Invalid Book id ==============\n\n");
        }
    }

    static void updateBookInfo() {
        if (books.isEmpty()) {
            System.out.println("RESULT : ============== No Book in the Library System! ============\n\n");
        } else {
            boolean bIdFound = false;
            System.out.print("Book id ? ");
            Scanner sc = new Scanner(System.in);
            try {
                int id = sc.nextInt();
                sc.nextLine();

                if (id > 0) {
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).getId() == id) {
                            System.out.print("new Book Title ? ");
                            String title = sc.nextLine();
                            System.out.print("new Book Author ? ");
                            String author = sc.nextLine();
                            System.out.print("new Customer id ? ");
                            int cusId = sc.nextInt();
                            sc.nextLine();
                            if (cusId > 0) {
                                books.get(i).setTitle(title);
                                books.get(i).setAuthor(author);
                                books.get(i).setCusId(cusId);
                                bIdFound = true;
                                System.out.print("RESULT :\tBook updated{id=" + id + ", Title=" + title + ", Author=" + author);
                                if (cusId == 0) {
                                    System.out.println(", Available for loan}\n\n");
                                } else {
                                    System.out.println(", Customer id=" + cusId + "}\n\n");
                                }

                            } else {
                                System.out.println("RESULT : ========== Invalid Customer id ==============\n\n");
                            }

                            break;
                        }
                    }
                    if (!bIdFound) {
                        System.out.println("RESULT : ============== No Such Book id ============\n\n");
                    }
                } else {
                    System.out.println("RESULT : =============== Invalid Book id ==============\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("RESULT : =============== Invalid Book id ==============\n\n");
            }

        }

    }

    static void deleteBook() {
        if (books.isEmpty()) {
            System.out.println("RESULT : ============== No Book in the Library System! ============\n\n");
        } else {
            boolean bIdFound = false;
            System.out.print("Book id to be removed ? ");
            try {
                Scanner sc = new Scanner(System.in);
                int id = sc.nextInt();

                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getId() == id) {
                        bIdFound = true;
                        if (books.get(i).getCusId() == 0) {
                            System.out.println("RESULT :\tBook removed{id=" + books.get(i).getId() + ", Title=" + books.get(i).getTitle() + ", Author=" + books.get(i).getAuthor() + "}\n\n");
                            books.remove(i);
                        } else {
                            System.out.println("RESULT : ========= Book on loan - Not able to delete ==========\n\n");
                        }

                        break;
                    }
                }
                if (!bIdFound) {
                    System.out.println("RESULT : ============== No Such Book id ============\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("RESULT : =============== Invalid Book id ==============\n\n");
            }
        }
    }

    static void loanBook() {
        if (books.isEmpty()) {
            System.out.println("RESULT : ============== No Book in the Library System! ============\n\n");
        } else {
            boolean bIdFound = false;
            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("Book id ? ");
                int bid = sc.nextInt();

                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getId() == bid) {
                        bIdFound = true;
                        if (books.get(i).getCusId() != 0) {
                            System.out.println("RESULT : ========= Book on loan ===========\n\n");
                        } else {
                            System.out.print("Customer id ? ");
                            int cid = sc.nextInt();
                            if (cid > 0) {
                                books.get(i).setCusId(cid);
                                System.out.println("RESULT :\tBook loan{id=" + books.get(i).getId() + ", Title=" + books.get(i).getTitle() + ", Author=" + books.get(i).getAuthor() + ", Customer id=" + books.get(i).getCusId() + "}\n\n");
                            } else {
                                System.out.println("RESULT : ============ Invalid customer id ===========\n\n");
                            }
                        }
                        break;
                    }
                }
                if (!bIdFound) {
                    System.out.println("RESULT : ========== No Such Book id ===================\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("RESULT : =============== Invalid Book id ==============\n\n");
            }

        }
    }

    static void returnBook() {
        if (books.isEmpty()) {
            System.out.println("RESULT : ============== No Book in the Library System! ============\n\n");
        } else {
            boolean bIdFound = false;
            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("Book id ? ");
                int bid = sc.nextInt();

                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getId() == bid) {
                        bIdFound = true;
                        if (books.get(i).getCusId() == 0) {
                            System.out.println("RESULT : ========= Book is already in the Library! ===========");
                        } else {
                            books.get(i).setCusId(0);
                            System.out.println("RESULT :\tBook returned{id=" + books.get(i).getId() + ", Title=" + books.get(i).getTitle() + ", Author=" + books.get(i).getAuthor() + ", Available for loan}\n\n");
                        }
                        break;
                    }
                }
                if (!bIdFound) {
                    System.out.println("RESULT : ========== No Such Book id ===================\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("RESULT : =============== Invalid Book id ==============\n\n");
            }
        }

    }
}
