
package library;

import java.util.Objects;

/**
 *
 * @author blueg
 */
public class Library {
    
    private int bookID;
    private int custID;
    private String bookTitle;
    private String authorName;
    private String yearPublished;

    public Library(int bookID, int custID, String bookTitle, String authorName, String yearPublished) {
        this.bookID = bookID;
        this.custID = custID;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "library{" + "bookID=" + bookID + ", custID=" + custID + ", bookTitle=" + bookTitle + ", authorName=" + authorName + ", yearPublished=" + yearPublished + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Library other = (Library) obj;
        if (this.bookID != other.bookID) {
            return false;
        }
        if (this.custID != other.custID) {
            return false;
        }
        if (!Objects.equals(this.bookTitle, other.bookTitle)) {
            return false;
        }
        if (!Objects.equals(this.authorName, other.authorName)) {
            return false;
        }
        if (!Objects.equals(this.yearPublished, other.yearPublished)) {
            return false;
        }
        return true;
    }
    
    
    
}
