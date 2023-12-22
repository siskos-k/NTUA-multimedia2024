import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> books;
    private List<User> users;
    private List<Admin> admins;
    private Map<Book, List<User>> lendings;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.lendings = new HashMap<>();
    }

    // Getters and setters
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public Map<Book, List<User>> getLendings() {
        return lendings;
    }

    public void setLendings(Map<Book, List<User>> lendings) {
        this.lendings = lendings;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void addSampleBooks() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Scribner", 1925, "9780743273565", 5, "Fiction");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1960, "9780061120084", 3, "Classics");
        Book book3 = new Book("1984", "George Orwell", "Secker & Warburg", 1949, "9780451524935", 4, "Dystopian");

        addBook(book1);
        addBook(book2);
        addBook(book3);
    }
    // Additional methods for library actions
}
