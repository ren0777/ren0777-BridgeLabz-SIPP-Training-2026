// Sample Program 3: Employee Management System
// Concepts: static, this, final, instanceof

public class Employee {

    // 1. STATIC – companyName and totalEmployees shared across all instances
    static String companyName    = "TechSoft Solutions Pvt. Ltd.";
    static int    totalEmployees = 0;

    // 3. FINAL – id cannot be modified after assignment
    final int id;

    String name;
    String designation;
    double salary;

    // 2. THIS – resolves ambiguity for name, id, designation
    Employee(int id, String name, String designation, double salary) {
        this.id          = id;            // 'this' used for all four fields
        this.name        = name;
        this.designation = designation;
        this.salary      = salary;
        totalEmployees++;
    }

    void appraise(double hikePercent) {
        double hike = salary * hikePercent / 100;
        salary += hike;
        System.out.println(name + " received a " + hikePercent
                         + "% hike. New Salary: Rs." + salary);
    }

    void display() {
        System.out.println("Company    : " + companyName);
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Salary     : Rs." + salary);
    }

    // 1. STATIC METHOD
    static void displayTotalEmployees() {
        System.out.println("Company         : " + companyName);
        System.out.println("Total Employees : " + totalEmployees);
    }

    public static void main(String[] args) {

        Employee emp1 = new Employee(101, "Sneha Kapoor", "Software Engineer", 70000.0);
        Employee emp2 = new Employee(102, "Rahul Verma",  "Team Lead",         95000.0);
        Object      obj  = 3.14;   // a Double, not an Employee

        // 4. INSTANCEOF – validate before displaying details
        System.out.println("=== Employee 1 ===");
        if (emp1 instanceof Employee) {
            emp1.display();
        }

        System.out.println("\n=== Employee 2 – With Appraisal ===");
        if (emp2 instanceof Employee) {
            emp2.display();
            emp2.appraise(15.0);
        }

        System.out.println("\n=== instanceof check on Double object ===");
        if (!(obj instanceof Employee)) {
            System.out.println("Object is NOT an Employee instance. Skipping display.");
        }

        System.out.println();
        Employee.displayTotalEmployees();   // static method call

        // Prove final – uncommenting causes compile error:
        // emp1.id = 999;   // ERROR: cannot assign a value to final variable
    }
}
