package srs;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DatabaseManager db = new DatabaseManager();

        while (true) {
            System.out.println("\n---- Student Result Management (Year-wise: 1 year = 2 semesters) ----");
            System.out.println("1. Add Student");
            System.out.println("2. Add Result (enter Year + Semester)");
            System.out.println("3. View Full Results (all semesters)");
            System.out.println("4. View Semester-wise Result (student + semester)");
            System.out.println("5. Update Marks (by result id)");
            System.out.println("6. Compute GPA for student-semester");
            System.out.println("7. Compute CGPA for Student");
            System.out.println("8. Final Summary (year-wise + final status)");
            System.out.println("9. Delete Student");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: "); String name = sc.nextLine();
                    System.out.print("Course (e.g., B.Tech): "); String course = sc.nextLine();
                    System.out.print("Branch (CSE): "); String branch = sc.nextLine();
                    System.out.print("Current Year (1-4): "); int year = sc.nextInt();
                    db.addStudent(new Student(id, name, course, branch, year));
                    break;

                case 2:
                    System.out.print("Enter Student ID: "); int sid = sc.nextInt();
                    Student s = db.getStudent(sid);
                    if (s == null) { System.out.println("Student not found"); break; }

                    System.out.print("Enter Year (1-4) for this result: "); int rYear = sc.nextInt();
                    System.out.print("Enter Semester Number (1-8) for this result: "); int rSem = sc.nextInt();
                    if (rYear < 1 || rYear > 4 || rSem < 1 || rSem > 8) { System.out.println("Invalid year or semester"); break; }

                    int derivedYear = (rSem + 1) / 2;
                    if (derivedYear != rYear) {
                        System.out.println("Warning: entered year " + rYear + " does not match semester " + rSem + " (derived year = " + derivedYear + "). Proceeding with entered values.");
                    }

                    List<Subject> subs = db.getOrGenerateSubjects(s.getCourse(), s.getBranch(), rSem);
                    int[] marks = new int[5];
                    System.out.println("Enter marks (out of 100) for 5 subjects:");
                    for (int i = 0; i < 5; i++) {
                        System.out.print((i+1) + ". " + subs.get(i).getSubjectName() + " : ");
                        marks[i] = sc.nextInt();
                    }

                    db.addResult(new Result(sid, rYear, rSem, marks));
                    break;

                case 3:
                    System.out.print("Enter Student ID: "); int vsid = sc.nextInt();
                    List<Result> results = db.listResultsForStudent(vsid);
                    if (results.isEmpty()) { System.out.println("No results found"); break; }
                    for (Result r : results) {
                        System.out.println("\n--- Student ID: " + r.getStudentId() + " | Year: " + r.getYear() + " | Semester: " + r.getSemester() + " ---");
                        int[] ms = r.getMarks();
                        List<Subject> subList = db.getOrGenerateSubjects(db.getStudent(vsid).getCourse(), db.getStudent(vsid).getBranch(), r.getSemester());
                        for (int i = 0; i < ms.length; i++) {
                            String name1 = (i < subList.size()) ? subList.get(i).getSubjectName() : ("Sub" + (i+1));
                            System.out.println(name1 + ": " + ms[i] + " -> " + r.getGrades()[i]);
                        }
                        System.out.println("GPA: " + r.getGpa());
                        System.out.println("Backlogs: " + r.getBacklogsCount() + " | C-Grades: " + r.getCGradeCount() + " | Status: " + r.getSemesterStatus());
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID: "); int ssid = sc.nextInt();
                    System.out.print("Enter Semester Number (1-8): "); int sSem = sc.nextInt();
                    Result semResult = db.getResultByStudentAndSemester(ssid, sSem);
                    if (semResult == null) {
                        System.out.println("No result found for student " + ssid + " semester " + sSem);
                        break;
                    }
                    List<Subject> subjects = db.getOrGenerateSubjects(db.getStudent(ssid).getCourse(), db.getStudent(ssid).getBranch(), sSem);
                    int[] marksSem = semResult.getMarks();
                    String[] gradesSem = semResult.getGrades();
                    System.out.println("\n--- Semester-wise Result: Student " + ssid + " | Year: " + semResult.getYear() + " | Sem: " + semResult.getSemester() + " ---");
                    for (int i = 0; i < marksSem.length; i++) {
                        String sname = (i < subjects.size()) ? subjects.get(i).getSubjectName() : ("Sub" + (i+1));
                        System.out.println(sname + " : " + marksSem[i] + " -> " + gradesSem[i]);
                    }
                    System.out.println("GPA: " + semResult.getGpa());
                    System.out.println("Backlogs: " + semResult.getBacklogsCount() + " | C-Grades: " + semResult.getCGradeCount());
                    System.out.println("Status: " + semResult.getSemesterStatus());
                    break;

                case 5:
                    System.out.print("Enter Result ID to update: "); int rid = sc.nextInt();
                    System.out.println("Enter new marks for 5 subjects:");
                    int[] newMarks = new int[5];
                    for (int i = 0; i < 5; i++) newMarks[i] = sc.nextInt();
                    db.updateMarks(rid, newMarks);
                    break;

                case 6:
                    System.out.print("Enter Student ID: "); int sId = sc.nextInt();
                    System.out.print("Enter Semester Number: "); int sNum = sc.nextInt();
                    System.out.println("GPA: " + db.computeGPAForStudentSemester(sId, sNum));
                    break;

                case 7:
                    System.out.print("Enter Student ID: "); int cg = sc.nextInt();
                    System.out.println("CGPA: " + db.computeCGPAForStudent(cg));
                    break;

                case 8:
                    System.out.print("Enter Student ID: "); int targetId = sc.nextInt();
                    Student stu = db.getStudent(targetId);
                    if (stu == null) { System.out.println("Student not found"); break; }
                    List<Result> resList = db.listResultsForStudent(targetId);
                    List<Double> semGpas = new java.util.ArrayList<>();
                    for (Result r : resList) semGpas.add(r.getGpa());
                    // aggregate per year (2 sems per year)
                    List<Double> yearGpas = new java.util.ArrayList<>();
                    for (int y = 1; y <= 4; y++) {
                        int semA = (y-1)*2 + 1;
                        int semB = semA + 1;
                        double gA = 0, gB = 0;
                        for (Result rr : resList) {
                            if (rr.getSemester() == semA) gA = rr.getGpa();
                            if (rr.getSemester() == semB) gB = rr.getGpa();
                        }
                        int cnt = 0; double sum = 0;
                        if (gA > 0) { sum += gA; cnt++; }
                        if (gB > 0) { sum += gB; cnt++; }
                        yearGpas.add(cnt > 0 ? Math.round((sum / cnt) * 100.0) / 100.0 : 0.0);
                    }
                    double cgpa = db.computeCGPAForStudent(targetId);
                    int totalBacklogs = db.totalBacklogsForStudent(targetId);
                    int failedSem = db.countFailedSemesters(targetId);
                    int cGrades = db.totalCGradeCount(targetId);
                    boolean finalPass = GPACalculator.isFinalPass(cgpa, totalBacklogs, failedSem, cGrades);
                    StudentResultSummary summary = new StudentResultSummary(stu, yearGpas, cgpa, totalBacklogs > 0);
                    summary.printSummary();
                    System.out.println("Total Failed Semesters: " + failedSem);
                    System.out.println("Total Backlogs: " + totalBacklogs);
                    System.out.println("Total C-Grades: " + cGrades);
                    System.out.println("Final Grade (from CGPA): " + GPACalculator.finalGradeFromCGPA(cgpa));
                    System.out.println("Final Status: " + (finalPass ? "PASS" : "FAIL"));
                    break;

                case 9:
                    System.out.print("Enter Student ID to delete: "); int did = sc.nextInt();
                    db.deleteStudent(did);
                    break;

                case 10:
                    System.out.println("Exiting..."); sc.close(); System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
