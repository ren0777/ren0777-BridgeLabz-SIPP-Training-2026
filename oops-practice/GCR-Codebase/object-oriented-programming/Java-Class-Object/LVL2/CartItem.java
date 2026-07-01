import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    static ArrayList<CartItem> cart = new ArrayList<>();

    static void addItem(CartItem item) {
        cart.add(item);
        System.out.println(item.itemName + " added to cart.");
    }

    static void removeItem(String itemName) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).itemName.equalsIgnoreCase(itemName)) {
                cart.remove(i);
                System.out.println(itemName + " removed from cart.");
                return;
            }
        }
        System.out.println(itemName + " not found in cart.");
    }

    static void displayTotal() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.price * item.quantity;
        }
        System.out.println("Total Cost: " + total);
    }

    public static void main(String[] args) {
        CartItem item1 = new CartItem("Pen", 10.0, 3);
        CartItem item2 = new CartItem("Notebook", 50.0, 2);
        CartItem item3 = new CartItem("Eraser", 5.0, 5);

        addItem(item1);
        addItem(item2);
        addItem(item3);
        removeItem("Pen");
        displayTotal();
    }
}
