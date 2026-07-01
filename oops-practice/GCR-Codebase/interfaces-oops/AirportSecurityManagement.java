interface LuggageScanner {
    boolean scanLuggage(String passengerName, double luggageWeight);

    default void displaySecurityGuidelines() {
        System.out.println("LuggageScanner: Max allowed luggage is 25 kg. No sharp or liquid items above 100ml.");
    }
}

interface PassportVerifier {
    boolean verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("PassportVerifier: Passport must be valid, not expired, and 8 characters long.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.length() == 8 && passportNo.matches("[A-Z0-9]+");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {

    @Override
    public boolean scanLuggage(String passengerName, double luggageWeight) {
        return luggageWeight <= 25.0;
    }

    @Override
    public boolean verifyPassport(String passportNo) {
        return PassportVerifier.isPassportNumberValid(passportNo);
    }

    @Override
    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }
}

public class AirportSecurityManagement {
    public static void main(String[] args) {
        AirportSecuritySystem security = new AirportSecuritySystem();

        String[] passengerNames = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        String[] passportNumbers = {"AB123456", "CD78", "EF901234", "GH567890", "ij!@#$%^"};
        double[] luggageWeights = {20.0, 30.0, 15.0, 25.0, 22.5};

        security.displaySecurityGuidelines();
        System.out.println("\n--- Passenger Boarding Status ---");

        for (int i = 0; i < passengerNames.length; i++) {
            boolean luggageOk = security.scanLuggage(passengerNames[i], luggageWeights[i]);
            boolean passportOk = security.verifyPassport(passportNumbers[i]);

            System.out.println("\nPassenger: " + passengerNames[i]);
            System.out.println("  Passport (" + passportNumbers[i] + "): " + (passportOk ? "VALID" : "INVALID"));
            System.out.println("  Luggage (" + luggageWeights[i] + " kg): " + (luggageOk ? "CLEARED" : "OVERWEIGHT"));
            System.out.println("  Boarding Status: " + (luggageOk && passportOk ? "ALLOWED" : "DENIED"));
        }
    }
}
