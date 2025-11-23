package srs;

public class Result {
    private int resultId;
    private int studentId;
    private int year;         // stored here as well
    private int semester;     // 1..8
    private int[] marks;      // length 5
    private String[] grades;  // length 5
    private double gpa;
    private int backlogsCount;
    private int cGradeCount;
    private String semesterStatus; // PASS / FAIL

    // for insert
    public Result(int studentId, int year, int semester, int[] marks) {
        this.studentId = studentId;
        this.year = year;
        this.semester = semester;
        this.marks = marks;
        this.grades = new String[5];
    }

    // for read
    public Result(int resultId, int studentId, int year, int semester, int[] marks,
                  String[] grades, double gpa, int backlogsCount, int cGradeCount, String semesterStatus) {
        this.resultId = resultId;
        this.studentId = studentId;
        this.year = year;
        this.semester = semester;
        this.marks = marks;
        this.grades = grades;
        this.gpa = gpa;
        this.backlogsCount = backlogsCount;
        this.cGradeCount = cGradeCount;
        this.semesterStatus = semesterStatus;
    }

    public int getResultId() { return resultId; }
    public int getStudentId() { return studentId; }
    public int getYear() { return year; }
    public int getSemester() { return semester; }
    public int[] getMarks() { return marks; }
    public String[] getGrades() { return grades; }
    public double getGpa() { return gpa; }
    public int getBacklogsCount() { return backlogsCount; }
    public int getCGradeCount() { return cGradeCount; }
    public String getSemesterStatus() { return semesterStatus; }

    public void setGrades(String[] grades) { this.grades = grades; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public void setBacklogsCount(int b) { this.backlogsCount = b; }
    public void setCGradeCount(int c) { this.cGradeCount = c; }
    public void setSemesterStatus(String s) { this.semesterStatus = s; }
}
