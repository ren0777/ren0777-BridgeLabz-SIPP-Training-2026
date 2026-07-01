import java.util.Scanner;

public class StudentMarksAnalyzer {

    static int[] acceptMarks(Scanner sc) {
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks of student " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        return marks;
    }

    static int findHighest(int[] marks) {
        int highest = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
            }
        }
        return highest;
    }

    static int findLowest(int[] marks) {
        int lowest = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }
        return lowest;
    }

    static int countAbove75(int[] marks) {
        int count = 0;
        for (int mark : marks) {
            if (mark > 75) {
                count++;
            }
        }
        return count;
    }

    static double calculateAverage(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    static void displayAboveAverage(int[] marks, double average) {
        System.out.println("\nMarks greater than average (" + String.format("%.2f", average) + "):");
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] > average) {
                System.out.println("  Student " + (i + 1) + " : " + marks[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] marks = acceptMarks(sc);
        int highest = findHighest(marks);
        int lowest = findLowest(marks);
        int aboveCount = countAbove75(marks);
        double average = calculateAverage(marks);

        System.out.println("\n========================================");
        System.out.println("         STUDENT MARKS ANALYSIS         ");
        System.out.println("========================================");
        System.out.println("Total Students   : " + marks.length);
        System.out.println("Highest Marks    : " + highest);
        System.out.println("Lowest Marks     : " + lowest);
        System.out.println("Students Above 75: " + aboveCount);
        System.out.printf("Average Marks    : %.2f%n", average);
        System.out.println("========================================");

        displayAboveAverage(marks, average);

        System.out.println("========================================");

        sc.close();
    }
}
