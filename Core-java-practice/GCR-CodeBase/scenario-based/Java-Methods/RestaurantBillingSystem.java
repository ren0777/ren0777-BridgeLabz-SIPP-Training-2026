import java.util.Scanner;

public class RestaurantBillingSystem {

    static double calculateFoodCost(String[] items, double[] prices, int[] quantities, int count) {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i] * quantities[i];
        }
        return total;
    }

    static double calculateGST(double foodCost) {
        return foodCost * 0.05;
    }

    static double calculateDiscount(double foodCost) {
        if (foodCost > 1000) {
            return foodCost * 0.10;
        } else if (foodCost > 500) {
            return foodCost * 0.05;
        } else {
            return 0;
        }
    }

    static double generateFinalBill(String customerName, String[] items, double[] prices, int[] quantities, int count) {
        double foodCost = calculateFoodCost(items, prices, quantities, count);
        double gst = calculateGST(foodCost);
        double discount = calculateDiscount(foodCost);
        double finalAmount = foodCost + gst - discount;

        System.out.println("\n========================================");
        System.out.println("         RESTAURANT BILL                ");
        System.out.println("========================================");
        System.out.println("Customer Name : " + customerName);
        System.out.println("----------------------------------------");
        System.out.printf("%-15s %-8s %-8s %-10s%n", "Item", "Price", "Qty", "Subtotal");
        System.out.println("----------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-15s %-8.2f %-8d %-10.2f%n", items[i], prices[i], quantities[i], prices[i] * quantities[i]);
        }
        System.out.println("----------------------------------------");
        System.out.printf("Food Cost     : Rs. %.2f%n", foodCost);
        System.out.printf("GST (5%%)      : Rs. %.2f%n", gst);
        System.out.printf("Discount      : Rs. %.2f%n", discount);
        System.out.println("----------------------------------------");
        System.out.printf("Total Payable : Rs. %.2f%n", finalAmount);
        System.out.println("========================================");

        return finalAmount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name : ");
        String customerName = sc.next();

        System.out.print("Enter Number of Items Ordered: ");
        int count = sc.nextInt();

        String[] items = new String[count];
        double[] prices = new double[count];
        int[] quantities = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter Item Name     : ");
            items[i] = sc.next();
            System.out.print("Enter Item Price    : ");
            prices[i] = sc.nextDouble();
            System.out.print("Enter Quantity      : ");
            quantities[i] = sc.nextInt();
        }

        generateFinalBill(customerName, items, prices, quantities, count);

        sc.close();
    }
}
