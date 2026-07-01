import java.util.Scanner;

public class UsernameValidator {

    static boolean containsSpaces(String username) {
        return username.contains(" ");
    }

    static int countCharacters(String username) {
        return username.length();
    }

    static String convertToUppercase(String username) {
        return username.toUpperCase();
    }

    static boolean isPalindrome(String username) {
        String lower = username.toLowerCase();
        String reversed = new StringBuilder(lower).reverse().toString();
        return lower.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        boolean hasSpaces = containsSpaces(username);
        int charCount = countCharacters(username);
        String upper = convertToUppercase(username);
        boolean palindrome = isPalindrome(username);

        System.out.println("\n========================================");
        System.out.println("         USERNAME VALIDATOR REPORT      ");
        System.out.println("========================================");
        System.out.println("Username         : " + username);
        System.out.println("Uppercase        : " + upper);
        System.out.println("Total Characters : " + charCount);
        System.out.println("Contains Spaces  : " + (hasSpaces ? "YES" : "NO"));
        System.out.println("Is Palindrome    : " + (palindrome ? "YES" : "NO"));
        System.out.println("----------------------------------------");

        if (hasSpaces) {
            System.out.println("Status : INVALID - Username must not contain spaces.");
        } else {
            System.out.println("Status : VALID Username.");
        }

        System.out.println("========================================");
        sc.close();
    }
}
