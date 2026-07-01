import java.util.Scanner;

class ResultGenerator {
    static final int TOTAL_SUBJECTS = 5;
    static final double PASSING_PERCENTAGE = 40.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Raj's Coaching Center - Result Generator ===\n");

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine().trim();

        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine().trim();

        int[] marks = new int[TOTAL_SUBJECTS];
        String[] subjectNames = {"English", "Mathematics", "Science", "Social Studies", "Hindi"};

        System.out.println("\n--- Enter Marks (0-100) ---");
        int totalMarks = 0;

        for (int i = 0; i < TOTAL_SUBJECTS; i++) {
            int mark;
            while (true) {
                System.out.print("Enter " + subjectNames[i] + " marks: ");
                try {
                    mark = Integer.parseInt(scanner.nextLine().trim());
                    if (mark < 0 || mark > 100) {
                        System.out.println("Marks should be between 0 and 100.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
            marks[i] = mark;
            totalMarks += mark;
        }

        double average = (double) totalMarks / TOTAL_SUBJECTS;
        String grade = assignGrade(average);
        boolean isPassed = average >= PASSING_PERCENTAGE;

        printResultCard(studentName, rollNumber, subjectNames, marks, totalMarks, average, grade, isPassed);

        scanner.close();
    }

    static String assignGrade(double average) {
        switch ((int) (average / 10)) {
            case 10:
            case 9:
                return "A+";
            case 8:
                return "A";
            case 7:
                return "B+";
            case 6:
                return "B";
            case 5:
                return "C";
            case 4:
                return "D";
            default:
                return "F";
        }
    }

    static void printResultCard(String name, String roll, String[] subjects, int[] marks,
                                 int total, double average, String grade, boolean passed) {
        System.out.println("\n==================== RESULT CARD ====================");
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + roll);
        System.out.println("====================================================");

        System.out.println("\nSubject-wise Marks:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println((i + 1) + ". " + subjects[i] + ": " + marks[i] + "/100");
        }

        System.out.println("\n----------------------------------------------------");
        System.out.println("Total Marks: " + total + "/500");
        System.out.println("Average: " + String.format("%.2f", average) + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Status: " + (passed ? "✓ PASSED" : "✗ FAILED"));
        System.out.println("====================================================\n");
    }
}
