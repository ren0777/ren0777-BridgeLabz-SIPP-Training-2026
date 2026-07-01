// Build a fitness tracker: interfaces Trackable (logActivity()),
// Reportable (generateReport()), Notifiable (sendAlert()). Class
// FitnessDevice implements all three. Add a default method
// resetData() to Trackable. Demonstrate multiple interface
// implementation Java cannot do with classes.

interface Trackable {

    void logActivity();

    default void resetData() {
        System.out.println("Activity data has been reset.");
    }
}

interface Reportable {

    void generateReport();
}

interface Notifiable {

    void sendAlert();
}

class FitnessDevice implements Trackable, Reportable, Notifiable {

    @Override
    public void logActivity() {
        System.out.println("Activity Logged.");
    }

    @Override
    public void generateReport() {
        System.out.println("Fitness Report Generated.");
    }

    @Override
    public void sendAlert() {
        System.out.println("Workout Reminder Sent.");
    }
}

public class Main {

    public static void main(String[] args) {

        FitnessDevice device = new FitnessDevice();

        device.logActivity();

        device.generateReport();

        device.sendAlert();

        device.resetData();
    }
}