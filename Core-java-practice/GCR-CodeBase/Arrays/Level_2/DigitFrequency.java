import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        
        long tempNumber = Math.abs(number);
        
        // Count digits
        int digitCount = 0;
        long countTemp = tempNumber;
        if (countTemp == 0) {
            digitCount = 1;
        } else {
            while (countTemp != 0) {
                digitCount++;
                countTemp /= 10;
            }
        }
        
        // Store digits in array
        int[] digits = new int[digitCount];
        int index = 0;
        while (tempNumber != 0) {
            digits[index] = (int)(tempNumber % 10);
            index++;
            tempNumber /= 10;
        }
        
        // Create frequency array for digits 0-9
        int[] frequency = new int[10];
        
        // Loop through digits and increase frequency
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }
        
        // Display results
        System.out.println("\n========== Digit Frequency Analysis ==========");
        System.out.println("Digit\tFrequency");
        System.out.println("==================");
        
        for (int digit = 0; digit <= 9; digit++) {
            if (frequency[digit] > 0) {
                System.out.println(digit + "\t" + frequency[digit]);
            }
        }
        
        scanner.close();
    }
}
