// Program 4: Hotel Booking System – Default, Parameterized & Copy Constructors

public class HotelBooking {

    String guestName;
    String roomType;
    int    nights;

    // Default constructor
    HotelBooking() {
        guestName = "Walk-In Guest";
        roomType  = "Standard";
        nights    = 1;
    }

    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType  = roomType;
        this.nights    = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType  = other.roomType;
        this.nights    = other.nights;
    }

    void display() {
        System.out.println("Guest: " + guestName
                         + " | Room: " + roomType
                         + " | Nights: " + nights);
    }

    public static void main(String[] args) {
        HotelBooking b1 = new HotelBooking();
        HotelBooking b2 = new HotelBooking("Priya Sharma", "Deluxe", 3);
        HotelBooking b3 = new HotelBooking(b2);   // copy of b2
        b3.guestName = "Rohit (Extended Stay)";

        System.out.println("-- Default Booking --");
        b1.display();

        System.out.println("-- Parameterized Booking --");
        b2.display();

        System.out.println("-- Copied & Modified Booking --");
        b3.display();
    }
}
