import java.util.Scanner;
import java.util.Arrays;

/**
 * Program to split text into words and compare with split() method
 */
public class SplitTextWords {
    
    /**
     * Find string length without using built-in length() method
     * @param text The input text
     * @return Length of the string
     */
    public static int findStringLength(String text) {
        int count = 0;
        try {
            for (int i = 0; ; i++) {
                text.charAt(i);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    /**
     * Split text into words using charAt() method without using split()
     * @param text The input text
     * @return Array of words
     */
    public static String[] splitTextIntoWords(String text) {
        int textLength = findStringLength(text);
        
        // First, count the number of words by counting spaces
        int wordCount = 1;
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        
        // Create array to store space indexes
        int[] spaceIndexes = new int[wordCount + 1];
        spaceIndexes[0] = -1;
        int spaceCount = 1;
        
        // Find indexes of all spaces
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[spaceCount] = i;
                spaceCount++;
            }
        }
        spaceIndexes[wordCount] = textLength;
        
        // Create array to store words
        String[] words = new String[wordCount];
        
        // Extract words using space indexes
        for (int i = 0; i < wordCount; i++) {
            int startIndex = spaceIndexes[i] + 1;
            int endIndex = spaceIndexes[i + 1];
            
            String word = "";
            for (int j = startIndex; j < endIndex; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }
        
        return words;
    }
    
    /**
     * Compare two string arrays
     * @param arr1 First array
     * @param arr2 Second array
     * @return true if arrays are equal, false otherwise
     */
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        
        // Split using user-defined method
        String[] userDefinedWords = splitTextIntoWords(text);
        
        // Split using built-in split() method
        String[] builtInWords = text.split(" ");
        
        // Compare arrays
        boolean areEqual = compareStringArrays(userDefinedWords, builtInWords);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Original Text: " + text);
        System.out.println("\nWords using user-defined method: " + Arrays.toString(userDefinedWords));
        System.out.println("Words using built-in split(): " + Arrays.toString(builtInWords));
        System.out.println("\nBoth arrays are equal: " + areEqual);
        
        scanner.close();
    }
}
