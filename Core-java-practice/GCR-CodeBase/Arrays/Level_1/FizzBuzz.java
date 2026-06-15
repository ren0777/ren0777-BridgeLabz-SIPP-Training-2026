import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        // Check if input is positive
        if (number <= 0) {
            System.out.println("Please enter a positive integer");
            scanner.close();
            return;
        }
        
        // Create String array to save results
        String[] results = new String[number + 1];
        
        // Store FizzBuzz values
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }
        
        // Display results
        System.out.println("\n--- FizzBuzz Results ---");
        for (int i = 1; i <= number; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }
        
        scanner.close();
    }
}
