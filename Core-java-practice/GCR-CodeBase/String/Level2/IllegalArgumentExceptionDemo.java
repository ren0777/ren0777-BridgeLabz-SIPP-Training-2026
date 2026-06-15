import java.util.Scanner;

/**
 * Program to demonstrate IllegalArgumentException
 */
public class IllegalArgumentExceptionDemo {
    
    /**
     * Method to generate IllegalArgumentException
     * Setting start index greater than end index throws this exception
     */
    public static void generateIllegalArgumentException(String text) {
        // Start index greater than end index
        int startIndex = 5;
        int endIndex = 2;
        String substring = text.substring(startIndex, endIndex);
        System.out.println("Substring: " + substring);
    }
    
    /**
     * Method to demonstrate and handle IllegalArgumentException
     * Using try-catch block to handle the exception
     */
    public static void handleIllegalArgumentException(String text, int startIndex, int endIndex) {
        try {
            if (startIndex > endIndex) {
                throw new IllegalArgumentException("Start index cannot be greater than end index");
            }
            String substring = text.substring(startIndex, endIndex);
            System.out.println("Substring: " + substring);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught: IllegalArgumentException");
            System.out.println("Error Message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught: " + e.getClass().getSimpleName());
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Demonstrating IllegalArgumentException ===\n");
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        System.out.println("\n--- Method 1: Generate Exception (Unhandled) ---");
        System.out.println("Attempting to create substring with start index > end index...\n");
        
        try {
            generateIllegalArgumentException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception Caught: " + e.getClass().getSimpleName());
            System.out.println("Program continued after exception handling.\n");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception Caught: " + e.getClass().getSimpleName());
            System.out.println("Program continued after exception handling.\n");
        }
        
        System.out.println("--- Method 2: Handle Exception (Using try-catch) ---");
        
        System.out.print("Enter start index: ");
        int startIndex = scanner.nextInt();
        
        System.out.print("Enter end index: ");
        int endIndex = scanner.nextInt();
        
        handleIllegalArgumentException(text, startIndex, endIndex);
        
        System.out.println("\nProgram executed successfully!");
        
        scanner.close();
    }
}
