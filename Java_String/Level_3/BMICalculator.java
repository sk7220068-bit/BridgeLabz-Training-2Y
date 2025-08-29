import java.util.Scanner;

public class BMICalculator {
    public static double[][] inputData(int n) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
            sc.close();
        }
        return data;
    }

    public static String[] bmiStatus(double weight, double height) {
        double h = height / 100.0;
        double bmi = weight / (h * h);
        String status;
        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 25) status = "Normal";
        else if (bmi < 30) status = "Overweight";
        else status = "Obese";
        return new String[]{String.format("%.2f", bmi), status};
    }

    public static String[][] process(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            result[i][0] = String.valueOf(data[i][0]);
            result[i][1] = String.valueOf(data[i][1]);
            String[] b = bmiStatus(data[i][0], data[i][1]);
            result[i][2] = b[0];
            result[i][3] = b[1];
        }
        return result;
    }

    public static void display(String[][] arr) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight", "Height", "BMI", "Status");
        for (String[] row : arr)
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
    }

    public static void main(String[] args) {
        double[][] data = inputData(10);
        String[][] result = process(data);
        display(result);
 
    }
}
