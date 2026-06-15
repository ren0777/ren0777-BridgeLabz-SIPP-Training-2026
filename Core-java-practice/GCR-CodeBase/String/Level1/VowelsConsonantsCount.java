import java.util.Scanner;

/**
 * Program to find and count vowels and consonants in a string
 */
public class VowelsConsonantsCount {
    
    /**
     * Check if character is vowel, consonant, or not a letter
     * @param ch The character to check
     * @return "Vowel", "Consonant", or "Not a Letter"
     */
    public static String checkCharacterType(char ch) {
        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        
        // Check if character is a vowel
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        }
        
        // Check if character is a consonant
        if (ch >= 'a' && ch <= 'z') {
            return "Consonant";
        }
        
        // Not a letter
        return "Not a Letter";
    }
    
    /**
     * Find vowels and consonants count in a string
     * @param text The input text
     * @return Array with {vowelsCount, consonantsCount}
     */
    public static int[] findVowelsConsonantsCount(String text) {
        int vowelsCount = 0;
        int consonantsCount = 0;
        
        // Count vowels and consonants using charAt() method
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String type = checkCharacterType(ch);
            
            if (type.equals("Vowel")) {
                vowelsCount++;
            } else if (type.equals("Consonant")) {
                consonantsCount++;
            }
        }
        
        return new int[]{vowelsCount, consonantsCount};
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        
        // Find vowels and consonants count
        int[] counts = findVowelsConsonantsCount(text);
        
        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Text: " + text);
        System.out.println("Total characters: " + text.length());
        System.out.println("Vowels count: " + counts[0]);
        System.out.println("Consonants count: " + counts[1]);
        System.out.println("Other characters: " + (text.length() - counts[0] - counts[1]));
        
        scanner.close();
    }
}
