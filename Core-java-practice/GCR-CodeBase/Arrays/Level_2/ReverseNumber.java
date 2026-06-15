import java.util.Scanner;

public class ReverseNumber {
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
        
        // Create array to store elements in reverse order
        int[] reversedDigits = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            reversedDigits[i] = digits[digitCount - 1 - i];
        }
        
        // Display results
        System.out.println("\n========== Results ==========");
        System.out.println("Original digits: ");
        for (int i = digitCount - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }
        
        System.out.println("\n\nReversed digits: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(reversedDigits[i]);
        }
        System.out.println();
        
        scanner.close();
    }
}
