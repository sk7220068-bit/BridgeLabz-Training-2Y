// MaximumOfThree.java
public class MaximumOfThree {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) max = y;
        if (z.compareTo(max) > 0) max = z;
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Max Integer: " + maximum(3, 5, 1));
        System.out.println("Max Double: " + maximum(2.2, 8.8, 6.6));
    }
}
