interface PaymentProcessor {
    void processPayment(double amount);

    default void refund(double amount) {
        System.out.println("Refund feature not supported by this provider.");
    }
}

class PayPal implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("PayPal processed payment of $" + amount);
    }
}

class Razorpay implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Razorpay processed payment of ₹" + amount);
    }

    public void refund(double amount) {
        System.out.println("Razorpay refunded ₹" + amount);
    }
}

public class PaymentTest {
    public static void main(String[] args) {
        PaymentProcessor p1 = new PayPal();
        PaymentProcessor p2 = new Razorpay();

        p1.processPayment(500);
        p1.refund(100);

        p2.processPayment(800);
        p2.refund(200);
    }
}
