import java.util.ArrayList;

public class SmartParkingSlotManager {
    private final ArrayList<String> parkedVehicles = new ArrayList<>();

    public void enterVehicle(String registrationNumber) {
        parkedVehicles.add(registrationNumber);
        System.out.println(registrationNumber + " entered parking.");
    }

    public void exitVehicle(String registrationNumber) {
        boolean removed = parkedVehicles.remove(registrationNumber);
        if (removed) {
            System.out.println(registrationNumber + " exited parking.");
        } else {
            System.out.println(registrationNumber + " not found in parking.");
        }
    }

    public void searchVehicle(String registrationNumber) {
        if (parkedVehicles.contains(registrationNumber)) {
            System.out.println(registrationNumber + " is currently parked.");
        } else {
            System.out.println(registrationNumber + " is not parked.");
        }
    }

    public void displayParkedVehicles() {
        System.out.println("\n--- Parked Vehicles ---");
        for (String regNo : parkedVehicles) {
            System.out.println(regNo);
        }
        System.out.println("Total Occupied Slots: " + parkedVehicles.size());
    }

    public static void main(String[] args) {
        SmartParkingSlotManager manager = new SmartParkingSlotManager();

        manager.enterVehicle("KA01AB1234");
        manager.enterVehicle("KA02CD5678");
        manager.enterVehicle("KA03EF9876");

        manager.searchVehicle("KA02CD5678");
        manager.searchVehicle("KA09ZZ0001");

        manager.exitVehicle("KA01AB1234");
        manager.exitVehicle("KA99XX1111");

        manager.displayParkedVehicles();
    }
}
