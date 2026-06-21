import java.util.Scanner;

public class BMICalculator {

    public static double calculateBMI(double weightKg, double heightCm) {
        double heightMeters = heightCm / 100.0;
        return weightKg / (heightMeters * heightMeters);
    }

    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal Weight";
        } else if (bmi < 30) {
            return "Overweight";
        }
        return "Obese";
    }

    public static String[] findBMIStatuses(double[][] personData) {
        String[] statuses = new String[personData.length];
        for (int i = 0; i < personData.length; i++) {
            statuses[i] = getBMIStatus(personData[i][2]);
        }
        return statuses;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int persons = 10;
        double[][] personData = new double[persons][3];

        System.out.println("Enter weight (kg) and height (cm) for 10 persons:");
        for (int i = 0; i < persons; i++) {
            System.out.print("\nPerson " + (i + 1) + ":");
            System.out.print("\nWeight (kg): ");
            personData[i][0] = scanner.nextDouble();
            System.out.print("Height (cm): ");
            personData[i][1] = scanner.nextDouble();
            personData[i][2] = calculateBMI(personData[i][0], personData[i][1]);
        }

        String[] statuses = findBMIStatuses(personData);

        System.out.println("\nPerson\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        for (int i = 0; i < persons; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t\t%s%n",
                    (i + 1), personData[i][0], personData[i][1], personData[i][2], statuses[i]);
        }

        scanner.close();
    }
}