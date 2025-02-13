import java.util.ArrayList;
import java.util.Scanner;

// Book class to store book details
class Book {
    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    // Display book details
    public void displayBook() {
        System.out.println("Title: " + title + " | Author: " + author + " | ISBN: " + isbn);
    }
}

// Library class to manage books
class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Add a book
    public void addBook() {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Book ISBN: ");
        String isbn = scanner.nextLine();

        books.add(new Book(title, author, isbn));
        System.out.println("Book added successfully!\n");
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("\nLibrary Books:");
            for (Book book : books) {
                book.displayBook();
            }
        }
    }

    // Search for a book
    public void searchBook() {
        System.out.print("Enter Book Title to Search: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("\nBook Found:");
                book.displayBook();
                return;
            }
        }
        System.out.println("Book not found!\n");
    }

    // Remove a book
    public void removeBook() {
        System.out.print("Enter Book ISBN to Remove: ");
        String isbn = scanner.nextLine();

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                System.out.println("Book removed successfully!\n");
                return;
            }
        }
        System.out.println("Book not found!\n");
    }

    // Menu-driven program
    public void menu() {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addBook();
                case 2 -> displayBooks();
                case 3 -> searchBook();
                case 4 -> removeBook();
                case 5 -> {
                    System.out.println("Exiting Library System. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

// Main class
public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        library.menu();
    }
}
