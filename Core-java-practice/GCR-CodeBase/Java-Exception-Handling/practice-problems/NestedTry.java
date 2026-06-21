// Problem 9: Nested try-catch Block
// Access an array element and divide it by a divisor using nested try-catch.

import java.util.Scanner;

public class NestedTry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();
            int[] numbers = new int[size];

            for (int i = 0; i < numbers.length; i++) {
                System.out.print("Enter value " + (i + 1) + ": ");
                numbers[i] = scanner.nextInt();
            }

            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            int value = numbers[index];

            try {
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();
                System.out.println("Result: " + (value / divisor));
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } finally {
            scanner.close();
        }
    }
}
