import java.io.*;
import java.util.Scanner;

class CustomerFeedbackAnalyzer {
    static final String FEEDBACK_FILE = "feedback.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Customer Feedback Analyzer ===\n");

        System.out.println("1. Add New Feedback");
        System.out.println("2. Analyze Feedback");
        System.out.print("\nSelect option (1-2): ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                collectFeedback(scanner);
                break;
            case "2":
                analyzeFeedback();
                break;
            default:
                System.out.println("Invalid option.");
        }

        scanner.close();
    }

    static void collectFeedback(Scanner scanner) {
        System.out.println("\n--- Enter 5 Customer Feedback Messages ---\n");

        try (FileWriter fw = new FileWriter(FEEDBACK_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (int i = 1; i <= 5; i++) {
                System.out.print("Feedback " + i + ": ");
                String feedback = scanner.nextLine().trim();

                if (!feedback.isEmpty()) {
                    bw.write(feedback);
                    bw.newLine();
                    System.out.println("✓ Feedback recorded.\n");
                } else {
                    System.out.println("Feedback cannot be empty.\n");
                    i--;
                }
            }

            System.out.println("✓ All feedback saved to " + FEEDBACK_FILE);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    static void analyzeFeedback() {
        System.out.println("\n--- Analyzing Feedback ---\n");

        try (BufferedReader br = new BufferedReader(new FileReader(FEEDBACK_FILE))) {

            String line;
            int goodCount = 0;
            int totalFeedback = 0;

            System.out.println("Feedback Messages:");
            System.out.println("-".repeat(50));

            while ((line = br.readLine()) != null) {
                totalFeedback++;
                System.out.println(totalFeedback + ". " + line);

                goodCount += countOccurrences(line, "good");
            }

            System.out.println("-".repeat(50));
            System.out.println("\n✓ Analysis Results:");
            System.out.println("Total Feedback Messages: " + totalFeedback);
            System.out.println("Good Feedback Count: " + goodCount);

            if (totalFeedback > 0) {
                double percentage = (goodCount * 100.0) / totalFeedback;
                System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ Feedback file not found: " + FEEDBACK_FILE);
            System.out.println("Please add feedback first.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    static int countOccurrences(String text, String word) {
        String lowerText = text.toLowerCase();
        String lowerWord = word.toLowerCase();
        int count = 0;
        int index = 0;

        while ((index = lowerText.indexOf(lowerWord, index)) != -1) {
            count++;
            index += lowerWord.length();
        }

        return count;
    }
}
