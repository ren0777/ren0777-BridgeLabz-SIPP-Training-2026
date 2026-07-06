import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class DailyExpenseLogger {
    private static final String EXPENSE_FILE = "expenses.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(EXPENSE_FILE, true))) {
            System.out.println("Enter daily expenses (type 'stop' to finish)");

            while (true) {
                System.out.print("Category: ");
                String category = scanner.nextLine().trim();

                if (category.equalsIgnoreCase("stop")) {
                    break;
                }

                System.out.print("Amount: ");
                String amount = scanner.nextLine().trim();

                // Required format: Food - 200
                bw.write(category + " - " + amount);
                bw.newLine();
                bw.flush();

                System.out.println("Saved: " + category + " - " + amount);
            }

            System.out.println("Expenses appended to " + EXPENSE_FILE);

        } catch (IOException e) {
            System.out.println("Error writing expenses: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
