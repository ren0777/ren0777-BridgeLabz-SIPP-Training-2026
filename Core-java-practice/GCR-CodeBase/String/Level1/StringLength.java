import java.util.Scanner;

/**
 * Program to find and return the length of a string without using length() method
 */
public class StringLength {
    
    /**
     * Find and return string length without using built-in length() method
     * Uses infinite loop and catches StringIndexOutOfBoundsException
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
            // When exception is thrown, we've reached the end of string
            return count;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        // Find length using user-defined method
        int userDefinedLength = findStringLength(text);
        
        // Find length using built-in method
        int builtInLength = text.length();
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("String: " + text);
        System.out.println("Length (User-defined method): " + userDefinedLength);
        System.out.println("Length (Built-in length() method): " + builtInLength);
        System.out.println("Both results match: " + (userDefinedLength == builtInLength));
        
        scanner.close();
    }
}
