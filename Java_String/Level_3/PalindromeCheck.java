import java.util.Scanner;

public class PalindromeCheck {
    public static boolean logic1(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }

    public static boolean logic2(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return logic2(s, start + 1, end - 1);
    }

    public static boolean logic3(String s) {
        char[] original = s.toCharArray();
        char[] rev = new char[s.length()];
        for (int i = 0; i < s.length(); i++) rev[i] = s.charAt(s.length() - 1 - i);
        for (int i = 0; i < s.length(); i++) if (original[i] != rev[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();
        System.out.println("Logic1: " + logic1(s));
        System.out.println("Logic2: " + logic2(s, 0, s.length() - 1));
        System.out.println("Logic3: " + logic3(s));
        sc.close();
    }
}
