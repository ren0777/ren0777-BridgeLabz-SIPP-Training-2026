import java.util.Scanner;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person {
    protected final int studentId;
    protected double gpa;

    public Student(String name, int age, int studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId=" + studentId +
                ", gpa=" + gpa +
                '}';
    }
}

class GradStudent extends Student {
    private String thesis;
    private String department;

    public GradStudent(String name, int age, int studentId, double gpa, String thesis, String department) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
        this.department = department;
    }

    @Override
    public String toString() {
        return "GradStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId=" + studentId +
                ", gpa=" + gpa +
                ", thesis='" + thesis + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

public class PersonStudentGradStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Q1: Person → Student → GradStudent Inheritance ===\n");

        Person person = new Person("John Doe", 30);
        Student student = new Student("Alice Johnson", 20, 1001, 3.8);
        GradStudent gradStudent = new GradStudent("Bob Smith", 25, 1002, 3.9, 
                                                   "Machine Learning Optimization", "Computer Science");

        System.out.println("--- Person Instance ---");
        System.out.println(person);

        System.out.println("\n--- Student Instance (IS-A Person) ---");
        System.out.println(student);

        System.out.println("\n--- GradStudent Instance (IS-A Student IS-A Person) ---");
        System.out.println(gradStudent);

        System.out.println("\n--- Demonstrating IS-A Relationships ---");
        System.out.println("Is Student a Person? " + (student instanceof Person));
        System.out.println("Is GradStudent a Student? " + (gradStudent instanceof Student));
        System.out.println("Is GradStudent a Person? " + (gradStudent instanceof Person));

        System.out.println("\n--- Final studentId (Cannot be modified) ---");
        System.out.println("Student ID for gradStudent: " + gradStudent.studentId);
        System.out.println("studentId is final - prevents modification after construction");

        sc.close();
    }
}
