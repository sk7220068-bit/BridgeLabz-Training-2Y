import java.util.function.Predicate;

public class TemperatureAlertSystem {
    public static void main(String[] args) {
        double threshold = 37.5;

        // Predicate to check if temperature crosses threshold
        Predicate<Double> isHighTemperature = temp -> temp > threshold;

        double currentTemp = 38.2;

        if (isHighTemperature.test(currentTemp)) {
            System.out.println("ALERT! Temperature crossed the threshold.");
        } else {
            System.out.println("Temperature is normal.");
        }
    }
}
