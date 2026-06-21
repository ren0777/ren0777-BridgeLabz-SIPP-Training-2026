import java.util.Arrays;
import java.util.Scanner;

public class FindFactorsAndStats {

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }

    public static long sumOfFactors(int[] factors) {
        long sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double sumOfSquareOfFactors(int[] factors) {
        double sum = 0;
        for (int factor : factors) {
            sum += Math.pow(factor, 2);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            scanner.close();
            return;
        }

        int[] factors = findFactors(number);

        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.printf("Sum of square of factors: %.0f%n", sumOfSquareOfFactors(factors));

        scanner.close();
    }
}