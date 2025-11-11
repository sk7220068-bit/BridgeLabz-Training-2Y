import java.util.Random;

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}

class OnlineOrder {
    public void placeOrder() throws OutOfStockException, PaymentFailedException {
        Random rand = new Random();
        int scenario = rand.nextInt(3);

        if (scenario == 0) {
            throw new OutOfStockException("Product is out of stock. Please try again later.");
        } else if (scenario == 1) {
            throw new PaymentFailedException("Payment failed. Please check your payment method.");
        } else {
            System.out.println("Order placed successfully! Your order will be delivered soon.");
        }
    }
}

public class OnlineOrderProcessing {
    public static void main(String[] args) {
        OnlineOrder order = new OnlineOrder();

        try {
            order.placeOrder();
        } catch (OutOfStockException e) {
            System.out.println("Order Error: " + e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println("Order Error: " + e.getMessage());
        }
    }
}
