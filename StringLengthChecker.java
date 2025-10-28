import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        int limit = 50;

        
        Function<String, Integer> getLength = msg -> msg.length();

        String message = "This is a sample message for testing the character limit.";

        int length = getLength.apply(message);
        System.out.println("Message Length: " + length);

        if (length > limit) {
            System.out.println("Message exceeds character limit!");
        } else {
            System.out.println("Message is within the limit.");
        }
    }
}
