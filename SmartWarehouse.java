// SmartWarehouse.java
import java.util.*;

abstract class WarehouseItem {
    String name;
    WarehouseItem(String name) { this.name = name; }
    public String toString() { return name; }
}

class Electronics extends WarehouseItem { Electronics(String n) { super(n); } }
class Groceries extends WarehouseItem { Groceries(String n) { super(n); } }
class Furniture extends WarehouseItem { Furniture(String n) { super(n); } }

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) { items.add(item); }
    public List<T> getItems() { return items; }
}

public class SmartWarehouse {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem i : items) System.out.println(i);
    }

    public static void main(String[] args) {
        Storage<Electronics> eStorage = new Storage<>();
        eStorage.addItem(new Electronics("Laptop"));
        eStorage.addItem(new Electronics("TV"));

        Storage<Groceries> gStorage = new Storage<>();
        gStorage.addItem(new Groceries("Apple"));
        gStorage.addItem(new Groceries("Rice"));

        System.out.println("Electronics:");
        displayItems(eStorage.getItems());
        System.out.println("Groceries:");
        displayItems(gStorage.getItems());
    }
}
