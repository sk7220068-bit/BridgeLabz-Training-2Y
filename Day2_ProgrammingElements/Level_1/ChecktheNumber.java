import java.util.Scanner;
public class ChecktheNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the num:");
		int num = sc.nextInt();
		if(num>0) {
			System.out.println("Positive");
		}else if(num==0){
			System.out.println("Zero");
		}else if(num<0) {
			System.out.println("negative");
		}
		sc.close();

	}

}
