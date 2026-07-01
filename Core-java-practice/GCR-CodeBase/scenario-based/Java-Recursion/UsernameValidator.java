import java.util.Scanner;

class UsernameValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Username Validator ===\n");
        System.out.println("Rules: Username must contain ONLY lowercase letters (a-z)");
        System.out.println("No numbers, uppercase, or special characters allowed.\n");

        while (true) {
            System.out.print("Enter username (or 'quit' to exit): ");
            String username = scanner.nextLine().trim();

            if (username.equalsIgnoreCase("quit")) {
                break;
            }

            if (username.isEmpty()) {
                System.out.println("❌ Username cannot be empty.\n");
                continue;
            }

            boolean isValid = isValidUsername(username, 0);
            displayValidationResult(username, isValid);
        }

        System.out.println("\nThank you for using Username Validator!");
        scanner.close();
    }

    static boolean isValidUsername(String username, int index) {
        if (index == username.length()) {
            return true;
        }

        char currentChar = username.charAt(index);

        if (currentChar < 'a' || currentChar > 'z') {
            return false;
        }

        return isValidUsername(username, index + 1);
    }

    static void displayValidationResult(String username, boolean isValid) {
        if (isValid) {
            System.out.println("✓ VALID: \"" + username + "\" is a valid username.");
        } else {
            System.out.println("✗ INVALID: \"" + username + "\" contains invalid characters.");
            findInvalidCharacters(username, 0);
        }
        System.out.println();
    }

    static void findInvalidCharacters(String username, int index) {
        if (index == username.length()) {
            return;
        }

        char currentChar = username.charAt(index);

        if (currentChar < 'a' || currentChar > 'z') {
            if (currentChar >= 'A' && currentChar <= 'Z') {
                System.out.println("  Position " + index + ": '" + currentChar + "' (uppercase letter)");
            } else if (currentChar >= '0' && currentChar <= '9') {
                System.out.println("  Position " + index + ": '" + currentChar + "' (digit)");
            } else {
                System.out.println("  Position " + index + ": '" + currentChar + "' (special character)");
            }
        }

        findInvalidCharacters(username, index + 1);
    }
}
