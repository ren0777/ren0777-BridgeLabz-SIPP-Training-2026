import java.util.Scanner;

/**
 * Program to convert complete text to uppercase and compare results
 */
public class UppercaseConversion {
    
    /**
     * Convert each character to uppercase using charAt() method
     * Uses ASCII value logic: difference between uppercase and lowercase is 32
     * 'a' = 97, 'A' = 65, difference = 32
     * 'b' = 98, 'B' = 66, difference = 32, and so on
     * @param text Input text
     * @return Uppercase text created using charAt()
     */
    public static String convertToUppercaseUsingCharAt(String text) {
        String uppercase = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                // Convert lowercase to uppercase by subtracting 32
                uppercase += (char) (ch - 32);
            } else {
                uppercase += ch;
            }
        }
        return uppercase;
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
        String userDefinedUppercase = convertToUppercaseUsingCharAt(text);
        
        // Convert using built-in toUpperCase() method
        String builtInUppercase = text.toUpperCase();
        
        // Compare the two results
        boolean areEqual = compareStringsUsingCharAt(userDefinedUppercase, builtInUppercase);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Original Text: " + text);
        System.out.println("Uppercase using charAt(): " + userDefinedUppercase);
        System.out.println("Uppercase using toUpperCase(): " + builtInUppercase);
        System.out.println("Both results are equal: " + areEqual);
        
        scanner.close();
    }
}
