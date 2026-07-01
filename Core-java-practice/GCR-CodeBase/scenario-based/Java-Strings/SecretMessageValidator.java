import java.util.Scanner;

public class SecretMessageValidator {

    static int countVowels(String code) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : code.toCharArray()) {
            if (vowels.indexOf(c) != -1) count++;
        }
        return count;
    }

    static int countConsonants(String code) {
        int count = 0;
        for (char c : code.toCharArray()) {
            if (Character.isLetter(c) && "aeiouAEIOU".indexOf(c) == -1) count++;
        }
        return count;
    }

    static int countDigits(String code) {
        int count = 0;
        for (char c : code.toCharArray()) {
            if (Character.isDigit(c)) count++;
        }
        return count;
    }

    static int countSpecialCharacters(String code) {
        int count = 0;
        for (char c : code.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != ' ') count++;
        }
        return count;
    }

    static String evaluateStrength(String code) {
        int digits = countDigits(code);
        int special = countSpecialCharacters(code);
        int length = code.length();

        if (digits >= 2 && special >= 1 && length >= 8) {
            return "STRONG";
        } else {
            return "WEAK";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Secret Code: ");
        String code = sc.nextLine();

        int vowels = countVowels(code);
        int consonants = countConsonants(code);
        int digits = countDigits(code);
        int special = countSpecialCharacters(code);
        String strength = evaluateStrength(code);

        System.out.println("\n========================================");
        System.out.println("       SECRET MESSAGE VALIDATOR         ");
        System.out.println("========================================");
        System.out.println("Secret Code      : " + code);
        System.out.println("Total Length     : " + code.length());
        System.out.println("----------------------------------------");
        System.out.println("Vowels           : " + vowels);
        System.out.println("Consonants       : " + consonants);
        System.out.println("Digits           : " + digits);
        System.out.println("Special Chars    : " + special);
        System.out.println("----------------------------------------");
        System.out.println("Criteria Check:");
        System.out.println("  Min Length 8   : " + (code.length() >= 8 ? "PASS" : "FAIL"));
        System.out.println("  Min 2 Digits   : " + (digits >= 2 ? "PASS" : "FAIL"));
        System.out.println("  Min 1 Special  : " + (special >= 1 ? "PASS" : "FAIL"));
        System.out.println("----------------------------------------");
        System.out.println("Code Strength    : " + strength);
        System.out.println("========================================");

        sc.close();
    }
}
