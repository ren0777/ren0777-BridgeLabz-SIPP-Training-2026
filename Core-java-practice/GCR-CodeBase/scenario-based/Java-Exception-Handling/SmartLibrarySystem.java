import java.util.Scanner;

class SmartLibrarySystem {
    static String[] books = {"Java", "Python", null, "C++", "JavaScript", null, "Go", "Rust"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Smart Library System ===\n");

        displayBooks();

        while (true) {
            System.out.println("1. Get Book Length");
            System.out.println("2. View Book Details");
            System.out.println("3. View All Books");
            System.out.println("4. Check Book Status");
            System.out.println("5. Exit");
            System.out.print("\nSelect option (1-5): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    getBookLengthMenu(scanner);
                    break;
                case "2":
                    viewBookDetails(scanner);
                    break;
                case "3":
                    displayBooks();
                    break;
                case "4":
                    checkBookStatus(scanner);
                    break;
                case "5":
                    System.out.println("Thank you for using Smart Library System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }

    static void displayBooks() {
        System.out.println("\n--- Library Books ---");
        System.out.println("Index | Book Name");
        System.out.println("-".repeat(30));

        for (int i = 0; i < books.length; i++) {
            String bookName = (books[i] == null) ? "[EMPTY SLOT]" : books[i];
            System.out.printf("  %d   | %s%n", i, bookName);
        }

        System.out.println();
    }

    static int getBookLength(int index) {
        try {
            if (index < 0 || index >= books.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid book index: " + index + ". Valid range: 0-" + (books.length - 1));
            }

            if (books[index] == null) {
                throw new NullPointerException("Book entry at index " + index + " is null/empty!");
            }

            return books[index].length();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Index Error: " + e.getMessage());
            return -1;

        } catch (NullPointerException e) {
            System.out.println("❌ Null Error: " + e.getMessage());
            return -1;

        } catch (Exception e) {
            System.out.println("❌ Unexpected Error: " + e.getMessage());
            return -1;
        }
    }

    static void getBookLengthMenu(Scanner scanner) {
        System.out.println("\n--- Get Book Length ---\n");

        try {
            System.out.print("Enter book index (0-" + (books.length - 1) + "): ");
            int index = Integer.parseInt(scanner.nextLine().trim());

            int length = getBookLength(index);

            if (length != -1) {
                System.out.println("✓ Book name: " + books[index]);
                System.out.println("✓ Length: " + length + " characters\n");
            } else {
                System.out.println();
            }

        } catch (NumberFormatException e) {
            System.out.println("❌ Input Error: Invalid number format!\n");
        }
    }

    static void viewBookDetails(Scanner scanner) {
        System.out.println("\n--- View Book Details ---\n");

        try {
            System.out.print("Enter book index (0-" + (books.length - 1) + "): ");
            int index = Integer.parseInt(scanner.nextLine().trim());

            if (index < 0 || index >= books.length) {
                System.out.println("❌ Invalid Index: " + index + ". Valid range: 0-" + (books.length - 1) + "\n");
                return;
            }

            if (books[index] == null) {
                System.out.println("❌ Null Book Entry: No book at index " + index + "!\n");
                return;
            }

            System.out.println("--- Book Details ---");
            System.out.println("Index: " + index);
            System.out.println("Book Name: " + books[index]);
            System.out.println("Length: " + books[index].length() + " characters");
            System.out.println("Status: ✓ Available\n");

        } catch (NumberFormatException e) {
            System.out.println("❌ Input Error: Invalid number format!\n");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage() + "\n");
        }
    }

    static void checkBookStatus(Scanner scanner) {
        System.out.println("\n--- Check Book Status ---\n");

        try {
            System.out.print("Enter book index (0-" + (books.length - 1) + "): ");
            int index = Integer.parseInt(scanner.nextLine().trim());

            if (index < 0 || index >= books.length) {
                System.out.println("❌ Invalid Index Error: Index " + index + " is out of range!");
                System.out.println("   Valid range: 0-" + (books.length - 1) + "\n");
                return;
            }

            System.out.println("--- Status Report ---");
            System.out.println("Index: " + index);

            if (books[index] == null) {
                System.out.println("Status: ⚠️  EMPTY SLOT");
                System.out.println("Details: No book currently stored at this index");
                System.out.println("Action: Slot is available for new book\n");
            } else {
                System.out.println("Book Name: " + books[index]);
                System.out.println("Status: ✓ AVAILABLE");
                System.out.println("Length: " + books[index].length() + " characters");
                System.out.println("Action: Book is ready for checkout\n");
            }

        } catch (NumberFormatException e) {
            System.out.println("❌ Input Error: Please enter a valid number!\n");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage() + "\n");
        }
    }
}
