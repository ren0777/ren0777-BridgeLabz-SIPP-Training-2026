// Program 6: Car Rental System – Constructors + Total Cost Calculation

public class CarRental {

    String customerName;
    String carModel;
    int rentalDays;

    static final double DAILY_RATE = 1500.0; // Rs. per day (constant)

    // Default constructor
    CarRental() {
        customerName = "Unknown Customer";
        carModel     = "Sedan";
        rentalDays   = 1;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel     = carModel;
        this.rentalDays   = rentalDays;
    }

    double calculateTotalCost() {
        return rentalDays * DAILY_RATE;
    }

    void display() {
        System.out.println("Customer : " + customerName
                + " | Car: " + carModel
                + " | Days: " + rentalDays
                + " | Total Cost: Rs." + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental r1 = new CarRental();
        CarRental r2 = new CarRental("Neha Gupta", "SUV", 5);

        System.out.println("-- Default Rental --");
        r1.display();

        System.out.println("-- Parameterized Rental --");
        r2.display();
    }
}
