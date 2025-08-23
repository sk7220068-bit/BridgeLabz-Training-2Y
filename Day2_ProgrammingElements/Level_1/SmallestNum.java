import java.util.*;
public class SmallestNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the 1 num:");
		int num1 = sc.nextInt();
		
		System.out.print("Enter the 2 num:");
		int num2 = sc.nextInt();
		
		System.out.print("Enter the 3 num:");
		int num3 = sc.nextInt();
		
		if (num1<num2 && num1 <num3) {
			System.out.println("Is the first number the smallest? Yes");
		}else {
			System.out.println("Is the first number the smallest? No");
			
		}
		sc.close();
	}

}
