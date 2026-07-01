// Program 1: Book class – Default & Parameterized Constructors

public class Book {

    String title;
    String author;
    double price;

    // Default constructor
    Book() {
        title  = "Unknown Title";
        author = "Unknown Author";
        price  = 0.0;
    }

    // Parameterized constructor
    Book(String title, String author, double price) {
        this.title  = title;
        this.author = author;
        this.price  = price;
    }

    void display() {
        System.out.println("Title : " + title
                         + " | Author: " + author
                         + " | Price: Rs." + price);
    }

    public static void main(String[] args) {
        Book defaultBook = new Book();
        Book myBook      = new Book("The Alchemist", "Paulo Coelho", 299.0);

        System.out.println("-- Default Constructor --");
        defaultBook.display();

        System.out.println("-- Parameterized Constructor --");
        myBook.display();
    }
}
