package com.library;

public class Library {

    private int bookId;
    private String bookTitle;
    private int custId;
    private String author;

    public Library(){}

    public Library(int bookId, String bookTitle, int custId, String author) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.custId = custId;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
