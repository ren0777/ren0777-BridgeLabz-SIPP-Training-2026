// Problem 10: Generate All Permutations of a String
// Generate all possible permutations of a string recursively.

public class StringPermutations {
    public static void generatePermutations(String text, String answer) {
        if (text.length() == 0) {
            System.out.println(answer);
            return;
        }

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            String remaining = text.substring(0, i) + text.substring(i + 1);
            generatePermutations(remaining, answer + current);
        }
    }

    public static void main(String[] args) {
        String text = "ABC";
        generatePermutations(text, "");
    }
}
