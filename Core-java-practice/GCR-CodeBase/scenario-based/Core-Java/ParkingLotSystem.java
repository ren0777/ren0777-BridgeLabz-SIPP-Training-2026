import java.util.Scanner;

class ParkingLotSystem {
    static final int TOTAL_SPOTS = 50;
    static final double HOURLY_RATE = 50.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int occupiedSpots = 0;
        int vehiclesParked = 0;
        double totalRevenue = 0.0;

        System.out.println("=== Smart Parking Lot Gate System ===");
        System.out.println("Total Parking Spots: " + TOTAL_SPOTS);
        System.out.println("Hourly Rate: ₹" + HOURLY_RATE + "\n");

        while (true) {
            displayMenu();
            System.out.print("Select option (1-4): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    occupiedSpots = handleParking(occupiedSpots, vehiclesParked, scanner);
                    if (occupiedSpots > vehiclesParked) {
                        vehiclesParked = occupiedSpots;
                    }
                    break;

                case "2":
                    int[] exitData = handleExit(occupiedSpots, scanner);
                    occupiedSpots = exitData[0];
                    totalRevenue += exitData[1];
                    break;

                case "3":
                    showOccupancy(occupiedSpots);
                    break;

                case "4":
                    printFinalReport(vehiclesParked, totalRevenue);
                    System.out.println("Thank you for using Smart Parking! Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please select 1-4.\n");
            }
        }
    }

    static void displayMenu() {
        System.out.println("\n--- Parking Lot Options ---");
        System.out.println("1. Park Vehicle");
        System.out.println("2. Exit Parking");
        System.out.println("3. Show Occupancy");
        System.out.println("4. Close Gate & Exit");
    }

    static int handleParking(int occupied, int parked, Scanner scanner) {
        if (occupied >= TOTAL_SPOTS) {
            System.out.println("❌ Parking lot is full! No spots available.\n");
            return occupied;
        }

        System.out.print("Enter vehicle registration number: ");
        String regNumber = scanner.nextLine().trim();

        System.out.print("Enter vehicle type (Car/Bike/Truck): ");
        String vehicleType = scanner.nextLine().trim();

        occupied++;
        System.out.println("✓ Vehicle parked successfully!");
        System.out.println("Registration: " + regNumber);
        System.out.println("Spot Occupied: " + occupied + "/" + TOTAL_SPOTS);
        System.out.println("Available Spots: " + (TOTAL_SPOTS - occupied) + "\n");

        return occupied;
    }

    static int[] handleExit(int occupied, Scanner scanner) {
        if (occupied == 0) {
            System.out.println("❌ No vehicles in parking lot.\n");
            return new int[]{occupied, 0};
        }

        System.out.print("Enter vehicle registration number: ");
        String regNumber = scanner.nextLine().trim();

        System.out.print("Enter duration (in hours): ");
        int hours;
        try {
            hours = Integer.parseInt(scanner.nextLine().trim());
            if (hours <= 0) {
                System.out.println("Duration must be positive.\n");
                return new int[]{occupied, 0};
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.\n");
            return new int[]{occupied, 0};
        }

        double parkingFee = calculateParkingFee(hours);
        occupied--;

        System.out.println("✓ Vehicle exited successfully!");
        System.out.println("Registration: " + regNumber);
        System.out.println("Duration: " + hours + " hour(s)");
        System.out.println("Parking Fee: ₹" + parkingFee);
        System.out.println("Remaining Spots: " + occupied + "/" + TOTAL_SPOTS + "\n");

        return new int[]{occupied, (int) parkingFee};
    }

    static double calculateParkingFee(int hours) {
        return (hours <= 2) ? HOURLY_RATE :
               (hours <= 4) ? HOURLY_RATE * 1.8 :
               (hours <= 8) ? HOURLY_RATE * 3.0 :
               (hours <= 12) ? HOURLY_RATE * 4.5 :
               (hours <= 24) ? HOURLY_RATE * 6.0 :
               HOURLY_RATE * 7.0;
    }

    static void showOccupancy(int occupied) {
        int available = TOTAL_SPOTS - occupied;
        double occupancyPercentage = (occupied * 100.0) / TOTAL_SPOTS;

        System.out.println("\n--- Parking Lot Occupancy ---");
        System.out.println("Occupied Spots: " + occupied + "/" + TOTAL_SPOTS);
        System.out.println("Available Spots: " + available);
        System.out.println("Occupancy: " + String.format("%.2f", occupancyPercentage) + "%");

        if (occupied >= TOTAL_SPOTS * 0.8) {
            System.out.println("⚠️  Warning: Parking lot is 80% full!");
        }

        if (occupied == TOTAL_SPOTS) {
            System.out.println("🔴 FULL - No spots available");
        } else if (available <= 5) {
            System.out.println("🟠 ALERT - Only " + available + " spot(s) remaining");
        } else {
            System.out.println("🟢 AVAILABLE - Good occupancy level");
        }

        System.out.println();
    }

    static void printFinalReport(int totalVehicles, double revenue) {
        System.out.println("\n==================== FINAL REPORT ====================");
        System.out.println("Total Vehicles Parked Today: " + totalVehicles);
        System.out.println("Total Revenue Generated: ₹" + revenue);

        if (totalVehicles > 0) {
            double avgRevenue = revenue / totalVehicles;
            System.out.println("Average Revenue per Vehicle: ₹" + String.format("%.2f", avgRevenue));
        }

        System.out.println("======================================================");
    }
}
