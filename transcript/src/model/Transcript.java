package model;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    /**
     * INVARIANT: course list and grade list are the same size
     * each course has a grade associated, and vice versa, at matching indices
     */

    private String studentName;
    private final int studentId;
    private List<String> courseNames;
    private List<Double> courseGrades;

    public Transcript(String studentName, int studentId) {

        this.studentName = studentName;
        this.studentId = studentId;
        this.courseNames = new ArrayList<>();
        this.courseGrades = new ArrayList<>();
    }

    // getters
    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    // REQUIRES course does not already exist in the transcript
    //          grade is between 0.0 and 4.0
    // MODIFIES this
    // EFFECTS adds a course and a corresponding grade
    public void addGrade(String course, double grade) {
        courseNames.add(course);
        courseGrades.add(grade);
    }

    // EFFECTS return course name and grade in format "course name: Grade" if course exists
    //         return null otherwise
    public String getCourseAndGrade(String course) {
        for (int i = 0; i < courseNames.size(); i++) {
            if (courseNames.get(i).equals(course)) {
                return course + ": " + courseGrades.get(i).toString();
            }
        }

        return null;
    }

    // REQUIRES the transcript should have at least one course-grade entry
    // EFFECTS outputs the whole transcript
    public void printTranscript() {
    }

    // REQUIRES the transcript should have at least one course-grade entry
    // EFFECTS calculates and returns the GPA
    public double getGPA() {
        return 0.0;
    }
}
