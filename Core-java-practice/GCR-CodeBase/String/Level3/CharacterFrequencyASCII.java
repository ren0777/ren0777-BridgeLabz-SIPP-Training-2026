import java.util.Scanner;
import java.util.Arrays;

/**
 * Program to find frequency of characters in a string using ASCII array
 */
public class CharacterFrequencyASCII {
    
    /**
     * Find frequency of characters in a string using ASCII array
     * @param text The input text
     * @return 2D array containing characters and their frequencies
     */
    public static String[][] findCharacterFrequency(String text) {
        // Create an array to store frequency of characters (256 ASCII characters)
        int[] frequency = new int[256];
        
        // Loop through the text to find frequency of characters
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
        // Count the number of unique characters
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                uniqueCount++;
            }
        }
        
        // Create 2D array to store characters and their frequencies
        String[][] result = new String[uniqueCount][2];
        int index = 0;
        
        // Loop through and store characters and their frequencies
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                result[index][0] = String.valueOf((char) i);
                result[index][1] = String.valueOf(frequency[i]);
                index++;
            }
        }
        
        return result;
    }
    
    /**
     * Display character frequency in tabular format
     * @param frequencyData 2D array containing frequency data
     */
    public static void displayFrequencyTable(String[][] frequencyData) {
        System.out.println("\n================================");
        System.out.println("Character | Frequency");
        System.out.println("================================");
        
        for (String[] row : frequencyData) {
            if (row[0].equals(" ")) {
                System.out.printf("  (space) |    %s%n", row[1]);
            } else {
                System.out.printf("    %s     |    %s%n", row[0], row[1]);
            }
        }
        
        System.out.println("================================");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Find character frequency
        String[][] frequencyData = findCharacterFrequency(text);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Original String: " + text);
        System.out.println("Length: " + text.length());
        
        displayFrequencyTable(frequencyData);
        
        scanner.close();
    }
}
