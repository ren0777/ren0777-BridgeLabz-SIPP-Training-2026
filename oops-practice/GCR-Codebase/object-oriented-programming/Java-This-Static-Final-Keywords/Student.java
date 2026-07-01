// Sample Program 5: University Student Management
// Concepts: static, this, final, instanceof

public class Student {

    // 1. STATIC – universityName and totalStudents shared across all instances
    static String universityName  = "Sunrise University";
    static int    totalStudents   = 0;

    // 3. FINAL – rollNumber cannot be changed once assigned
    final String rollNumber;

    String name;
    char   grade;

    // 2. THIS – resolves ambiguity for name, rollNumber, grade
    Student(String rollNumber, String name, char grade) {
        this.rollNumber = rollNumber;    // 'this' used for all three fields
        this.name       = name;
        this.grade      = grade;
        totalStudents++;
    }

    // Update grade (rollNumber stays final – cannot be changed)
    void updateGrade(char newGrade) {
        System.out.println(name + "'s grade updated: " + grade + " → " + newGrade);
        this.grade = newGrade;
    }

    void display() {
        System.out.println("University : " + universityName);
        System.out.println("Roll No    : " + rollNumber);
        System.out.println("Name       : " + name);
        System.out.println("Grade      : " + grade);
    }

    // 1. STATIC METHOD
    static void displayTotalStudents() {
        System.out.println("University     : " + universityName);
        System.out.println("Total Students : " + totalStudents);
    }

    public static void main(String[] args) {

        Student s1  = new Student("2024CSE001", "Ananya Singh", 'A');
        Student s2  = new Student("2024CSE002", "Karan Patel",  'B');
        Object     obj = new int[]{1, 2, 3};   // an int array, not a Student

        // 4. INSTANCEOF – check before displaying or updating
        System.out.println("=== Student 1 ===");
        if (s1 instanceof Student) {
            s1.display();
        }

        System.out.println("\n=== Student 2 – Update Grade ===");
        if (s2 instanceof Student) {
            s2.display();
            s2.updateGrade('A');
            System.out.println("After update:");
            s2.display();
        }

        System.out.println("\n=== instanceof check on int[] object ===");
        if (!(obj instanceof Student)) {
            System.out.println("Object is NOT a Student instance. Skipping operation.");
        }

        System.out.println();
        Student.displayTotalStudents();   // static method call

        // Prove final – uncommenting causes compile error:
        // s1.rollNumber = "2024CSE999";   // ERROR: cannot assign a value to final variable
    }
}
