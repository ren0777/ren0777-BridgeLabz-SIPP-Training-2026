import java.util.Scanner;

/**
 * Program to compare two strings using charAt() method and check result with equals()
 */
public class StringComparison {
    
    /**
     * Compare two strings using charAt() method
     * @param str1 First string
     * @param str2 Second string
     * @return true if strings are equal, false otherwise
     */
    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        // If lengths are different, strings are not equal
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Compare character by character using charAt()
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take user input for two strings
        System.out.print("Enter first string: ");
        String str1 = scanner.next();
        
        System.out.print("Enter second string: ");
        String str2 = scanner.next();
        
        // Compare using charAt() method
        boolean resultCharAt = compareStringsUsingCharAt(str1, str2);
        
        // Compare using built-in equals() method
        boolean resultEquals = str1.equals(str2);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        System.out.println("Result using charAt() method: " + resultCharAt);
        System.out.println("Result using equals() method: " + resultEquals);
        System.out.println("Both methods return same result: " + (resultCharAt == resultEquals));
        
        scanner.close();
    }
}
