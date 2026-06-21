// Problem 4: Reverse a String Using Recursion
// Write a recursive function to reverse a given string.

public class ReverseString {
    public static String reverse(String text) {
        if (text == null || text.length() <= 1) {
            return text;
        }

        return reverse(text.substring(1)) + text.charAt(0);
    }

    public static void main(String[] args) {
        String text = "hello";
        System.out.println(reverse(text));
    }
}
