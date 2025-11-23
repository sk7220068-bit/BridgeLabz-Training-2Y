package srs;

public class Subject {
    private int subjectId;
    private String subjectName;
    private int maxMarks;
    private int semester;

    public Subject(int subjectId, String subjectName, int maxMarks, int semester) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.maxMarks = maxMarks;
        this.semester = semester;
    }

    public Subject(String subjectName, int maxMarks, int semester) {
        this.subjectName = subjectName;
        this.maxMarks = maxMarks;
        this.semester = semester;
    }

    public int getSubjectId() { return subjectId; }
    public String getSubjectName() { return subjectName; }
    public int getMaxMarks() { return maxMarks; }
    public int getSemester() { return semester; }
}
