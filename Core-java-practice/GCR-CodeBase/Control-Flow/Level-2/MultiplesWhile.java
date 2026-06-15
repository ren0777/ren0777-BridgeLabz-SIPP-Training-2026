import java.util.Scanner;

public class MultiplesWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive number less than 100: ");
        int number = sc.nextInt();

        if (number > 0 && number < 100) {
            int multiple = number;

            while (multiple < 100) {
                System.out.print(multiple + " ");
                multiple += number;
            }
        } else {
            System.out.println("Invalid input.");
        }
    }
}