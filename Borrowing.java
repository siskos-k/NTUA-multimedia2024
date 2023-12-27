import java.util.Date;

public class Borrowing {
    private User user;
    private Book book;
    private Date borrowingDate;

    public Borrowing(User user, Book book) {
        this.user = user;
        this.book = book;
        this.borrowingDate = new Date(); // Assuming you want to track the borrowing date
    }

    // Getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

 
    
}
