import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addSampleBooks();
        // Adding an admin with provided credentials
        Admin medialabAdmin = new Admin("a", "a");
        library.addAdmin(medialabAdmin);
        //adding a user
        User medialabUser = new User("u", "u");
        library.addUser(medialabUser);
        
        // Login as either user or admin
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login as:\n1. User\n2. Admin");
        int choice = scanner.nextInt();
        boolean isUser= false;
        switch (choice) {
            case 1:
                System.out.print("Enter user username: ");
                String Username = scanner.next();
                System.out.print("Enter user password: ");
                String Password = scanner.next();

                if (loginAsUser(Username, Password, library)) {
                    isUser = true;
                    System.out.println("User logged in successfully!");
                } else {
                    System.out.println("Invalid user credentials. Exiting...");
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
        System.out.println("Admin actions:");
        System.out.println("1. View all books");
        System.out.println("2. Add a book");
        System.out.println("3. Delete a book");
        System.out.println("4. Exit admin actions");

        int adminChoice = scanner.nextInt();

        switch (adminChoice) {
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

            case 1:
                // View all books (assuming the admin has viewing privileges)
                System.out.println(library.getAllBooksInfo(medialabAdmin));
                break;

            case 3: 
             // Prompt the admin to enter the ISBN of the book to be deleted
             System.out.print("Enter the ISBN of the book to delete: ");
             String bookISBNToDelete = scanner.next();
             library.deleteBookByAdmin(medialabAdmin, bookISBNToDelete);
             break;
            case 4:
                // Exit admin actions
                System.out.println("Exiting admin actions.");
                adminActionsLoop = false;
                break;

            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
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
      private static boolean loginAsUser(String username, String password, Library library) {
        for (User user : library.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Admin found, login successful
            }
        }
        return false; // Admin not found, login failed
        
    }
}