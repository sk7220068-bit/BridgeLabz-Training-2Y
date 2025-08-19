import java.util.Scanner;
public class AreaOfTriangle {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base: ");
        double base = sc.nextDouble();
        System.out.print("Enter the height: ");
        double height = sc.nextDouble();
        double areaCm = 0.5 * base * height;
        double areaInches = areaCm / (2.54 * 2.54);
        System.out.println("The Area of the triangle in sq inche is " + areaInches + " and sq cm is " + areaCm);
        sc.close();
    }
}
