// NumericSum.java
import java.util.*;

public class NumericSum {
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) sum += n.doubleValue();
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(2.5, 3.5);

        System.out.println("Sum Integers: " + sumNumbers(ints));
        System.out.println("Sum Doubles: " + sumNumbers(doubles));
    }
}
