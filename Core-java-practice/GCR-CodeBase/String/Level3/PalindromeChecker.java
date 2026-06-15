import java.util.Scanner;

/**
 * Program to check if a text is palindrome using 3 different approaches
 * A palindrome reads the same forward and backward
 */
public class PalindromeChecker {
    
    /**
     * Logic 1: Compare characters from start and end of string
     * @param text The input text
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;
        
        // Compare characters from start and end
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    /**
     * Logic 2: Recursive method to check palindrome
     * @param text The input text
     * @param start Start index
     * @param end End index
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        // Base case: if start index >= end index, return true
        if (start >= end) {
            return true;
        }
        
        // If characters at start and end are not equal, return false
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        
        // Recursively call with incremented start and decremented end
        return isPalindromeRecursive(text, start + 1, end - 1);
    }
    
    /**
     * Logic 3: Compare original and reversed character arrays
     * @param text The input text
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeUsingCharArray(String text) {
        // Method to reverse a string using charAt()
        String reversed = reverseStringUsingCharAt(text);
        
        // Get original character array
        char[] originalArray = text.toCharArray();
        char[] reversedArray = reversed.toCharArray();
        
        // Compare original and reversed arrays
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] != reversedArray[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Helper method to reverse a string using charAt()
     * @param text The input text
     * @return Reversed string
     */
    public static String reverseStringUsingCharAt(String text) {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        return reversed;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Remove spaces for palindrome check
        String textNoSpaces = text.replaceAll(" ", "").toLowerCase();
        
        // Check using all three methods
        boolean result1 = isPalindromeIterative(textNoSpaces);
        boolean result2 = isPalindromeRecursive(textNoSpaces, 0, textNoSpaces.length() - 1);
        boolean result3 = isPalindromeUsingCharArray(textNoSpaces);
        
        // Display results
        System.out.println("\n--- Palindrome Check Results ---");
        System.out.println("Original String: " + text);
        System.out.println("String (no spaces, lowercase): " + textNoSpaces);
        
        System.out.println("\nMethod 1 (Iterative - Compare from start and end): " + result1);
        System.out.println("Method 2 (Recursive - Using recursion): " + result2);
        System.out.println("Method 3 (Using character arrays): " + result3);
        
        if (result1) {
            System.out.println("\n\"" + text + "\" is a PALINDROME!");
        } else {
            System.out.println("\n\"" + text + "\" is NOT a palindrome.");
        }
        
        scanner.close();
    }
}
