// Sample Program 1: Bank Account System
// Concepts: static, this, final, instanceof

public class BankAccount {

    // 1. STATIC – shared across all BankAccount objects
    static String bankName      = "National Savings Bank";
    static int    totalAccounts = 0;

    // 3. FINAL – accountNumber cannot be changed once assigned
    final int accountNumber;

    String accountHolderName;
    double balance;

    // 2. THIS – resolves naming ambiguity between parameters and instance variables
    BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber     = accountNumber;      // 'this' differentiates field from param
        this.accountHolderName = accountHolderName;
        this.balance           = balance;
        totalAccounts++;
    }

    void deposit(double amount) {
        if (amount > 0) balance += amount;
        System.out.println("Deposited Rs." + amount + " | Balance: Rs." + balance);
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn Rs." + amount + " | Balance: Rs." + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    void display() {
        System.out.println("Bank          : " + bankName);
        System.out.println("Account No    : " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance       : Rs." + balance);
    }

    // 1. STATIC METHOD – called on the class, not an object
    static void getTotalAccounts() {
        System.out.println("Total Accounts Created: " + totalAccounts);
    }

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount(1001, "Riya Sharma",  50000.0);
        BankAccount acc2 = new BankAccount(1002, "Arjun Mehta",  30000.0);
        Object         obj  = "I am a String, not a BankAccount";

        // 4. INSTANCEOF – verify object type before calling display()
        System.out.println("=== Account 1 ===");
        if (acc1 instanceof BankAccount) {
            acc1.display();
        }

        System.out.println("\n=== Account 2 ===");
        if (acc2 instanceof BankAccount) {
            acc2.display();
            acc2.deposit(5000.0);
            acc2.withdraw(2000.0);
        }

        System.out.println("\n=== instanceof check on non-BankAccount object ===");
        if (!(obj instanceof BankAccount)) {
            System.out.println("Object is NOT a BankAccount instance. Skipping.");
        }

        System.out.println();
        BankAccount.getTotalAccounts();   // static method call

        // Prove final – uncommenting the line below causes a compile error:
        // acc1.accountNumber = 9999;  // ERROR: cannot assign a value to final variable
    }
}
