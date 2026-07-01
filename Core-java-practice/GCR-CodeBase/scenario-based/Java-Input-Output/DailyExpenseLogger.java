import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

class DailyExpenseLogger {
    static final String EXPENSE_FILE = "expenses.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Daily Expense Logger ===\n");

        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Daily Summary");
            System.out.println("4. Exit");
            System.out.print("\nSelect option (1-4): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addExpense(scanner);
                    break;
                case "2":
                    viewAllExpenses();
                    break;
                case "3":
                    viewDailySummary();
                    break;
                case "4":
                    System.out.println("Thank you for using Expense Logger!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }

    static void addExpense(Scanner scanner) {
        System.out.println("\n--- Add New Expense ---\n");

        System.out.print("Enter expense category (Food/Travel/Shopping/etc): ");
        String category = scanner.nextLine().trim();

        System.out.print("Enter amount: ₹");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine().trim());
            if (amount <= 0) {
                System.out.println("Amount must be positive.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount.\n");
            return;
        }

        String date = LocalDate.now().toString();
        String expenseEntry = date + " | " + category + " - " + amount;

        try (FileWriter fw = new FileWriter(EXPENSE_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(expenseEntry);
            bw.newLine();

            System.out.println("✓ Expense recorded: " + category + " - ₹" + amount + "\n");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage() + "\n");
        }
    }

    static void viewAllExpenses() {
        System.out.println("\n--- All Expenses ---\n");

        try (BufferedReader br = new BufferedReader(new FileReader(EXPENSE_FILE))) {

            String line;
            int count = 0;
            double totalExpense = 0;

            System.out.println("Date       | Category              | Amount");
            System.out.println("-".repeat(55));

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length == 2) {
                    String date = parts[0];
                    String[] details = parts[1].split(" - ");

                    if (details.length == 2) {
                        String category = details[0];
                        double amount = Double.parseDouble(details[1]);

                        System.out.printf("%s | %-20s | ₹%.2f%n", date, category, amount);
                        totalExpense += amount;
                        count++;
                    }
                }
            }

            System.out.println("-".repeat(55));
            System.out.printf("Total Expenses (%d entries): ₹%.2f%n\n", count, totalExpense);

        } catch (FileNotFoundException e) {
            System.out.println("❌ No expenses recorded yet.\n");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage() + "\n");
        }
    }

    static void viewDailySummary() {
        System.out.println("\n--- Daily Summary (Today) ---\n");

        String today = LocalDate.now().toString();
        try (BufferedReader br = new BufferedReader(new FileReader(EXPENSE_FILE))) {

            String line;
            double dailyTotal = 0;
            int expenseCount = 0;

            while ((line = br.readLine()) != null) {
                if (line.startsWith(today)) {
                    String[] parts = line.split(" \\| ");
                    if (parts.length == 2) {
                        String[] details = parts[1].split(" - ");
                        if (details.length == 2) {
                            double amount = Double.parseDouble(details[1]);
                            dailyTotal += amount;
                            expenseCount++;

                            System.out.println("✓ " + details[0] + " - ₹" + amount);
                        }
                    }
                }
            }

            System.out.println("-".repeat(40));
            if (expenseCount > 0) {
                System.out.printf("Total Today (%d expenses): ₹%.2f%n\n", expenseCount, dailyTotal);
            } else {
                System.out.println("No expenses recorded for today.\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ No expenses recorded yet.\n");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage() + "\n");
        }
    }
}
