import java.util.Scanner;
import java.util.Arrays;

/**
 * Program to find unique characters in a string using charAt() method
 */
public class UniqueCharacters {
    
    /**
     * Find the length of text without using String length() method
     * @param text The input text
     * @return Length of the text
     */
    public static int findLength(String text) {
        int count = 0;
        try {
            for (int i = 0; ; i++) {
                text.charAt(i);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Length found when exception is thrown
        }
        return count;
    }
    
    /**
     * Find unique characters in a string using charAt() method
     * Uses nested loops to check uniqueness
     * @param text The input text
     * @return 1D array containing unique characters
     */
    public static char[] findUniqueCharacters(String text) {
        int length = findLength(text);
        char[] tempArray = new char[length];
        int uniqueCount = 0;
        
        // Outer loop: iterate through each character
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;
            
            // Inner loop: check if character is unique by comparing with previous characters
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }
            
            // If character is unique, store it
            if (isUnique) {
                tempArray[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }
        
        // Create a new array with only unique characters
        char[] resultArray = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            resultArray[i] = tempArray[i];
        }
        
        return resultArray;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Find unique characters
        char[] uniqueChars = findUniqueCharacters(text);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Original String: " + text);
        System.out.println("Length of string (without using length()): " + findLength(text));
        System.out.println("Unique Characters: " + Arrays.toString(uniqueChars));
        System.out.println("Number of Unique Characters: " + uniqueChars.length);
        
        scanner.close();
    }
}
