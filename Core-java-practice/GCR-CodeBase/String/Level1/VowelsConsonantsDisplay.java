import java.util.Scanner;

/**
 * Program to find vowels and consonants and display character type
 */
public class VowelsConsonantsDisplay {
    
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
     * Find vowels and consonants in a string and return 2D array
     * @param text The input text
     * @return 2D array with character and its type
     */
    public static String[][] findVowelsConsonants(String text) {
        String[][] result = new String[text.length()][2];
        
        // Store each character and its type
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacterType(ch);
        }
        
        return result;
    }
    
    /**
     * Display 2D array in tabular format
     * @param data 2D array with character and type
     */
    public static void displayCharacterTypeTable(String[][] data) {
        System.out.println("\n=====================================================");
        System.out.println("Index | Character | Type");
        System.out.println("=====================================================");
        
        for (int i = 0; i < data.length; i++) {
            String ch = data[i][0];
            if (ch.equals(" ")) {
                ch = "(space)";
            }
            System.out.printf("%5d |    %s     | %s%n", (i + 1), ch, data[i][1]);
        }
        
        System.out.println("=====================================================");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        
        // Find vowels and consonants
        String[][] characterData = findVowelsConsonants(text);
        
        // Display in tabular format
        System.out.println("\n--- Results ---");
        System.out.println("Text: " + text);
        
        displayCharacterTypeTable(characterData);
        
        // Count summary
        int vowels = 0, consonants = 0, others = 0;
        for (String[] row : characterData) {
            if (row[1].equals("Vowel")) vowels++;
            else if (row[1].equals("Consonant")) consonants++;
            else others++;
        }
        
        System.out.println("\n--- Summary ---");
        System.out.println("Total Vowels: " + vowels);
        System.out.println("Total Consonants: " + consonants);
        System.out.println("Total Others: " + others);
        
        scanner.close();
    }
}
