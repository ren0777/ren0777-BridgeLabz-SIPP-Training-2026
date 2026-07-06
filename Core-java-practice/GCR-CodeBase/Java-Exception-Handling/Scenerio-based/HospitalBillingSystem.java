class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {

    static double calculateAverageItemCost(double totalBill, int items) {
        try {
            if (items == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return totalBill / items;
        } catch (ArithmeticException e) {
            System.out.println("Billing Error: Number of items cannot be zero.");
            return -1;
        }
    }

    static String getPatientByIndex(String[] patients, int index) {
        try {
            return patients[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Patient Error: Invalid patient index " + index + ".");
            return "UNKNOWN";
        }
    }

    static int parseBillingInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Input Error: '" + input + "' is not a valid number.");
            return -1;
        }
    }

    static void processPayment(double billAmount, double payment)
            throws InsufficientFundsException {
        if (payment < billAmount) {
            throw new InsufficientFundsException(
                    "Payment failed: Required Rs." + billAmount
                            + ", received Rs." + payment + ".");
        }

        System.out.println("Payment successful.");
    }

    public static void main(String[] args) {
        double avgCost = calculateAverageItemCost(5000, 0);
        System.out.println("Average item cost: " + avgCost);

        String[] patients = {"Aadi", "Faizan", "Rahul"};
        String patient = getPatientByIndex(patients, 5);
        System.out.println("Selected patient: " + patient);

        int parsedAmount = parseBillingInput("ABC");
        System.out.println("Parsed amount: " + parsedAmount);

        try {
            processPayment(10000, 5000);
        } catch (InsufficientFundsException e) {
            System.out.println("Payment Error: " + e.getMessage());
        }

        System.out.println("System continues running safely.");
    }
}
