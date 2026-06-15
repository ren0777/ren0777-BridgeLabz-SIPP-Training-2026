import java.util.Scanner;

/**
 * Program to find frequency of characters using nested loops
 */
public class CharacterFrequencyNested {
    
    /**
     * Find frequency of characters using nested loops
     * @param text The input text
     * @return 1D String array with characters and their frequencies
     */
    public static String[] findCharacterFrequency(String text) {
        char[] charArray = text.toCharArray();
        int[] frequency = new int[charArray.length];
        
        // Nested loop to find frequency of each character
        for (int i = 0; i < charArray.length; i++) {
            if (frequency[i] == 0) { // Not yet counted
                frequency[i] = 1;
                
                // Inner loop to check for duplicate characters
                for (int j = i + 1; j < charArray.length; j++) {
                    if (charArray[i] == charArray[j]) {
                        frequency[i]++;
                        charArray[j] = '0'; // Mark duplicate to avoid counting again
                    }
                }
            }
        }
        
        // Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '0' && frequency[i] > 0) {
                uniqueCount++;
            }
        }
        
        // Create result array to store characters and frequencies
        String[] result = new String[uniqueCount];
        int index = 0;
        
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '0' && frequency[i] > 0) {
                result[index] = charArray[i] + " - " + frequency[i];
                index++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        // Find character frequency using nested loops
        String[] frequencyResult = findCharacterFrequency(text);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Original String: " + text);
        System.out.println("Length: " + text.length());
        System.out.println("\n================================");
        System.out.println("Character | Frequency");
        System.out.println("================================");
        
        for (String result : frequencyResult) {
            String[] parts = result.split(" - ");
            if (parts[0].equals(" ")) {
                System.out.printf("  (space) |    %s%n", parts[1]);
            } else {
                System.out.printf("    %s     |    %s%n", parts[0], parts[1]);
            }
        }
        
        System.out.println("================================");
        
        scanner.close();
    }
}
