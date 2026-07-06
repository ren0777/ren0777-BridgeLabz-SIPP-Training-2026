import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SmartClassroomAttendanceTracker {
    private final HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    public void markAttendance(String subject, String student) {
        attendance.putIfAbsent(subject, new ArrayList<>());
        ArrayList<String> students = attendance.get(subject);

        if (students.contains(student)) {
            System.out.println("Duplicate attendance ignored for " + student + " in " + subject);
            return;
        }

        students.add(student);
        System.out.println("Attendance marked: " + student + " -> " + subject);
    }

    public void displayAttendanceBySubject() {
        System.out.println("\n--- Subject-wise Attendance ---");
        for (Map.Entry<String, ArrayList<String>> entry : attendance.entrySet()) {
            String subject = entry.getKey();
            ArrayList<String> students = entry.getValue();

            System.out.println(subject + ": " + students);
            System.out.println("Total Present in " + subject + ": " + students.size());
        }
    }

    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();

        tracker.markAttendance("Math", "Riya");
        tracker.markAttendance("Math", "Kabir");
        tracker.markAttendance("Math", "Riya");

        tracker.markAttendance("Science", "Aarav");
        tracker.markAttendance("Science", "Mira");
        tracker.markAttendance("Science", "Mira");

        tracker.displayAttendanceBySubject();
    }
}
