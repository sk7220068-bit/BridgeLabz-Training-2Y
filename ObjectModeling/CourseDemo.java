import java.util.ArrayList;

class Course {
    private String courseName;
    private ArrayList<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void showEnrolledStudents() {
        System.out.println("\nCourse: " + courseName + " | Enrolled Students:");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}

class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this); // maintain both sides of association
        }
    }

    public void viewCourses() {
        System.out.println("\nStudent: " + name + " | Enrolled Courses:");
        for (Course c : courses) {
            System.out.println(" - " + c.getCourseName());
        }
    }
}

class School {
    private String schoolName;
    private ArrayList<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student); // aggregation
    }

    public void showStudents() {
        System.out.println("\nSchool: " + schoolName + " | Students:");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}

public class CourseDemo {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        school.addStudent(student1);
        school.addStudent(student2);

        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        student1.enrollInCourse(math);
        student1.enrollInCourse(science);

        student2.enrollInCourse(science);

        school.showStudents();

        student1.viewCourses();
        student2.viewCourses();

        math.showEnrolledStudents();
        science.showEnrolledStudents();
    }
}
