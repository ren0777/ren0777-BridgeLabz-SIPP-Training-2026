// Program 3: Person – Copy Constructor

public class Person {

    String name;
    int    age;
    String email;

    // Parameterized constructor
    Person(String name, int age, String email) {
        this.name  = name;
        this.age   = age;
        this.email = email;
    }

    // Copy constructor
    Person(Person other) {
        this.name  = other.name;
        this.age   = other.age;
        this.email = other.email;
    }

    void display() {
        System.out.println("Name: " + name + " | Age: " + age + " | Email: " + email);
    }

    public static void main(String[] args) {
        Person original = new Person("Arjun", 22, "arjun@email.com");
        Person copy     = new Person(original);   // copy constructor

        copy.name = "Arjun (Clone)";   // modifying copy does not affect original

        System.out.println("-- Original --");
        original.display();

        System.out.println("-- Copied Person --");
        copy.display();
    }
}
