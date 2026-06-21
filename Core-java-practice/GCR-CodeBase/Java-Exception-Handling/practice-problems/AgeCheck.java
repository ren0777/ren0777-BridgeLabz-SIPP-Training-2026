// Problem 3: Custom Exception
// Validate age using a user-defined AgeException.

import java.util.Scanner;

public class AgeCheck {
    public static void validateAge(int age) throws AgeException {
        if (age < 18) {
            throw new AgeException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            validateAge(age);
            System.out.println("Access granted!");
        } catch (AgeException e) {
            System.out.println("Age must be 18 or above");
        } finally {
            scanner.close();
        }
    }
}
