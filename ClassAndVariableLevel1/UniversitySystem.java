class Std{
    static String universityName = "National University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Std(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Std) {
            this.grade = newGrade;
        }
    }

    public void displayDetails() {
        if (this instanceof Std) {
            System.out.println("University: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        Std s1 = new Std(101, "Anjali Sharma", "A");
        Std s2 = new Std(102, "Rahul Mehta", "B");

        s1.displayDetails();
        System.out.println();
        s2.displayDetails();

        s2.updateGrade("A+");
        System.out.println("\nAfter updating grade:\n");
        s2.displayDetails();

        Std.displayTotalStudents();
    }
}

