import java.util.*;

public class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        for (int i = 0; i < n; i++) {
            if (first.hasNext()) first.next();
            else return null;
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> letters = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        System.out.println("List: " + letters);
        System.out.println(n + "nd element from end: " + findNthFromEnd(letters, n));
    }
}
