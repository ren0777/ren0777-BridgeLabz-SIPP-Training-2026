// Problem 10: Bank Transaction System
// Handle checked custom exception and invalid withdrawal amount.

import java.util.Scanner;

public class Bank {
    private double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws BalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        if (amount > balance) {
            throw new BalanceException("Insufficient balance!");
        }

        balance = balance - amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank account = new Bank(5000);

        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } catch (BalanceException e) {
            System.out.println("Insufficient balance!");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid amount!");
        } finally {
            scanner.close();
        }
    }
}
