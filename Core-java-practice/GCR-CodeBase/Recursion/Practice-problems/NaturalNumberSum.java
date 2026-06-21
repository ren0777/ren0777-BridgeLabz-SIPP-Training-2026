// Problem 3: Sum of First N Natural Numbers
// Find the sum of first N natural numbers using recursion.

public class NaturalNumberSum {
    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }

        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(sum(n));
    }
}
