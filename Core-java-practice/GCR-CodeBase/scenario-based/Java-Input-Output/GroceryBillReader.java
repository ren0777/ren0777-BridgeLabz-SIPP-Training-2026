import java.io.*;
import java.util.Scanner;

class GroceryBillReader {
    static final String BILL_FILE = "bill.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Grocery Bill Reader ===\n");

        while (true) {
            System.out.println("1. Create Sample Bill");
            System.out.println("2. Read & Display Bill");
            System.out.println("3. View Bill Statistics");
            System.out.println("4. Add Item to Bill");
            System.out.println("5. Exit");
            System.out.print("\nSelect option (1-5): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    createSampleBill();
                    break;
                case "2":
                    readAndDisplayBill();
                    break;
                case "3":
                    viewBillStatistics();
                    break;
                case "4":
                    addItemToBill(scanner);
                    break;
                case "5":
                    System.out.println("Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }

    static void createSampleBill() {
        System.out.println("\n--- Creating Sample Bill ---\n");

        String[] sampleBill = {
            "=== GROCERY STORE BILL ===",
            "Date: " + java.time.LocalDate.now(),
            "",
            "Item                 Quantity    Price",
            "-".repeat(45),
            "Milk                 2 liters    ₹120",
            "Bread                1 pack      ₹50",
            "Eggs                 2 dozen     ₹240",
            "Vegetables           2 kg        ₹150",
            "Rice                 5 kg        ₹350",
            "Flour                2 kg        ₹180",
            "Sugar                1 kg        ₹60",
            "Oil                  1 liter     ₹180",
            "-".repeat(45),
            "Total Amount: ₹1330",
            "Tax (5%): ₹66.50",
            "Final Total: ₹1396.50"
        };

        try (FileWriter fw = new FileWriter(BILL_FILE);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (String line : sampleBill) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("✓ Sample bill created successfully!");
            System.out.println("✓ File: " + BILL_FILE + "\n");

        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage() + "\n");
        }
    }

    static void readAndDisplayBill() {
        System.out.println("\n--- Bill Contents ---\n");

        try (FileReader fileReader = new FileReader(BILL_FILE);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int lineNumber = 1;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                lineNumber++;
            }

            System.out.println("\n✓ Total lines in bill: " + (lineNumber - 1) + "\n");

        } catch (FileNotFoundException e) {
            System.out.println("❌ Bill file not found: " + BILL_FILE);
            System.out.println("Please create a sample bill first.\n");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage() + "\n");
        }
    }

    static void viewBillStatistics() {
        System.out.println("\n--- Bill Statistics ---\n");

        try (FileReader fileReader = new FileReader(BILL_FILE);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int totalLines = 0;
            int emptyLines = 0;
            int itemLines = 0;
            int maxLineLength = 0;

            while ((line = bufferedReader.readLine()) != null) {
                totalLines++;

                if (line.isEmpty()) {
                    emptyLines++;
                } else if (line.contains("₹")) {
                    itemLines++;
                }

                if (line.length() > maxLineLength) {
                    maxLineLength = line.length();
                }
            }

            System.out.println("Total Lines: " + totalLines);
            System.out.println("Empty Lines: " + emptyLines);
            System.out.println("Item/Price Lines: " + itemLines);
            System.out.println("Max Line Length: " + maxLineLength + " characters");
            System.out.println("Non-empty Lines: " + (totalLines - emptyLines) + "\n");

        } catch (FileNotFoundException e) {
            System.out.println("❌ Bill file not found.\n");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage() + "\n");
        }
    }

    static void addItemToBill(Scanner scanner) {
        System.out.println("\n--- Add Item to Bill ---\n");

        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine().trim();

        System.out.print("Enter quantity: ");
        String quantity = scanner.nextLine().trim();

        System.out.print("Enter price (₹): ");
        String price = scanner.nextLine().trim();

        String itemEntry = String.format("%-20s %-12s ₹%s", itemName, quantity, price);

        try (FileWriter fw = new FileWriter(BILL_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(itemEntry);
            bw.newLine();

            System.out.println("\n✓ Item added to bill!\n");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage() + "\n");
        }
    }
}
