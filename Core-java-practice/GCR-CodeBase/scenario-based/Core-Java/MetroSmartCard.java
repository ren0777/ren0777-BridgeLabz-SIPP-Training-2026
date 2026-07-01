import java.util.Scanner;

class MetroSmartCard {
    static final double INITIAL_BALANCE = 500.0;
    static final double MIN_BALANCE_WARNING = 50.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double smartCardBalance = INITIAL_BALANCE;
        int journeyCount = 0;

        System.out.println("=== Delhi Metro Smart Card System ===");
        System.out.println("Initial Balance: ₹" + smartCardBalance + "\n");

        while (smartCardBalance > 0) {
            System.out.println("\n--- Journey " + (journeyCount + 1) + " ---");
            System.out.print("Enter distance in km (or -1 to exit): ");

            double distance;
            try {
                distance = Double.parseDouble(scanner.nextLine().trim());

                if (distance == -1) {
                    break;
                }

                if (distance <= 0) {
                    System.out.println("Distance must be positive.");
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid distance.");
                continue;
            }

            double fare = calculateFare(distance);
            System.out.println("Distance: " + distance + " km");
            System.out.println("Fare: ₹" + fare);

            if (smartCardBalance < fare) {
                System.out.println("Insufficient balance!");
                System.out.println("Available Balance: ₹" + smartCardBalance);
                System.out.println("Required Fare: ₹" + fare);
                continue;
            }

            smartCardBalance -= fare;
            journeyCount++;

            System.out.println("Fare Deducted: ₹" + fare);
            System.out.println("Remaining Balance: ₹" + smartCardBalance);

            if (smartCardBalance < MIN_BALANCE_WARNING && smartCardBalance > 0) {
                System.out.println("⚠️  Balance is running low. Please recharge soon!");
            }

            if (smartCardBalance == 0) {
                System.out.println("\n⛔ Your balance is exhausted. Please recharge your card.");
                break;
            }
        }

        printJourneyReport(journeyCount, smartCardBalance);

        scanner.close();
    }

    static double calculateFare(double distance) {
        return (distance <= 2) ? 10.0 :
               (distance <= 5) ? 15.0 :
               (distance <= 10) ? 25.0 :
               (distance <= 15) ? 35.0 :
               (distance <= 20) ? 45.0 :
               50.0;
    }

    static void printJourneyReport(int journeys, double remainingBalance) {
        System.out.println("\n=== Journey Report ===");
        System.out.println("Total Journeys: " + journeys);
        System.out.println("Remaining Balance: ₹" + remainingBalance);

        if (remainingBalance > 0) {
            System.out.println("\n📱 Card Status: Active");
        } else {
            System.out.println("\n📱 Card Status: Balance Exhausted");
            System.out.println("Please recharge to continue using the metro.");
        }

        System.out.println("\nThank you for using Delhi Metro!");
    }
}
