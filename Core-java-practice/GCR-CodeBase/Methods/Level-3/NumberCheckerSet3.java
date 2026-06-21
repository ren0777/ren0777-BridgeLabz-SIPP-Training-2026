import java.util.Arrays;
import java.util.Scanner;

public class NumberCheckerSet3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] digits = NumberChecker.getDigitsArray(number);
        int[] reversed = NumberChecker.reverseDigits(digits);

        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Reversed digits: " + Arrays.toString(reversed));
        System.out.println("Digits arrays equal: " + NumberChecker.areEqual(digits, reversed));
        System.out.println("Palindrome number: " + NumberChecker.isPalindrome(digits));
        System.out.println("Duck number: " + NumberChecker.isDuckNumber(digits));

        scanner.close();
    }
}