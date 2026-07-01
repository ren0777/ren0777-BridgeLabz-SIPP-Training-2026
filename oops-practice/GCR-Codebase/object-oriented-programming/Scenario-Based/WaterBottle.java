public class WaterBottle {

    private String ownerName;
    private double dailyTarget;

    public WaterBottle(String ownerName, double dailyTarget) {
        this.ownerName = ownerName;
        this.dailyTarget = dailyTarget;
    }

    public void displayBottleInfo() {
        System.out.println("Owner: " + ownerName + " | Daily Target: " + dailyTarget + " liters");
    }

    public static void main(String[] args) {
        WaterBottle bottle1 = new WaterBottle("Alice", 2.5);
        WaterBottle bottle2 = new WaterBottle("Bob", 3.0);

        bottle1.displayBottleInfo();
        bottle2.displayBottleInfo();
    }
}
