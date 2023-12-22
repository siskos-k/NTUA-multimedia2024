import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {
    private List<Book> books;
    private List<User> users;
    private List<Admin> admins;
    private Map<Book, List<User>> lendings;
    private Set<String> uniqueCategories;


    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.lendings = new HashMap<>();
        this.uniqueCategories = new HashSet<>();
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

    //ADDING REMOVING AND EDITING BOOKS
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
    public void editBookByAdmin(Admin admin, String ISBN, String newTitle, String newAuthor, String newPublisher, int newReleaseYear, int newNumCopies, String newCategory) {
        Book bookToEdit = null;
    
        // Find the book with the given ISBN
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                bookToEdit = book;
                break;
            }
        }
    
        // Edit the book if found
        if (bookToEdit != null) {
            // Update the book details
            bookToEdit.setTitle(newTitle);
            bookToEdit.setAuthor(newAuthor);
            bookToEdit.setPublisher(newPublisher);
            bookToEdit.setReleaseYear(newReleaseYear);
            bookToEdit.setNumCopies(newNumCopies);
            bookToEdit.setCategory(newCategory);
    
            System.out.println("Book with ISBN " + ISBN + " edited successfully.");
        } else {
            System.out.println("Book with ISBN " + ISBN + " not found.");
        }
    }
    

    //ADDING REMOVING AND EDITING CATEGORIES
    public void addCategory(String newCategory) {
        // Add the new category for all books
        for (Book book : books) {
            book.setCategory(newCategory);
            uniqueCategories.add(newCategory);
        }
        System.out.println("Category added successfully.");
    }

    public void removeCategoryAndBooks(String categoryToRemove) {
        // Remove all books in the specified category
        books.removeIf(book -> {
            if (book.getCategory().equals(categoryToRemove)) {
                uniqueCategories.remove(categoryToRemove);
                return true;
            }
            return false;
        });
        System.out.println("Category and associated books removed successfully.");
    }

    private Set<String> getAllUniqueCategories() {
        Set<String> categories = new HashSet<>();
        for (Book book : books) {
            categories.add(book.getCategory());
        }
        return categories;
    }

public void printAllCategories() {
    System.out.println("List of all categories:");
    for (String category : getAllUniqueCategories()) {
        System.out.println(category);
    }
}
    public void UpdateCategory(String oldCategory, String newCategory) {
        // Add or update the category for all books
        for (Book book : books) {
            if (oldCategory == null || book.getCategory().equals(oldCategory)) {
                book.setCategory(newCategory);
            }
        }
        System.out.println("Category updated successfully.");
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
