import java.util.Scanner;

class Subscription {
    protected String subscriberName;
    protected String subscriptionId;
    protected int monthsActive;

    public Subscription(String subscriberName, String subscriptionId, int monthsActive) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
        this.monthsActive = monthsActive;
    }

    public double calculateMonthlyCharge() {
        return 9.99;
    }

    public void displayInfo() {
        System.out.println("Subscriber: " + subscriberName);
        System.out.println("Subscription ID: " + subscriptionId);
        System.out.println("Months Active: " + monthsActive);
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public String getSubscriberName() {
        return subscriberName;
    }
}

class BasicPlan extends Subscription {
    public BasicPlan(String subscriberName, String subscriptionId, int monthsActive) {
        super(subscriberName, subscriptionId, monthsActive);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 9.99;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Basic Plan ===");
        super.displayInfo();
        System.out.println("Plan: Basic (SD Quality)");
        System.out.println("Monthly Charge: $" + String.format("%.2f", calculateMonthlyCharge()));
    }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String subscriberName, String subscriptionId, int monthsActive) {
        super(subscriberName, subscriptionId, monthsActive);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 15.99;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Premium Plan ===");
        super.displayInfo();
        System.out.println("Plan: Premium (4K Quality)");
        System.out.println("Monthly Charge: $" + String.format("%.2f", calculateMonthlyCharge()));
    }
}

class FamilyPlan extends Subscription {
    private int numberOfProfiles;

    public FamilyPlan(String subscriberName, String subscriptionId, int monthsActive, int numberOfProfiles) {
        super(subscriberName, subscriptionId, monthsActive);
        this.numberOfProfiles = numberOfProfiles;
    }

    @Override
    public double calculateMonthlyCharge() {
        return 19.99;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Family Plan ===");
        super.displayInfo();
        System.out.println("Plan: Family (4K Quality, 4 Profiles)");
        System.out.println("Number of Profiles: " + numberOfProfiles);
        System.out.println("Monthly Charge: $" + String.format("%.2f", calculateMonthlyCharge()));
    }
}

public class StreamingPlatformSubscriptionAnalyzer {
    public static Subscription searchBySubscriptionId(Subscription[] subscriptions, String subscriptionId) {
        for (Subscription subscription : subscriptions) {
            if (subscription.getSubscriptionId().equals(subscriptionId)) {
                return subscription;
            }
        }
        return null;
    }

    public static void displaySubscribersByLetter(Subscription[] subscriptions, char letter) {
        System.out.println("\nSubscribers starting with '" + letter + "':");
        boolean found = false;
        for (Subscription subscription : subscriptions) {
            if (subscription.getSubscriberName().charAt(0) == Character.toUpperCase(letter)) {
                System.out.println("  - " + subscription.getSubscriberName() + " (" + subscription.subscriptionId + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("  No subscribers found starting with '" + letter + "'");
        }
    }

    public static double calculateTotalMonthlyRevenue(Subscription[] subscriptions) {
        double totalRevenue = 0;
        for (Subscription subscription : subscriptions) {
            totalRevenue += subscription.calculateMonthlyCharge();
        }
        return totalRevenue;
    }

    public static Subscription findMostExpensiveSubscription(Subscription[] subscriptions) {
        Subscription mostExpensive = subscriptions[0];
        double maxCharge = subscriptions[0].calculateMonthlyCharge();

        for (Subscription subscription : subscriptions) {
            if (subscription.calculateMonthlyCharge() > maxCharge) {
                maxCharge = subscription.calculateMonthlyCharge();
                mostExpensive = subscription;
            }
        }
        return mostExpensive;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Streaming Platform Subscription Analyzer ===\n");

        Subscription[] subscriptions = new Subscription[8];
        subscriptions[0] = new BasicPlan("Alice Johnson", "SUB001", 12);
        subscriptions[1] = new PremiumPlan("Bob Smith", "SUB002", 8);
        subscriptions[2] = new FamilyPlan("Charlie Brown", "SUB003", 6, 4);
        subscriptions[3] = new BasicPlan("Diana Prince", "SUB004", 5);
        subscriptions[4] = new PremiumPlan("Eve Wilson", "SUB005", 15);
        subscriptions[5] = new FamilyPlan("Frank Miller", "SUB006", 10, 4);
        subscriptions[6] = new BasicPlan("Grace Lee", "SUB007", 3);
        subscriptions[7] = new FamilyPlan("Henry Davis", "SUB008", 20, 5);

        System.out.println("--- All Subscriptions ---\n");
        for (int i = 0; i < subscriptions.length; i++) {
            System.out.println("Subscription " + (i + 1) + ":");
            subscriptions[i].displayInfo();
            System.out.println();
        }

        System.out.println("--- Total Monthly Revenue ---");
        double totalRevenue = calculateTotalMonthlyRevenue(subscriptions);
        System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));

        System.out.println("\n--- Most Expensive Subscription ---");
        Subscription mostExpensive = findMostExpensiveSubscription(subscriptions);
        mostExpensive.displayInfo();

        System.out.println("\n--- Search by Subscription ID ---");
        String searchId = "SUB003";
        Subscription found = searchBySubscriptionId(subscriptions, searchId);
        if (found != null) {
            System.out.println("Found:");
            found.displayInfo();
        } else {
            System.out.println("Subscription not found.");
        }

        displaySubscribersByLetter(subscriptions, 'A');
        displaySubscribersByLetter(subscriptions, 'B');
        displaySubscribersByLetter(subscriptions, 'F');

        System.out.println("\n--- Subscription Plan Statistics ---");
        int basicCount = 0, premiumCount = 0, familyCount = 0;
        double basicRevenue = 0, premiumRevenue = 0, familyRevenue = 0;

        for (Subscription subscription : subscriptions) {
            double charge = subscription.calculateMonthlyCharge();
            if (subscription instanceof BasicPlan) {
                basicCount++;
                basicRevenue += charge;
            } else if (subscription instanceof PremiumPlan) {
                premiumCount++;
                premiumRevenue += charge;
            } else if (subscription instanceof FamilyPlan) {
                familyCount++;
                familyRevenue += charge;
            }
        }

        System.out.println("Basic Plans: " + basicCount + " | Revenue: $" + String.format("%.2f", basicRevenue));
        System.out.println("Premium Plans: " + premiumCount + " | Revenue: $" + String.format("%.2f", premiumRevenue));
        System.out.println("Family Plans: " + familyCount + " | Revenue: $" + String.format("%.2f", familyRevenue));
        System.out.println("Total Subscriptions: " + subscriptions.length);

        sc.close();
    }
}
