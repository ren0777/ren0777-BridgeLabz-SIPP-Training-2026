import java.util.Scanner;

/**
 * Program to find frequency of characters using unique characters
 */
public class CharacterFrequencyUnique {
    
    /**
     * Find unique characters in a string using charAt() method
     * @param text The input text
     * @return 1D array containing unique characters
     */
    public static char[] findUniqueCharacters(String text) {
        char[] tempArray = new char[text.length()];
        int uniqueCount = 0;
        
        // Outer loop: iterate through each character
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;
            
            // Inner loop: check if character is unique
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }
            
            // If character is unique, store it
            if (isUnique) {
                tempArray[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }
        
        // Create a new array with only unique characters
        char[] resultArray = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            resultArray[i] = tempArray[i];
        }
        
        return resultArray;
    }
    
    /**
     * Find frequency of characters in a string using unique characters
     * @param text The input text
     * @return 2D array containing unique characters and their frequencies
     */
    public static String[][] findCharacterFrequency(String text) {
        // Create frequency array for 256 ASCII characters
        int[] frequency = new int[256];
        
        // Loop through text to find frequency
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
        // Find unique characters
        char[] uniqueChars = findUniqueCharacters(text);
        
        // Create 2D array to store unique characters and their frequencies
        String[][] result = new String[uniqueChars.length][2];
        
        // Loop through unique characters and store with frequencies
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]);
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
        
        // Find character frequency using unique characters
        String[][] frequencyData = findCharacterFrequency(text);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Original String: " + text);
        System.out.println("Length: " + text.length());
        System.out.println("Unique Characters: " + frequencyData.length);
        
        displayFrequencyTable(frequencyData);
        
        scanner.close();
    }
}
