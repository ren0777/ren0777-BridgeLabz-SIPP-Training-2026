// Problem 4: Multiple Catch Blocks
// Retrieve a value from an array and handle multiple exceptions.

import java.util.Scanner;

public class ArrayValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = null;

        try {
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();

            if (size >= 0) {
                numbers = new int[size];

                for (int i = 0; i < numbers.length; i++) {
                    System.out.print("Enter value " + (i + 1) + ": ");
                    numbers[i] = scanner.nextInt();
                }
            }

            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}
