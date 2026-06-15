import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base: ");
        double base = sc.nextDouble();

        System.out.print("Enter height: ");
        double height = sc.nextDouble();

        double areaSqInches = 0.5 * base * height;
        double areaSqCm = areaSqInches * 6.4516;

        System.out.println("Area in square inches = " + areaSqInches);
        System.out.println("Area in square centimeters = " + areaSqCm);

        sc.close();
    }
}