import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int numberOfPersons = scanner.nextInt();
        
        double[] weights = new double[numberOfPersons];
        double[] heights = new double[numberOfPersons];
        double[] bmiValues = new double[numberOfPersons];
        String[] weightStatus = new String[numberOfPersons];
        
        // Take input for weight and height
        System.out.println("\nEnter weight (kg) and height (m) for each person:");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.print("\nPerson " + (i + 1) + ":");
            System.out.print("\nWeight (kg): ");
            weights[i] = scanner.nextDouble();
            System.out.print("Height (m): ");
            heights[i] = scanner.nextDouble();
        }
        
        // Calculate BMI and determine weight status
        for (int i = 0; i < numberOfPersons; i++) {
            bmiValues[i] = weights[i] / (heights[i] * heights[i]);
            
            if (bmiValues[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmiValues[i] >= 18.5 && bmiValues[i] < 25) {
                weightStatus[i] = "Normal Weight";
            } else if (bmiValues[i] >= 25 && bmiValues[i] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        // Display results
        System.out.println("\n========== BMI Analysis Results ==========");
        System.out.println("Person\tHeight(m)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("===================================================");
        
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s%n", 
                (i + 1), heights[i], weights[i], bmiValues[i], weightStatus[i]);
        }
        
        scanner.close();
    }
}
