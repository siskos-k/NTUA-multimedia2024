import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding an admin with provided credentials
        Admin medialabAdmin = new Admin("a", "a");
        library.addAdmin(medialabAdmin);

        // Login as either user or admin
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login as:\n1. User\n2. Admin");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // User login logic
                // ...
                break;
            case 2:
                // Admin login logic
                System.out.print("Enter admin username: ");
                String adminUsername = scanner.next();
                System.out.print("Enter admin password: ");
                String adminPassword = scanner.next();

                if (loginAsAdmin(adminUsername, adminPassword, library)) {
                    // Admin logged in successfully
                    // Add your admin-specific logic here
                    System.out.println("Admin logged in successfully!");
                } else {
                    System.out.println("Invalid admin credentials. Exiting...");
                }
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
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
}
