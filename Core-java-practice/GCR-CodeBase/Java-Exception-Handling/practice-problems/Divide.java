// Problem 2: Unchecked Exception
// Divide two numbers and handle ArithmeticException and InputMismatchException.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Divide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();

            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } catch (InputMismatchException e) {
            System.out.println("Please enter numeric values");
        } finally {
            scanner.close();
        }
    }
}
