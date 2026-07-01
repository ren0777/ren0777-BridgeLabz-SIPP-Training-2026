import java.util.Scanner;

class Vehicle {
    protected String vehicleNumber;
    protected String ownerName;
    protected double fuelEfficiency;

    public Vehicle(String vehicleNumber, String ownerName, double fuelEfficiency) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.fuelEfficiency = fuelEfficiency;
    }

    public double fuelCost(int km) {
        return km / fuelEfficiency * 100;
    }

    public void displayInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Owner: " + ownerName);
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " km/liter");
    }
}

class Car extends Vehicle {
    public Car(String vehicleNumber, String ownerName, double fuelEfficiency) {
        super(vehicleNumber, ownerName, fuelEfficiency);
    }

    @Override
    public double fuelCost(int km) {
        double cost = super.fuelCost(km);
        return cost + (cost * 0.10);
    }
}

class Bus extends Vehicle {
    public Bus(String vehicleNumber, String ownerName, double fuelEfficiency) {
        super(vehicleNumber, ownerName, fuelEfficiency);
    }

    @Override
    public double fuelCost(int km) {
        double cost = super.fuelCost(km);
        return cost - (cost * 0.20);
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, String ownerName, double fuelEfficiency) {
        super(vehicleNumber, ownerName, fuelEfficiency);
    }

    @Override
    public double fuelCost(int km) {
        return super.fuelCost(km);
    }
}

class ElectricCar extends Vehicle {
    private double batteryCapacity;

    public ElectricCar(String vehicleNumber, String ownerName, double batteryCapacity) {
        super(vehicleNumber, ownerName, 0);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public double fuelCost(int km) {
        double chargeCost = (km / 100.0) * batteryCapacity * 5;
        return chargeCost;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Type: Electric Vehicle");
    }
}

public class TransportCompanyFleet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Transport Company Fleet Management ===\n");

        Vehicle[] fleet = new Vehicle[5];
        fleet[0] = new Car("CAR001", "John Doe", 12.5);
        fleet[1] = new Bus("BUS001", "City Transport", 8.0);
        fleet[2] = new Bike("BIKE001", "Mike Smith", 50.0);
        fleet[3] = new Car("CAR002", "Sarah Johnson", 14.0);
        fleet[4] = new ElectricCar("ECAR001", "Tech Company", 75.0);

        System.out.println("--- Fleet Vehicles ---");
        for (int i = 0; i < fleet.length; i++) {
            System.out.println("\nVehicle " + (i + 1) + ":");
            fleet[i].displayInfo();
        }

        System.out.println("\n--- Calculating Fuel Cost for 100 km ---");
        int distance = 100;
        double totalCost = 0;
        int carCount = 0, busCount = 0, bikeCount = 0, electricCarCount = 0;

        for (Vehicle vehicle : fleet) {
            double cost = vehicle.fuelCost(distance);
            totalCost += cost;

            if (vehicle instanceof ElectricCar) {
                System.out.println(vehicle.vehicleNumber + " (ElectricCar): $" + String.format("%.2f", cost));
                electricCarCount++;
            } else if (vehicle instanceof Car) {
                System.out.println(vehicle.vehicleNumber + " (Car): $" + String.format("%.2f", cost));
                carCount++;
            } else if (vehicle instanceof Bus) {
                System.out.println(vehicle.vehicleNumber + " (Bus): $" + String.format("%.2f", cost));
                busCount++;
            } else if (vehicle instanceof Bike) {
                System.out.println(vehicle.vehicleNumber + " (Bike): $" + String.format("%.2f", cost));
                bikeCount++;
            }
        }

        System.out.println("\n--- Fleet Statistics ---");
        System.out.println("Total Fuel Cost for " + distance + " km: $" + String.format("%.2f", totalCost));
        System.out.println("Cars: " + carCount);
        System.out.println("Buses: " + busCount);
        System.out.println("Bikes: " + bikeCount);
        System.out.println("Electric Cars: " + electricCarCount);
        System.out.println("\nNote: ElectricCar added without modifying existing code (Open/Closed Principle)");

        sc.close();
    }
}
