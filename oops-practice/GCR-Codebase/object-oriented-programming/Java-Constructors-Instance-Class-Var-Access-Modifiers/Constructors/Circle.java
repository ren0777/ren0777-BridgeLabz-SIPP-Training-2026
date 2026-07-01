// Program 2: Circle – Constructor Chaining using this()

public class Circle {

    double radius;

    // Default constructor chains to parameterized one
    Circle() {
        this(1.0);   // constructor chaining
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    void display() {
        System.out.printf("Radius: %.2f | Area: %.4f%n", radius, area());
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();       // chains to Circle(1.0)
        Circle c2 = new Circle(5.5);

        System.out.println("-- Default (chained) Constructor --");
        c1.display();

        System.out.println("-- Parameterized Constructor --");
        c2.display();
    }
}
