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
 * @author chiangyong
 */
public class BookManage {
    
    static ArrayList<BookLibrary> arrBL = new ArrayList<BookLibrary>();
    BookLibrary bookLib = new BookLibrary();
    Scanner inp = new Scanner(System.in);
    int authorid, bookid, customerid;
    String authorname, booktitle;
    boolean idFlag = false;
    
    void AddBook(){
        
        System.out.print("Enter the Author ID: "); 
        authorid = inp.nextInt();
        inp.nextLine();
        System.out.print("Enter the Author Name: "); 
        authorname = inp.nextLine();
      //  System.out.print("Enter the book type: "); 
      //  String booktype = inp.next();
        
        System.out.print("Enter the book title: "); 
        booktitle = inp.nextLine();
        System.out.print("Enter the customer ID: "); 
        customerid = inp.nextInt();
        System.out.print("Enter the book ID: "); 
        bookid = inp.nextInt();
        
        arrBL.add(new BookLibrary(authorid,authorname,booktitle,customerid,bookid));
        
        
       // System.out.print(arrBL.size());
        
    }
    
    void UpdateBook(){
       
        if(arrBL.size()!=0){
                  
            System.out.print("Enter the author ID: ");
            authorid = inp.nextInt();
            inp.nextLine();
            for(int i = 0; i < arrBL.size(); i++){
                if(arrBL.get(i).getAuthorID()==authorid){
                   System.out.print("Enter the author name: ");
                   authorname = inp.nextLine();
                   System.out.print("Enter the book title: ");
                   booktitle = inp.nextLine();
                   System.out.print("Enter customer ID: ");
                   customerid = inp.nextInt();
                   System.out.print("Enter book ID: ");
                   bookid = inp.nextInt();
                    arrBL.set(i,new BookLibrary(authorid,authorname,booktitle,customerid,bookid));
                   idFlag = true;
                    break;
                }
            }
            if(idFlag != false){
                System.out.println("No such author ID");
            }
            else
            {
                idFlag = false;
            }
        }
        
        
    }
    
    void DeleteBook(){
        
        if(arrBL.size() != 0){
            System.out.print("Enter the author ID: ");
            authorid = inp.nextInt();
            for(int i=0; i < arrBL.size(); i++){
                if(arrBL.get(i).getAuthorID()== authorid){
                    arrBL.remove(i);
                    System.out.println("Author ID: "+ authorid +" is removed");
                    idFlag = true;
                    break;
                }
            }
            if(idFlag == false){
                System.out.println("No Such Author ID");
            }
            else
            {
                idFlag = false;
            }    
        }
    }
    
    void QueryBook(){
        if(arrBL.size()!= 0){
            System.out.print("Enter the author ID: ");
            authorid = inp.nextInt();
            for(int i=0; i < arrBL.size(); i++){
                if(arrBL.get(i).getAuthorID()== authorid){
                    System.out.println(arrBL.get(i));
                    idFlag = true;
                    break;
                }
                
            if(idFlag == false){
                System.out.println("No Such Author ID");
            }
            else
            {
                idFlag = false;
            }        
            
        }
           
    }
}}
