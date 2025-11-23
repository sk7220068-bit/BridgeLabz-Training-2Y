package srs;

import java.util.List;

public class GPACalculator {

    // subject grade based on marks (out of 100)
    public static String calculateGrade(int marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B+";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }

    // map grade to grade points (10-scale)
    public static double gradePoint(String grade) {
        switch (grade) {
            case "A+": return 10.0;
            case "A": return 9.0;
            case "B+": return 8.0;
            case "B": return 7.0;
            case "C": return 6.0;
            case "D": return 5.0;
            default: return 0.0; // F
        }
    }

    // compute GPA from marks[] (returns rounded to 2 decimals)
    public static double computeGPA(int[] marks) {
        double total = 0.0;
        for (int m : marks) total += gradePoint(calculateGrade(m));
        double gpa = total / marks.length;
        return Math.round(gpa * 100.0) / 100.0;
    }

    // compute number of backlogs (marks < 40)
    public static int computeBacklogs(int[] marks) {
        int cnt = 0;
        for (int m : marks) if (m < 40) cnt++;
        return cnt;
    }

    // compute count of C grades (grade == "C")
    public static int computeCGradeCount(String[] grades) {
        int cnt = 0;
        for (String g : grades) if ("C".equals(g)) cnt++;
        return cnt;
    }

    // semester pass rules:
    // A semester is PASS if: backlogs==0 AND gpa >= 4.0
    public static boolean isSemesterPass(int[] marks, double gpa) {
        int backlogs = computeBacklogs(marks);
        return backlogs == 0 && gpa >= 4.0;
    }

    // final grade from CGPA
    public static String finalGradeFromCGPA(double cgpa) {
        if (cgpa >= 9.0) return "O";
        else if (cgpa >= 8.0) return "A+";
        else if (cgpa >= 7.0) return "A";
        else if (cgpa >= 6.0) return "B+";
        else if (cgpa >= 5.0) return "B";
        else if (cgpa >= 4.0) return "C";
        else return "F";
    }

    // final pass/fail rules (revised)
    // Fail if: cgpa < 4.0 OR totalBacklogs > 0 OR failedSemesters > 2 OR cGradeCount >= 3
    public static boolean isFinalPass(double cgpa, int totalBacklogs, int failedSemesters, int cGradeCount) {
        if (cgpa < 4.0) return false;
        if (totalBacklogs > 0) return false;
        if (failedSemesters > 2) return false;
        if (cGradeCount >= 3) return false;
        return true;
    }

    // compute CGPA from stored semester GPAs
    public static double computeCGPA(List<Double> semGpas) {
        if (semGpas.isEmpty()) return 0.0;
        double sum = 0.0;
        for (double g : semGpas) sum += g;
        double cgpa = sum / semGpas.size();
        return Math.round(cgpa * 100.0) / 100.0;
    }
}
