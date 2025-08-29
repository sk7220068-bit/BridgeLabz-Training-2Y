import java.util.Scanner;

public class StringIndexDem {
    public static void generateException(String str) {
        System.out.println(str.charAt(str.length())); // Out of range
    }

    public static void handleException(String str) {
        try {
            System.out.println(str.charAt(str.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String str = sc.next();

       
        handleException(str);
        sc.close();
    }
}
