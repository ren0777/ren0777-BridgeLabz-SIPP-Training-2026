import java.io.*;
import java.util.Scanner;

public class StudentGradeManager {

    static String[] names = new String[100];
    static int[] totals = new int[100];
    static double[] averages = new double[100];
    static String[] grades = new String[100];

    static int count = 0;

    static void readData(String fileName) {

        try {

            BufferedReader br =
                    new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(" ");

                names[count] = data[0];

                int total = 0;

                for (int i = 1; i <= 5; i++) {
                    total += Integer.parseInt(data[i]);
                }

                totals[count] = total;
                averages[count] = total / 5.0;
                grades[count] = calculateGrade(averages[count]);

                count++;
            }

            br.close();

        } catch (FileNotFoundException e) {

            System.out.println("Input file not found.");

        } catch (IOException e) {

            System.out.println("Error reading file.");
        }
    }

    static String calculateGrade(double avg) {

        if (avg >= 90) {
            return "A";
        } else {
            if (avg >= 75) {
                return "B";
            } else {
                if (avg >= 60) {
                    return "C";
                } else {
                    return "F";
                }
            }
        }
    }

    static void searchStudent(String name) {

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (names[i].equalsIgnoreCase(name)) {

                System.out.println("\nStudent Found");
                System.out.println("Name: " + names[i]);
                System.out.println("Total: " + totals[i]);
                System.out.println("Average: " + averages[i]);
                System.out.println("Grade: " + grades[i]);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    static void bubbleSort() {

        for (int i = 0; i < count - 1; i++) {

            for (int j = 0; j < count - i - 1; j++) {

                if (totals[j] < totals[j + 1]) {

                    int tempTotal = totals[j];
                    totals[j] = totals[j + 1];
                    totals[j + 1] = tempTotal;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;

                    double tempAvg = averages[j];
                    averages[j] = averages[j + 1];
                    averages[j + 1] = tempAvg;

                    String tempGrade = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = tempGrade;
                }
            }
        }
    }

    static void writeReport(String fileName) {

        try {

            BufferedWriter bw =
                    new BufferedWriter(new FileWriter(fileName));

            bw.write("===== STUDENT REPORT =====");
            bw.newLine();

            for (int i = 0; i < count; i++) {

                bw.write(
                        names[i]
                                + " | Total: " + totals[i]
                                + " | Average: " + averages[i]
                                + " | Grade: " + grades[i]);

                bw.newLine();
            }

            bw.close();

            System.out.println("Report generated successfully.");

        } catch (IOException e) {

            System.out.println("Error writing report.");
        }
    }

    public static void main(String[] args) {

        readData("students.txt");

        bubbleSort();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name to search: ");

        String searchName = sc.nextLine();

        searchStudent(searchName);

        writeReport("report.txt");
    }
}