// A university system has Person → Student → GradStudent. Each
// level adds attributes (GPA, thesis). Override toString() at each level.
// Use super() to chain constructors. Make studentId final.
// Demonstrate that GradStudent IS-A Student IS-A Person.

class Person {

    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name : " + name +
               "\nAge : " + age;
    }
}

class Student extends Person {

    private final int studentId;
    protected double gpa;

    public Student(String name, int age, int studentId, double gpa) {

        super(name, age);

        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {

        return super.toString() +
               "\nStudent ID : " + studentId +
               "\nGPA : " + gpa;
    }
}

class GradStudent extends Student {

    private String thesis;

    public GradStudent(String name,
                       int age,
                       int studentId,
                       double gpa,
                       String thesis) {

        super(name, age, studentId, gpa);

        this.thesis = thesis;
    }

    @Override
    public String toString() {

        return super.toString() +
               "\nThesis : " + thesis;
    }
}

public class Main {

    public static void main(String[] args) {

        GradStudent gs =
                new GradStudent(
                        "Faizan",
                        22,
                        101,
                        9.2,
                        "Cloud Computing Security"
                );

        System.out.println(gs);

        Person p = gs;
        Student s = gs;

        System.out.println("\nIS-A Relationship");

        System.out.println("GradStudent IS-A Person : "
                + (p instanceof Person));

        System.out.println("GradStudent IS-A Student : "
                + (s instanceof Student));
    }
}