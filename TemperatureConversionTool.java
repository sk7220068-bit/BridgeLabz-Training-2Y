import java.util.Scanner;

class InvalidTemperatureException extends Exception {
    public InvalidTemperatureException(String message) {
        super(message);
    }
}

class TemperatureConverter {
    public double convert(double value, char unit) throws InvalidTemperatureException {
        if (unit == 'C' || unit == 'c') {
            if (value < -273.15) {
                throw new InvalidTemperatureException("Error: Temperature below absolute zero is not possible!");
            }
            return (value * 9 / 5) + 32; // Celsius to Fahrenheit
        } else if (unit == 'F' || unit == 'f') {
            if (value < -459.67) {
                throw new InvalidTemperatureException("Error: Temperature below absolute zero is not possible!");
            }
            return (value - 32) * 5 / 9; // Fahrenheit to Celsius
        } else {
            throw new InvalidTemperatureException("Error: Invalid unit! Use 'C' for Celsius or 'F' for Fahrenheit.");
        }
    }
}

public class TemperatureConversionTool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TemperatureConverter converter = new TemperatureConverter();

        System.out.print("Enter temperature value: ");
        double value = sc.nextDouble();

        System.out.print("Enter unit (C/F): ");
        char unit = sc.next().charAt(0);

        try {
            double result = converter.convert(value, unit);
            if (unit == 'C' || unit == 'c') {
                System.out.printf("Converted Temperature: %.2f°F%n", result);
            } else {
                System.out.printf("Converted Temperature: %.2f°C%n", result);
            }
        } catch (InvalidTemperatureException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
