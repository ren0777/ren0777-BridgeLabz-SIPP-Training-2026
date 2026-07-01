import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    String employeeId;
    String name;
    String department;
    double salary;
    int skillScore;

    Employee(String employeeId, String name, String department, double salary, int skillScore) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.skillScore = skillScore;
    }

    void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + salary);
        System.out.println("Skill Score: " + skillScore);
    }
}

class EmployeeSkillAssignmentSerialization {
    static final String EMPLOYEE_FILE = "employees.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Employee Skill Assignment (Serialization) ===\n");

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Exit");
            System.out.print("\nSelect option (1-3): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addEmployee(scanner);
                    break;
                case "2":
                    viewAllEmployees();
                    break;
                case "3":
                    System.out.println("Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }

    static void addEmployee(Scanner scanner) {
        System.out.println("\n--- Add Employee ---\n");

        System.out.print("Enter Employee ID: ");
        String employeeId = scanner.nextLine().trim();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine().trim();

        System.out.print("Enter Salary: ₹");
        double salary;
        try {
            salary = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid salary.\n");
            return;
        }

        System.out.print("Enter Skill Score (0-100): ");
        int skillScore;
        try {
            skillScore = Integer.parseInt(scanner.nextLine().trim());
            if (skillScore < 0 || skillScore > 100) {
                System.out.println("Skill score must be between 0-100.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid skill score.\n");
            return;
        }

        Employee employee = new Employee(employeeId, name, department, salary, skillScore);
        serializeEmployee(employee);
        System.out.println("\n✓ Employee saved successfully!\n");
    }

    static void serializeEmployee(Employee employee) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EMPLOYEE_FILE, true))) {
            oos.writeObject(employee);
        } catch (IOException e) {
            System.out.println("Error saving employee: " + e.getMessage());
        }
    }

    static void viewAllEmployees() {
        System.out.println("\n--- All Employees ---\n");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EMPLOYEE_FILE))) {

            int employeeCount = 0;
            Employee employee;

            while (true) {
                try {
                    employee = (Employee) ois.readObject();
                    employeeCount++;

                    System.out.println("Employee #" + employeeCount);
                    System.out.println("-".repeat(40));
                    employee.display();
                    System.out.println();

                } catch (EOFException e) {
                    break;
                }
            }

            if (employeeCount == 0) {
                System.out.println("No employees found.\n");
            } else {
                System.out.println("Total Employees: " + employeeCount + "\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ No employee data found.\n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading employee data: " + e.getMessage() + "\n");
        }
    }
}
