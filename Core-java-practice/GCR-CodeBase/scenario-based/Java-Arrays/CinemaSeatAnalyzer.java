import java.util.Scanner;

public class CinemaSeatAnalyzer {

    static int[] acceptSeats(Scanner sc) {
        System.out.print("Enter total number of seats: ");
        int n = sc.nextInt();
        int[] seats = new int[n];
        System.out.println("Enter seat status (0 = Empty, 1 = Booked):");
        for (int i = 0; i < n; i++) {
            System.out.print("Seat " + (i + 1) + ": ");
            seats[i] = sc.nextInt();
        }
        return seats;
    }

    static int[] findLongestEmptyBlock(int[] seats) {
        int maxLength = 0;
        int maxStart = -1;
        int currentLength = 0;
        int currentStart = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                if (currentLength == 0) {
                    currentStart = i;
                }
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStart = currentStart;
                }
            } else {
                currentLength = 0;
            }
        }
        return new int[]{maxStart, maxStart + maxLength - 1, maxLength};
    }

    static int countBooked(int[] seats) {
        int count = 0;
        for (int s : seats) {
            if (s == 1) count++;
        }
        return count;
    }

    static int countAvailable(int[] seats) {
        int count = 0;
        for (int s : seats) {
            if (s == 0) count++;
        }
        return count;
    }

    static boolean canGroupSitTogether(int[] seats, int groupSize) {
        int currentLength = 0;
        for (int s : seats) {
            if (s == 0) {
                currentLength++;
                if (currentLength >= groupSize) return true;
            } else {
                currentLength = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] seats = acceptSeats(sc);

        int[] block = findLongestEmptyBlock(seats);
        int booked = countBooked(seats);
        int available = countAvailable(seats);
        boolean groupCanSit = canGroupSitTogether(seats, 5);

        System.out.println("\n========================================");
        System.out.println("         CINEMA SEAT ANALYSIS           ");
        System.out.println("========================================");
        System.out.println("Total Seats      : " + seats.length);
        System.out.println("Booked Seats     : " + booked);
        System.out.println("Available Seats  : " + available);
        System.out.println("----------------------------------------");

        if (block[2] == 0) {
            System.out.println("No empty seats found.");
        } else {
            System.out.println("Longest Empty Block:");
            System.out.println("  Start Position : Seat " + (block[0] + 1));
            System.out.println("  End Position   : Seat " + (block[1] + 1));
            System.out.println("  Block Length   : " + block[2] + " seats");
        }

        System.out.println("----------------------------------------");
        System.out.println("Group of 5 Suggestion:");
        if (groupCanSit) {
            System.out.println("  YES - A group of 5 can sit together.");
        } else {
            System.out.println("  NO  - A group of 5 cannot sit together.");
        }
        System.out.println("========================================");

        sc.close();
    }
}
