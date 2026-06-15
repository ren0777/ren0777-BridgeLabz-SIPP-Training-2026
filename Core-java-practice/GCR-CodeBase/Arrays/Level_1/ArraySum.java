import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        
        System.out.println("Enter numbers (0 or negative number to stop, or maximum 10 numbers):");
        
        // Infinite while loop to take user input
        while (true) {
            System.out.print("Enter number: ");
            double number = scanner.nextDouble();
            
            // Break if user enters 0 or negative number
            if (number <= 0) {
                break;
            }
            
            // Break if array is full
            if (index == 10) {
                break;
            }
            
            // Store number in array and increment index
            numbers[index] = number;
            index++;
        }
        
        // Calculate sum of all elements
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }
        
        // Display all numbers entered
        System.out.println("\n--- Numbers Entered ---");
        for (int i = 0; i < index; i++) {
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
        }
        
        // Display total
        System.out.println("\n--- Total ---");
        System.out.println("Sum of all numbers: " + total);
        
        scanner.close();
    }
}
