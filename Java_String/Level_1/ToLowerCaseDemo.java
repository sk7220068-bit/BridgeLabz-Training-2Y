import java.util.Scanner;

public class ToLowerCaseDemo {
    public static String toLowerCustom(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }
            result += ch;
        }
        return result;
    }

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String custom = toLowerCustom(text);
        String builtin = text.toLowerCase();

        System.out.println("Custom: " + custom);
        System.out.println("Built-in: " + builtin);
        System.out.println("Both match? " + compareUsingCharAt(custom, builtin));
        sc.close();
    
    }
}
