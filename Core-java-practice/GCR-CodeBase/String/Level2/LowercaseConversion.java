import java.util.Scanner;

/**
 * Program to convert complete text to lowercase and compare results
 */
public class LowercaseConversion {
    
    /**
     * Convert each character to lowercase using charAt() method
     * Uses ASCII value logic: difference between uppercase and lowercase is 32
     * 'A' = 65, 'a' = 97, difference = 32
     * 'B' = 66, 'b' = 98, difference = 32, and so on
     * @param text Input text
     * @return Lowercase text created using charAt()
     */
    public static String convertToLowercaseUsingCharAt(String text) {
        String lowercase = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                // Convert uppercase to lowercase by adding 32
                lowercase += (char) (ch + 32);
            } else {
                lowercase += ch;
            }
        }
        return lowercase;
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
        
        // Take user input for complete text
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        
        // Convert using charAt() method
        String userDefinedLowercase = convertToLowercaseUsingCharAt(text);
        
        // Convert using built-in toLowerCase() method
        String builtInLowercase = text.toLowerCase();
        
        // Compare the two results
        boolean areEqual = compareStringsUsingCharAt(userDefinedLowercase, builtInLowercase);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Original Text: " + text);
        System.out.println("Lowercase using charAt(): " + userDefinedLowercase);
        System.out.println("Lowercase using toLowerCase(): " + builtInLowercase);
        System.out.println("Both results are equal: " + areEqual);
        
        scanner.close();
    }
}
