import java.util.Scanner;

/**
 * Program to calculate student grades based on marks in 3 subjects
 */
public class StudentGrades {
    
    private static final int NUM_STUDENTS = 5; // Can be adjusted
    private static final int NUM_SUBJECTS = 3;
    
    /**
     * Generate random 2-digit scores for Physics, Chemistry, and Math
     * @param numOfStudents Number of students
     * @return 2D array with PCM scores for all students
     */
    public static int[][] generateRandomScores(int numOfStudents) {
        int[][] scores = new int[numOfStudents][NUM_SUBJECTS];
        
        for (int i = 0; i < numOfStudents; i++) {
            // Generate random scores between 0 and 100
            scores[i][0] = (int) (Math.random() * 101); // Physics
            scores[i][1] = (int) (Math.random() * 101); // Chemistry
            scores[i][2] = (int) (Math.random() * 101); // Math
        }
        
        return scores;
    }
    
    /**
     * Calculate total, average, and percentage for each student
     * @param scores 2D array with PCM scores
     * @return 2D array with total, average, and percentage
     */
    public static double[][] calculateStatistics(int[][] scores) {
        double[][] statistics = new double[scores.length][3];
        
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / NUM_SUBJECTS;
            double percentage = (total / (NUM_SUBJECTS * 100)) * 100;
            
            statistics[i][0] = Math.round(total * 100.0) / 100.0;
            statistics[i][1] = Math.round(average * 100.0) / 100.0;
            statistics[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        
        return statistics;
    }
    
    /**
     * Calculate grade based on percentage
     * A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: <60
     * @param statistics 2D array with statistics
     * @return 2D array with grades
     */
    public static String[][] calculateGrades(double[][] statistics) {
        String[][] grades = new String[statistics.length][1];
        
        for (int i = 0; i < statistics.length; i++) {
            double percentage = statistics[i][2];
            
            if (percentage >= 90) {
                grades[i][0] = "A";
            } else if (percentage >= 80) {
                grades[i][0] = "B";
            } else if (percentage >= 70) {
                grades[i][0] = "C";
            } else if (percentage >= 60) {
                grades[i][0] = "D";
            } else {
                grades[i][0] = "F";
            }
        }
        
        return grades;
    }
    
    /**
     * Display student scorecard in tabular format
     * @param scores Student scores
     * @param statistics Statistics
     * @param grades Grades
     */
    public static void displayScorecard(int[][] scores, double[][] statistics, String[][] grades) {
        System.out.println("\n" + "=".repeat(110));
        System.out.println("Student | Physics | Chemistry | Math | Total | Average | Percentage | Grade");
        System.out.println("=".repeat(110));
        
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("   %2d   |   %3d   |    %3d    |  %3d |  %5.0f |  %5.2f  |   %5.2f%%   |   %s%n",
                    (i + 1),
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    statistics[i][0],
                    statistics[i][1],
                    statistics[i][2],
                    grades[i][0]);
        }
        
        System.out.println("=".repeat(110));
    }
    
    public static void main(String[] args) {
        System.out.println("=== Student Grade Report ===\n");
        
        // Generate random scores for students
        int[][] scores = generateRandomScores(NUM_STUDENTS);
        
        // Calculate statistics (total, average, percentage)
        double[][] statistics = calculateStatistics(scores);
        
        // Calculate grades
        String[][] grades = calculateGrades(statistics);
        
        // Display scorecard
        displayScorecard(scores, statistics, grades);
        
        // Display summary statistics
        System.out.println("\n--- Summary Statistics ---");
        double totalPercentage = 0;
        int gradeACount = 0, gradeBCount = 0, gradeCCount = 0, gradeDCount = 0, gradeFCount = 0;
        
        for (int i = 0; i < NUM_STUDENTS; i++) {
            totalPercentage += statistics[i][2];
            
            switch (grades[i][0]) {
                case "A":
                    gradeACount++;
                    break;
                case "B":
                    gradeBCount++;
                    break;
                case "C":
                    gradeCCount++;
                    break;
                case "D":
                    gradeDCount++;
                    break;
                case "F":
                    gradeFCount++;
                    break;
            }
        }
        
        System.out.printf("Class Average Percentage: %.2f%%%n", totalPercentage / NUM_STUDENTS);
        System.out.println("Grade A: " + gradeACount);
        System.out.println("Grade B: " + gradeBCount);
        System.out.println("Grade C: " + gradeCCount);
        System.out.println("Grade D: " + gradeDCount);
        System.out.println("Grade F: " + gradeFCount);
    }
}
