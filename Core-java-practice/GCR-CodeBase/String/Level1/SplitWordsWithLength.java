import java.util.Scanner;

/**
 * Program to split text into words and return words with their lengths in 2D array
 */
public class SplitWordsWithLength {
    
    /**
     * Find string length without using built-in length() method
     * @param text The input text
     * @return Length of the string
     */
    public static int findStringLength(String text) {
        int count = 0;
        try {
            for (int i = 0; ; i++) {
                text.charAt(i);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    /**
     * Split text into words using charAt() method
     * @param text The input text
     * @return Array of words
     */
    public static String[] splitTextIntoWords(String text) {
        int textLength = findStringLength(text);
        
        // Count words by counting spaces
        int wordCount = 1;
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        
        // Create array to store space indexes
        int[] spaceIndexes = new int[wordCount + 1];
        spaceIndexes[0] = -1;
        int spaceCount = 1;
        
        // Find indexes of all spaces
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[spaceCount] = i;
                spaceCount++;
            }
        }
        spaceIndexes[wordCount] = textLength;
        
        // Create array to store words
        String[] words = new String[wordCount];
        
        // Extract words using space indexes
        for (int i = 0; i < wordCount; i++) {
            int startIndex = spaceIndexes[i] + 1;
            int endIndex = spaceIndexes[i + 1];
            
            String word = "";
            for (int j = startIndex; j < endIndex; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }
        
        return words;
    }
    
    /**
     * Create 2D array with words and their lengths
     * @param words Array of words
     * @return 2D array with word and length
     */
    public static String[][] createWordLengthArray(String[] words) {
        String[][] wordLength = new String[words.length][2];
        
        for (int i = 0; i < words.length; i++) {
            wordLength[i][0] = words[i];
            wordLength[i][1] = String.valueOf(findStringLength(words[i]));
        }
        
        return wordLength;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        
        // Split text into words
        String[] words = splitTextIntoWords(text);
        
        // Create 2D array with words and lengths
        String[][] wordLength = createWordLengthArray(words);
        
        // Display results in tabular format
        System.out.println("\n--- Results ---");
        System.out.println("Original Text: " + text);
        
        System.out.println("\n=====================================================");
        System.out.println("Word                      | Length");
        System.out.println("=====================================================");
        
        for (String[] row : wordLength) {
            System.out.printf("%-25s | %s%n", row[0], row[1]);
        }
        
        System.out.println("=====================================================");
        
        scanner.close();
    }
}
