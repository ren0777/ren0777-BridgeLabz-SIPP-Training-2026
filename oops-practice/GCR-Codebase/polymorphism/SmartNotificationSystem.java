import java.util.Scanner;

class Notification {
    protected String recipientName;
    protected String message;
    protected String timestamp;

    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
        this.timestamp = java.time.LocalTime.now().toString();
    }

    public void sendNotification() {
        System.out.println("Sending notification to " + recipientName + ": " + message);
    }

    public void displayDetails() {
        System.out.println("Recipient: " + recipientName);
        System.out.println("Message: " + message);
        System.out.println("Sent at: " + timestamp);
    }
}

class EmailNotification extends Notification {
    private String emailAddress;

    public EmailNotification(String recipientName, String message, String emailAddress) {
        super(recipientName, message);
        this.emailAddress = emailAddress;
    }

    @Override
    public void sendNotification() {
        System.out.println("[EMAIL] Sending to " + recipientName + " (" + emailAddress + ")");
        System.out.println("Subject: Notification");
        System.out.println("Body: " + message);
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Email Notification ===");
        super.displayDetails();
        System.out.println("Email: " + emailAddress);
        System.out.println("Channel: Email");
    }
}

class SMSNotification extends Notification {
    private String phoneNumber;

    public SMSNotification(String recipientName, String message, String phoneNumber) {
        super(recipientName, message);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void sendNotification() {
        System.out.println("[SMS] Sending to " + recipientName + " (" + phoneNumber + ")");
        System.out.println("Message: " + message);
    }

    @Override
    public void displayDetails() {
        System.out.println("=== SMS Notification ===");
        super.displayDetails();
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Channel: SMS");
    }
}

class PushNotification extends Notification {
    private String deviceId;
    private String appName;

    public PushNotification(String recipientName, String message, String deviceId, String appName) {
        super(recipientName, message);
        this.deviceId = deviceId;
        this.appName = appName;
    }

    @Override
    public void sendNotification() {
        System.out.println("[PUSH] Sending to " + recipientName + " on " + appName);
        System.out.println("Device ID: " + deviceId);
        System.out.println("Notification: " + message);
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Push Notification ===");
        super.displayDetails();
        System.out.println("Device ID: " + deviceId);
        System.out.println("App: " + appName);
        System.out.println("Channel: Push");
    }
}

public class SmartNotificationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Smart Notification System ===\n");

        Notification[] notifications = new Notification[6];
        notifications[0] = new EmailNotification("Alice Johnson", "Your order has been confirmed", "alice@email.com");
        notifications[1] = new SMSNotification("Bob Smith", "Your OTP is 123456", "+1-555-0101");
        notifications[2] = new PushNotification("Charlie Brown", "Sale Alert: 50% off today!", "DEVICE_001", "ShopApp");
        notifications[3] = new EmailNotification("Diana Prince", "Password reset link sent", "diana@email.com");
        notifications[4] = new SMSNotification("Eve Wilson", "Appointment reminder for tomorrow", "+1-555-0102");
        notifications[5] = new PushNotification("Frank Miller", "New message from support team", "DEVICE_002", "ChatApp");

        System.out.println("--- Sending Notifications (Dynamic Method Dispatch) ---\n");
        for (Notification notification : notifications) {
            notification.sendNotification();
            System.out.println();
        }

        System.out.println("\n--- All Notifications Details ---\n");
        for (int i = 0; i < notifications.length; i++) {
            System.out.println("Notification " + (i + 1) + ":");
            notifications[i].displayDetails();
            System.out.println();
        }

        System.out.println("--- Notification Statistics ---");
        int emailCount = 0, smsCount = 0, pushCount = 0;
        for (Notification notification : notifications) {
            if (notification instanceof EmailNotification) {
                emailCount++;
            } else if (notification instanceof SMSNotification) {
                smsCount++;
            } else if (notification instanceof PushNotification) {
                pushCount++;
            }
        }

        System.out.println("Email Notifications: " + emailCount);
        System.out.println("SMS Notifications: " + smsCount);
        System.out.println("Push Notifications: " + pushCount);
        System.out.println("Total Notifications: " + notifications.length);

        sc.close();
    }
}
