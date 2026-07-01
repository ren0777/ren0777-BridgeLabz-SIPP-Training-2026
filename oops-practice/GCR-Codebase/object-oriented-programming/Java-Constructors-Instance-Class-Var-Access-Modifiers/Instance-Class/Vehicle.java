// Section 2 – Problem 3: Vehicle Registration
// Demonstrates: Class variable registrationFee shared by all Vehicle instances

public class Vehicle {

    // Instance variables
    String ownerName;
    String vehicleType;

    // Class variable – fixed fee applied to all vehicles
    static double registrationFee = 2000.0;

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName   = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method
    void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName
                         + " | Type: " + vehicleType
                         + " | Registration Fee: Rs." + registrationFee);
    }

    // Class method – updates the fee for all vehicles at once
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: Rs." + registrationFee);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Amit Tiwari", "Car");
        Vehicle v2 = new Vehicle("Sunita Rao",  "Bike");

        System.out.println("-- Before Fee Update --");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(2500.0);

        System.out.println("-- After Fee Update (both vehicles reflect change) --");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
