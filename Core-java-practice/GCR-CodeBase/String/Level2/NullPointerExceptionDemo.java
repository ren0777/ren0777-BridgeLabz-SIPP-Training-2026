import java.util.Scanner;
public class NullPointerExceptionDemo {
    
    /**
     * Method to generate NullPointerException
     * Accessing a method on null object will throw NullPointerException
     */
    public static void generateNullPointerException() {
        String text = null;
        
        // This will throw NullPointerException
        System.out.println("String length: " + text.length());
    }
    
    /**
     * Method to demonstrate and handle NullPointerException
     * Using try-catch block to handle the exception
     */
    public static void handleNullPointerException() {
        String text = null;
        
        try {
            System.out.println("String length: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Exception Caught: NullPointerException");
            System.out.println("Error Message: " + e.getMessage());
            System.out.println("The text variable is null. Cannot call methods on null object.");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Demonstrating NullPointerException ===\n");
        
        System.out.println("--- Method 1: Generate Exception (Unhandled) ---");
        System.out.println("Attempting to call generateNullPointerException()...\n");
        
        try {
            generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Exception Caught in main: " + e.getClass().getSimpleName());
            System.out.println("Program continued after exception handling.\n");
        }
        
        System.out.println("--- Method 2: Handle Exception (Using try-catch) ---");
        handleNullPointerException();
        
        System.out.println("\nProgram executed successfully!");
    }
}
