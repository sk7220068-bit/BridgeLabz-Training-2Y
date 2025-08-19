import java.util.Scanner;
public class BasicCalculator {
	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        System.out.print("Enter the first number: ");
	        float number1 = input.nextFloat();
	        System.out.print("Enter the second number: ");
	        float number2 = input.nextFloat();
	        float addition = number1 + number2;
	        float subtraction = number1 - number2;
	        float multiplication = number1 * number2;
	        String division;
	        if (number2 != 0) {
	            division = String.valueOf(number1 / number2);
	        } else {
	            division = "undefined (division by zero)";
	        }
	        System.out.println("\nThe addition, subtraction, multiplication, and division value of 2 numbers "
	                + number1 + " and " + number2 + " is:" + addition +','+ subtraction +"," + multiplication +" and "+ division);
	        
	        input.close();
	    }
}
