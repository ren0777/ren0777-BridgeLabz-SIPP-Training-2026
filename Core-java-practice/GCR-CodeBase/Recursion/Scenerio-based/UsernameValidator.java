// Scenario 2: Username Validator
// Recursively verify whether a username contains only lowercase letters.

public class UsernameValidator {
    public static boolean isValidUsername(String username, int index) {
        if (index == username.length()) {
            return true;
        }

        char current = username.charAt(index);
        if (current < 'a' || current > 'z') {
            return false;
        }

        return isValidUsername(username, index + 1);
    }

    public static void main(String[] args) {
        String username = "abcdxyz";
        System.out.println(isValidUsername(username, 0));
    }
}
