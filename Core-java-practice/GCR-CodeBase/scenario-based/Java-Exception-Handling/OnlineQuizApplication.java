import java.util.Scanner;

class OnlineQuizApplication {
    static String[] correctAnswers = {"A", "B", "C", "D", "A"};
    static String[] studentAnswers = new String[5];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Online Quiz Application ===\n");

        collectAnswers(scanner);
        evaluateAnswers();

        scanner.close();
    }

    static void collectAnswers(Scanner scanner) {
        System.out.println("--- Answer Quiz ---\n");
        System.out.println("Enter your answers (A, B, C, or D):\n");

        for (int i = 0; i < correctAnswers.length; i++) {
            System.out.print("Question " + (i + 1) + ": ");
            String answer = scanner.nextLine().trim().toUpperCase();

            if (answer.isEmpty()) {
                studentAnswers[i] = null;
            } else {
                studentAnswers[i] = answer;
            }
        }

        System.out.println();
    }

    static void evaluateAnswers() {
        System.out.println("--- Quiz Results ---\n");

        int correctCount = 0;
        int incorrectCount = 0;
        int skippedCount = 0;

        for (int i = 0; i < correctAnswers.length; i++) {
            try {
                checkAnswer(i);
                if (studentAnswers[i] != null && studentAnswers[i].equals(correctAnswers[i])) {
                    correctCount++;
                } else if (studentAnswers[i] != null) {
                    incorrectCount++;
                } else {
                    skippedCount++;
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("❌ Question " + (i + 1) + ": " + e.getMessage());
                incorrectCount++;

            } catch (NullPointerException e) {
                System.out.println("⚠️  Question " + (i + 1) + ": Answer is null/empty (Skipped)");
                skippedCount++;

            } catch (Exception e) {
                System.out.println("❌ Question " + (i + 1) + ": Unexpected error - " + e.getMessage());
                incorrectCount++;
            }
        }

        displayResults(correctCount, incorrectCount, skippedCount);
    }

    static void checkAnswer(int questionIndex) throws ArrayIndexOutOfBoundsException, NullPointerException {
        try {
            if (questionIndex < 0 || questionIndex >= correctAnswers.length) {
                throw new ArrayIndexOutOfBoundsException("Question index " + questionIndex + " out of bounds!");
            }

            String studentAnswer = studentAnswers[questionIndex];

            if (studentAnswer == null || studentAnswer.isEmpty()) {
                throw new NullPointerException("Student answer is null or empty!");
            }

            String correctAnswer = correctAnswers[questionIndex];

            System.out.print("Question " + (questionIndex + 1) + ": ");
            System.out.print("Your answer: " + studentAnswer + ", ");
            System.out.print("Correct answer: " + correctAnswer + " → ");

            if (studentAnswer.equals(correctAnswer)) {
                System.out.println("✓ CORRECT");
            } else {
                System.out.println("✗ WRONG");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (NullPointerException e) {
            throw e;
        }
    }

    static void displayResults(int correct, int incorrect, int skipped) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("QUIZ SUMMARY");
        System.out.println("=".repeat(50));

        System.out.println("Total Questions: " + correctAnswers.length);
        System.out.println("Correct Answers: " + correct);
        System.out.println("Incorrect Answers: " + incorrect);
        System.out.println("Skipped Questions: " + skipped);

        double percentage = (correct * 100.0) / correctAnswers.length;
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");

        System.out.println("\n--- Status ---");
        if (percentage >= 80) {
            System.out.println("✓ PASS - Excellent Performance!");
        } else if (percentage >= 60) {
            System.out.println("✓ PASS - Good Performance!");
        } else if (percentage >= 40) {
            System.out.println("✗ FAIL - Need Improvement!");
        } else {
            System.out.println("✗ FAIL - Please Review!");
        }

        System.out.println("=".repeat(50) + "\n");
    }
}
