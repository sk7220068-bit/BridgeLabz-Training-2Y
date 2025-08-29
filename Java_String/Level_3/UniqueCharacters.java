import java.util.Scanner;

public class UniqueCharacters {
    public static int getLength(String s) {
        int count = 0;
        try { while (true) { s.charAt(count); count++; } }
        catch (Exception e) {}
        return count;
    }

    public static char[] findUnique(String s) {
        int n = getLength(s);
        char[] temp = new char[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            boolean unique = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == c) { unique = false; break; }
            }
            if (unique) temp[idx++] = c;
        }
        char[] result = new char[idx];
        for (int i = 0; i < idx; i++) result[i] = temp[i];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = sc.nextLine();
        char[] u = findUnique(s);
        System.out.print("Unique characters: ");
        for (char c : u) System.out.print(c + " ");
        sc.close();
    }
}
