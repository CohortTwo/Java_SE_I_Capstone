/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dapp;

/**
 *
 * @author amutha
 */
public class LibraryCust {
    private int BookId;
    private String BookName;
    private String Author;
    private int CustId;

    public LibraryCust(int BookId, String BookName, String Author, int CustId) {
        this.BookId = BookId;
        this.BookName = BookName;
        this.Author = Author;
        this.CustId = CustId;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int BookId) {
        this.BookId = BookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public int getCustId() {
        return CustId;
    }

    public void setCustId(int CustId) {
        this.CustId = CustId;
    }
    
    
}
