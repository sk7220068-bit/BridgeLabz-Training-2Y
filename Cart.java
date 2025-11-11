// Cart.java
import java.util.*;

public class Cart<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) { items.add(item); }
    public void removeItem(T item) { items.remove(item); }
    public void displayItems() { System.out.println("Items: " + items); }

    public static void main(String[] args) {
        Cart<String> electronicsCart = new Cart<>();
        electronicsCart.addItem("Laptop");
        electronicsCart.addItem("Phone");
        electronicsCart.displayItems();

        Cart<String> clothingCart = new Cart<>();
        clothingCart.addItem("Shirt");
        clothingCart.addItem("Jeans");
        clothingCart.displayItems();
    }
}
