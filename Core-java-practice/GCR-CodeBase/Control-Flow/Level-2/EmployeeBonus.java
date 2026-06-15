import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter Years of Service: ");
        int yearsOfService = sc.nextInt();

        double bonus = 0;

        if (yearsOfService > 5) {
            bonus = salary * 0.05; // 5% bonus
        }

        System.out.println("Bonus Amount = " + bonus);

        sc.close();
    }
}