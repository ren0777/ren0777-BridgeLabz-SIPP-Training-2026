import java.util.Scanner;

public class WarehouseStockRecovery {

    static int[] acceptStock(Scanner sc) {
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        int[] stock = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter stock for product " + (i + 1) + ": ");
            stock[i] = sc.nextInt();
        }
        return stock;
    }

    static int findMissingPosition(int[] stock) {
        for (int i = 0; i < stock.length; i++) {
            if (stock[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    static int calculateNonZeroAverage(int[] stock) {
        int sum = 0;
        int count = 0;
        for (int s : stock) {
            if (s != 0) {
                sum += s;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }

    static void restoreStock(int[] stock, int position, int average) {
        stock[position] = average;
    }

    static void displayInventory(int[] stock) {
        System.out.println("\n========================================");
        System.out.println("        UPDATED INVENTORY               ");
        System.out.println("========================================");
        System.out.printf("%-12s %-10s%n", "Product No.", "Stock");
        System.out.println("----------------------------------------");
        for (int i = 0; i < stock.length; i++) {
            System.out.printf("%-12d %-10d%n", (i + 1), stock[i]);
        }
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] stock = acceptStock(sc);

        int missingPos = findMissingPosition(stock);

        System.out.println("\n========================================");
        System.out.println("        WAREHOUSE STOCK RECOVERY        ");
        System.out.println("========================================");

        if (missingPos == -1) {
            System.out.println("No missing stock found.");
        } else {
            int average = calculateNonZeroAverage(stock);
            System.out.println("Missing Stock at Product No.: " + (missingPos + 1));
            System.out.println("Replacement Value (Average) : " + average);
            restoreStock(stock, missingPos, average);
            displayInventory(stock);
        }

        sc.close();
    }
}
