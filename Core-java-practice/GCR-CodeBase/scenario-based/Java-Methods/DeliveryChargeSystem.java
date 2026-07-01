import java.util.Scanner;

public class DeliveryChargeSystem {

    static double calculateCharge(int distance) {
        double baseCharge = 50.0;
        double perKmRate = 5.0;
        return baseCharge + (distance * perKmRate);
    }

    static double calculateCharge(int distance, int weight) {
        double baseCharge = 50.0;
        double perKmRate = 5.0;
        double weightCharge = weight * 10.0;
        return baseCharge + (distance * perKmRate) + weightCharge;
    }

    static double calculateCharge(int distance, int weight, boolean expressDelivery) {
        double baseCharge = 50.0;
        double perKmRate = 5.0;
        double weightCharge = weight * 10.0;
        double expressCharge = expressDelivery ? 100.0 : 0.0;
        return baseCharge + (distance * perKmRate) + weightCharge + expressCharge;
    }

    static void displayCharge(String type, double charge) {
        System.out.println("\n========================================");
        System.out.println("       DELIVERY CHARGE DETAILS         ");
        System.out.println("========================================");
        System.out.println("Delivery Type   : " + type);
        System.out.printf("Total Charge    : Rs. %.2f%n", charge);
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nSelect Delivery Option:");
        System.out.println("1. Distance Only");
        System.out.println("2. Distance + Weight");
        System.out.println("3. Distance + Weight + Express");
        System.out.print("Enter Choice (1/2/3): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Distance (km): ");
                int d1 = sc.nextInt();
                double charge1 = calculateCharge(d1);
                displayCharge("Standard (Distance Only)", charge1);
                break;

            case 2:
                System.out.print("Enter Distance (km): ");
                int d2 = sc.nextInt();
                System.out.print("Enter Weight (kg)  : ");
                int w2 = sc.nextInt();
                double charge2 = calculateCharge(d2, w2);
                displayCharge("Standard (Distance + Weight)", charge2);
                break;

            case 3:
                System.out.print("Enter Distance (km)       : ");
                int d3 = sc.nextInt();
                System.out.print("Enter Weight (kg)         : ");
                int w3 = sc.nextInt();
                System.out.print("Express Delivery? (true/false): ");
                boolean express = sc.nextBoolean();
                double charge3 = calculateCharge(d3, w3, express);
                String type = express ? "Express (Distance + Weight + Express)" : "Standard (Distance + Weight)";
                displayCharge(type, charge3);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
