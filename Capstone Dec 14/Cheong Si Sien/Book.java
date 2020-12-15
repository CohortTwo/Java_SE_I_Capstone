package library;

import java.util.Objects;

public class Book {

    private int id;
    private String title;
    private int borrowerid;
    private String author;

    public Book(int id, String title, int borrowerid, String author) {
        this.id = id;
        this.title = title;
        this.borrowerid = borrowerid;
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

    public int getborrowerid() {
        return borrowerid;
    }

    public void setborrowerid(int borrowerid) {
        this.borrowerid = borrowerid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", borrower=" + borrower + ", author=" + author + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.borrowerid != other.borrowerid) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return true;
    }

}
