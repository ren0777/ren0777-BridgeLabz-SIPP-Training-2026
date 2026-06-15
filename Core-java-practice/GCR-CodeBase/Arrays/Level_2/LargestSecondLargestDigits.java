import java.util.Scanner;

public class LargestSecondLargestDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        
        // Store digits of the number in array
        long tempNumber = Math.abs(number);
        while (tempNumber != 0) {
            digits[index] = (int)(tempNumber % 10);
            index++;
            
            if (index == maxDigit) {
                break;
            }
            
            tempNumber /= 10;
        }
        
        // Find largest and second largest
        int largest = 0;
        int secondLargest = 0;
        
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        // Display results
        System.out.println("\n========== Results ==========");
        System.out.println("Digits extracted: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }
        System.out.println("\n\nLargest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        
        scanner.close();
    }
}
