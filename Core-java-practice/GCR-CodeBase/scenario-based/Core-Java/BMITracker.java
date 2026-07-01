import java.util.Scanner;

class BMITracker {
    static final double UNDERWEIGHT_LIMIT = 18.5;
    static final double NORMAL_LIMIT = 24.9;
    static final double OVERWEIGHT_LIMIT = 29.9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Maya's BMI Fitness Tracker ===\n");

        System.out.print("Enter client name: ");
        String clientName = scanner.nextLine().trim();

        System.out.print("Enter height in meters: ");
        double heightInMeters;
        try {
            heightInMeters = Double.parseDouble(scanner.nextLine().trim());
            if (heightInMeters <= 0) {
                System.out.println("Height must be positive.");
                scanner.close();
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid height input.");
            scanner.close();
            return;
        }

        System.out.print("Enter weight in kilograms: ");
        double weightInKg;
        try {
            weightInKg = Double.parseDouble(scanner.nextLine().trim());
            if (weightInKg <= 0) {
                System.out.println("Weight must be positive.");
                scanner.close();
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid weight input.");
            scanner.close();
            return;
        }

        double bmi = calculateBMI(weightInKg, heightInMeters);
        String category = getBMICategory(bmi);

        System.out.println("\n=== BMI Report ===");
        System.out.println("Client Name: " + clientName);
        System.out.println("Height: " + heightInMeters + " m");
        System.out.println("Weight: " + weightInKg + " kg");
        System.out.println("BMI: " + String.format("%.2f", bmi));
        System.out.println("Category: " + category);

        printCategoryDescription(category);

        scanner.close();
    }

    static double calculateBMI(double weightInKg, double heightInMeters) {
        return weightInKg / (heightInMeters * heightInMeters);
    }

    static String getBMICategory(double bmi) {
        if (bmi < UNDERWEIGHT_LIMIT) {
            return "Underweight";
        } else if (bmi <= NORMAL_LIMIT) {
            return "Normal Weight";
        } else if (bmi <= OVERWEIGHT_LIMIT) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printCategoryDescription(String category) {
        System.out.println("\nRecommendation: ");
        if (category.equals("Underweight")) {
            System.out.println("Focus on gaining healthy weight with balanced nutrition and strength training.");
        } else if (category.equals("Normal Weight")) {
            System.out.println("Maintain your current fitness level with regular exercise and balanced diet.");
        } else if (category.equals("Overweight")) {
            System.out.println("Consider increasing physical activity and managing calorie intake.");
        } else {
            System.out.println("Consult with a healthcare professional for a personalized fitness plan.");
        }
    }
}
