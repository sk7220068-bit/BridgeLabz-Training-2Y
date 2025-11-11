import java.util.*;

public class StudentGradeParser {
    public static void main(String[] args) {
        List<String> grades = Arrays.asList("90", "A+", "85", "B", "100");

        for (String grade : grades) {
            try {
                int numericGrade = Integer.parseInt(grade);
                System.out.println("Valid grade: " + numericGrade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid grade input: " + grade);
            }
        }
    }
}
