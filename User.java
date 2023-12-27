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
        this.borrowings = new ArrayList<>();

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
    private List<Borrowing> borrowings;

    public List<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void borrowBook(Book book) {
        if (book.getNumCopies() > 0) {
            book.setNumCopies(book.getNumCopies() - 1);
            Borrowing borrowing = new Borrowing(this, book);
            borrowings.add(borrowing);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Sorry, no copies available for borrowing.");
        }
    }

    public void viewBorrowedBooks() {
        System.out.println("Borrowed Books:");
        System.out.println("Number of Borrowings: " + borrowings.size()); // Add this line
        for (Borrowing borrowing : borrowings) {
            System.out.println("Book: " + borrowing.getBook().getTitle() +
                    ", Borrowing Date: " + borrowing.getBorrowingDate());
        }
    }
    
}
