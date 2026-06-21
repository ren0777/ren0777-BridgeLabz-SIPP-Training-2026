import java.util.Arrays;
import java.util.Scanner;

public class NumberCheckerSet1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] digits = NumberChecker.getDigitsArray(number);
        int[] largestPair = NumberChecker.findLargestAndSecondLargest(digits);
        int[] smallestPair = NumberChecker.findSmallestAndSecondSmallest(digits);

        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Digit count: " + NumberChecker.countDigits(number));
        System.out.println("Duck number: " + NumberChecker.isDuckNumber(digits));
        System.out.println("Armstrong number: " + NumberChecker.isArmstrongNumber(digits));
        System.out.println("Largest and second largest: " + Arrays.toString(largestPair));
        System.out.println("Smallest and second smallest: " + Arrays.toString(smallestPair));

        scanner.close();
    }
}