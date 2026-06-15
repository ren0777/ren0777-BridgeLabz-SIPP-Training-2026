import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of persons: ");
        int numberOfPersons = scanner.nextInt();
        
        // Create 2D array to store weight, height, and BMI
        double[][] personData = new double[numberOfPersons][3];
        String[] weightStatus = new String[numberOfPersons];
        
        // Take input for weight and height
        System.out.println("\nEnter weight (kg) and height (m) for each person:");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.print("\nPerson " + (i + 1) + ":");
            
            // Get weight
            boolean validWeight = false;
            while (!validWeight) {
                System.out.print("\nWeight (kg): ");
                personData[i][0] = scanner.nextDouble();
                if (personData[i][0] > 0) {
                    validWeight = true;
                } else {
                    System.out.println("Please enter a positive value");
                }
            }
            
            // Get height
            boolean validHeight = false;
            while (!validHeight) {
                System.out.print("Height (m): ");
                personData[i][1] = scanner.nextDouble();
                if (personData[i][1] > 0) {
                    validHeight = true;
                } else {
                    System.out.println("Please enter a positive value");
                }
            }
        }
        
        // Calculate BMI and determine weight status
        for (int i = 0; i < numberOfPersons; i++) {
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] < 25) {
                weightStatus[i] = "Normal Weight";
            } else if (personData[i][2] >= 25 && personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        
        // Display results
        System.out.println("\n========== BMI Analysis Results (2D Array) ==========");
        System.out.println("Person\tHeight(m)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("======================================================");
        
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s%n", 
                (i + 1), personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
        
        scanner.close();
    }
}
