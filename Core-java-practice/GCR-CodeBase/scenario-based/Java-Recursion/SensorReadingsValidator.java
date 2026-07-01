import java.util.Scanner;

class SensorReadingsValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Consecutive Sensor Readings Validator ===\n");

        System.out.print("Enter number of readings: ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine().trim());
            if (n <= 0) {
                System.out.println("Number of readings must be positive.");
                scanner.close();
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            scanner.close();
            return;
        }

        int[] readings = new int[n];
        System.out.println("\nEnter " + n + " temperature readings:");

        for (int i = 0; i < n; i++) {
            System.out.print("Reading " + (i + 1) + ": ");
            try {
                readings[i] = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid temperature.");
                i--;
            }
        }

        System.out.println("\nReadings: " + arrayToString(readings));

        boolean isIncreasing = isStrictlyIncreasing(readings, 0);

        System.out.println("Are readings strictly increasing? " + (isIncreasing ? "✓ TRUE" : "✗ FALSE"));

        if (isIncreasing) {
            System.out.println("Analysis: Temperature is consistently rising with each reading.");
        } else {
            System.out.println("Analysis: Temperature did not maintain a consistent increase.");
            findFirstDecrease(readings, 0);
        }

        scanner.close();
    }

    static boolean isStrictlyIncreasing(int[] readings, int index) {
        if (index >= readings.length - 1) {
            return true;
        }

        if (readings[index] >= readings[index + 1]) {
            return false;
        }

        return isStrictlyIncreasing(readings, index + 1);
    }

    static void findFirstDecrease(int[] readings, int index) {
        if (index >= readings.length - 1) {
            return;
        }

        if (readings[index] >= readings[index + 1]) {
            System.out.println("First decrease at position " + index + ": " + readings[index] + " → " + readings[index + 1]);
            return;
        }

        findFirstDecrease(readings, index + 1);
    }

    static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
