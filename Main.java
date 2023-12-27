import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addSampleBooks();
        // Adding an admin with provided credentials
        Admin medialabAdmin = new Admin("a", "a");
        library.addAdmin(medialabAdmin);
        library.addRandomUsers(5);
        //adding a user
        User medialabUser = new User("u", "u");
        library.addUser(medialabUser);
        library.addSpecificBorrowings();

        // Login as either user or admin
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login as:\n1. User\n2. Admin");
        int choice = scanner.nextInt();
        boolean isUser= true;
        switch (choice) {
            case 1:
                System.out.print("Enter user username: ");
                String Username = scanner.next();
                System.out.print("Enter user password: ");
                String Password = scanner.next();

                if (loginAsUser(Username, Password, library)) {
                    isUser = true;
                    System.out.println("User logged in successfully!");
                    User cur = new User(Username, Password);
                    performUserActions(cur, library, scanner);

                } else {
                    System.out.println("Invalid user credentials. Exiting...");
                    isUser = true;
                    
                }
                    
                break;

            case 2:
                // Admin login logic
                System.out.print("Enter admin username: ");
                String adminUsername = scanner.next();
                System.out.print("Enter admin password: ");
                String adminPassword = scanner.next();

                if (loginAsAdmin(adminUsername, adminPassword, library)) {
                    // Admin logged in successfully
                    System.out.println("Admin logged in successfully!");
                     isUser= false;
                } else {
                    System.out.println("Invalid admin credentials. Exiting...");
                }
                
                break;
                
            default:
                System.out.println("Invalid choice. Exiting...");
        }
        String allBooksInfo = library.getAllBooksInfo(medialabAdmin);
        if(!isUser) {System.out.println(allBooksInfo); }
        else System.out.println("not authorised to perform this action");


        //maybe remove the code above?
        // Inside the main method or a dedicated admin action method
// Inside the main method or a dedicated admin action method
if (isUser) {
    // Perform user actions
} else {
    // Admin actions
    boolean adminActionsLoop = true;

    while (adminActionsLoop) {
         System.out.println("");

        System.out.println("Admin actions:");
         System.out.println("--------------");
        System.out.println("1. View all books");
           System.out.println("--------------");
        System.out.println("2. Add a book");
        System.out.println("3. Edit a book");
         System.out.println("4. Delete a book");
          System.out.println("--------------");
           System.out.println("5. View all categories");
        // System.out.println("6. Add a category");
        System.out.println("6. Edit a category");
         System.out.println("7. Delete a category");
          System.out.println("--------------");
            System.out.println("8. View all borrowings");
          System.out.println("--------------");
        System.out.println("9. Exit admin actions");

        int adminChoice = scanner.nextInt();

        switch (adminChoice) {
            case 1:
                // View all books (assuming the admin has viewing privileges)
                System.out.println(library.getAllBooksInfo(medialabAdmin));
                break;

            case 2:
                // Prompt the admin to enter book details
                System.out.print("Enter title: ");
                String newTitle = scanner.next();
                System.out.print("Enter author: ");
                String newAuthor = scanner.next();
                System.out.print("Enter publisher: ");
                String newPublisher = scanner.next();
                System.out.print("Enter release year: ");
                int newReleaseYear = scanner.nextInt();
                System.out.print("Enter ISBN: ");
                String newISBN = scanner.next();
                System.out.print("Enter number of copies: ");
                int newNumCopies = scanner.nextInt();
                System.out.print("Enter category: ");
                String newCategory = scanner.next();

                // Call the method to add a book
                library.addBookByAdmin(medialabAdmin, newTitle, newAuthor, newPublisher, newReleaseYear, newISBN, newNumCopies, newCategory);
                System.out.println("Book added successfully!");
                break;

            
            case 3:
                // Prompt the admin to enter the ISBN of the book to edit
                System.out.print("Enter the ISBN of the book to edit: ");
                String bookISBNToEdit = scanner.next();

                // Prompt the admin to enter the new details for the book
                System.out.print("Enter new title: ");
                String newTitleE = scanner.next();
                System.out.print("Enter new author: ");
                String newAuthorE = scanner.next();
                System.out.print("Enter new publisher: ");
                String newPublisherE = scanner.next();
                System.out.print("Enter new release year: ");
                int newReleaseYearE = scanner.nextInt();
                System.out.print("Enter new number of copies: ");
                int newNumCopiesE = scanner.nextInt();
                System.out.print("Enter new category: ");
                String newCategoryE = scanner.next();

                // Call the method to edit a book
                library.editBookByAdmin(medialabAdmin, bookISBNToEdit, newTitleE, newAuthorE, newPublisherE, newReleaseYearE, newNumCopiesE, newCategoryE);
                break;
            case 4: 
                // Prompt the admin to enter the ISBN of the book to be deleted
                System.out.print("Enter the ISBN of the book to delete: ");
                String bookISBNToDelete = scanner.next();
                library.deleteBookByAdmin(medialabAdmin, bookISBNToDelete);
                break;
            // case 6:
            // System.out.print("Enter the new category to add: ");
            // String newCategoryToAdd = scanner.next();
            // library.addCategory(newCategoryToAdd);
            // break;
            case 5:
        // Print all categories
        library.printAllCategories();
        break;
            case 6:
                // Prompt the admin to enter the old category (can be null) and the new category
                System.out.print("Enter the old category (leave blank to add a new category): ");
                String oldCategory = scanner.next();
                System.out.print("Enter the new category: ");
                String updatedCategory = scanner.next();

                // Call the method to add or update a category
                library.UpdateCategory(oldCategory.isEmpty() ? null : oldCategory, updatedCategory);
                break;

            case 7:
    // Prompt the admin to enter the category to remove
    System.out.print("Enter the category to remove: ");
    String categoryToRemove = scanner.next();

    // Call the method to remove a category and associated books
    library.removeCategoryAndBooks(categoryToRemove);
    break;
            case 8: 
            library.viewAllBorrowings();
            break;
            case 9:
                // Exit admin actions
                System.out.println("Exiting a userActionsLoop = false;dmin actions.");
                adminActionsLoop = false;
                break;

            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }
}


    }

    private static void performUserActions(User user, Library library, Scanner scanner) {
        boolean userActionsLoop = true;

        while (userActionsLoop) {
            System.out.println("\nUser actions:");
            System.out.println("--------------");
            System.out.println("1. Borrow a book");
            System.out.println("2. View borrowed books");
            System.out.println("3. Exit user actions");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    // Borrow a book
                    System.out.print("Enter the ISBN of the book to borrow: ");
                    String bookISBNToBorrow = scanner.next();
                    Book bookToBorrow = findBookByISBN(bookISBNToBorrow, library);

                    if (bookToBorrow != null) {
                        library.borrowBook(user, bookToBorrow);
                    } else {
                        System.out.println("Book with ISBN " + bookISBNToBorrow + " not found.");
                    }
                    break;

                case 2:
                    // View borrowed books
                    // User cur = new User(Username, Password);
                    library.viewBorrowedBooks(user.getUsername());
                    break;

                case 3:
                    // Exit user actions
                    System.out.println("Exiting user actions.");
                    userActionsLoop = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    // Admin login method
    private static boolean loginAsAdmin(String username, String password, Library library) {
        for (Admin admin : library.getAdmins()) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true; // Admin found, login successful
            }
        }
        return false; // Admin not found, login failed
    }

    // User login method
    private static boolean loginAsUser(String username, String password, Library library) {
        for (User user : library.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // User found, login successful
            }
        }
        return false; // User not found, login failed
    }

    // Helper method to find a book by ISBN
    private static Book findBookByISBN(String ISBN, Library library) {
        for (Book book : library.getBooks()) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }
}