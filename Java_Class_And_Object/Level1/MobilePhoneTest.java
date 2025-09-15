class MobilePhone {
    String brand;
    String model;
    double price;

    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
        System.out.println("-------------------------");
    }
}

public class MobilePhoneTest {
    public static void main(String[] args) {
        MobilePhone m1 = new MobilePhone("Samsung", "Galaxy S23", 79999);
        MobilePhone m2 = new MobilePhone("Apple", "iPhone 14", 89999);
        MobilePhone m3 = new MobilePhone("OnePlus", "11R", 39999);

        m1.displayDetails();
        m2.displayDetails();
        m3.displayDetails();
    }
}
