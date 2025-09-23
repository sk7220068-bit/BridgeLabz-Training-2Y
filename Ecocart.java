import java.util.*;

abstract class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
    	return id; 
    	}
    public void setId(int id) { 
    	this.id = id; 
    	}

    public String getName() { 
    	return name;
    	}
    public void setName(String name) { 
    	this.name = name; 
    	}

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract double getDiscountedPrice();

    public void displayProductInfo() {
        System.out.println("Product ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Base Price: " + price);
        System.out.println("Discounted Price: " + getDiscountedPrice());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return this.id == other.id;
    }
}

class OrganicProduct extends Product {
    public OrganicProduct(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double getDiscountedPrice() {
        return getPrice() * 0.90;
    }

    @Override
    public String toString() {
        return "OrganicProduct [ID=" + getId() +
                ", Name=" + getName() +
                ", Base Price=" + getPrice() +
                ", Discounted Price=" + getDiscountedPrice() + "]";
    }
}

class RecycledProduct extends Product {
    public RecycledProduct(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double getDiscountedPrice() {
        return getPrice() * 0.95;
    }

    @Override
    public String toString() {
        return "RecycledProduct [ID=" + getId() +
                ", Name=" + getName() +
                ", Base Price=" + getPrice() +
                ", Discounted Price=" + getDiscountedPrice() + "]";
    }
}

class Cart {
    private List<Product> items = new ArrayList<>();
    private static int totalCartsCreated = 0;
    public static final double TAX_RATE = 0.05;

    public Cart() {
        totalCartsCreated++;
    }

    public void addItem(Product product) {
        items.add(product);
        System.out.println("Added product: " + product.getName());
    }

    public void addItem(Product... products) {
        items.addAll(Arrays.asList(products));
        System.out.println(products.length + " products added to cart.");
    }

    public void addItem(int productId, int quantity) {
        System.out.println("Added " + quantity + " units of Product ID " + productId);
    }

    public static int getCartCount() {
        return totalCartsCreated;
    }

    public void printCartItems() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart Items:");
            for (Product p : items) {
                System.out.println(p);
            }
        }
    }

    public final void printBillHeader() {
        System.out.println("******* EcoCart Bill ********");
    }

    public void printTotalBill() {
        double total = 0;
        for (Product p : items) {
            double discounted = p.getDiscountedPrice();
            double tax = discounted * TAX_RATE;
            total += discounted + tax;
        }
        System.out.println("Final Total (with 5% GST): " + total);
    }
}

final class EcoRules {
    public static void printRules() {
        System.out.println("Use eco-friendly bags.");
        System.out.println("Recycle waste responsibly.");
    }
}

public class Ecocart {
    public static void main(String[] args) {
        OrganicProduct op1 = new OrganicProduct(101, "Organic Rice", 100);
        RecycledProduct rp1 = new RecycledProduct(201, "Recycled Notebook", 200);

        op1.displayProductInfo();
        System.out.println();
        rp1.displayProductInfo();
        System.out.println();

        Cart cart1 = new Cart();
        cart1.addItem(op1);
        cart1.addItem(rp1);
        cart1.addItem(op1, rp1);
        cart1.addItem(301, 5);

        cart1.printCartItems();

        System.out.println("Total carts created: " + Cart.getCartCount());
        cart1.printCartItems();

        cart1.printBillHeader();
        cart1.printTotalBill();

        EcoRules.printRules();
    }
}
