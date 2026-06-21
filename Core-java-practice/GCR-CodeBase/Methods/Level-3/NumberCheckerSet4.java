import java.util.Scanner;

public class NumberCheckerSet4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] digits = NumberChecker.getDigitsArray(number);

        System.out.println("Prime number: " + NumberChecker.isPrime(number));
        System.out.println("Neon number: " + NumberChecker.isNeon(number));
        System.out.println("Spy number: " + NumberChecker.isSpy(digits));
        System.out.println("Automorphic number: " + NumberChecker.isAutomorphic(number));
        System.out.println("Buzz number: " + NumberChecker.isBuzz(number));

        scanner.close();
    }
}