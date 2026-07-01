import java.util.Scanner;

class Device {
    protected String deviceId;
    protected String status;
    protected String deviceType;

    public Device(String deviceId, String deviceType) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.status = "OFF";
    }

    public void turnOn() {
        this.status = "ON";
        System.out.println(deviceType + " " + deviceId + " is now ON");
    }

    public void turnOff() {
        this.status = "OFF";
        System.out.println(deviceType + " " + deviceId + " is now OFF");
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Type: " + deviceType);
        System.out.println("Status: " + status);
    }
}

class Thermostat extends Device {
    private double temperatureSetting;
    private double currentTemperature;
    private String mode;

    public Thermostat(String deviceId, double temperatureSetting, double currentTemperature) {
        super(deviceId, "Thermostat");
        this.temperatureSetting = temperatureSetting;
        this.currentTemperature = currentTemperature;
        this.mode = "Auto";
    }

    public void setTemperature(double temp) {
        if (temp < 15 || temp > 30) {
            System.out.println("Temperature must be between 15°C and 30°C");
            return;
        }
        this.temperatureSetting = temp;
        System.out.println("Thermostat temperature set to " + temp + "°C");
    }

    public void setMode(String mode) {
        if (mode.equalsIgnoreCase("Heating") || mode.equalsIgnoreCase("Cooling") || mode.equalsIgnoreCase("Auto")) {
            this.mode = mode;
            System.out.println("Mode changed to " + mode);
        } else {
            System.out.println("Invalid mode. Choose from: Heating, Cooling, Auto");
        }
    }

    public void updateCurrentTemperature(double temp) {
        this.currentTemperature = temp;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Mode: " + mode);
        System.out.println("Current Temperature: " + String.format("%.1f", currentTemperature) + "°C");
        System.out.println("Target Temperature: " + String.format("%.1f", temperatureSetting) + "°C");
    }
}

public class SmartHomeDevices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Q5: Smart Home Devices ===\n");

        Device lightBulb = new Device("LIGHT001", "Smart Light Bulb");
        Device doorLock = new Device("LOCK001", "Smart Door Lock");
        Thermostat thermostat = new Thermostat("THERM001", 22.0, 20.5);

        System.out.println("--- Generic Device: Light Bulb ---");
        lightBulb.displayStatus();
        lightBulb.turnOn();
        System.out.println();

        System.out.println("--- Generic Device: Door Lock ---");
        doorLock.displayStatus();
        doorLock.turnOn();
        System.out.println();

        System.out.println("--- Smart Thermostat (Subclass) ---");
        thermostat.displayStatus();
        System.out.println();

        System.out.println("--- Operating Thermostat ---");
        thermostat.turnOn();
        thermostat.setMode("Heating");
        thermostat.setTemperature(23);
        thermostat.updateCurrentTemperature(22.8);
        System.out.println();

        System.out.println("--- Updated Thermostat Status ---");
        thermostat.displayStatus();
        System.out.println();

        System.out.println("--- Demonstrating Single Inheritance ---");
        System.out.println("Is Thermostat a Device? " + (thermostat instanceof Device));

        sc.close();
    }
}
