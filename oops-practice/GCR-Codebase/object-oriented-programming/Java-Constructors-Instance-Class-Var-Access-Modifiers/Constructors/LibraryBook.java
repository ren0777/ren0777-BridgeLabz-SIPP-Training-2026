// Program 5: Library Book System – Constructor + Borrow/Return Methods

public class LibraryBook {

    String  title;
    String  author;
    double  price;
    boolean available;

    // Parameterized constructor
    LibraryBook(String title, String author, double price) {
        this.title     = title;
        this.author    = author;
        this.price     = price;
        this.available = true;   // books start as available
    }

    // Borrow a book
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("\"" + title + "\" has been borrowed successfully.");
        } else {
            System.out.println("Sorry, \"" + title + "\" is currently not available.");
        }
    }

    // Return a book
    void returnBook() {
        available = true;
        System.out.println("\"" + title + "\" has been returned. Thank you!");
    }

    void display() {
        System.out.println("Title: " + title
                         + " | Author: " + author
                         + " | Price: Rs." + price
                         + " | Available: " + (available ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        LibraryBook lb = new LibraryBook("Clean Code", "Robert C. Martin", 450.0);

        lb.display();
        lb.borrowBook();          // success
        lb.borrowBook();          // already borrowed
        lb.returnBook();
        lb.borrowBook();          // available again after return
        lb.display();
    }
}
