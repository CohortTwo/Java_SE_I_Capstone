
package collection;


public class Book {
    
    int bkId;
    String bkName;
    String bkTitle;
    String author;

    public int getBkId() {
        return bkId;
    }

    public void setBkId(int bkId) {
        this.bkId = bkId;
    }

    public String getBkName() {
        return bkName;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    public String getBkTitle() {
        return bkTitle;
    }

    public void setBkTitle(String bkTitle) {
        this.bkTitle = bkTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(int bkId, String bkName, String bkTitle, String author) {
        this.bkId = bkId;
        this.bkName = bkName;
        this.bkTitle = bkTitle;
        this.author = author;
    }
    
    
}
