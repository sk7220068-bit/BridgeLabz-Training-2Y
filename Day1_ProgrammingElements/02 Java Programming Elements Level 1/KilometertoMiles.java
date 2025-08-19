import java.util.Scanner;
public class KilometertoMiles {
	public static void main(String[] args) {
        double km;
        System.out.println("Enter the kilometer");
        Scanner input = new Scanner(System.in);
        km = input.nextDouble();
        double miles = km / 1.6;
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
    }

}
