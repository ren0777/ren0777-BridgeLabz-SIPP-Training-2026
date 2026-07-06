class InsufficientBalanceException extends Exception {
    private final double availableBalance;
    private final double requestedAmount;
    private final double shortage;

    public InsufficientBalanceException(double availableBalance, double requestedAmount) {
        super("Insufficient balance: available Rs." + availableBalance
                + ", requested Rs." + requestedAmount
                + ", shortage Rs." + (requestedAmount - availableBalance));
        this.availableBalance = availableBalance;
        this.requestedAmount = requestedAmount;
        this.shortage = requestedAmount - availableBalance;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }

    public double getShortage() {
        return shortage;
    }
}

public class ATMWithdrawalSystem {
    static void withdraw(double balance, double amount)
            throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }

        double remainingBalance = balance - amount;
        System.out.println("Withdrawal successful. Remaining balance: Rs." + remainingBalance);
    }

    public static void main(String[] args) {
        double accountBalance = 5000;
        double withdrawalRequest = 8000;

        try {
            withdraw(accountBalance, withdrawalRequest);
        } catch (InsufficientBalanceException e) {
            System.out.println("ATM Error: " + e.getMessage());
            System.out.println("Available: Rs." + e.getAvailableBalance());
            System.out.println("Requested: Rs." + e.getRequestedAmount());
            System.out.println("Shortage: Rs." + e.getShortage());
        }
    }
}
