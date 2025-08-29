import java.util.Scanner;

public class ShortestLongestWord {
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }
    public static String[] splitWords(String str) {
        int len = getLength(str);
        int spaces = 0;
        for (int i = 0; i < len; i++) if (str.charAt(i) == ' ') spaces++;
        int[] indexes = new int[spaces + 2];
        int idx = 1;
        for (int i = 0; i < len; i++) if (str.charAt(i) == ' ') indexes[idx++] = i;
        indexes[0] = -1;
        indexes[indexes.length - 1] = len;
        String[] words = new String[spaces + 1];
        for (int i = 0; i < words.length; i++) {
            String w = "";
            for (int j = indexes[i] + 1; j < indexes[i + 1]; j++) w += str.charAt(j);
            words[i] = w;
        }
        return words;
    }
    public static String[] findShortestLongest(String[] words) {
        String shortest = words[0], longest = words[0];
        for (String w : words) {
            if (getLength(w) < getLength(shortest)) shortest = w;
            if (getLength(w) > getLength(longest)) longest = w;
        }
        return new String[]{shortest, longest};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitWords(text);
        String[] result = findShortestLongest(words);
        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);
        sc.close();
    }
}
