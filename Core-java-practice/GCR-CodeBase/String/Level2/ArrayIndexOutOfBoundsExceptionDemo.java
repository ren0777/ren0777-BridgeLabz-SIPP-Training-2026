import java.util.Scanner;

/**
 * Program to demonstrate ArrayIndexOutOfBoundsException
 */
public class ArrayIndexOutOfBoundsExceptionDemo {
    
    /**
     * Method to generate ArrayIndexOutOfBoundsException
     * Accessing an array index larger than the array length throws this exception
     */
    public static void generateArrayIndexOutOfBoundsException(String[] names) {
        // Access index larger than array length
        System.out.println("Name at index " + names.length + ": " + names[names.length]);
    }
    
    /**
     * Method to demonstrate and handle ArrayIndexOutOfBoundsException
     * Using try-catch block to handle the exception
     */
    public static void handleArrayIndexOutOfBoundsException(String[] names, int index) {
        try {
            System.out.println("Name at index " + index + ": " + names[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception Caught: ArrayIndexOutOfBoundsException");
            System.out.println("Error Message: " + e.getMessage());
            System.out.println("Valid indices are from 0 to " + (names.length - 1));
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught: " + e.getClass().getSimpleName());
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Demonstrating ArrayIndexOutOfBoundsException ===\n");
        
        System.out.print("Enter number of names: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        String[] names = new String[count];
        
        System.out.println("Enter " + count + " names:");
        for (int i = 0; i < count; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }
        
        System.out.println("\n--- Method 1: Generate Exception (Unhandled) ---");
        System.out.println("Attempting to access index beyond array length...\n");
        
        try {
            generateArrayIndexOutOfBoundsException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception Caught: " + e.getClass().getSimpleName());
            System.out.println("Program continued after exception handling.\n");
        }
        
        System.out.println("--- Method 2: Handle Exception (Using try-catch) ---");
        
        System.out.print("Enter an index to access (0 to " + (count - 1) + "): ");
        int index = scanner.nextInt();
        
        handleArrayIndexOutOfBoundsException(names, index);
        
        System.out.println("\nProgram executed successfully!");
        
        scanner.close();
    }
}
