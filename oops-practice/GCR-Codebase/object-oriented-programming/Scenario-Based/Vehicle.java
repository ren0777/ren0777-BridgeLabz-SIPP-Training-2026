public class Vehicle {

    private String vehicleNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void displayInfo() {
        System.out.println("Number: " + vehicleNumber + " | Owner: " + ownerName + " | Type: " + vehicleType);
    }

    public static void displayCars(Vehicle[] vehicles) {
        System.out.println("--- Cars ---");
        for (Vehicle v : vehicles) {
            if (v.getVehicleType().equalsIgnoreCase("Car")) {
                v.displayInfo();
            }
        }
    }

    public static void displayBikes(Vehicle[] vehicles) {
        System.out.println("--- Bikes ---");
        for (Vehicle v : vehicles) {
            if (v.getVehicleType().equalsIgnoreCase("Bike")) {
                v.displayInfo();
            }
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[10];

        vehicles[0] = new Vehicle("MH01AB1234", "Alice", "Car");
        vehicles[1] = new Vehicle("DL02CD5678", "Bob", "Bike");
        vehicles[2] = new Vehicle("KA03EF9012", "Charlie", "Car");
        vehicles[3] = new Vehicle("TN04GH3456", "Diana", "Bike");
        vehicles[4] = new Vehicle("GJ05IJ7890", "Eve", "Car");
        vehicles[5] = new Vehicle("UP06KL2345", "Frank", "Bike");
        vehicles[6] = new Vehicle("RJ07MN6789", "Grace", "Car");
        vehicles[7] = new Vehicle("WB08OP0123", "Henry", "Bike");
        vehicles[8] = new Vehicle("MP09QR4567", "Iris", "Car");
        vehicles[9] = new Vehicle("PB10ST8901", "Jack", "Bike");

        displayCars(vehicles);
        System.out.println();
        displayBikes(vehicles);
    }
}
