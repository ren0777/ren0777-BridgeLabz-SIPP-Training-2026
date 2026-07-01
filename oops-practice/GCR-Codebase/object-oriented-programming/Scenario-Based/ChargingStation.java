public class ChargingStation {

    private static int totalStations = 0;
    private static double electricityRate = 8.5;

    private String stationId;
    private double unitsConsumed;

    public ChargingStation(String stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    public double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    public void displayStationDetails() {
        System.out.println("Station ID: " + stationId + " | Units Consumed: " + unitsConsumed + " | Bill: Rs." + calculateBill());
    }

    public static void setElectricityRate(double rate) {
        electricityRate = rate;
    }

    public static int getTotalStations() {
        return totalStations;
    }

    public static void main(String[] args) {
        ChargingStation s1 = new ChargingStation("CS-01", 30);
        ChargingStation s2 = new ChargingStation("CS-02", 45);
        ChargingStation s3 = new ChargingStation("CS-03", 20);
        ChargingStation s4 = new ChargingStation("CS-04", 60);
        ChargingStation s5 = new ChargingStation("CS-05", 10);

        System.out.println("--- Bills at Rate: Rs." + electricityRate + " ---");
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("\nUpdating electricity rate to Rs.10.0...\n");
        ChargingStation.setElectricityRate(10.0);

        System.out.println("--- Bills at Updated Rate: Rs.10.0 ---");
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("\nTotal Stations: " + ChargingStation.getTotalStations());
    }
}
