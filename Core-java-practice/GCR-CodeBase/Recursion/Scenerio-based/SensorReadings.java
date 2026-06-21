// Scenario 1: Consecutive Sensor Readings
// Recursively determine whether temperature readings are strictly increasing.

public class SensorReadings {
    public static boolean isStrictlyIncreasing(int[] readings, int index) {
        if (index == readings.length - 1) {
            return true;
        }

        if (readings[index] >= readings[index + 1]) {
            return false;
        }

        return isStrictlyIncreasing(readings, index + 1);
    }

    public static void main(String[] args) {
        int[] readings = {12, 15, 18, 22, 30};
        System.out.println(isStrictlyIncreasing(readings, 0));
    }
}
