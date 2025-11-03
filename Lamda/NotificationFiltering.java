import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;
    int priority;

    Alert(String type, String message, int priority) {
        this.type = type;
        this.message = message;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message + " (Priority: " + priority + ")";
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("Emergency", "Patient heart rate critical!", 1),
            new Alert("Info", "New appointment scheduled.", 3),
            new Alert("Reminder", "Check patient BP logs.", 2),
            new Alert("Emergency", "Low oxygen level detected.", 1),
            new Alert("Info", "Daily report generated.", 3)
        );

        Predicate<Alert> emergencyOnly = a -> a.type.equals("Emergency");
        Predicate<Alert> highPriority = a -> a.priority == 1;
        Predicate<Alert> remindersOnly = a -> a.type.equals("Reminder");

        System.out.println("Emergency Alerts:");
        alerts.stream().filter(emergencyOnly).forEach(System.out::println);

        System.out.println("\nHigh Priority Alerts:");
        alerts.stream().filter(highPriority).forEach(System.out::println);

        System.out.println("\nReminder Alerts:");
        alerts.stream().filter(remindersOnly).forEach(System.out::println);
    }
}
