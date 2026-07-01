// Sample Program 4: Shopping Cart System
// Concepts: static, this, final, instanceof

public class Product {

    // 1. STATIC – discount applies to ALL products equally
    static double discount   = 10.0;   // percentage
    static int    totalItems = 0;

    // 3. FINAL – productID is a permanent unique identifier
    final String productID;

    String productName;
    double price;
    int    quantity;

    // 2. THIS – resolves ambiguity for productName, price, quantity
    Product(String productID, String productName, double price, int quantity) {
        this.productID   = productID;     // 'this' used for all four fields
        this.productName = productName;
        this.price       = price;
        this.quantity    = quantity;
        totalItems++;
    }

    double discountedPrice() {
        return price - (price * discount / 100);
    }

    double totalCost() {
        return discountedPrice() * quantity;
    }

    void display() {
        System.out.println("Product ID      : " + productID);
        System.out.println("Name            : " + productName);
        System.out.println("Original Price  : Rs." + price);
        System.out.println("Discount        : " + discount + "%");
        System.out.println("Discounted Price: Rs." + discountedPrice());
        System.out.println("Quantity        : " + quantity);
        System.out.println("Total Cost      : Rs." + totalCost());
    }

    // 1. STATIC METHOD – updates discount for ALL products
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }

    public static void main(String[] args) {

        Product p1  = new Product("PRD-001", "Laptop",     75000.0, 1);
        Product p2  = new Product("PRD-002", "Headphones",  2500.0, 2);
        Object     obj = true;   // a Boolean, not a Product

        // 4. INSTANCEOF – validate before processing
        System.out.println("=== Product 1 ===");
        if (p1 instanceof Product) {
            p1.display();
        }

        System.out.println("\n=== Product 2 ===");
        if (p2 instanceof Product) {
            p2.display();
        }

        // Update static discount – affects ALL products instantly
        System.out.println("\n=== After Discount Update to 20% ===");
        Product.updateDiscount(20.0);

        System.out.println("\nProduct 1 after update:");
        p1.display();

        System.out.println("\nProduct 2 after update:");
        p2.display();

        System.out.println("\n=== instanceof check on Boolean object ===");
        if (!(obj instanceof Product)) {
            System.out.println("Object is NOT a Product instance. Skipping processing.");
        }

        // Prove final – uncommenting causes compile error:
        // p1.productID = "PRD-999";   // ERROR: cannot assign a value to final variable
    }
}
