import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class StudentResultSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            if (name == null || name.trim().isEmpty()) {
                throw new NullPointerException("Name cannot be null or empty");
            }

            System.out.print("Enter student age: ");
            int age = sc.nextInt();
            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or above");
            }

            int[] marks = new int[3];
            System.out.println("Enter marks in 3 subjects:");
            for (int i = 0; i < 3; i++) {
                System.out.print("Subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
                if (marks[i] < 0 || marks[i] > 100) {
                    throw new InvalidMarksException("Marks must be between 0 and 100");
                }
            }

            double average = 0;
            try {
                int total = 0;
                for (int mark : marks) {
                    total += mark;
                }
                average = total / 3.0;
                System.out.println("\nAverage Marks: " + average);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nAccessing extra index in marks array...");
            System.out.println("Fourth mark: " + marks[3]);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (InvalidMarksException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Result processing completed");
            sc.close();
        }  
    }
}
