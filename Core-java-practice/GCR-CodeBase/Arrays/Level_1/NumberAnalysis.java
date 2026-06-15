import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        
        // Take user input for 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        // Check positive, negative, zero and even/odd for positive
        System.out.println("\n--- Number Analysis ---");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                System.out.println("Number " + numbers[i] + " is negative");
            } else if (numbers[i] == 0) {
                System.out.println("Number " + numbers[i] + " is zero");
            } else {
                if (numbers[i] % 2 == 0) {
                    System.out.println("Number " + numbers[i] + " is positive and even");
                } else {
                    System.out.println("Number " + numbers[i] + " is positive and odd");
                }
            }
        }
        
        // Compare first and last elements
        System.out.println("\n--- Comparison of First and Last Element ---");
        if (numbers[0] == numbers[4]) {
            System.out.println("First element (" + numbers[0] + ") is equal to last element (" + numbers[4] + ")");
        } else if (numbers[0] > numbers[4]) {
            System.out.println("First element (" + numbers[0] + ") is greater than last element (" + numbers[4] + ")");
        } else {
            System.out.println("First element (" + numbers[0] + ") is less than last element (" + numbers[4] + ")");
        }
        
        scanner.close();
    }
}
