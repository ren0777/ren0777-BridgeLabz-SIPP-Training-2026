// Sample Program 2: Library Management System
// Concepts: static, this, final, instanceof

public class Book {

    // 1. STATIC – libraryName shared across all Book objects
    static String libraryName = "City Central Library";
    static int    totalBooks  = 0;

    // 3. FINAL – isbn is a permanent unique identifier, cannot be changed
    final String isbn;

    String title;
    String author;
    boolean isAvailable;

    // 2. THIS – resolves ambiguity for title, author, isbn
    Book(String isbn, String title, String author) {
        this.isbn        = isbn;          // 'this' used for all three fields
        this.title       = title;
        this.author      = author;
        this.isAvailable = true;
        totalBooks++;
    }

    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("\"" + title + "\" has been borrowed.");
        } else {
            System.out.println("\"" + title + "\" is not available right now.");
        }
    }

    void returnBook() {
        isAvailable = true;
        System.out.println("\"" + title + "\" has been returned.");
    }

    void display() {
        System.out.println("Library  : " + libraryName);
        System.out.println("ISBN     : " + isbn);
        System.out.println("Title    : " + title);
        System.out.println("Author   : " + author);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    // 1. STATIC METHOD
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
        System.out.println("Total Books : " + totalBooks);
    }

    public static void main(String[] args) {

        Book book1 = new Book("978-0-13-468599-1", "Effective Java",   "Joshua Bloch");
        Book book2 = new Book("978-0-59-651798-1", "Head First Java",  "Kathy Sierra");
        Object  obj   = 42;   // an Integer, not a Book

        // 4. INSTANCEOF – check before displaying details
        System.out.println("=== Book 1 ===");
        if (book1 instanceof Book) {
            book1.display();
        }

        System.out.println("\n=== Book 2 – Borrow & Return ===");
        if (book2 instanceof Book) {
            book2.display();
            book2.borrowBook();
            book2.borrowBook();   // already borrowed
            book2.returnBook();
        }

        System.out.println("\n=== instanceof check on Integer object ===");
        if (!(obj instanceof Book)) {
            System.out.println("Object is NOT a Book instance. Skipping display.");
        }

        System.out.println();
        Book.displayLibraryName();   // static method call

        // Prove final – uncommenting causes compile error:
        // book1.isbn = "000-0-00-000000-0";  // ERROR: cannot assign to final variable
    }
}
