import java.util.Scanner;

/**
 * Program to trim leading and trailing spaces using charAt() method
 */
public class TrimSpaces {
    
    /**
     * Find the starting and ending index without spaces
     * @param text The input text
     * @return Array with {startIndex, endIndex}
     */
    public static int[] findTrimIndexes(String text) {
        int startIndex = 0;
        int endIndex = text.length() - 1;
        
        // Find start index by skipping leading spaces
        while (startIndex < text.length() && text.charAt(startIndex) == ' ') {
            startIndex++;
        }
        
        // Find end index by skipping trailing spaces
        while (endIndex >= startIndex && text.charAt(endIndex) == ' ') {
            endIndex--;
        }
        
        return new int[]{startIndex, endIndex + 1};
    }
    
    /**
     * Create substring from a string using charAt() method
     * @param text The input text
     * @param startIndex Start index
     * @param endIndex End index (exclusive)
     * @return Substring
     */
    public static String createSubstringUsingCharAt(String text, int startIndex, int endIndex) {
        String substring = "";
        for (int i = startIndex; i < endIndex; i++) {
            substring += text.charAt(i);
        }
        return substring;
    }
    
    /**
     * Compare two strings using charAt() method
     * @param str1 First string
     * @param str2 Second string
     * @return true if equal, false otherwise
     */
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a text (can have leading/trailing spaces): ");
        String text = scanner.nextLine();
        
        // Find trim indexes
        int[] indexes = findTrimIndexes(text);
        
        // Trim using user-defined method
        String userDefinedTrimmed = createSubstringUsingCharAt(text, indexes[0], indexes[1]);
        
        // Trim using built-in trim() method
        String builtInTrimmed = text.trim();
        
        // Compare results
        boolean areEqual = compareStrings(userDefinedTrimmed, builtInTrimmed);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Original Text: \"" + text + "\"");
        System.out.println("Original Length: " + text.length());
        
        System.out.println("\nTrimmed using user-defined method: \"" + userDefinedTrimmed + "\"");
        System.out.println("Trimmed Length: " + userDefinedTrimmed.length());
        
        System.out.println("\nTrimmed using built-in trim(): \"" + builtInTrimmed + "\"");
        System.out.println("Trimmed Length: " + builtInTrimmed.length());
        
        System.out.println("\nBoth results are equal: " + areEqual);
        
        scanner.close();
    }
}
