interface Trackable {
    void logActivity(String activity);

    default void resetData() {
        System.out.println("All fitness data has been reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {

    private String deviceOwner;
    private String[] activities = new String[10];
    private int activityCount = 0;

    public FitnessDevice(String deviceOwner) {
        this.deviceOwner = deviceOwner;
    }

    @Override
    public void logActivity(String activity) {
        if (activityCount < activities.length) {
            activities[activityCount++] = activity;
            System.out.println("Activity logged: " + activity);
        }
    }

    @Override
    public void generateReport() {
        System.out.println("\n--- Fitness Report for " + deviceOwner + " ---");
        for (int i = 0; i < activityCount; i++) {
            System.out.println((i + 1) + ". " + activities[i]);
        }
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("ALERT for " + deviceOwner + ": " + message);
    }
}

public class FitnessTracker {
    public static void main(String[] args) {
        FitnessDevice device = new FitnessDevice("Alice");

        device.logActivity("Morning Run - 5km");
        device.logActivity("Cycling - 20 mins");
        device.logActivity("Yoga - 30 mins");
        device.logActivity("Swimming - 45 mins");

        device.generateReport();

        device.sendAlert("You have reached your daily step goal!");
        device.sendAlert("Time to drink water!");

        device.resetData();
    }
}
