import java.util.Scanner;

/**
 * Program to create substring using charAt() and compare with substring() method
 */
public class SubstringComparison {
    
    /**
     * Create substring from string using charAt() method
     * @param str The original string
     * @param start Start index
     * @param end End index (exclusive)
     * @return Substring created using charAt()
     */
    public static String createSubstringUsingCharAt(String str, int start, int end) {
        String substring = "";
        for (int i = start; i < end; i++) {
            substring += str.charAt(i);
        }
        return substring;
    }
    
    /**
     * Compare two strings using charAt() method
     * @param str1 First string
     * @param str2 Second string
     * @return true if strings are equal, false otherwise
     */
    public static boolean compareStringsUsingCharAt(String str1, String str2) {
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
        
        // Take user input
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        System.out.print("Enter start index: ");
        int startIndex = scanner.nextInt();
        
        System.out.print("Enter end index: ");
        int endIndex = scanner.nextInt();
        
        // Create substring using charAt()
        String userDefinedSubstring = createSubstringUsingCharAt(text, startIndex, endIndex);
        
        // Create substring using built-in substring() method
        String builtInSubstring = text.substring(startIndex, endIndex);
        
        // Compare the two substrings
        boolean areEqual = compareStringsUsingCharAt(userDefinedSubstring, builtInSubstring);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Original String: " + text);
        System.out.println("Start Index: " + startIndex + ", End Index: " + endIndex);
        System.out.println("Substring using charAt(): " + userDefinedSubstring);
        System.out.println("Substring using built-in method: " + builtInSubstring);
        System.out.println("Both substrings are equal: " + areEqual);
        
        scanner.close();
    }
}
