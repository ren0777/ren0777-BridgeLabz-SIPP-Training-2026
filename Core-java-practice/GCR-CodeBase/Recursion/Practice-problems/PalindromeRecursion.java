// Problem 5: Check Palindrome Using Recursion
// Determine whether a string is palindrome using recursion.

public class PalindromeRecursion {
    public static boolean isPalindrome(String text, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return isPalindrome(text, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String text = "madam";

        if (isPalindrome(text, 0, text.length() - 1)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
