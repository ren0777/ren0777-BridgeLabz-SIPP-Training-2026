import java.util.Scanner;

public class ElectricityBillCalculator {

    static int acceptUnits(Scanner sc) {
        System.out.print("Enter Units Consumed: ");
        return sc.nextInt();
    }

    static double calculateBill(int units) {
        double amount = 0;
        if (units <= 100) {
            amount = units * 3.50;
        } else if (units <= 200) {
            amount = (100 * 3.50) + ((units - 100) * 5.00);
        } else if (units <= 500) {
            amount = (100 * 3.50) + (100 * 5.00) + ((units - 200) * 6.50);
        } else {
            amount = (100 * 3.50) + (100 * 5.00) + (300 * 6.50) + ((units - 500) * 8.00);
        }
        return amount;
    }

    static void displayBill(String name, String customerID, int units, double billAmount) {
        double surcharge = billAmount * 0.05;
        double totalAmount = billAmount + surcharge;

        System.out.println("\n========================================");
        System.out.println("         ELECTRICITY BILL DETAILS       ");
        System.out.println("========================================");
        System.out.println("Customer Name   : " + name);
        System.out.println("Customer ID     : " + customerID);
        System.out.println("Units Consumed  : " + units + " kWh");
        System.out.println("----------------------------------------");
        System.out.printf("Base Bill Amount: Rs. %.2f%n", billAmount);
        System.out.printf("Surcharge (5%%) : Rs. %.2f%n", surcharge);
        System.out.println("----------------------------------------");
        System.out.printf("Total Payable   : Rs. %.2f%n", totalAmount);
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name : ");
        String name = sc.next();

        System.out.print("Enter Customer ID   : ");
        String customerID = sc.next();

        int units = acceptUnits(sc);
        double billAmount = calculateBill(units);
        displayBill(name, customerID, units, billAmount);

        sc.close();
    }
}
