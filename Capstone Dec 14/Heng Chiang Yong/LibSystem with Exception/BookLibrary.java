/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author chiangyong
 */
public class BookLibrary {
    private int authorID;
    private String authorName;
   // private String bookType;
    private String bookTitle;
    private int customerID;
    private int bookID;

    public BookLibrary(int authorID, String authorName, String bookTitle, int customerID, int bookID) {
        this.authorID = authorID;
        this.authorName = authorName;
       // this.bookType = bookType;
        this.bookTitle = bookTitle;
        this.customerID = customerID;
        this.bookID = bookID;
    }

    public BookLibrary() {
    }

    @Override
    public String toString() {
        return "BookLibrary{" + "authorID=" + authorID + ", authorName=" + authorName + ", bookTitle=" + bookTitle + ", customerID=" + customerID + ", bookID=" + bookID + '}';
    }

    
    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

//    public String getBookType() {
//        return bookType;
//    }
//
//    public void setBookType(String bookType) {
//        this.bookType = bookType;
//    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
    
    
    
    
    
}
