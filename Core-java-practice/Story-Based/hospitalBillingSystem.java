// A hospital billing system must never crash. Wrap division-by-zero
// (bills with zero items), array out-of-bounds (invalid patient index),
// and number format exceptions (bad input) with meaningful
// messages. Create a custom InsufficientFundsException for payment
// failures.

class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {

    static void processPayment(double billAmount, double payment)
            throws InsufficientFundsException {

        if (payment < billAmount) {
            throw new InsufficientFundsException(
                    "Payment amount is insufficient.");
        }

        System.out.println("Payment Successful!");
    }

    public static void main(String[] args) {

        try {

            int totalBill = 5000;
            int items = 0;

            int avgCost = totalBill / items;

            System.out.println(avgCost);

        } catch (ArithmeticException e) {

            System.out.println(
                    "Cannot calculate bill. Number of items cannot be zero.");
        }

        try {

            String[] patients = {
                    "Aadi",
                    "Faizan",
                    "Rahul"
            };

            System.out.println(patients[5]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                    "Invalid patient index selected.");
        }

        try {

            String input = "ABC";

            int amount = Integer.parseInt(input);

            System.out.println(amount);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter a valid numeric value.");
        }

        try {

            processPayment(10000, 5000);

        } catch (InsufficientFundsException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\nSystem continues running safely...");
    }
}
