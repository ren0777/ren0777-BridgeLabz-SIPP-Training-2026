import java.util.Arrays;
import java.util.Scanner;

public class EuclideanDistanceAndLineEquation {

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] lineEquation(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1);
        double intercept = y1 - (slope * x1);
        return new double[]{slope, intercept};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1 y1: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2 y2: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.println("Distance: " + distance(x1, y1, x2, y2));
        System.out.println("Slope and y-intercept: " + Arrays.toString(lineEquation(x1, y1, x2, y2)));

        scanner.close();
    }
}