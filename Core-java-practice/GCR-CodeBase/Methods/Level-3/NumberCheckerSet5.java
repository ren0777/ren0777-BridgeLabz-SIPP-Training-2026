import java.util.Scanner;

public class NumberCheckerSet5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("Perfect number: " + NumberChecker.isPerfect(number));
        System.out.println("Abundant number: " + NumberChecker.isAbundant(number));
        System.out.println("Deficient number: " + NumberChecker.isDeficient(number));
        System.out.println("Strong number: " + NumberChecker.isStrong(number));

        scanner.close();
    }
}