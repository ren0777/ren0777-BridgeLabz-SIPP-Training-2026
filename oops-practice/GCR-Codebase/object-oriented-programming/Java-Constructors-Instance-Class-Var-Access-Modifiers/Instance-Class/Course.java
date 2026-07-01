// Section 2 – Problem 2: Online Course Management
// Demonstrates: Class variable (instituteName) shared across all Course instances

public class Course {

    // Instance variables
    String courseName;
    int    duration;   // in hours
    double fee;

    // Class variable – one value shared by ALL courses
    static String instituteName = "Sunrise Academy";

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration   = duration;
        this.fee        = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Institute: " + instituteName
                         + " | Course: " + courseName
                         + " | Duration: " + duration + " hrs"
                         + " | Fee: Rs." + fee);
    }

    // Class method – modifies the shared institute name for ALL courses
    static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute name updated to: " + instituteName);
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 40, 4999.0);
        Course c2 = new Course("Data Science",     60, 7999.0);

        System.out.println("-- Before Update --");
        c1.displayCourseDetails();
        c2.displayCourseDetails();

        Course.updateInstituteName("TechEd Institute");

        System.out.println("-- After Update (both courses reflect change) --");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
