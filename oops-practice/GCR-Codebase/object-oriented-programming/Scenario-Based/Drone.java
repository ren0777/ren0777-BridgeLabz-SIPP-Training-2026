public class Drone {

    private String droneId;
    private int batteryPercentage;
    private static String companyName = "SwiftDrone Logistics";

    public Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    public void startDelivery() {
        if (batteryPercentage < 20) {
            System.out.println("Drone " + droneId + " has low battery. Cannot start delivery.");
        } else {
            batteryPercentage -= 20;
            System.out.println("Drone " + droneId + " started delivery. Battery remaining: " + batteryPercentage + "%");
        }
    }

    public void displayStatus() {
        System.out.println("Company: " + companyName + " | Drone ID: " + droneId + " | Battery: " + batteryPercentage + "%");
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static void main(String[] args) {
        Drone d1 = new Drone("D-101", 80);
        Drone d2 = new Drone("D-102", 15);
        Drone d3 = new Drone("D-103", 60);

        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();

        System.out.println();

        d1.startDelivery();
        d2.startDelivery();
        d3.startDelivery();

        System.out.println();

        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();
    }
}
