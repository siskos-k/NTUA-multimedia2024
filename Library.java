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

    public void addBookByAdmin(Admin admin, String title, String author, String publisher, int releaseYear, String ISBN, int numCopies, String category) {
        Book newBook = new Book(title, author, publisher, releaseYear, ISBN, numCopies, category);
        addBook(newBook); // Utilize the existing addBook method
        System.out.println("Book added successfully!");
    }
    public void deleteBookByAdmin(Admin admin, String ISBN) {
            Book bookToDelete = null;
            for (Book book : books) {
                if (book.getISBN().equals(ISBN)) {
                    bookToDelete = book;
                    break;
                }
            }
            if (bookToDelete != null) {
                books.remove(bookToDelete);
                System.out.println("Book with ISBN " + ISBN + " deleted successfully.");
            } else {
                System.out.println("Book with ISBN " + ISBN + " not found.");
            }
    }
    
    
    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addSampleBooks() {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Scribner", 1925, "1", 5, "Fiction");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1960, "2", 3, "Classics");
        Book book3 = new Book("1984", "George Orwell", "Secker & Warburg", 1949, "3", 4, "Dystopian");

        addBook(book1);
        addBook(book2);
        addBook(book3);
    }
    public String getAllBooksInfo(LibraryUser user) {
        //maybe check if libr is ad or not lol
        StringBuilder result = new StringBuilder();
        result.append("List of Books:\n");

        if(user.hasViewingPrivileges()){
            // System.out.println(user.hasViewingPrivileges());
        for (Book book : books) {
            result.append("Title: ").append(book.getTitle()).append("\n");
            result.append("Author: ").append(book.getAuthor()).append("\n");
            result.append("Publisher: ").append(book.getPublisher()).append("\n");
            result.append("Release Year: ").append(book.getReleaseYear()).append("\n");
            result.append("ISBN: ").append(book.getISBN()).append("\n");
            result.append("Number of Copies: ").append(book.getNumCopies()).append("\n");
            result.append("Rating: ").append(book.getRating()).append("\n");
            result.append("Category: ").append(book.getCategory()).append("\n");
            result.append("Comments: ").append(book.getComments()).append("\n\n");
        }
        return result.toString();
    }


    else {
    System.out.println("not authorised");
    return("no");
}
    }
    
    }
    // Additional methods for library actions
