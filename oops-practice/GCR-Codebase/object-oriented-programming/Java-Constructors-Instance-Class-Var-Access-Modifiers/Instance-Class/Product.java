// Section 2 – Problem 1: Product Inventory
// Demonstrates: Instance variables vs Class (static) variable and methods

public class Product {

    // Instance variables (unique per object)
    String productName;
    double price;

    // Class variable – shared across ALL Product instances
    static int totalProducts = 0;

    Product(String productName, double price) {
        this.productName = productName;
        this.price       = price;
        totalProducts++;   // increments for every new Product created
    }

    // Instance method – works on one specific product
    void displayProductDetails() {
        System.out.println("Product: " + productName + " | Price: Rs." + price);
    }

    // Class (static) method – belongs to the class, not any single object
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop",   75000.0);
        Product p2 = new Product("Mouse",     1200.0);
        Product p3 = new Product("Keyboard",  2500.0);

        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();

        Product.displayTotalProducts();   // called on class, not object
    }
}
