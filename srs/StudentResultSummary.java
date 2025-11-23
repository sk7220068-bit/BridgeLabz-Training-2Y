package srs;

import java.util.List;

public class StudentResultSummary {
    private Student student;
    private List<Double> yearGPAs; // 4 entries (0.0 if missing)
    private double cgpa;
    private boolean hasBacklog;

    public StudentResultSummary(Student student, List<Double> yearGPAs, double cgpa, boolean hasBacklog) {
        this.student = student;
        this.yearGPAs = yearGPAs;
        this.cgpa = cgpa;
        this.hasBacklog = hasBacklog;
    }

    public void printSummary() {
        System.out.println("\n===== Final Summary =====");
        System.out.println("ID: " + student.getId() + " | " + student.getName());
        System.out.println("Course: " + student.getCourse() + " | Branch: " + student.getBranch());
        for (int i = 0; i < yearGPAs.size(); i++) {
            System.out.println("Year " + (i+1) + " GPA: " + String.format("%.2f", yearGPAs.get(i)));
        }
        System.out.println("CGPA: " + String.format("%.2f", cgpa));
        System.out.println("Final Status: " + (hasBacklog ? "FAIL (Backlog)" : "PASS"));
        System.out.println("=========================\n");
    }
}
