public class BankAccount {

    private String accountNumber;
    private String holder;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(holder + " deposited: " + amount + " | Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println(holder + " withdrawal failed. Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println(holder + " withdrew: " + amount + " | Balance: " + balance);
        }
    }

    public void getStatement() {
        System.out.println("Account: " + accountNumber + " | Holder: " + holder + " | Balance: " + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("ACC001", "Alice", 5000);
        BankAccount a2 = new BankAccount("ACC002", "Bob", 3000);
        BankAccount a3 = new BankAccount("ACC003", "Charlie", 7000);

        a1.deposit(1000);
        a1.withdraw(500);
        a1.deposit(200);
        a1.withdraw(6000);
        a1.withdraw(300);

        a2.deposit(500);
        a2.withdraw(1000);
        a2.deposit(800);
        a2.withdraw(200);
        a2.deposit(100);

        a3.withdraw(2000);
        a3.deposit(1500);
        a3.withdraw(500);
        a3.deposit(300);
        a3.withdraw(100);

        System.out.println("\n--- Statements ---");
        a1.getStatement();
        a2.getStatement();
        a3.getStatement();

        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());
    }
}
