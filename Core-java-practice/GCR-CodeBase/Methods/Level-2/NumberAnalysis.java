import java.util.Scanner;

public class NumberAnalysis {

    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        return Integer.compare(number1, number2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n--- Number Analysis ---");
        for (int i = 0; i < numbers.length; i++) {
            if (isPositive(numbers[i])) {
                if (isEven(numbers[i])) {
                    System.out.println("Number " + numbers[i] + " is positive and even");
                } else {
                    System.out.println("Number " + numbers[i] + " is positive and odd");
                }
            } else {
                System.out.println("Number " + numbers[i] + " is negative");
            }
        }

        int comparison = compare(numbers[0], numbers[numbers.length - 1]);
        System.out.println("\n--- Comparison of First and Last Element ---");
        if (comparison == 0) {
            System.out.println("First element is equal to last element.");
        } else if (comparison > 0) {
            System.out.println("First element is greater than last element.");
        } else {
            System.out.println("First element is less than last element.");
        }

        scanner.close();
    }
}