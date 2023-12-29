import java.io.*;
import java.util.List;

public class LibrarySerializer {
    private static final String FILE_NAME = "medialab/books.ser";

    public static void saveBooks(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
            System.out.println("Books saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving books: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Book> loadBooks() {
        List<Book> books = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (List<Book>) ois.readObject();
            System.out.println("Books loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading books: " + e.getMessage());
        }
        return books;
    }
}
