
package Collections;


public class Book {
    
    private int id;
    private String title;
    private int custID;
    private String author;
 
 
    public Book() {
 
    }
 
    public Book(int id, String title, int custID, String author) {
        this.id = id;
        this.title = title;
        this.custID = custID;
        this.author = author;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public int getCustID() {
        return custID;
    }
 
    public void setCustID(int custID) {
        this.custID = custID;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
}


