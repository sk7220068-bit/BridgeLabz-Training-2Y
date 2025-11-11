// UniversityCourses.java
import java.util.*;

abstract class CourseType { String name; CourseType(String n){ name=n;} public String toString(){return name;} }
class ExamCourse extends CourseType { ExamCourse(String n){super(n);} }
class AssignmentCourse extends CourseType { AssignmentCourse(String n){super(n);} }
class ResearchCourse extends CourseType { ResearchCourse(String n){super(n);} }

class Course<T extends CourseType> {
    T course;
    Course(T course){ this.course=course; }
    public String toString(){ return course.toString(); }
}

public class UniversityCourses {
    public static void displayCourses(List<? extends CourseType> list){
        for(CourseType c:list) System.out.println(c);
    }

    public static void main(String[] args){
        List<ExamCourse> exams = Arrays.asList(new ExamCourse("Math"), new ExamCourse("Physics"));
        List<ResearchCourse> research = Arrays.asList(new ResearchCourse("AI"), new ResearchCourse("ML"));
        displayCourses(exams);
        displayCourses(research);
    }
}
