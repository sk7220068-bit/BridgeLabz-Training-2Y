package srs;

public class Semester {
    //private int semId;
    private int semNumber; // 1..8
    private String semName;
    private int studentId;

    public Semester(String semName, int semNumber, int studentId) {
        this.semName = semName;
        this.semNumber = semNumber;
        this.studentId = studentId;
    }

    public Semester(int semId, String semName, int semNumber, int studentId) {
        //this.semId = semId;
        this.semName = semName;
        this.semNumber = semNumber;
        this.studentId = studentId;
    }

    //public int getSemId() { return semId; }
    public int getSemNumber() { return semNumber; }
    public String getSemName() { return semName; }
    public int getStudentId() { return studentId; }
}
