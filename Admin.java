public class Admin implements LibraryUser{
    private String username;
    private String password;

    public boolean login(String username, String password) {
        // Implementation for admin login
        return false;
    }
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
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
    public boolean hasViewingPrivileges() {
        // Add your logic here to determine if the admin has the privilege to view books
        // For simplicity, always return true in this example
        return true;
    }
    // Additional methods for admin actions
}
