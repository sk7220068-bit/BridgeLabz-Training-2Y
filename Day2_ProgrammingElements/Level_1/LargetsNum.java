import java.util.Scanner;

public class LargetsNum {

	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the 1 num:");
		int number1 = sc.nextInt();
		
		System.out.print("Enter the 2 num:");
		int number2 = sc.nextInt();
		
		System.out.print("Enter the 3 num:");
		int number3 = sc.nextInt();
		
	    System.out.println("Is the first number the largest? " + (number1 > number2 && number1 > number3 ? "Yes" : "No"));
	    System.out.println("Is the second number the largest? " + (number2 > number1 && number2 > number3 ? "Yes" : "No"));
	    System.out.println("Is the third number the largest? " + (number3 > number1 && number3 > number2 ? "Yes" : "No"));
		sc.close();

	}

}
