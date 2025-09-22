import java.util.ArrayList;

public class UniversityDemo {
    public static void main(String[] args) {
        University uni = new University("National University");

        uni.addDepartment("Computer Science");
        uni.addDepartment("Physics");

        Faculty f1 = new Faculty("Alice", "AI");
        Faculty f2 = new Faculty("Bob", "Quantum Mechanics");

        uni.addFaculty(f1);
        uni.addFaculty(f2);

        uni.showUniversityDetails();

        uni.closeUniversity();

        System.out.println("\nFaculty members still exist independently:");
        f1.showDetails();
        f2.showDetails();
    }
}

class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void showDetails() {
        System.out.println(" Faculty: " + name + " | Specialization: " + specialization);
    }
}

class Depart{
    private String deptName;

    public Depart(String deptName) {
        this.deptName = deptName;
    }

    public void showDetails() {
        System.out.println(" Department: " + deptName);
    }
}

class University {
    private String universityName;
    private ArrayList<Depart> departments;
    private ArrayList<Faculty> faculties;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Depart(deptName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void showUniversityDetails() {
        System.out.println("\nUniversity: " + universityName);
        System.out.println("Departments:");
        for (Depart d : departments) {
            d.showDetails();
        }
        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            f.showDetails();
        }
    }

    public void closeUniversity() {
        departments.clear();
        System.out.println("\nUniversity " + universityName + " has been closed. All departments removed.");
    }
}
