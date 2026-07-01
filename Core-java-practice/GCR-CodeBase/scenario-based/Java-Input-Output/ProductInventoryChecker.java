import java.io.*;
import java.util.*;

class ProductInventoryChecker {
    static final String INVENTORY_FILE = "inventory.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Product Inventory Checker ===\n");

        while (true) {
            System.out.println("1. Create Sample Inventory");
            System.out.println("2. View Inventory");
            System.out.println("3. Check Out-of-Stock Items");
            System.out.println("4. Check Low Stock Items");
            System.out.println("5. Update Product Quantity");
            System.out.println("6. Add New Product");
            System.out.println("7. Exit");
            System.out.print("\nSelect option (1-7): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    createSampleInventory();
                    break;
                case "2":
                    viewInventory();
                    break;
                case "3":
                    checkOutOfStock();
                    break;
                case "4":
                    checkLowStock(scanner);
                    break;
                case "5":
                    updateProductQuantity(scanner);
                    break;
                case "6":
                    addNewProduct(scanner);
                    break;
                case "7":
                    System.out.println("Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }

    static void createSampleInventory() {
        System.out.println("\n--- Creating Sample Inventory ---\n");

        String[] inventory = {
            "Laptop-10",
            "Mouse-0",
            "Keyboard-5",
            "Monitor-2",
            "USB Cable-15",
            "HDMI Cable-0",
            "Webcam-3",
            "Headphones-8",
            "Charger-0",
            "RAM-6"
        };

        try (FileWriter fw = new FileWriter(INVENTORY_FILE);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (String item : inventory) {
                bw.write(item);
                bw.newLine();
            }

            System.out.println("✓ Sample inventory created!");
            System.out.println("✓ File: " + INVENTORY_FILE + "\n");

        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage() + "\n");
        }
    }

    static void viewInventory() {
        System.out.println("\n--- Product Inventory ---\n");

        try (BufferedReader br = new BufferedReader(new FileReader(INVENTORY_FILE))) {

            String line;
            int productCount = 0;
            int totalQuantity = 0;

            System.out.println("Product Name         Quantity");
            System.out.println("-".repeat(40));

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    String productName = parts[0].trim();
                    int quantity = Integer.parseInt(parts[1].trim());

                    System.out.printf("%-20s %d%n", productName, quantity);
                    productCount++;
                    totalQuantity += quantity;
                }
            }

            System.out.println("-".repeat(40));
            System.out.println("Total Products: " + productCount);
            System.out.println("Total Items: " + totalQuantity + "\n");

        } catch (FileNotFoundException e) {
            System.out.println("❌ Inventory file not found.\n");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage() + "\n");
        }
    }

    static void checkOutOfStock() {
        System.out.println("\n--- Out-of-Stock Items ---\n");

        try (BufferedReader br = new BufferedReader(new FileReader(INVENTORY_FILE))) {

            String line;
            List<String> outOfStock = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    String productName = parts[0].trim();
                    int quantity = Integer.parseInt(parts[1].trim());

                    if (quantity == 0) {
                        outOfStock.add(productName);
                    }
                }
            }

            if (outOfStock.isEmpty()) {
                System.out.println("✓ All products are in stock!\n");
            } else {
                System.out.println("⚠️  Out-of-Stock Products:\n");
                for (int i = 0; i < outOfStock.size(); i++) {
                    System.out.println((i + 1) + ". " + outOfStock.get(i) + " is out of stock");
                }
                System.out.println("\nTotal out-of-stock items: " + outOfStock.size() + "\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ Inventory file not found.\n");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage() + "\n");
        }
    }

    static void checkLowStock(Scanner scanner) {
        System.out.println("\n--- Check Low Stock ---\n");

        System.out.print("Enter low stock threshold: ");
        int threshold;
        try {
            threshold = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.\n");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(INVENTORY_FILE))) {

            String line;
            List<String> lowStockItems = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    String productName = parts[0].trim();
                    int quantity = Integer.parseInt(parts[1].trim());

                    if (quantity > 0 && quantity <= threshold) {
                        lowStockItems.add(productName + " (" + quantity + " units)");
                    }
                }
            }

            if (lowStockItems.isEmpty()) {
                System.out.println("✓ No low stock items found.\n");
            } else {
                System.out.println("⚠️  Low Stock Items (≤" + threshold + " units):\n");
                for (int i = 0; i < lowStockItems.size(); i++) {
                    System.out.println((i + 1) + ". " + lowStockItems.get(i));
                }
                System.out.println("\nTotal low stock items: " + lowStockItems.size() + "\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ Inventory file not found.\n");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage() + "\n");
        }
    }

    static void updateProductQuantity(Scanner scanner) {
        System.out.println("\n--- Update Product Quantity ---\n");

        System.out.print("Enter product name: ");
        String productToUpdate = scanner.nextLine().trim();

        System.out.print("Enter new quantity: ");
        int newQuantity;
        try {
            newQuantity = Integer.parseInt(scanner.nextLine().trim());
            if (newQuantity < 0) {
                System.out.println("Quantity cannot be negative.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity.\n");
            return;
        }

        List<String> updatedInventory = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(INVENTORY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 2 && parts[0].trim().equalsIgnoreCase(productToUpdate)) {
                    updatedInventory.add(productToUpdate + "-" + newQuantity);
                    found = true;
                } else {
                    updatedInventory.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage() + "\n");
            return;
        }

        if (!found) {
            System.out.println("❌ Product not found.\n");
            return;
        }

        try (FileWriter fw = new FileWriter(INVENTORY_FILE);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String item : updatedInventory) {
                bw.write(item);
                bw.newLine();
            }
            System.out.println("✓ Product quantity updated successfully!\n");
        } catch (IOException e) {
            System.out.println("Error updating inventory: " + e.getMessage() + "\n");
        }
    }

    static void addNewProduct(Scanner scanner) {
        System.out.println("\n--- Add New Product ---\n");

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine().trim();

        System.out.print("Enter quantity: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine().trim());
            if (quantity < 0) {
                System.out.println("Quantity cannot be negative.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity.\n");
            return;
        }

        try (FileWriter fw = new FileWriter(INVENTORY_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(productName + "-" + quantity);
            bw.newLine();
            System.out.println("✓ Product added successfully!\n");
        } catch (IOException e) {
            System.out.println("Error adding product: " + e.getMessage() + "\n");
        }
    }
}
