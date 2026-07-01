import java.util.Scanner;
import java.util.Arrays;

public class WordMatchSystem {

    static boolean areAnagrams(String word1, String word2) {
        String w1 = word1.toLowerCase().trim();
        String w2 = word2.toLowerCase().trim();

        if (w1.length() != w2.length()) return false;

        char[] arr1 = w1.toCharArray();
        char[] arr2 = w2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    static String toUppercase(String word) {
        return word.toUpperCase();
    }

    static int getLength(String word) {
        return word.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Skill Keyword  : ");
        String word1 = sc.nextLine();

        System.out.print("Enter Second Skill Keyword : ");
        String word2 = sc.nextLine();

        boolean anagram = areAnagrams(word1, word2);
        String upper1 = toUppercase(word1);
        String upper2 = toUppercase(word2);
        int len1 = getLength(word1);
        int len2 = getLength(word2);

        System.out.println("\n========================================");
        System.out.println("          WORD MATCH SYSTEM             ");
        System.out.println("========================================");
        System.out.println("Keyword 1        : " + upper1);
        System.out.println("Keyword 2        : " + upper2);
        System.out.println("----------------------------------------");
        System.out.println("Length of Keyword 1 : " + len1);
        System.out.println("Length of Keyword 2 : " + len2);
        System.out.println("----------------------------------------");
        System.out.println("Are Anagrams     : " + (anagram ? "YES" : "NO"));
        System.out.println("----------------------------------------");

        if (anagram) {
            System.out.println("Result : Both skill keywords are ANAGRAMS.");
            System.out.println("         Candidate has matching skill sets!");
        } else {
            System.out.println("Result : Keywords are NOT ANAGRAMS.");
            System.out.println("         Skill keywords do not match.");
        }

        System.out.println("========================================");
        sc.close();
    }
}
