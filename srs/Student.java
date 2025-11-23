package srs;

public class Student {
    private int id;
    private String name;
    private String course;
    private String branch;
    private int year; // 1..4

    public Student(int id, String name, String course, String branch, int year) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.branch = branch;
        this.year = year;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public String getBranch() { return branch; }
    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }
    public void setName(String name) { this.name = name; }
}
