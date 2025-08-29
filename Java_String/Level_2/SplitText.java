import java.util.Scanner;

public class SplitText {
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
    public static boolean compareArrays(String[] a1, String[] a2) {
        if (a1.length != a2.length) return false;
        for (int i = 0; i < a1.length; i++) if (!a1[i].equals(a2[i])) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] arr1 = splitWords(text);
        String[] arr2 = text.split(" ");
        System.out.println("Both results match? " + compareArrays(arr1, arr2));
        sc.close();
    }
}
