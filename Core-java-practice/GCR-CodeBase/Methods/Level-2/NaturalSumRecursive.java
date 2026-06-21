import java.util.Scanner;

public class NaturalSumRecursive {

    public static long calculateSumRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + calculateSumRecursive(n - 1);
    }

    public static long calculateSumFormula(int n) {
        return (long) n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Please enter a natural number greater than 0.");
            scanner.close();
            return;
        }

        long recursiveSum = calculateSumRecursive(n);
        long formulaSum = calculateSumFormula(n);

        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula: " + formulaSum);
        System.out.println("Both computations are correct: " + (recursiveSum == formulaSum));

        scanner.close();
    }
}