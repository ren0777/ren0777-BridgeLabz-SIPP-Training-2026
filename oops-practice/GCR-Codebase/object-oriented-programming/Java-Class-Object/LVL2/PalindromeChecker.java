class PalindromeChecker {
    String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    boolean isPalindrome() {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);
    }

    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        PalindromeChecker pc1 = new PalindromeChecker("madam");
        pc1.displayResult();

        PalindromeChecker pc2 = new PalindromeChecker("hello");
        pc2.displayResult();
    }
}
