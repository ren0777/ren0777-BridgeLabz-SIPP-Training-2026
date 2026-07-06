public class MovieSeatReservation {
    private static final int[] seats = {101, 102, 103, 104, 105};

    static int getSeat(int index) {
        try {
            return seats[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat position: " + index + ". Please select a valid position.");
            return -1;
        }
    }

    public static void main(String[] args) {
        int validSeat = getSeat(2);
        System.out.println("Seat at position 2: " + validSeat);

        int invalidSeat = getSeat(8);
        System.out.println("Seat at position 8: " + invalidSeat);
    }
}
