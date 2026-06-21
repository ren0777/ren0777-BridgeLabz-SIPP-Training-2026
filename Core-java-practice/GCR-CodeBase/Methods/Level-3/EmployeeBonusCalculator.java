import java.util.Arrays;

public class EmployeeBonusCalculator {

    public static double[][] generateEmployeeData(int count) {
        double[][] data = new double[count][2];
        for (int i = 0; i < count; i++) {
            data[i][0] = 50000 + (int) (Math.random() * 90000);
            data[i][1] = 1 + (int) (Math.random() * 10);
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        double[][] result = new double[employeeData.length][4];

        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonusRate = yearsOfService > 5 ? 0.05 : 0.02;
            double bonus = oldSalary * bonusRate;
            double newSalary = oldSalary + bonus;

            result[i][0] = oldSalary;
            result[i][1] = yearsOfService;
            result[i][2] = bonus;
            result[i][3] = newSalary;
        }

        return result;
    }

    public static void displaySummary(double[][] result) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Employee\tOld Salary\tYears\tBonus\tNew Salary");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.0f\t%.2f\t%.2f%n",
                    (i + 1), result[i][0], result[i][1], result[i][2], result[i][3]);
            totalOldSalary += result[i][0];
            totalNewSalary += result[i][3];
            totalBonus += result[i][2];
        }

        System.out.println("Total old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);
        System.out.println("Total bonus: " + totalBonus);
    }

    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData(10);
        double[][] result = calculateBonusAndNewSalary(employeeData);

        System.out.println("Generated data: " + Arrays.deepToString(employeeData));
        displaySummary(result);
    }
}