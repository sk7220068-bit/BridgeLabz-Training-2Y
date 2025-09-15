class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : " + price);
    }

    double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

public class Inventory {
    public static void main(String[] args) {
        Item item1 = new Item(101, "Laptop", 55000);
        Item item2 = new Item(102, "Headphones", 1500);

        item1.displayDetails();
        System.out.println("Total Cost (2 units): " + item1.calculateTotalCost(2));
        System.out.println("-----------------------------");

        item2.displayDetails();
        System.out.println("Total Cost (5 units): " + item2.calculateTotalCost(5));
    }
}
