import java.time.LocalDate;
import java.util.Scanner;

class Order {
    protected String orderId;
    protected LocalDate orderDate;
    protected double amount;

    public Order(String orderId, LocalDate orderDate, double amount) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.amount = amount;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }

    public void displayOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Amount: $" + String.format("%.2f", amount));
        System.out.println("Status: " + getOrderStatus());
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;
    protected LocalDate shipDate;

    public ShippedOrder(String orderId, LocalDate orderDate, double amount, 
                        String trackingNumber, LocalDate shipDate) {
        super(orderId, orderDate, amount);
        this.trackingNumber = trackingNumber;
        this.shipDate = shipDate;
    }

    @Override
    public String getOrderStatus() {
        return "Shipped";
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Ship Date: " + shipDate);
    }
}

class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;
    private String deliveryAddress;

    public DeliveredOrder(String orderId, LocalDate orderDate, double amount,
                         String trackingNumber, LocalDate shipDate, 
                         LocalDate deliveryDate, String deliveryAddress) {
        super(orderId, orderDate, amount, trackingNumber, shipDate);
        this.deliveryDate = deliveryDate;
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String getOrderStatus() {
        return "Delivered";
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Delivery Address: " + deliveryAddress);
    }
}

public class OnlineRetailOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Q3: Online Retail Order Management ===\n");

        LocalDate today = LocalDate.now();

        Order order1 = new Order("ORD001", today.minusDays(10), 150.50);
        ShippedOrder order2 = new ShippedOrder("ORD002", today.minusDays(8), 275.75, 
                                               "TRK123456789", today.minusDays(5));
        DeliveredOrder order3 = new DeliveredOrder("ORD003", today.minusDays(15), 420.00,
                                                   "TRK987654321", today.minusDays(10),
                                                   today.minusDays(2), "123 Main St, New York, NY");

        System.out.println("--- Order 1: Order Placed ---");
        order1.displayOrderInfo();
        System.out.println();

        System.out.println("--- Order 2: Shipped Order ---");
        order2.displayOrderInfo();
        System.out.println();

        System.out.println("--- Order 3: Delivered Order ---");
        order3.displayOrderInfo();
        System.out.println();

        System.out.println("--- Demonstrating Multilevel Inheritance ---");
        System.out.println("Is DeliveredOrder a ShippedOrder? " + (order3 instanceof ShippedOrder));
        System.out.println("Is DeliveredOrder an Order? " + (order3 instanceof Order));
        System.out.println("Is ShippedOrder an Order? " + (order2 instanceof Order));

        sc.close();
    }
}
