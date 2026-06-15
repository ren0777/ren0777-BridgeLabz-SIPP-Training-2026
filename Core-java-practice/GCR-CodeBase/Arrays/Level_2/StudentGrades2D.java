import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        
        // 2D array to store marks: [student][subject] - subject 0=Physics, 1=Chemistry, 2=Maths
        double[][] marks = new double[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];
        
        String[] subjects = {"Physics", "Chemistry", "Maths"};
        
        // Take input for marks
        System.out.println("\nEnter marks for Physics, Chemistry, and Maths (out of 100):");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("\nStudent " + (i + 1) + ":");
            
            for (int j = 0; j < 3; j++) {
                boolean validMarks = false;
                while (!validMarks) {
                    System.out.print("\n" + subjects[j] + ": ");
                    marks[i][j] = scanner.nextDouble();
                    if (marks[i][j] < 0) {
                        System.out.println("Please enter a positive value");
                        continue;
                    }
                    validMarks = true;
                }
            }
        }
        
        // Calculate percentage and grade using 2D array
        for (int i = 0; i < numberOfStudents; i++) {
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300) * 100;
            
            if (percentages[i] >= 90) {
                grades[i] = 'A';
            } else if (percentages[i] >= 80) {
                grades[i] = 'B';
            } else if (percentages[i] >= 70) {
                grades[i] = 'C';
            } else if (percentages[i] >= 60) {
                grades[i] = 'D';
            } else {
                grades[i] = 'F';
            }
        }
        
        // Display results
        System.out.println("\n========== Student Grades Report (2D Array) ==========");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        System.out.println("==================================================================");
        
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t\t%.2f\t%.2f\t\t%c%n", 
                (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
        
        scanner.close();
    }
}
