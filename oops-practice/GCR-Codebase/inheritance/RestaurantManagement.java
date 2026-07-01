import java.util.Scanner;

interface Worker {
    void performDuties();
    void displayRole();
}

class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person implements Worker {
    private String specialty;
    private int experienceYears;

    public Chef(String name, int id, String specialty, int experienceYears) {
        super(name, id);
        this.specialty = specialty;
        this.experienceYears = experienceYears;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing " + specialty + " dishes");
        System.out.println("Coordinating with the kitchen staff");
        System.out.println("Ensuring quality and taste standards");
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Chef");
    }

    public void displayChefInfo() {
        System.out.println("=== Chef Information ===");
        displayPersonInfo();
        displayRole();
        System.out.println("Specialty: " + specialty);
        System.out.println("Experience: " + experienceYears + " years");
    }
}

class Waiter extends Person implements Worker {
    private int tablesAssigned;
    private double salary;

    public Waiter(String name, int id, int tablesAssigned, double salary) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
        this.salary = salary;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is taking orders from customers");
        System.out.println("Serving food and beverages");
        System.out.println("Managing " + tablesAssigned + " tables");
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Waiter");
    }

    public void displayWaiterInfo() {
        System.out.println("=== Waiter Information ===");
        displayPersonInfo();
        displayRole();
        System.out.println("Tables Assigned: " + tablesAssigned);
        System.out.println("Salary: $" + String.format("%.2f", salary));
    }
}

public class RestaurantManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Q7: Restaurant Management with Hybrid Inheritance ===\n");

        Chef chef1 = new Chef("Marco Rossi", 101, "Italian Cuisine", 15);
        Chef chef2 = new Chef("Kenji Tanaka", 102, "Japanese Sushi", 12);
        Waiter waiter1 = new Waiter("Emma Wilson", 201, 5, 2500);
        Waiter waiter2 = new Waiter("James Brown", 202, 4, 2300);

        System.out.println("--- Chef 1 ---");
        chef1.displayChefInfo();
        System.out.println("Duties:");
        chef1.performDuties();
        System.out.println();

        System.out.println("--- Chef 2 ---");
        chef2.displayChefInfo();
        System.out.println("Duties:");
        chef2.performDuties();
        System.out.println();

        System.out.println("--- Waiter 1 ---");
        waiter1.displayWaiterInfo();
        System.out.println("Duties:");
        waiter1.performDuties();
        System.out.println();

        System.out.println("--- Waiter 2 ---");
        waiter2.displayWaiterInfo();
        System.out.println("Duties:");
        waiter2.performDuties();
        System.out.println();

        System.out.println("--- Demonstrating Hybrid Inheritance ---");
        System.out.println("Is Chef a Person? " + (chef1 instanceof Person));
        System.out.println("Does Chef implement Worker? " + (chef1 instanceof Worker));
        System.out.println("Is Waiter a Person? " + (waiter1 instanceof Person));
        System.out.println("Does Waiter implement Worker? " + (waiter1 instanceof Worker));

        System.out.println("\n--- Polymorphic Worker Array ---");
        Worker[] workers = {chef1, chef2, waiter1, waiter2};
        for (int i = 0; i < workers.length; i++) {
            System.out.println("\nWorker " + (i + 1) + ":");
            workers[i].displayRole();
            workers[i].performDuties();
        }

        sc.close();
    }
}
