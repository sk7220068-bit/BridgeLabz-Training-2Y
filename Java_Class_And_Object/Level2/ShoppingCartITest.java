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

    double getTotalPrice() {
        return price * quantity;
    }

    void displayItem() {
        System.out.println(itemName + " | Price: " + price + " | Quantity: " + quantity + " | Subtotal: " + getTotalPrice());
    }
}

class ShoppingCart {
    ArrayList<CartItem> items = new ArrayList<>();

    void addItem(String itemName, double price, int quantity) {
        boolean found = false;
        for (CartItem item : items) {
            if (item.itemName.equalsIgnoreCase(itemName)) {
                item.quantity += quantity; // increase quantity
                found = true;
                System.out.println(quantity + " more " + itemName + "(s) added. New quantity: " + item.quantity);
                break;
            }
        }
        if (!found) {
            items.add(new CartItem(itemName, price, quantity));
            System.out.println(itemName + " added to cart.");
        }
    }

    void removeItem(String itemName) {
        boolean removed = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).itemName.equalsIgnoreCase(itemName)) {
                items.remove(i);
                removed = true;
                System.out.println(itemName + " removed from cart.");
                break;
            }
        }
        if (!removed) {
            System.out.println(itemName + " not found in cart.");
        }
    }

    void displayTotalCost() {
        double total = 0;
        System.out.println("\n--- Cart Details ---");
        for (CartItem item : items) {
            item.displayItem();
            total += item.getTotalPrice();
        }
        System.out.println("Total Cost: " + total);
        System.out.println("--------------------\n");
    }
}

public class ShoppingCartITest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Laptop", 55000, 1);
        cart.addItem("Headphones", 1500, 2);
        cart.addItem("Mouse", 700, 1);

        cart.displayTotalCost();

        cart.addItem("Headphones", 1500, 1); // increases quantity instead of duplicate
        cart.displayTotalCost();

        cart.removeItem("Mouse");
        cart.displayTotalCost();

        cart.removeItem("Keyboard"); // not in cart
    }
}
