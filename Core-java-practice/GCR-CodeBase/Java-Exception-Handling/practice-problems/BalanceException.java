// Custom exception used by Bank.

public class BalanceException extends Exception {
    public BalanceException(String message) {
        super(message);
    }
}
