/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

/**
 *
 * @author jony
 */
public class LibBook {
    
    
    private int bookId;
    private String bTitle;
    private String bAuthor;
    private int custId;
    

    public LibBook(int bookId, String bTitle, String bAuthor, int custId) {
        this.bookId = bookId;
        this.bTitle = bTitle;
        this.bAuthor = bAuthor;
        this.custId = custId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }
    

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }
    
    
    
    
}
