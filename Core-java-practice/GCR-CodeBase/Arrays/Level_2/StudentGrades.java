import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        
        double[] physics = new double[numberOfStudents];
        double[] chemistry = new double[numberOfStudents];
        double[] maths = new double[numberOfStudents];
        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];
        
        // Take input for marks
        System.out.println("\nEnter marks for Physics, Chemistry, and Maths (out of 100):");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("\nStudent " + (i + 1) + ":");
            
            // Physics marks
            boolean validPhysics = false;
            while (!validPhysics) {
                System.out.print("\nPhysics: ");
                physics[i] = scanner.nextDouble();
                if (physics[i] < 0) {
                    System.out.println("Please enter a positive value");
                    continue;
                }
                validPhysics = true;
            }
            
            // Chemistry marks
            boolean validChemistry = false;
            while (!validChemistry) {
                System.out.print("Chemistry: ");
                chemistry[i] = scanner.nextDouble();
                if (chemistry[i] < 0) {
                    System.out.println("Please enter a positive value");
                    continue;
                }
                validChemistry = true;
            }
            
            // Maths marks
            boolean validMaths = false;
            while (!validMaths) {
                System.out.print("Maths: ");
                maths[i] = scanner.nextDouble();
                if (maths[i] < 0) {
                    System.out.println("Please enter a positive value");
                    continue;
                }
                validMaths = true;
            }
        }
        
        // Calculate percentage and grade
        for (int i = 0; i < numberOfStudents; i++) {
            double totalMarks = physics[i] + chemistry[i] + maths[i];
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
        System.out.println("\n========== Student Grades Report ==========");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        System.out.println("==================================================================");
        
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t\t%.2f\t%.2f\t\t%c%n", 
                (i + 1), physics[i], chemistry[i], maths[i], percentages[i], grades[i]);
        }
        
        scanner.close();
    }
}
