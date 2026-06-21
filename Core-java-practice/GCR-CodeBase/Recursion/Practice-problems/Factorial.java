// Problem 2: Calculate Factorial
// Write a recursive function to calculate the factorial of a number.

public class Factorial {
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));
    }
}
