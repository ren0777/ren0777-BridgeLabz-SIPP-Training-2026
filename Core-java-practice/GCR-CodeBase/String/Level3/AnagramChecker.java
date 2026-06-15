import java.util.Scanner;

/**
 * Program to check if two texts are anagrams
 * An anagram is formed by rearranging letters to form different words or phrases
 */
public class AnagramChecker {
    
    /**
     * Check if two texts are anagrams
     * @param text1 First text
     * @param text2 Second text
     * @return true if anagrams, false otherwise
     */
    public static boolean areAnagrams(String text1, String text2) {
        // Remove spaces and convert to lowercase for comparison
        String str1 = text1.replaceAll(" ", "").toLowerCase();
        String str2 = text2.replaceAll(" ", "").toLowerCase();
        
        // Check if lengths are equal
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Create arrays to store frequency of characters
        int[] frequency1 = new int[256];
        int[] frequency2 = new int[256];
        
        // Find frequency of characters in first text
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            frequency1[ch]++;
        }
        
        // Find frequency of characters in second text
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            frequency2[ch]++;
        }
        
        // Compare frequencies
        for (int i = 0; i < 256; i++) {
            if (frequency1[i] != frequency2[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Display character frequency for a given text
     * @param text The input text
     */
    public static void displayCharacterFrequency(String text) {
        String cleanText = text.replaceAll(" ", "").toLowerCase();
        int[] frequency = new int[256];
        
        // Find frequency of characters
        for (int i = 0; i < cleanText.length(); i++) {
            char ch = cleanText.charAt(i);
            frequency[ch]++;
        }
        
        System.out.println("\nCharacter Frequency for \"" + text + "\":");
        System.out.println("================================");
        System.out.println("Character | Frequency");
        System.out.println("================================");
        
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                System.out.printf("    %c     |    %d%n", (char) i, frequency[i]);
            }
        }
        
        System.out.println("================================");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first text: ");
        String text1 = scanner.nextLine();
        
        System.out.print("Enter second text: ");
        String text2 = scanner.nextLine();
        
        // Check if texts are anagrams
        boolean result = areAnagrams(text1, text2);
        
        // Display results
        System.out.println("\n--- Anagram Check Results ---");
        System.out.println("Text 1: " + text1);
        System.out.println("Text 2: " + text2);
        
        displayCharacterFrequency(text1);
        displayCharacterFrequency(text2);
        
        System.out.println("\n--- Conclusion ---");
        if (result) {
            System.out.println("\"" + text1 + "\" and \"" + text2 + "\" are ANAGRAMS!");
        } else {
            System.out.println("\"" + text1 + "\" and \"" + text2 + "\" are NOT anagrams.");
        }
        
        scanner.close();
    }
}
