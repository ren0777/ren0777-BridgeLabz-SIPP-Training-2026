import java.util.Scanner;

/**
 * Program to find shortest and longest words in a text
 */
public class ShortestLongestWord {
    
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
    
    /**
     * Find shortest and longest words
     * @param wordLength 2D array with words and lengths
     * @return Array containing {shortestLength, longestLength}
     */
    public static int[] findShortestAndLongest(String[][] wordLength) {
        int[] result = new int[2];
        
        int shortestLength = Integer.MAX_VALUE;
        int longestLength = Integer.MIN_VALUE;
        String shortestWord = "";
        String longestWord = "";
        
        for (String[] row : wordLength) {
            int length = Integer.parseInt(row[1]);
            
            if (length < shortestLength) {
                shortestLength = length;
                shortestWord = row[0];
            }
            
            if (length > longestLength) {
                longestLength = length;
                longestWord = row[0];
            }
        }
        
        // Store results (we'll print them separately)
        System.out.println("Shortest Word: " + shortestWord + " (Length: " + shortestLength + ")");
        System.out.println("Longest Word: " + longestWord + " (Length: " + longestLength + ")");
        
        result[0] = shortestLength;
        result[1] = longestLength;
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        
        // Split text into words
        String[] words = splitTextIntoWords(text);
        
        // Create 2D array with words and lengths
        String[][] wordLength = createWordLengthArray(words);
        
        // Display word list
        System.out.println("\n--- All Words ---");
        System.out.println("=====================================================");
        System.out.println("Word                      | Length");
        System.out.println("=====================================================");
        
        for (String[] row : wordLength) {
            System.out.printf("%-25s | %s%n", row[0], row[1]);
        }
        
        System.out.println("=====================================================");
        
        // Find and display shortest and longest
        System.out.println("\n--- Shortest and Longest Words ---");
        int[] result = findShortestAndLongest(wordLength);
        
        scanner.close();
    }
}
