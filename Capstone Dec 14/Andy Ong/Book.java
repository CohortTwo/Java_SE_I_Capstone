/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author andy
 */
public class Book {
	int bookID;
	String bookTitle;
	int borrowerID;
	String Author;

	public Book(int bookID, String bookTitle, int borrowerID, String Author) {
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.borrowerID = borrowerID;
		this.Author = Author;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setCustID(int borrowID) {
		this.borrowerID = borrowID;
	}

	public void setAuthor(String Author) {
		this.Author = Author;
	}

	public int getBookID() {
		return bookID;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public int getBorrowerID() {
		return borrowerID;
	}

	public String getAuthor() {
		return Author;
	}
}
