import java.util.Scanner;

class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    private String authorName;
    private String bio;

    public Author(String title, int publicationYear, String authorName, String bio) {
        super(title, publicationYear);
        this.authorName = authorName;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Book Information ===");
        super.displayInfo();
        System.out.println("Author: " + authorName);
        System.out.println("Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Q2: Library Management - Book and Author ===\n");

        Author book1 = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald", 
                                  "American author known for depicting the Jazz Age");
        
        Author book2 = new Author("To Kill a Mockingbird", 1960, "Harper Lee",
                                  "American novelist who won the Pulitzer Prize");
        
        Author book3 = new Author("1984", 1949, "George Orwell",
                                  "British author and political satirist");

        book1.displayInfo();
        System.out.println();

        book2.displayInfo();
        System.out.println();

        book3.displayInfo();
        System.out.println();

        System.out.println("--- Demonstrating Single Inheritance ---");
        System.out.println("Is Author a Book? " + (book1 instanceof Book));

        sc.close();
    }
}
