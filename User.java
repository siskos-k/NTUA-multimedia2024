import java.util.ArrayList;
import java.util.List;

public class User implements LibraryUser{
    private String username;
    private String password;
    private List<Book> borrowedBooks;
    
    public boolean login(String username, String password) {
        // Implementation for admin login
        return false;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
    public boolean hasViewingPrivileges() {
        // Add your logic here to determine if the admin has the privilege to view books
        // For simplicity, always return true in this example
        return false;
    }
    // Additional methods for user actions
}
