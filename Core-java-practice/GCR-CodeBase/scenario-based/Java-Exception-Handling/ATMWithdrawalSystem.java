import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class InsufficientBalanceException extends Exception {
    private double requestedAmount;
    private double availableBalance;
    private double shortfall;
    private String accountNumber;
    private LocalDateTime timestamp;

    InsufficientBalanceException(String accountNumber, double requestedAmount, double availableBalance) {
        super("Withdrawal Failed: Insufficient Balance");
        this.accountNumber = accountNumber;
        this.requestedAmount = requestedAmount;
        this.availableBalance = availableBalance;
        this.shortfall = requestedAmount - availableBalance;
        this.timestamp = LocalDateTime.now();
    }

    void displayDetails() {
        System.out.println("❌ WITHDRAWAL FAILED");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Requested Amount: ₹" + requestedAmount);
        System.out.println("Available Balance: ₹" + availableBalance);
        System.out.println("Shortfall: ₹" + shortfall);
        System.out.println("Time: " + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    double getShortfall() {
        return shortfall;
    }

    double getAvailableBalance() {
        return availableBalance;
    }
}

class ATMAccount {
    String accountNumber;
    String accountHolder;
    double balance;
    String pin;

    ATMAccount(String accountNumber, String accountHolder, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.pin = pin;
    }
}

class ATMWithdrawalSystem {
    static ATMAccount[] accounts = new ATMAccount[5];
    static int accountCount = 0;
    static ATMAccount currentAccount = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeAccounts();

        System.out.println("=== ATM Withdrawal System ===\n");

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("\nSelect option (1-2): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    login(scanner);
                    if (currentAccount != null) {
                        atmMenu(scanner);
                    }
                    break;
                case "2":
                    System.out.println("Thank you for using ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }

    static void initializeAccounts() {
        accounts[0] = new ATMAccount("ACC001", "Aditya Kumar", 5000, "1234");
        accounts[1] = new ATMAccount("ACC002", "Priya Singh", 10000, "5678");
        accounts[2] = new ATMAccount("ACC003", "Rahul Sharma", 3500, "9012");
        accountCount = 3;
    }

    static void login(Scanner scanner) {
        System.out.println("\n--- Login ---\n");

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine().trim();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine().trim();

        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].accountNumber.equals(accountNumber) && accounts[i].pin.equals(pin)) {
                currentAccount = accounts[i];
                System.out.println("\n✓ Login successful!");
                System.out.println("Welcome, " + currentAccount.accountHolder + "\n");
                return;
            }
        }

        System.out.println("❌ Invalid Account Number or PIN.\n");
    }

    static void atmMenu(Scanner scanner) {
        while (currentAccount != null) {
            System.out.println("--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Logout");
            System.out.print("\nSelect option (1-4): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    checkBalance();
                    break;
                case "2":
                    withdrawMoney(scanner);
                    break;
                case "3":
                    depositMoney(scanner);
                    break;
                case "4":
                    System.out.println("✓ Logged out successfully.\n");
                    currentAccount = null;
                    return;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }

    static void checkBalance() {
        System.out.println("\n--- Account Balance ---");
        System.out.println("Account Holder: " + currentAccount.accountHolder);
        System.out.println("Account Number: " + currentAccount.accountNumber);
        System.out.println("Current Balance: ₹" + currentAccount.balance + "\n");
    }

    static void withdrawMoney(Scanner scanner) {
        System.out.println("\n--- Withdrawal ---\n");

        try {
            System.out.print("Enter withdrawal amount: ₹");
            double withdrawalAmount = Double.parseDouble(scanner.nextLine().trim());

            if (withdrawalAmount <= 0) {
                System.out.println("❌ Withdrawal amount must be positive.\n");
                return;
            }

            if (withdrawalAmount > currentAccount.balance) {
                throw new InsufficientBalanceException(currentAccount.accountNumber, withdrawalAmount, currentAccount.balance);
            }

            currentAccount.balance -= withdrawalAmount;

            System.out.println("\n✓ WITHDRAWAL SUCCESSFUL");
            System.out.println("Amount Withdrawn: ₹" + withdrawalAmount);
            System.out.println("Remaining Balance: ₹" + currentAccount.balance);
            System.out.println("Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Please enter a valid amount.\n");
        } catch (InsufficientBalanceException e) {
            System.out.println();
            e.displayDetails();
            System.out.println("Please withdraw an amount ≤ ₹" + e.getAvailableBalance() + "\n");
        }
    }

    static void depositMoney(Scanner scanner) {
        System.out.println("\n--- Deposit ---\n");

        try {
            System.out.print("Enter deposit amount: ₹");
            double depositAmount = Double.parseDouble(scanner.nextLine().trim());

            if (depositAmount <= 0) {
                System.out.println("❌ Deposit amount must be positive.\n");
                return;
            }

            currentAccount.balance += depositAmount;

            System.out.println("\n✓ DEPOSIT SUCCESSFUL");
            System.out.println("Amount Deposited: ₹" + depositAmount);
            System.out.println("New Balance: ₹" + currentAccount.balance);
            System.out.println("Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Please enter a valid amount.\n");
        }
    }
}
