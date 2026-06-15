import java.util.Scanner;

/**
 * Program to find BMI and status of all team members (10 persons)
 */
public class BMICalculator {
    
    /**
     * Find BMI and status for a person
     * @param weight Weight in kg
     * @param heightCm Height in cm
     * @return Array containing weight, height, BMI, and status
     */
    public static String[] calculateBMIAndStatus(double weight, double heightCm) {
        // Convert cm to meters
        double heightM = heightCm / 100.0;
        
        // Calculate BMI: weight / (height * height)
        double bmi = weight / (heightM * heightM);
        
        // Determine status based on BMI
        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        
        return new String[]{String.format("%.2f", weight), String.format("%.2f", heightCm), 
                          String.format("%.2f", bmi), status};
    }
    
    /**
     * Process all team members' data and return 2D array with BMI info
     * @param weightHeightData 2D array with weight and height
     * @return 2D array with weight, height, BMI, and status
     */
    public static String[][] processBMIData(double[][] weightHeightData) {
        String[][] bmiData = new String[weightHeightData.length][4];
        
        for (int i = 0; i < weightHeightData.length; i++) {
            bmiData[i] = calculateBMIAndStatus(weightHeightData[i][0], weightHeightData[i][1]);
        }
        
        return bmiData;
    }
    
    /**
     * Display BMI data in tabular format
     * @param bmiData 2D array containing BMI information
     */
    public static void displayBMITable(String[][] bmiData) {
        System.out.println("\n============================================================");
        System.out.println("Person | Weight(kg) | Height(cm) |   BMI   |   Status");
        System.out.println("============================================================");
        
        for (int i = 0; i < bmiData.length; i++) {
            System.out.printf("  %2d   |   %6s   |    %6s  |  %6s | %s%n", 
                            (i + 1), bmiData[i][0], bmiData[i][1], bmiData[i][2], bmiData[i][3]);
        }
        
        System.out.println("============================================================");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int TEAM_SIZE = 10;
        double[][] weightHeightData = new double[TEAM_SIZE][2];
        
        System.out.println("=== BMI Calculator for Team Members ===");
        System.out.println("Enter weight and height for " + TEAM_SIZE + " team members\n");
        
        // Take user input for weight and height
        for (int i = 0; i < TEAM_SIZE; i++) {
            System.out.print("Person " + (i + 1) + ":");
            System.out.print("\n  Enter weight (kg): ");
            weightHeightData[i][0] = scanner.nextDouble();
            
            System.out.print("  Enter height (cm): ");
            weightHeightData[i][1] = scanner.nextDouble();
        }
        
        // Calculate BMI and status
        String[][] bmiData = processBMIData(weightHeightData);
        
        // Display results in tabular format
        displayBMITable(bmiData);
        
        scanner.close();
    }
}
