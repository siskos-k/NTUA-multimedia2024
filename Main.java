import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addSampleBooks();
        // Adding an admin with provided credentials
        Admin medialabAdmin = new Admin("a", "a");
        library.addAdmin(medialabAdmin);
        library.addRandomUsers(5);
        // adding a user
        User medialabUser = new User("u", "u");
        library.addUser(medialabUser);
        library.addSpecificBorrowings();

        Scanner scanner = new Scanner(System.in);

        boolean appRunning = true;

        while (appRunning) {
            // Login as either user or admin
            System.out.println("Login as:\n1. User\n2. Admin\n3. Create new account\n4. Exit");
            int choice = scanner.nextInt();

            boolean isUser = true;

            switch (choice) {
                case 1:
                    // User login logic
                    System.out.print("Enter user username: ");
                    String username = scanner.next();
                    System.out.print("Enter user password: ");
                    String password = scanner.next();

                    if (loginAsUser(username, password, library)) {
                        isUser = true;
                        System.out.println("User logged in successfully!");
                        User cur = new User(username, password);
                        performUserActions(cur, library, scanner);

                    } else {
                        System.out.println("Invalid user credentials. Try again.");
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
                        isUser = false;
                        performAdminActions(medialabAdmin, library, scanner);
                    } else {
                        System.out.println("Invalid admin credentials. Try again.");
                    }
                    break;

                case 3:
                    // Option to create a new user
                    System.out.print("Enter new user username: ");
                    String newUserUsername = scanner.next();
                    System.out.print("Enter new user password: ");
                    String newUserPassword = scanner.next();
                    User newUser = new User(newUserUsername, newUserPassword);
                    library.addUser(newUser);
                    System.out.println("New user created successfully!");
                    if (loginAsUser(newUserUsername, newUserPassword, library)) {
                        isUser = true;
                        System.out.println("User logged in successfully!");
                        User newCurr = new User(newUserUsername, newUserPassword);
                        performUserActions(newCurr, library, scanner);
                    } else {
                        System.out.println("Error logging in the new user. Exiting...");
                        isUser = true;
                    }
                    break;

                case 4:
                    // Exit the application
                    System.out.println("Exiting the application.");
                    appRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
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

    // Admin login method
    private static boolean loginAsAdmin(String username, String password, Library library) {
        for (Admin admin : library.getAdmins()) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true; // Admin found, login successful
            }
        }
        return false; // Admin not found, login failed
    }

    private static void performAdminActions(Admin admin, Library library, Scanner scanner) {
        // Admin actions loop
        boolean adminActionsLoop = true;

        while (adminActionsLoop) {
            System.out.println("Admin actions:");
            System.out.println("--------------");
            System.out.println("1. View all books");
            System.out.println("2. Add a book");
            System.out.println("3. Edit a book");
            System.out.println("4. Delete a book");
            System.out.println("5. View all categories");
            System.out.println("6. Edit a category");
            System.out.println("7. Delete a category");
            System.out.println("8. View all borrowings");
            System.out.println("9. Exit admin actions");

            int adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    // View all books (assuming the admin has viewing privileges)
                    System.out.println(library.getAllBooksInfo(admin));
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
                    library.addBookByAdmin(admin, newTitle, newAuthor, newPublisher, newReleaseYear, newISBN, newNumCopies, newCategory);
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
                    library.editBookByAdmin(admin, bookISBNToEdit, newTitleE, newAuthorE, newPublisherE, newReleaseYearE, newNumCopiesE, newCategoryE);
                    break;

                case 4:
                    // Prompt the admin to enter the ISBN of the book to be deleted
                    System.out.print("Enter the ISBN of the book to delete: ");
                    String bookISBNToDelete = scanner.next();
                    library.deleteBookByAdmin(admin, bookISBNToDelete);
                    break;

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
                    // View all borrowings
                    library.viewAllBorrowings();
                    break;

                case 9:
                    // Exit admin actions
                    System.out.println("Exiting admin actions.");
                    adminActionsLoop = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void performUserActions(User user, Library library, Scanner scanner) {
        // User actions loop
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
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Book with ISBN " + bookISBNToBorrow + " not found.");
                    }
                    break;

                case 2:
                    // View borrowed books
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

