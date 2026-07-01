interface FoodDelivery {
    void deliverFood(String customerName);

    default void trackOrder() {
        System.out.println("FoodDelivery: Your food order is on the way. Estimated time: 30 mins.");
    }

    static String generateDeliveryCode() {
        int code = (int) (Math.random() * 900000) + 100000;
        return "DEL-" + code;
    }
}

interface GroceryDelivery {
    void deliverGrocery(String customerName);

    default void trackOrder() {
        System.out.println("GroceryDelivery: Your grocery order is being packed. Estimated time: 45 mins.");
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {

    private String executiveName;

    public DeliveryExecutive(String executiveName) {
        this.executiveName = executiveName;
    }

    @Override
    public void deliverFood(String customerName) {
        String code = FoodDelivery.generateDeliveryCode();
        System.out.println(executiveName + " delivering FOOD to " + customerName + " | Code: " + code);
    }

    @Override
    public void deliverGrocery(String customerName) {
        String code = FoodDelivery.generateDeliveryCode();
        System.out.println(executiveName + " delivering GROCERIES to " + customerName + " | Code: " + code);
    }

    @Override
    public void trackOrder() {
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        DeliveryExecutive executive = new DeliveryExecutive("Ravi");

        String[] foodCustomers = {"Alice", "Bob", "Charlie"};
        String[] groceryCustomers = {"Diana", "Eve", "Frank"};

        System.out.println("--- Food Deliveries ---");
        for (String customer : foodCustomers) {
            executive.deliverFood(customer);
            executive.trackOrder();
            System.out.println();
        }

        System.out.println("--- Grocery Deliveries ---");
        for (String customer : groceryCustomers) {
            executive.deliverGrocery(customer);
            executive.trackOrder();
            System.out.println();
        }
    }
}
