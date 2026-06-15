import java.util.Scanner;

/**
 * Program to demonstrate NumberFormatException
 */
public class NumberFormatExceptionDemo {
    
    /**
     * Method to generate NumberFormatException
     * Using Integer.parseInt() with non-numeric string throws this exception
     */
    public static void generateNumberFormatException(String text) {
        // Try to parse a non-numeric string
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }
    
    /**
     * Method to demonstrate and handle NumberFormatException
     * Using try-catch block to handle the exception
     */
    public static void handleNumberFormatException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Exception Caught: NumberFormatException");
            System.out.println("Error Message: " + e.getMessage());
            System.out.println("The input string '" + text + "' cannot be parsed as an integer.");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught: " + e.getClass().getSimpleName());
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Demonstrating NumberFormatException ===\n");
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        System.out.println("\n--- Method 1: Generate Exception (Unhandled) ---");
        System.out.println("Attempting to parse the string using Integer.parseInt()...\n");
        
        try {
            generateNumberFormatException(text);
        } catch (NumberFormatException e) {
            System.out.println("Exception Caught: " + e.getClass().getSimpleName());
            System.out.println("Program continued after exception handling.\n");
        }
        
        System.out.println("--- Method 2: Handle Exception (Using try-catch) ---");
        
        System.out.print("Enter another string (or a number): ");
        String inputText = scanner.nextLine();
        
        handleNumberFormatException(inputText);
        
        System.out.println("\nProgram executed successfully!");
        
        scanner.close();
    }
}
