package srs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Connection conn;
    private final String URL = "jdbc:mysql://localhost:3306/srs?serverTimezone=UTC&useSSL=false";
    private final String USER = "root";
    private final String PASS = "Aabc@123"; // change to your MySQL password

    public DatabaseManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("DB connected");
        } catch (Exception e) {
            System.out.println("DB connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------- students ----------
    public void addStudent(Student s) {
        String q = "INSERT INTO students (id, name, course, branch, year) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());
            ps.setString(4, s.getBranch());
            ps.setInt(5, s.getYear());
            ps.executeUpdate();
            System.out.println("Student added: " + s.getName());
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public Student getStudent(int id) {
        String q = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("course"), rs.getString("branch"), rs.getInt("year"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public void deleteStudent(int id) {
        String q = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, id); ps.executeUpdate();
            System.out.println("Deleted student " + id);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // ---------- subjects ----------
    public List<Subject> getOrGenerateSubjects(String course, String branch, int semester) {
        List<Subject> list = getSubjectsFromDB(course, branch, semester);
        if (!list.isEmpty()) return list;

        List<Subject> generated = generateDefaultSubjects(course, branch, semester);
        for (Subject s : generated) {
            int id = insertSubject(course, branch, semester, s.getSubjectName(), s.getMaxMarks());
            if (id > 0) list.add(new Subject(id, s.getSubjectName(), s.getMaxMarks(), semester));
        }
        return list;
    }

    public List<Subject> getSubjectsFromDB(String course, String branch, int semester) {
        List<Subject> list = new ArrayList<>();
        String q = "SELECT subject_id, subject_name, max_marks FROM subjects WHERE course=? AND branch=? AND semester=? ORDER BY subject_id";
        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setString(1, course);
            ps.setString(2, branch);
            ps.setInt(3, semester);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(new Subject(rs.getInt("subject_id"), rs.getString("subject_name"), rs.getInt("max_marks"), semester));
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public int insertSubject(String course, String branch, int semester, String subjectName, int maxMarks) {
        String q = "INSERT INTO subjects (course, branch, semester, subject_name, max_marks) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, course);
            ps.setString(2, branch);
            ps.setInt(3, semester);
            ps.setString(4, subjectName);
            ps.setInt(5, maxMarks);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) { e.printStackTrace(); }
        return -1;
    }

    // same default subject generation as before
    private List<Subject> generateDefaultSubjects(String course, String branch, int sem) {
        List<Subject> list = new ArrayList<>();
        if (!"B.Tech".equalsIgnoreCase(course) || !"CSE".equalsIgnoreCase(branch)) {
            for (int i = 1; i <= 5; i++) list.add(new Subject("Subject " + i, 100, sem));
            return list;
        }
        switch (sem) {
            case 1:
                list.add(new Subject("Mathematics-I",100,sem));
                list.add(new Subject("Programming in C",100,sem));
                list.add(new Subject("Physics",100,sem));
                list.add(new Subject("Engineering Graphics",100,sem));
                list.add(new Subject("English",100,sem));
                break;
            case 2:
                list.add(new Subject("Mathematics-II",100,sem));
                list.add(new Subject("Data Structures",100,sem));
                list.add(new Subject("Basic Electronics",100,sem));
                list.add(new Subject("Environmental Science",100,sem));
                list.add(new Subject("Chemistry",100,sem));
                break;
            case 3:
                list.add(new Subject("Discrete Mathematics",100,sem));
                list.add(new Subject("OOPS with Java",100,sem));
                list.add(new Subject("Computer Architecture",100,sem));
                list.add(new Subject("Database Management Systems",100,sem));
                list.add(new Subject("Operating Systems",100,sem));
                break;
            case 4:
                list.add(new Subject("Design & Analysis of Algorithms",100,sem));
                list.add(new Subject("Computer Networks",100,sem));
                list.add(new Subject("Microprocessor",100,sem));
                list.add(new Subject("Theory of Computation",100,sem));
                list.add(new Subject("Web Technology",100,sem));
                break;
            case 5:
                list.add(new Subject("Software Engineering",100,sem));
                list.add(new Subject("Compiler Design",100,sem));
                list.add(new Subject("Artificial Intelligence",100,sem));
                list.add(new Subject("Elective-I",100,sem));
                list.add(new Subject("Professional Ethics",100,sem));
                break;
            case 6:
                list.add(new Subject("Machine Learning",100,sem));
                list.add(new Subject("Distributed Systems",100,sem));
                list.add(new Subject("Mobile Computing",100,sem));
                list.add(new Subject("Elective-II",100,sem));
                list.add(new Subject("Project - Phase I",100,sem));
                break;
            case 7:
                list.add(new Subject("Cloud Computing",100,sem));
                list.add(new Subject("Big Data Analytics",100,sem));
                list.add(new Subject("Elective-III",100,sem));
                list.add(new Subject("Project - Phase II",100,sem));
                list.add(new Subject("Seminar",100,sem));
                break;
            case 8:
                list.add(new Subject("Advanced Topics",100,sem));
                list.add(new Subject("Elective-IV",100,sem));
                list.add(new Subject("Major Project",100,sem));
                list.add(new Subject("Internship Report",100,sem));
                list.add(new Subject("Viva-Voce",100,sem));
                break;
            default:
                for (int i = 1; i <= 5; i++) list.add(new Subject("CSE_Subject_S" + sem + "_" + i, 100, sem));
        }
        return list;
    }

    // ---------------- results ----------------
    public void addResult(Result r) {
        // compute grades, gpa, backlogs, c-grade count, semester status
        int[] m = r.getMarks();
        String[] grades = new String[5];
        for (int i = 0; i < 5; i++) grades[i] = GPACalculator.calculateGrade(m[i]);
        double gpa = GPACalculator.computeGPA(m);
        int backlogs = GPACalculator.computeBacklogs(m);
        int cCount = GPACalculator.computeCGradeCount(grades);
        String semStatus = GPACalculator.isSemesterPass(m, gpa) ? "PASS" : "FAIL";

        String q = "INSERT INTO results (student_id, year, semester, mark1, mark2, mark3, mark4, mark5, " +
                "grade1, grade2, grade3, grade4, grade5, gpa, backlogs_count, c_grade_count, semester_status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, r.getStudentId());
            ps.setInt(2, r.getYear());
            ps.setInt(3, r.getSemester());
            for (int i = 0; i < 5; i++) ps.setInt(4 + i, m[i]);
            for (int i = 0; i < 5; i++) ps.setString(9 + i, grades[i]);
            ps.setDouble(14, gpa);
            ps.setInt(15, backlogs);
            ps.setInt(16, cCount);
            ps.setString(17, semStatus);
            ps.executeUpdate();
            System.out.println("Result added for student " + r.getStudentId() + " year " + r.getYear() + " sem " + r.getSemester());
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public Result getResultByStudentAndSemester(int studentId, int semester) {
        String q = "SELECT * FROM results WHERE student_id = ? AND semester = ? ORDER BY result_id DESC LIMIT 1";
        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, studentId);
            ps.setInt(2, semester);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int resultId = rs.getInt("result_id");
                int year = rs.getInt("year");
                int[] marks = new int[5];
                String[] grades = new String[5];
                for (int i = 0; i < 5; i++) marks[i] = rs.getInt("mark" + (i+1));
                for (int i = 0; i < 5; i++) grades[i] = rs.getString("grade" + (i+1));
                double gpa = rs.getDouble("gpa");
                int backlogs = rs.getInt("backlogs_count");
                int cCount = rs.getInt("c_grade_count");
                String semStatus = rs.getString("semester_status");
                return new Result(resultId, studentId, year, semester, marks, grades, gpa, backlogs, cCount, semStatus);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    public List<Result> listResultsForStudent(int studentId) {
        List<Result> out = new ArrayList<>();
        String q = "SELECT * FROM results WHERE student_id = ? ORDER BY year, semester";
        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int resultId = rs.getInt("result_id");
                int year = rs.getInt("year");
                int semester = rs.getInt("semester");
                int[] marks = new int[5];
                String[] grades = new String[5];
                for (int i = 0; i < 5; i++) marks[i] = rs.getInt("mark" + (i+1));
                for (int i = 0; i < 5; i++) grades[i] = rs.getString("grade" + (i+1));
                double gpa = rs.getDouble("gpa");
                int backlogs = rs.getInt("backlogs_count");
                int cCount = rs.getInt("c_grade_count");
                String semStatus = rs.getString("semester_status");
                out.add(new Result(resultId, studentId, year, semester, marks, grades, gpa, backlogs, cCount, semStatus));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return out;
    }

    public void updateMarks(int resultId, int[] newMarks) {
        // recompute everything then update
        String getQ = "SELECT * FROM results WHERE result_id = ?";
        try (PreparedStatement getPs = conn.prepareStatement(getQ)) {
            getPs.setInt(1, resultId);
            ResultSet rs = getPs.executeQuery();
            if (!rs.next()) {
                System.out.println("Result id not found: " + resultId); return;
            }
//            int studentId = rs.getInt("student_id");
//            int year = rs.getInt("year");
//            int semester = rs.getInt("semester");

            String[] grades = new String[5];
            for (int i = 0; i < 5; i++) grades[i] = GPACalculator.calculateGrade(newMarks[i]);
            double gpa = GPACalculator.computeGPA(newMarks);
            int backlogs = GPACalculator.computeBacklogs(newMarks);
            int cCount = GPACalculator.computeCGradeCount(grades);
            String semStatus = GPACalculator.isSemesterPass(newMarks, gpa) ? "PASS" : "FAIL";

            String u = "UPDATE results SET mark1=?, mark2=?, mark3=?, mark4=?, mark5=?, " +
                    "grade1=?, grade2=?, grade3=?, grade4=?, grade5=?, gpa=?, backlogs_count=?, c_grade_count=?, semester_status=? WHERE result_id=?";
            try (PreparedStatement ups = conn.prepareStatement(u)) {
                for (int i = 0; i < 5; i++) ups.setInt(i+1, newMarks[i]);
                for (int i = 0; i < 5; i++) ups.setString(6 + i, grades[i]);
                ups.setDouble(11, gpa);
                ups.setInt(12, backlogs);
                ups.setInt(13, cCount);
                ups.setString(14, semStatus);
                ups.setInt(15, resultId);
                ups.executeUpdate();
                System.out.println("Updated marks and recalculated metrics for result_id " + resultId);
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // ---------- computed analytics using stored fields ----------

    // compute GPA for a student's semester (by studentId + semester) - uses stored gpa
    public double computeGPAForStudentSemester(int studentId, int semester) {
        Result r = getResultByStudentAndSemester(studentId, semester);
        if (r == null) return 0.0;
        return r.getGpa();
    }

    // compute CGPA using stored gpa values of student's results
    public double computeCGPAForStudent(int studentId) {
        String q = "SELECT gpa FROM results WHERE student_id = ? AND gpa > 0";
        List<Double> gps = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) gps.add(rs.getDouble("gpa"));
        } catch (SQLException e) { e.printStackTrace(); }
        return GPACalculator.computeCGPA(gps);
    }

    // total backlogs (sum of backlogs_count stored)
    public int totalBacklogsForStudent(int studentId) {
        String q = "SELECT SUM(backlogs_count) as s FROM results WHERE student_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("s");
        } catch (SQLException e) { e.printStackTrace(); }
        return 0;
    }

    // count of failed semesters (semester_status = 'FAIL')
    public int countFailedSemesters(int studentId) {
        String q = "SELECT COUNT(*) as c FROM results WHERE student_id = ? AND semester_status = 'FAIL'";
        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("c");
        } catch (SQLException e) { e.printStackTrace(); }
        return 0;
    }

    // total C grade count across all results (sum of c_grade_count)
    public int totalCGradeCount(int studentId) {
        String q = "SELECT SUM(c_grade_count) as s FROM results WHERE student_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("s");
        } catch (SQLException e) { e.printStackTrace(); }
        return 0;
    }

    // final pass status using stored metrics & GPACalculator rules
    public boolean isFinalPass(int studentId) {
        double cgpa = computeCGPAForStudent(studentId);
        int totalBacklogs = totalBacklogsForStudent(studentId);
        int failedSem = countFailedSemesters(studentId);
        int cCount = totalCGradeCount(studentId);
        return GPACalculator.isFinalPass(cgpa, totalBacklogs, failedSem, cCount);
    }
}
