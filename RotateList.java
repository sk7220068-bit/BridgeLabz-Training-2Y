import java.util.*;

public class RotateList {
    public static <T> List<T> rotateList(List<T> list, int positions) {
        int n = list.size();
        List<T> rotated = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rotated.add(list.get((i + positions) % n));
        }
        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50);
        System.out.println("Original List: " + nums);
        System.out.println("Rotated by 2: " + rotateList(nums, 2));
    }
}
