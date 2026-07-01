import java.io.*;
import java.util.Scanner;

class SchoolResultPortal {
    static final String INPUT_FILE = "students.txt";
    static final String OUTPUT_FILE = "report_cards.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== School Result Portal ===\n");

        System.out.println("1. Add New Student Result");
        System.out.println("2. Generate Report Cards from File");
        System.out.print("\nSelect option (1-2): ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                addStudentResult(scanner);
                break;
            case "2":
                generateReportCards();
                break;
            default:
                System.out.println("Invalid option.");
        }

        scanner.close();
    }

    static void addStudentResult(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        int[] marks = new int[5];
        String[] subjects = {"English", "Mathematics", "Science", "Social Studies", "Hindi"};

        System.out.println("\nEnter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print(subjects[i] + ": ");
            try {
                marks[i] = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                i--;
            }
        }

        saveStudentData(name, marks);
        System.out.println("\n✓ Student data saved successfully!");
    }

    static void saveStudentData(String name, int[] marks) {
        try (FileWriter fw = new FileWriter(INPUT_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            StringBuilder sb = new StringBuilder();
            sb.append(name).append(",");
            for (int i = 0; i < marks.length; i++) {
                sb.append(marks[i]);
                if (i < marks.length - 1) sb.append(",");
            }

            bw.write(sb.toString());
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    static void generateReportCards() {
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {

            System.out.println("\n--- Generating Report Cards ---\n");

            try (FileWriter fw = new FileWriter(OUTPUT_FILE, true);
                 BufferedWriter bw = new BufferedWriter(fw)) {

                bw.write("=".repeat(60));
                bw.newLine();
                bw.write("SCHOOL REPORT CARDS - " + java.time.LocalDate.now());
                bw.newLine();
                bw.write("=".repeat(60));
                bw.newLine();

                String line;
                int studentCount = 0;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 6) {
                        String name = parts[0];
                        int[] marks = new int[5];
                        int sum = 0;

                        for (int i = 0; i < 5; i++) {
                            marks[i] = Integer.parseInt(parts[i + 1]);
                            sum += marks[i];
                        }

                        double average = (double) sum / 5;
                        String grade = assignGrade(average);

                        bw.write("\nStudent Name: " + name);
                        bw.newLine();
                        bw.write("Total Marks: " + sum + "/500");
                        bw.newLine();
                        bw.write("Average: " + String.format("%.2f", average));
                        bw.newLine();
                        bw.write("Grade: " + grade);
                        bw.newLine();
                        bw.write("-".repeat(60));
                        bw.newLine();

                        studentCount++;
                    }
                }

                bw.write("\nTotal Students Processed: " + studentCount);
                bw.newLine();
                bw.write("=".repeat(60));
                bw.newLine();

                System.out.println("✓ Report cards generated successfully!");
                System.out.println("✓ Saved to: " + OUTPUT_FILE);
                System.out.println("✓ Students processed: " + studentCount);

            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ Input file not found: " + INPUT_FILE);
            System.out.println("Please add student results first.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static String assignGrade(double average) {
        if (average >= 90) return "A+";
        if (average >= 80) return "A";
        if (average >= 70) return "B+";
        if (average >= 60) return "B";
        if (average >= 50) return "C";
        if (average >= 40) return "D";
        return "F";
    }
}
