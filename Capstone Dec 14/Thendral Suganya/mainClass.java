/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;

import java.util.Scanner;


/**
 *
 * @author tthen
 */
import java.util.ArrayList;
public class mainClass {
    static ArrayList<Book> booklist = new ArrayList<Book>();
     public static void main(String[] args){
         
         menu();
     }
      public static void menu() {
         
         System.out.println("***** Book Management System *******");
         System.out.println("1.Query all book information\n2. Query according to Book Number\n3. Add Books\n4. Modify book information\n5. Delete Book\n6. Exit");
         Scanner s1 = new Scanner(System.in);
         switch (s1.nextInt()) {
            case 1:
               getAllbooks();
                break;
            case 2:
                findBookById();
                break;
            case 3:
                addBooks();
                break;
            case 4:
                changeInfo();
                break;
            case 5:
                delete();
                break;

        }
    }
        
     
    public static void addBooks(){
        int bno;
        String stitle;
        int custid;
        String sauthor;
        Scanner s2 = new Scanner(System.in);
        System.out.println("Please enter the Book id (integer):");
        bno = s2.nextInt();
        System.out.println("Please enter the Book Title:");
        stitle = s2.next();
        System.out.println("Please enter the Customer id:Integer:");
        custid = s2.nextInt();
        System.out.println("Please enter Authr name:");
        sauthor = s2.next();
        booklist.add(new Book(bno,stitle,custid,sauthor));
       
        menu();
    }   
     
     public static void getAllbooks(){
         if (!booklist.isEmpty()) {
            for (int i = 0; i < booklist.size(); i++) {
                System.out.println("The Book information for book number:" + booklist.get(i).getbno() + " is: \n------------------ --\n"
                        + "Book Title:" + booklist.get(i).getstitle() + "\n Customer Id :" + booklist.get(i).getcustid() + "\n Author is:"
                        + booklist.get(i).getsauthor() + "\n--------------------\n\n");
            }
        } else {
            System.out.println("This system has no book information temporarily!");

        }
         menu();
    }
     
      public static void changeInfo() {
        if (booklist.size() != 0) {
            int j = 0;
            System.out.println("Please enter Book id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < booklist.size(); i++) {
                if (booklist.get(i).getbno() == id) {
                    int bno;
        String stitle;
        int custid;
        String sauthor;
        Scanner s2 = new Scanner(System.in);
        System.out.println("Please enter the Book id (integer):");
        bno = s2.nextInt();
        System.out.println("Please enter the Book Title:");
        stitle = s2.next();
        System.out.println("Please enter the Customer id:Integer:");
        custid = s2.nextInt();
        System.out.println("Please enter Authr name:");
        sauthor = s2.next();
        booklist.set(i,new Book(bno,stitle,custid,sauthor));
        j++;
        break;
                }
            }
                         
            if (j == 0) {
                System.out.println("This system has no such id  in book information!");
            }
        } else {
            System.out.println("This system has no book information temporarily!");
        }
      menu();
    }
     
      
      public static void delete() {
        if (booklist.size() != 0) {
            int j = 0;
            System.out.println("Please enter Book id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < booklist.size(); i++) {
                if (booklist.get(i).getbno() == id) {
                    int oid = booklist.get(i).getbno();
                    booklist.remove(i);
                    System.out.println("Student ID:" + oid + "The Book information has been deleted successfully!");
                    //menu();
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
     
      public static void findBookById() {
        int i;
        if (booklist.size() != 0) {
            int j = 0;
            System.out.println("Please enter Book id!");
            Scanner s3 = new Scanner(System.in);
            int bno = s3.nextInt();
            for (i = 0; i < booklist.size(); i++) {
                if (booklist.get(i).getbno() == bno) {
                    j++;
                    System.out.println("The Book information for book number:" + booklist.get(i).getbno() + " is: \n------------------ --\n"
                            + "Book Title:" + booklist.get(i).getstitle() + "\n Customer Id is:" + booklist.get(i).getcustid() + "\n Author name is:"
                            + booklist.get(i).getsauthor() + "\n--------------------\n\n");

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

     
}
          
         
        


