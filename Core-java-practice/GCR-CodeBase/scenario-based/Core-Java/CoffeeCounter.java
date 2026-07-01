import java.util.Scanner;

class CoffeeCounter {
    static final double ESPRESSO_PRICE = 50.0;
    static final double CAPPUCCINO_PRICE = 80.0;
    static final double LATTE_PRICE = 90.0;
    static final double AMERICANO_PRICE = 60.0;
    static final double GST_RATE = 0.18;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalBill = 0.0;

        while (true) {
            System.out.println("\n=== Ravi's Coffee Shop ===");
            System.out.println("1. Espresso (₹50)");
            System.out.println("2. Cappuccino (₹80)");
            System.out.println("3. Latte (₹90)");
            System.out.println("4. Americano (₹60)");
            System.out.println("Type 'exit' to end\n");

            System.out.print("Enter coffee type (1-4) or 'exit': ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            int coffeeType;
            try {
                coffeeType = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1-4 or 'exit'.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity;
            try {
                quantity = Integer.parseInt(scanner.nextLine().trim());
                if (quantity <= 0) {
                    System.out.println("Quantity must be positive.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a number.");
                continue;
            }

            double price = getPriceByType(coffeeType);
            if (price == -1) {
                System.out.println("Invalid coffee type. Please select 1-4.");
                continue;
            }

            double itemTotal = price * quantity;
            double gst = itemTotal * GST_RATE;
            double itemBillWithGST = itemTotal + gst;

            System.out.println("Item Total: ₹" + itemTotal);
            System.out.println("GST (18%): ₹" + gst);
            System.out.println("Bill with GST: ₹" + itemBillWithGST);

            totalBill += itemBillWithGST;
            System.out.println("Running Total: ₹" + totalBill);
        }

        System.out.println("\n=== Final Receipt ===");
        System.out.println("Total Bill: ₹" + totalBill);
        System.out.println("Thank you for visiting!");
        scanner.close();
    }

    static double getPriceByType(int type) {
        switch (type) {
            case 1:
                return ESPRESSO_PRICE;
            case 2:
                return CAPPUCCINO_PRICE;
            case 3:
                return LATTE_PRICE;
            case 4:
                return AMERICANO_PRICE;
            default:
                return -1;
        }
    }
}
