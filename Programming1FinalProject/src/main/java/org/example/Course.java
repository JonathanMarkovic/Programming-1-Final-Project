package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.util.Util;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = "" + nextId++;
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        assignments = new ArrayList<>();
        registeredStudents = new ArrayList<>();
        finalScores = new ArrayList<>();
    }

    /**
     * checks if the assignment weights for the course are all valid(add up to 100)
     * @return true if the assignment weight is valid
     */
    public boolean isAssignmentWeightValid() {
        double weight = 0;
        int maxWeight = 1;

        for (Assignment assignment : assignments) {
            weight += assignment.getWeight();
        }

        if (weight - maxWeight == 0) {
            return true;
        }

        return false;
    }

    /**
     * adds a student to the list of registeredStudents
     * @param student the student being added to the list of registered students
     * @return true if the student was successfully added
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);
        finalScores.add(null);

        int studentIdx = registeredStudents.indexOf(student);
        for (int i = 0; i < assignments.size(); i++) {
            Assignment assignment = assignments.get(i);
            assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * calculates the average weighted grade for a student
     */
    public void calcStudentsAverage() {
        for (int i = 0; i < registeredStudents.size(); i++) {
            double finalScore = 0;
            for (int j = 0; j < assignments.size(); j++) {
                Assignment assignment = assignments.get(j);
                int score = assignment.getScores().get(i);

                finalScore += score * assignment.getWeight();
            }
            finalScores.set(i, finalScore);
        }
    }

    /**
     * adds an assignment to the course's list of assignments
     * @param assignmentName the name of the assignment
     * @param weight the weight of the assignment
     * @param maxScore the maximum score of the assignment
     * @return true if the assignment was added correctly
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight, maxScore, registeredStudents.size());
        if (assignments.contains(assignment)) {
            return false;
        }
        assignments.add(assignment);
        return true;
    }

    /**
     * generates random scores for each assignment for each student
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }

        calcStudentsAverage();
    }

    /**
     * Displays the scores for each student for each assignment, assignment average, and final score
     */
    public void displayScores() {
        System.out.printf("Course: %s %s\n", courseName, courseId);
        System.out.printf("Final Score         ");
        System.out.printf("Student             ");
        int num = 1;
        for (int i = 0; i < assignments.size(); i++) {
            Assignment assignment = assignments.get(i);
            System.out.printf("%20s", assignment.getAssignmentName());
        }
        System.out.printf("\n");
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.printf("%20.2f %20s ", finalScores.get(i), student.getStudentName());

            for (int j = 0; j < assignments.size(); j++) {
                Assignment assignment = assignments.get(j);
                int score = assignment.getScores().get(i);
                System.out.printf("%20d", score);
            }
            System.out.printf("\n");
        }
        System.out.printf("%30s", "Average");
        for (int i = 0; i < assignments.size(); i++) {
            Assignment assignment = assignments.get(i);
            double average = assignment.getAssignmentAverage();
            System.out.printf("%20.2f", average);
        }
        System.out.printf("\n");
    }

    /**
     * simplified toString method
     * @return the simplified String
     */
    public String toSimplifiedString() {
        return String.format("Course ID: %s, Course Name: %s, DepartmentName: %d\n",
                courseId, courseName, department);
    }

    @Override
    public String toString() {
        ArrayList<String> students = new ArrayList<>();
        for (Student student : registeredStudents) {
            students.add(student.toSimplifiedString());
        }
        return String.format("Course ID: %s\n" +
                "Course Name: %s\n" +
                "Credits: %d\n" +
                "Department: %s\n" +
                "Assignments: %s\n" +
                "Registered Students: %s\n",
                courseName, credits, department.getDepartmentName() ,assignments.toString(), students);
    }
}
