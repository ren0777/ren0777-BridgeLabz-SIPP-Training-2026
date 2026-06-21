import java.util.Arrays;
import java.util.Scanner;

public class Quadratic {

    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - (4 * a * c);

        if (delta < 0) {
            return new double[0];
        }

        if (delta == 0) {
            return new double[]{-b / (2 * a)};
        }

        double sqrtDelta = Math.sqrt(delta);
        double root1 = (-b + sqrtDelta) / (2 * a);
        double root2 = (-b - sqrtDelta) / (2 * a);
        return new double[]{root1, root2};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        double[] roots = findRoots(a, b, c);
        if (roots.length == 0) {
            System.out.println("No real roots.");
        } else {
            System.out.println("Roots: " + Arrays.toString(roots));
        }

        scanner.close();
    }
}