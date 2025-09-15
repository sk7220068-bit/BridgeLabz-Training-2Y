class Students {
    String name;
    int rollNumber;
    double marks;

    Students(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    void displayReport() {
        System.out.println("Student Report");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + calculateGrade());
        System.out.println("----------------------------");
    }
}

public class StudentReport {
    public static void main(String[] args) {
        Students s1 = new Students("Shivam", 101, 92);
        Students s2 = new Students("Rahul", 102, 76);
        Students s3 = new Students("Ananya", 103, 48);

        s1.displayReport();
        s2.displayReport();
        s3.displayReport();
    }
}
