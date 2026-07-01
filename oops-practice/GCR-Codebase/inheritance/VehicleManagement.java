import java.util.Scanner;

interface Refuelable {
    void refuel(double amount);
    void displayFuelStatus();
}

class Vehicle {
    protected String model;
    protected double maxSpeed;
    protected String color;

    public Vehicle(String model, double maxSpeed, String color) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    public void displayVehicleInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Color: " + color);
    }
}

class ElectricVehicle extends Vehicle {
    private double batteryCapacity;
    private double currentBatteryLevel;

    public ElectricVehicle(String model, double maxSpeed, String color, 
                           double batteryCapacity, double currentBatteryLevel) {
        super(model, maxSpeed, color);
        this.batteryCapacity = batteryCapacity;
        this.currentBatteryLevel = currentBatteryLevel;
    }

    public void charge(double amount) {
        if (amount <= 0) {
            System.out.println("Charging amount must be positive.");
            return;
        }
        currentBatteryLevel = Math.min(currentBatteryLevel + amount, batteryCapacity);
        System.out.println(model + " charged by " + amount + " kWh. Battery: " + 
                         String.format("%.2f", currentBatteryLevel) + "/" + batteryCapacity + " kWh");
    }

    @Override
    public void displayVehicleInfo() {
        System.out.println("=== Electric Vehicle ===");
        super.displayVehicleInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Current Battery Level: " + String.format("%.2f", currentBatteryLevel) + " kWh");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    private double fuelTankCapacity;
    private double currentFuel;

    public PetrolVehicle(String model, double maxSpeed, String color,
                        double fuelTankCapacity, double currentFuel) {
        super(model, maxSpeed, color);
        this.fuelTankCapacity = fuelTankCapacity;
        this.currentFuel = currentFuel;
    }

    @Override
    public void refuel(double amount) {
        if (amount <= 0) {
            System.out.println("Refuel amount must be positive.");
            return;
        }
        currentFuel = Math.min(currentFuel + amount, fuelTankCapacity);
        System.out.println(model + " refueled with " + amount + " liters. Fuel: " + 
                         String.format("%.2f", currentFuel) + "/" + fuelTankCapacity + " liters");
    }

    @Override
    public void displayFuelStatus() {
        System.out.println("Fuel Level: " + String.format("%.2f", currentFuel) + "/" + 
                         fuelTankCapacity + " liters");
    }

    @Override
    public void displayVehicleInfo() {
        System.out.println("=== Petrol Vehicle ===");
        super.displayVehicleInfo();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
        displayFuelStatus();
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Q4: Vehicle Management System with Hybrid Inheritance ===\n");

        ElectricVehicle tesla = new ElectricVehicle("Tesla Model 3", 220, "Black", 75, 45);
        PetrolVehicle honda = new PetrolVehicle("Honda Civic", 200, "White", 60, 35);
        ElectricVehicle nissan = new ElectricVehicle("Nissan Leaf", 160, "Silver", 62, 20);

        System.out.println("--- Electric Vehicle ---");
        tesla.displayVehicleInfo();
        tesla.charge(20);
        System.out.println();

        System.out.println("--- Petrol Vehicle ---");
        honda.displayVehicleInfo();
        honda.refuel(25);
        System.out.println();

        System.out.println("--- Another Electric Vehicle ---");
        nissan.displayVehicleInfo();
        nissan.charge(30);
        System.out.println();

        System.out.println("--- Demonstrating Hybrid Inheritance ---");
        System.out.println("Is tesla a Vehicle? " + (tesla instanceof Vehicle));
        System.out.println("Is honda a Vehicle? " + (honda instanceof Vehicle));
        System.out.println("Does honda implement Refuelable? " + (honda instanceof Refuelable));
        System.out.println("Does tesla implement Refuelable? " + (tesla instanceof Refuelable));

        System.out.println("\n--- Refueling Petrol Vehicles ---");
        Refuelable refuelableVehicle = honda;
        refuelableVehicle.refuel(15);
        refuelableVehicle.displayFuelStatus();

        sc.close();
    }
}
