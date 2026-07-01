// Sample Program 6: Vehicle Registration System
// Concepts: static, this, final, instanceof

public class Vehicle {

    // 1. STATIC – registrationFee is common for all vehicles
    static double registrationFee = 2000.0;
    static int totalVehicles = 0;

    // 3. FINAL – registrationNumber is a permanent unique identifier
    final String registrationNumber;

    String ownerName;
    String vehicleType;

    // 2. THIS – resolves ambiguity for ownerName, vehicleType, registrationNumber
    Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber; // 'this' for all three fields
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        totalVehicles++;
    }

    void display() {
        System.out.println("Registration No  : " + registrationNumber);
        System.out.println("Owner Name       : " + ownerName);
        System.out.println("Vehicle Type     : " + vehicleType);
        System.out.println("Registration Fee : Rs." + registrationFee);
    }

    // 1. STATIC METHOD – updates the fee for ALL vehicles
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: Rs." + registrationFee);
    }

    static void displayTotalVehicles() {
        System.out.println("Total Vehicles Registered: " + totalVehicles);
    }

    public static void main(String[] args) {

        Vehicle v1 = new Vehicle("UK07-AB-1234", "Amit Rawat", "Car");
        Vehicle v2 = new Vehicle("UK07-CD-5678", "Priya Negi", "Bike");
        Object obj = "Just a String"; // not a Vehicle

        // 4. INSTANCEOF – check before displaying registration details
        System.out.println("=== Vehicle 1 ===");
        if (v1 instanceof Vehicle) {
            v1.display();
        }

        System.out.println("\n=== Vehicle 2 ===");
        if (v2 instanceof Vehicle) {
            v2.display();
        }

        // Update static fee – reflects in all vehicle objects instantly
        System.out.println("\n=== Fee Update ===");
        Vehicle.updateRegistrationFee(2500.0);

        System.out.println("\nVehicle 1 after fee update:");
        v1.display();

        System.out.println("\nVehicle 2 after fee update:");
        v2.display();

        System.out.println("\n=== instanceof check on String object ===");
        if (!(obj instanceof Vehicle)) {
            System.out.println("Object is NOT a Vehicle instance. Skipping display.");
        }

        System.out.println();
        Vehicle.displayTotalVehicles();

        // Prove final – uncommenting causes compile error:
        // v1.registrationNumber = "UK00-XX-0000"; // ERROR: cannot assign to final
        // variable
    }
}
