import java.util.Scanner;
import java.util.Arrays;

/**
 * Program to return all characters in a string and compare with toCharArray()
 */
public class CharArrayComparison {
    
    /**
     * Return all characters in a string without using toCharArray()
     * @param str The input string
     * @return Array of characters
     */
    public static char[] getCharactersUsingCharAt(String str) {
        char[] characters = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            characters[i] = str.charAt(i);
        }
        return characters;
    }
    
    /**
     * Compare two char arrays
     * @param arr1 First char array
     * @param arr2 Second char array
     * @return true if arrays are equal, false otherwise
     */
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take user input
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        // Get char array using user-defined method
        char[] userDefinedArray = getCharactersUsingCharAt(text);
        
        // Get char array using built-in toCharArray() method
        char[] builtInArray = text.toCharArray();
        
        // Compare the two arrays
        boolean areEqual = compareCharArrays(userDefinedArray, builtInArray);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Original String: " + text);
        System.out.println("Character array using charAt(): " + Arrays.toString(userDefinedArray));
        System.out.println("Character array using toCharArray(): " + Arrays.toString(builtInArray));
        System.out.println("Both arrays are equal: " + areEqual);
        
        scanner.close();
    }
}
