import java.util.Scanner;

class Course {
    protected String courseName;
    protected int duration;
    protected String instructor;

    public Course(String courseName, int duration, String instructor) {
        this.courseName = courseName;
        this.duration = duration;
        this.instructor = instructor;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Instructor: " + instructor);
    }
}

class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String instructor,
                       String platform, boolean isRecorded) {
        super(courseName, duration, instructor);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration, String instructor,
                           String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, instructor, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double calculateFinalPrice() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Original Fee: $" + String.format("%.2f", fee));
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: $" + String.format("%.2f", calculateFinalPrice()));
    }
}

public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Q6: Educational Course Hierarchy ===\n");

        Course basicCourse = new Course("Data Structures Basics", 20, "Prof. John Smith");

        OnlineCourse onlineCourse = new OnlineCourse("Web Development Fundamentals", 30, 
                                                      "Prof. Sarah Johnson", "Udemy", true);

        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Advanced Machine Learning", 50,
                                                           "Prof. Robert Williams", "Coursera", true, 199.99, 20);

        System.out.println("--- Basic Course (Offline) ---");
        basicCourse.displayCourseInfo();
        System.out.println();

        System.out.println("--- Online Course (Free) ---");
        onlineCourse.displayCourseInfo();
        System.out.println();

        System.out.println("--- Paid Online Course ---");
        paidCourse.displayCourseInfo();
        System.out.println();

        System.out.println("--- Another Paid Online Course ---");
        PaidOnlineCourse paidCourse2 = new PaidOnlineCourse("Python for Data Science", 40,
                                                            "Prof. Lisa Chen", "Pluralsight", true, 149.99, 15);
        paidCourse2.displayCourseInfo();
        System.out.println();

        System.out.println("--- Demonstrating Multilevel Inheritance ---");
        System.out.println("Is PaidOnlineCourse an OnlineCourse? " + (paidCourse instanceof OnlineCourse));
        System.out.println("Is PaidOnlineCourse a Course? " + (paidCourse instanceof Course));
        System.out.println("Is OnlineCourse a Course? " + (onlineCourse instanceof Course));

        sc.close();
    }
}
