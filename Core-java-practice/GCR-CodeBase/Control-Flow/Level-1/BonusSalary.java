import java.util.*;

class BonusSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Years of experience: ");
        int year = sc.nextInt();

        System.out.print("Salary: ");
        double salary = sc.nextDouble();

        double finalSalary = salary;

        if (year > 5) {
            finalSalary = salary + (salary * 0.05);
        }

        System.out.println("Final salary is: " + finalSalary);

        sc.close();
    }
}