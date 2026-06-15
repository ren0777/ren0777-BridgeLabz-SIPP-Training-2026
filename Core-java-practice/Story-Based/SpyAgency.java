import java.util.*;

public class SpyAgency {

    public static String reverseMessage(String message) {
        return new StringBuilder(message).reverse().toString();
    }

    public static boolean isPalindrome(String message) {
        String reversed = reverseMessage(message);
        return message.equalsIgnoreCase(reversed);
    }

    public static void countVowelsConsonants(String message) {
        int vowels = 0;
        int consonants = 0;

        message = message.toLowerCase();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static boolean areAnagrams(String s1, String s2) {
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static char firstNonRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter secret message: ");
        String message = sc.nextLine();

        System.out.println("Reversed Message: " + reverseMessage(message));

        if (isPalindrome(message)) {
            System.out.println("The message is a Palindrome.");
        } else {
            System.out.println("The message is NOT a Palindrome.");
        }

        countVowelsConsonants(message);

        System.out.print("\nEnter first intercept: ");
        String intercept1 = sc.nextLine();

        System.out.print("Enter second intercept: ");
        String intercept2 = sc.nextLine();

        if (areAnagrams(intercept1, intercept2)) {
            System.out.println("The intercepts are Anagrams.");
        } else {
            System.out.println("The intercepts are NOT Anagrams.");
        }

        System.out.print("\nEnter surveillance log: ");
        String log = sc.nextLine();

        char result = firstNonRepeatingChar(log);

        if (result != '\0') {
            System.out.println("First Non-Repeating Character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }
}