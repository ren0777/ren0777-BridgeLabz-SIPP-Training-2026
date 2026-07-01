import java.util.Scanner;

class PasswordStrengthChecker {
    static final int MIN_LENGTH = 8;
    static final String SPECIAL_CHARS = "@#$%&*";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Password Strength Checker ===\n");

        displayPasswordRules();

        while (true) {
            System.out.print("\nEnter password (or 'quit' to exit): ");
            String password = scanner.nextLine();

            if (password.equalsIgnoreCase("quit")) {
                System.out.println("Thank you for using Password Strength Checker!");
                scanner.close();
                return;
            }

            try {
                checkPassword(password);
                System.out.println("✓ Password is STRONG and meets all requirements!\n");

            } catch (NullPointerException e) {
                System.out.println("❌ Error: " + e.getMessage() + "\n");

            } catch (IllegalArgumentException e) {
                System.out.println("❌ Invalid Password: " + e.getMessage() + "\n");

            } catch (Exception e) {
                System.out.println("❌ Unexpected Error: " + e.getMessage() + "\n");
            }
        }
    }

    static void displayPasswordRules() {
        System.out.println("--- Password Requirements ---");
        System.out.println("1. First character must be UPPERCASE (A-Z)");
        System.out.println("2. Last character must be a DIGIT (0-9)");
        System.out.println("3. Minimum length: " + MIN_LENGTH + " characters");
        System.out.println("4. Must contain at least ONE special character: " + SPECIAL_CHARS);
        System.out.println("5. Password cannot be null or empty\n");
    }

    static void checkPassword(String password) throws NullPointerException, IllegalArgumentException {
        try {
            if (password == null) {
                throw new NullPointerException("Password cannot be null!");
            }

            if (password.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be empty!");
            }

            validateLength(password);
            validateFirstCharacter(password);
            validateLastCharacter(password);
            validateSpecialCharacter(password);

        } catch (NullPointerException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    static void validateLength(String password) throws IllegalArgumentException {
        if (password.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(
                "Password too short! Length: " + password.length() + ", Required: " + MIN_LENGTH
            );
        }
    }

    static void validateFirstCharacter(String password) throws IllegalArgumentException {
        try {
            char firstChar = password.charAt(0);

            if (!Character.isUpperCase(firstChar)) {
                throw new IllegalArgumentException(
                    "First character must be UPPERCASE. Found: '" + firstChar + "'"
                );
            }

        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Password is empty!");
        }
    }

    static void validateLastCharacter(String password) throws IllegalArgumentException {
        try {
            char lastChar = password.charAt(password.length() - 1);

            if (!Character.isDigit(lastChar)) {
                throw new IllegalArgumentException(
                    "Last character must be a DIGIT (0-9). Found: '" + lastChar + "'"
                );
            }

        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Password is empty!");
        }
    }

    static void validateSpecialCharacter(String password) throws IllegalArgumentException {
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARS.indexOf(c) != -1) {
                hasSpecial = true;
                break;
            }
        }

        if (!hasSpecial) {
            throw new IllegalArgumentException(
                "Must contain at least one special character: " + SPECIAL_CHARS
            );
        }
    }

    static String analyzePassword(String password) {
        StringBuilder analysis = new StringBuilder();

        analysis.append("--- Password Analysis ---\n");
        analysis.append("Length: ").append(password.length()).append(" characters\n");

        char firstChar = password.charAt(0);
        analysis.append("First Character: '").append(firstChar).append("' - ");
        analysis.append(Character.isUpperCase(firstChar) ? "UPPERCASE ✓" : "NOT UPPERCASE ✗").append("\n");

        char lastChar = password.charAt(password.length() - 1);
        analysis.append("Last Character: '").append(lastChar).append("' - ");
        analysis.append(Character.isDigit(lastChar) ? "DIGIT ✓" : "NOT DIGIT ✗").append("\n");

        int specialCharCount = 0;
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARS.indexOf(c) != -1) {
                specialCharCount++;
            }
        }
        analysis.append("Special Characters: ").append(specialCharCount).append(" found - ");
        analysis.append(specialCharCount > 0 ? "✓" : "✗").append("\n");

        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        analysis.append("Total Digits: ").append(digitCount).append("\n");

        int uppercaseCount = 0;
        int lowercaseCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) uppercaseCount++;
            if (Character.isLowerCase(c)) lowercaseCount++;
        }
        analysis.append("Uppercase Letters: ").append(uppercaseCount).append("\n");
        analysis.append("Lowercase Letters: ").append(lowercaseCount).append("\n");

        return analysis.toString();
    }
}
