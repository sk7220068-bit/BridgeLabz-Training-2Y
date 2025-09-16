class Product {
    static double discount = 10.0;

    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        double total = price * quantity;
        total -= (total * discount / 100);
        return total;
    }

    public void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Total Price after Discount: " + calculateTotal());
        }
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", 50000, 1);
        Product p2 = new Product(102, "Headphones", 2000, 2);

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();

        Product.updateDiscount(20);
        System.out.println("\nAfter updating discount:\n");

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
    }
}
