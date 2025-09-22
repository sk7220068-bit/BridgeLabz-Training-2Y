import java.util.ArrayList;

public class ECommerceDemo {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Phone", 30000);
        Product p3 = new Product("Headphones", 2000);

        Order order1 = new Order(101, customer1);
        order1.addProduct(p1);
        order1.addProduct(p3);

        Order order2 = new Order(102, customer2);
        order2.addProduct(p2);

        customer1.placeOrder(order1);
        customer2.placeOrder(order2);

        customer1.viewOrders();
        customer2.viewOrders();
    }
}

class Cuustomer {
    private String name;
    private ArrayList<Order> orders;

    public Cuustomer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order #" + order.getOrderId());
    }

    public void viewOrders() {
        System.out.println("\nCustomer: " + name + " has placed:");
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}

class Product {
    private String productName;
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private int orderId;
    private Cuustomer cuustomer;
    private ArrayList<Product> products;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.cuustomer = cuustomer;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order #" + orderId + " contains:");
        double total = 0;
        for (Product p : products) {
            System.out.println(" - " + p.getProductName() + " (₹" + p.getPrice() + ")");
            total += p.getPrice();
        }
        System.out.println("Total: ₹" + total);
    }
}
