import java.util.Arrays;
import java.util.Scanner;

public class NumberCheckerSet2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] digits = NumberChecker.getDigitsArray(number);
        int[][] frequency = NumberChecker.digitFrequency(digits);

        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Digit count: " + NumberChecker.countDigits(number));
        System.out.println("Sum of digits: " + NumberChecker.sumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + NumberChecker.sumOfSquareOfDigits(digits));
        System.out.println("Harshad number: " + NumberChecker.isHarshadNumber(number, digits));
        System.out.println("Digit frequency:");

        for (int[] row : frequency) {
            if (row[1] > 0) {
                System.out.println(row[0] + " -> " + row[1]);
            }
        }

        scanner.close();
    }
}