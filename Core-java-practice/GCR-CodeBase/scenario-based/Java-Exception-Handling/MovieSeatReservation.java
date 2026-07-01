import java.util.Scanner;

class MovieSeatReservation {
    static int[] seats = {101, 102, 103, 104, 105};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Movie Seat Reservation System ===\n");

        displayAvailableSeats();

        while (true) {
            System.out.println("\n1. View Seat");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View All Seats");
            System.out.println("5. Exit");
            System.out.print("\nSelect option (1-5): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    viewSeat(scanner);
                    break;
                case "2":
                    reserveSeat(scanner);
                    break;
                case "3":
                    cancelReservation(scanner);
                    break;
                case "4":
                    displayAllSeats();
                    break;
                case "5":
                    System.out.println("Thank you for using our reservation system!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }

    static void displayAvailableSeats() {
        System.out.println("--- Available Seats ---");
        System.out.print("Seats: ");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] != -1) {
                System.out.print(seats[i] + " ");
            }
        }
        System.out.println("\n");
    }

    static int getSeat(int index) {
        try {
            if (index < 0 || index >= seats.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid seat index: " + index + ". Valid range: 0-" + (seats.length - 1));
            }

            if (seats[index] == -1) {
                System.out.println("⚠️  Seat at position " + index + " is already reserved.");
                return -1;
            }

            return seats[index];

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Error: " + e.getMessage());
            return -1;
        } catch (Exception e) {
            System.out.println("❌ Unexpected error: " + e.getMessage());
            return -1;
        }
    }

    static void viewSeat(Scanner scanner) {
        System.out.println("\n--- View Seat ---\n");

        try {
            System.out.print("Enter seat position (0-" + (seats.length - 1) + "): ");
            int index = Integer.parseInt(scanner.nextLine().trim());

            int seatNumber = getSeat(index);

            if (seatNumber == -1) {
                System.out.println("Failed to retrieve seat.\n");
            } else {
                System.out.println("✓ Seat at position " + index + ": " + seatNumber + "\n");
            }

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Please enter a valid number.\n");
        }
    }

    static void reserveSeat(Scanner scanner) {
        System.out.println("\n--- Reserve Seat ---\n");

        try {
            System.out.print("Enter seat position to reserve (0-" + (seats.length - 1) + "): ");
            int index = Integer.parseInt(scanner.nextLine().trim());

            if (index < 0 || index >= seats.length) {
                System.out.println("❌ Invalid seat position: " + index + ". Valid range: 0-" + (seats.length - 1) + "\n");
                return;
            }

            if (seats[index] == -1) {
                System.out.println("❌ Seat at position " + index + " is already reserved.\n");
                return;
            }

            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine().trim();

            int reservedSeat = seats[index];
            seats[index] = -1;

            System.out.println("✓ Reservation successful!");
            System.out.println("Customer: " + customerName);
            System.out.println("Seat Number: " + reservedSeat);
            System.out.println("Position: " + index + "\n");

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Please enter a valid number.\n");
        } catch (Exception e) {
            System.out.println("❌ Error during reservation: " + e.getMessage() + "\n");
        }
    }

    static void cancelReservation(Scanner scanner) {
        System.out.println("\n--- Cancel Reservation ---\n");

        try {
            System.out.print("Enter seat position to cancel (0-" + (seats.length - 1) + "): ");
            int index = Integer.parseInt(scanner.nextLine().trim());

            if (index < 0 || index >= seats.length) {
                System.out.println("❌ Invalid seat position: " + index + ". Valid range: 0-" + (seats.length - 1) + "\n");
                return;
            }

            if (seats[index] != -1) {
                System.out.println("❌ Seat at position " + index + " is not reserved.\n");
                return;
            }

            int seatNumber = (index == 0) ? 101 : (index == 1) ? 102 : (index == 2) ? 103 : (index == 3) ? 104 : 105;
            seats[index] = seatNumber;

            System.out.println("✓ Reservation cancelled successfully!");
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Position: " + index);
            System.out.println("Status: Available for booking\n");

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Please enter a valid number.\n");
        } catch (Exception e) {
            System.out.println("❌ Error during cancellation: " + e.getMessage() + "\n");
        }
    }

    static void displayAllSeats() {
        System.out.println("\n--- All Seats ---");
        System.out.println("Position | Seat Number | Status");
        System.out.println("-".repeat(40));

        for (int i = 0; i < seats.length; i++) {
            String status = (seats[i] == -1) ? "Reserved" : "Available";
            String seatNum = (seats[i] == -1) ? "---" : String.valueOf(seats[i]);
            System.out.printf("   %d     |    %s     | %s%n", i, seatNum, status);
        }

        System.out.println();
    }
}
