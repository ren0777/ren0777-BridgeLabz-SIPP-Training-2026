import java.util.Scanner;

public class OddEvenSeparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Check if input is a natural number
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number");
            scanner.close();
            return;
        }
        
        // Create arrays for odd and even numbers
        int[] evenNumbers = new int[number / 2 + 1];
        int[] oddNumbers = new int[number / 2 + 1];
        int evenIndex = 0;
        int oddIndex = 0;
        
        // Iterate from 1 to number and separate odd and even
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }
        
        // Display even numbers
        System.out.println("\n--- Even Numbers ---");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();
        
        // Display odd numbers
        System.out.println("\n--- Odd Numbers ---");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
