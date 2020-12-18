package libapp;

public class Book {

    private int id;
    private String title;
    private String author;
    private int cusId;

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id>0) this.id = id;
        else System.out.println("Invalid Book id.");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(int id, String title, String author) {
        this.setId(id);
        this.title = title;
        this.author = author;

    }
}
