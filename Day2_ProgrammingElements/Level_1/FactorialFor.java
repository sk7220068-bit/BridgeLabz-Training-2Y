import java.util.Scanner;

public class FactorialFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long fact = 1;

            for (int i = 1; i <= n; i++) {
                fact *= i;
            }

            System.out.println("Factorial of " + n + " = " + fact);
        }

        sc.close();
    }
}
