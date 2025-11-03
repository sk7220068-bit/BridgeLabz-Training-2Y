import java.util.*;
import java.util.stream.Collectors;

public class NameUppercasing {
    public static void main(String[] args) {
        List<String> employeeNames = Arrays.asList("Rahul", "Sneha", "Arjun", "Priya");

        List<String> upperCaseNames = employeeNames.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println("Employee Names in Uppercase:");
        upperCaseNames.forEach(System.out::println);
    }
}
