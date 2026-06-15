import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfEmployees = 10;
        double[] salaries = new double[numberOfEmployees];
        double[] yearsOfService = new double[numberOfEmployees];
        double[] bonuses = new double[numberOfEmployees];
        double[] newSalaries = new double[numberOfEmployees];
        
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        
        // Take input from user
        System.out.println("Enter salary and years of service for 10 employees:");
        for (int i = 0; i < numberOfEmployees; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("\nEmployee " + (i + 1) + ":");
                System.out.print("\nSalary: ");
                salaries[i] = scanner.nextDouble();
                
                if (salaries[i] < 0) {
                    System.out.println("Invalid salary! Please enter a positive number.");
                    continue;
                }
                
                System.out.print("Years of Service: ");
                yearsOfService[i] = scanner.nextDouble();
                
                if (yearsOfService[i] < 0) {
                    System.out.println("Invalid years of service! Please enter a positive number.");
                    continue;
                }
                
                validInput = true;
            }
        }
        
        // Calculate bonus and new salary
        for (int i = 0; i < numberOfEmployees; i++) {
            if (yearsOfService[i] > 5) {
                bonuses[i] = salaries[i] * 0.05; // 5% bonus
            } else {
                bonuses[i] = salaries[i] * 0.02; // 2% bonus
            }
            
            newSalaries[i] = salaries[i] + bonuses[i];
            
            totalOldSalary += salaries[i];
            totalBonus += bonuses[i];
            totalNewSalary += newSalaries[i];
        }
        
        // Display results
        System.out.println("\n========== Employee Bonus Details ==========");
        System.out.println("Employee\tOld Salary\tBonus\t\tNew Salary\tYears of Service");
        System.out.println("=========================================================================");
        
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.1f%n", 
                (i + 1), salaries[i], bonuses[i], newSalaries[i], yearsOfService[i]);
        }
        
        System.out.println("=========================================================================");
        System.out.printf("Total Old Salary: %.2f%n", totalOldSalary);
        System.out.printf("Total Bonus: %.2f%n", totalBonus);
        System.out.printf("Total New Salary: %.2f%n", totalNewSalary);
        
        scanner.close();
    }
}
