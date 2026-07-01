public class SpaceTourist {

    private static int totalReservations = 0;
    private static String missionName = "Lunar Explorer 2025";

    private String touristName;
    private int seatNumber;

    public SpaceTourist(String touristName, int seatNumber) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        totalReservations++;
    }

    public SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public void displayDetails() {
        System.out.println("Mission: " + missionName + " | Tourist: " + touristName + " | Seat: " + seatNumber);
    }

    public static int getTotalReservations() {
        return totalReservations;
    }

    public static void main(String[] args) {
        SpaceTourist t1 = new SpaceTourist("Alice", 1);
        SpaceTourist t2 = new SpaceTourist("Bob", 2);
        SpaceTourist t3 = new SpaceTourist("Charlie", 3);

        t1.updateSeatNumber(10).updateSeatNumber(15);
        t2.updateSeatNumber(20).updateSeatNumber(25);

        t1.displayDetails();
        t2.displayDetails();
        t3.displayDetails();

        System.out.println("Total Reservations: " + SpaceTourist.getTotalReservations());
    }
}
