interface HeartRateMonitor {
    int getHeartRate(String patientId);

    default void displayHealthTips() {
        System.out.println("HeartRateMonitor: Maintain a resting heart rate between 60-100 bpm. Exercise regularly.");
    }
}

interface TemperatureMonitor {
    double getTemperature(String patientId);

    default void displayHealthTips() {
        System.out.println("TemperatureMonitor: Normal body temperature is 36.1°C to 37.2°C. Stay hydrated.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null && patientId.startsWith("P") && patientId.length() == 5;
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {

    private int[] heartRates = {72, 95, 110, 65, 88};
    private double[] temperatures = {36.5, 37.0, 38.9, 36.8, 37.5};

    @Override
    public int getHeartRate(String patientId) {
        int index = getIndex(patientId);
        return index >= 0 ? heartRates[index] : -1;
    }

    @Override
    public double getTemperature(String patientId) {
        int index = getIndex(patientId);
        return index >= 0 ? temperatures[index] : -1;
    }

    private int getIndex(String patientId) {
        int id = Integer.parseInt(patientId.substring(1)) - 1;
        return (id >= 0 && id < heartRates.length) ? id : -1;
    }

    @Override
    public void displayHealthTips() {
        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    public void generateHealthReport(String[] patientNames, String[] patientIds) {
        System.out.println("\n--- Patient Health Report ---");
        for (int i = 0; i < patientNames.length; i++) {
            boolean validId = TemperatureMonitor.isPatientIdValid(patientIds[i]);
            System.out.println("\nPatient: " + patientNames[i] + " | ID: " + patientIds[i]);
            if (!validId) {
                System.out.println("  Status: INVALID PATIENT ID");
                continue;
            }
            int hr = getHeartRate(patientIds[i]);
            double temp = getTemperature(patientIds[i]);
            System.out.println("  Heart Rate: " + hr + " bpm | " + (hr >= 60 && hr <= 100 ? "NORMAL" : "ABNORMAL"));
            System.out.println("  Temperature: " + temp + "°C | " + (temp >= 36.1 && temp <= 37.2 ? "NORMAL" : "ABNORMAL"));
        }
    }
}

public class SmartHealthcareMonitoring {
    public static void main(String[] args) {
        HealthMonitoringSystem system = new HealthMonitoringSystem();

        String[] patientNames = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        String[] patientIds = {"P0001", "P0002", "P0003", "P9999", "XY123"};

        system.displayHealthTips();
        system.generateHealthReport(patientNames, patientIds);
    }
}
