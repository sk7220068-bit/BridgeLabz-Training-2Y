
import java.util.Scanner;

public class StringLength1{
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len1 = getLength(str);
        int len2 = str.length();
        System.out.println("Length using custom method: " + len1);
        System.out.println("Length using built-in: " + len2);
        sc.close();
    }
}
