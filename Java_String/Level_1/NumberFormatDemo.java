import java.util.Scanner;

public class NumberFormatDemo {
    public static void generateException(String str) {
        int num = Integer.parseInt(str); 
        System.out.println(num);
    }

    public static void handleException(String str) {
        try {
            int num = Integer.parseInt(str);
            System.out.println("Converted number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Handled NumberFormatException: " + e.getMessage());
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
