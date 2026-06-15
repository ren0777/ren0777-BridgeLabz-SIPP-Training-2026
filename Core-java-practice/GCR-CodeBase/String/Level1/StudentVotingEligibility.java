import java.util.Scanner;

/**
 * Program to check voting eligibility of 10 students based on age
 */
public class StudentVotingEligibility {
    
    /**
     * Generate random 2-digit ages for students
     * @param numOfStudents Number of students
     * @return Array of ages
     */
    public static int[] generateRandomAges(int numOfStudents) {
        int[] ages = new int[numOfStudents];
        for (int i = 0; i < numOfStudents; i++) {
            // Generate random age between 10 and 99
            ages[i] = 10 + (int) (Math.random() * 90);
        }
        return ages;
    }
    
    /**
     * Check voting eligibility for students
     * @param ages Array of ages
     * @return 2D array with age and voting eligibility
     */
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            
            // Validate age for negative number
            if (ages[i] < 0) {
                result[i][1] = "false"; // Cannot vote if age is negative
            }
            // Check if age is 18 or above
            else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        
        return result;
    }
    
    /**
     * Display voting eligibility in tabular format
     * @param eligibilityData 2D array with eligibility data
     */
    public static void displayVotingTable(String[][] eligibilityData) {
        System.out.println("\n==================================================");
        System.out.println("Student | Age | Can Vote?");
        System.out.println("==================================================");
        
        for (int i = 0; i < eligibilityData.length; i++) {
            String canVote = eligibilityData[i][1].equals("true") ? "Yes" : "No";
            System.out.printf("   %2d   | %3s |    %s%n", (i + 1), eligibilityData[i][0], canVote);
        }
        
        System.out.println("==================================================");
    }
    
    public static void main(String[] args) {
        System.out.println("=== Student Voting Eligibility Check ===\n");
        
        final int NUM_STUDENTS = 10;
        
        // Generate random ages
        int[] ages = generateRandomAges(NUM_STUDENTS);
        
        // Check voting eligibility
        String[][] eligibilityData = checkVotingEligibility(ages);
        
        // Display results
        displayVotingTable(eligibilityData);
        
        // Display statistics
        int canVoteCount = 0;
        int cannotVoteCount = 0;
        
        for (String[] row : eligibilityData) {
            if (row[1].equals("true")) {
                canVoteCount++;
            } else {
                cannotVoteCount++;
            }
        }
        
        System.out.println("\n--- Statistics ---");
        System.out.println("Total Students: " + NUM_STUDENTS);
        System.out.println("Can Vote: " + canVoteCount);
        System.out.println("Cannot Vote: " + cannotVoteCount);
        System.out.printf("Percentage Can Vote: %.2f%%%n", (canVoteCount / (double) NUM_STUDENTS) * 100);
    }
}
