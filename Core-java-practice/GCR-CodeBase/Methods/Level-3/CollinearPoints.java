import java.util.Scanner;

public class CollinearPoints {

    public static boolean areCollinearUsingSlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        double slope12 = (y2 - y1) / (x2 - x1);
        double slope23 = (y3 - y2) / (x3 - x2);
        return Double.compare(slope12, slope23) == 0;
    }

    public static boolean areCollinearUsingArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1 y1: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2 y2: ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        System.out.print("Enter x3 y3: ");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        System.out.println("Collinear using slope: " + areCollinearUsingSlope(x1, y1, x2, y2, x3, y3));
        System.out.println("Collinear using area: " + areCollinearUsingArea(x1, y1, x2, y2, x3, y3));

        scanner.close();
    }
}