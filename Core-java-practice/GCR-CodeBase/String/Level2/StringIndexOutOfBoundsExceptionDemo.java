import java.util.Scanner;

/**
 * Program to demonstrate StringIndexOutOfBoundsException
 */
public class StringIndexOutOfBoundsExceptionDemo {
    
    /**
     * Method to generate StringIndexOutOfBoundsException
     * Accessing an index beyond the string length throws this exception
     */
    public static void generateStringIndexOutOfBoundsException(String text) {
        // Accessing index beyond the length of string
        System.out.println("Character at index " + text.length() + ": " + text.charAt(text.length()));
    }
    
    /**
     * Method to demonstrate and handle StringIndexOutOfBoundsException
     * Using try-catch block to handle the exception
     */
    public static void handleStringIndexOutOfBoundsException(String text) {
        try {
            // Attempting to access index beyond the length of string
            System.out.println("Character at index " + text.length() + ": " + text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception Caught: StringIndexOutOfBoundsException");
            System.out.println("Error Message: " + e.getMessage());
            System.out.println("Valid indices are from 0 to " + (text.length() - 1));
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught: " + e.getClass().getSimpleName());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Demonstrating StringIndexOutOfBoundsException ===\n");
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        System.out.println("\n--- Method 1: Generate Exception (Unhandled) ---");
        System.out.println("Attempting to access index beyond string length...\n");
        
        try {
            generateStringIndexOutOfBoundsException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception Caught: " + e.getClass().getSimpleName());
            System.out.println("Program continued after exception handling.\n");
        }
        
        System.out.println("--- Method 2: Handle Exception (Using try-catch) ---");
        handleStringIndexOutOfBoundsException(text);
        
        System.out.println("\nProgram executed successfully!");
        
        scanner.close();
    }
}
