import java.util.Scanner;
public class SumofnNaturalno {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum =0;
		if(n>=0) {
			for(int i = 0; i<=n; i++) {
				sum+=i;
			}
			System.out.print("The sum of " + n + "natural numbers is " + sum);
		}else {
			System.out.print("The number " + n +" is not natural number.");
		}
		sc.close();
	}

}
