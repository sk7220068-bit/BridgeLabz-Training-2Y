import java.util.*;

public class TrimSpaces {
    static int[] trimIndices(String str) {
        int start = 0, end = str.length()-1;
        while (start < str.length() && str.charAt(start) == ' ') start++;
        while (end >= 0 && str.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    static String substring(String str, int start, int end) {
        String res = "";
        for (int i = start; i <= end; i++) res += str.charAt(i);
        return res;
    }

    static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] ind = trimIndices(str);
        String customTrim = substring(str, ind[0], ind[1]);
        boolean res = compare(customTrim, str.trim());
        System.out.println("Custom Trim: " + customTrim);
        System.out.println("Matches built-in trim: " + res);
        sc.close();
    }
}
