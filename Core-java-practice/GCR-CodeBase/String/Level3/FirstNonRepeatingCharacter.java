import java.util.Scanner;

/**
 * Program to find the first non-repeating character in a string
 */
public class FirstNonRepeatingCharacter {
    
    /**
     * Find the first non-repeating character in a string using charAt() method
     * Uses ASCII value as index in frequency array
     * @param text The input text
     * @return First non-repeating character, or '\0' if none found
     */
    public static char findFirstNonRepeatingCharacter(String text) {
        // Create an array to store frequency of characters
        // 256 ASCII characters are supported
        int[] frequency = new int[256];
        
        // Loop through the text to find frequency of characters
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
        // Loop through the text to find first non-repeating character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }
        
        // Return null character if no non-repeating character found
        return '\0';
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Find first non-repeating character
        char result = findFirstNonRepeatingCharacter(text);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Original String: " + text);
        
        if (result != '\0') {
            System.out.println("First Non-repeating Character: '" + result + "'");
            System.out.println("Character at index: " + text.indexOf(result));
        } else {
            System.out.println("No non-repeating character found!");
        }
        
        scanner.close();
    }
}
