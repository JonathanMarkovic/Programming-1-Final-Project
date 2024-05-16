package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class Course {
    //TODO: follow assignment instructions
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Double> finalScores;
    private static int nextId = 1;

    //TODO: put in contructor with initialized ArrayLists

    /**
     * checks if the assignment weights for the course are all valid(add up to 100)
     * @return
     */
    public boolean isAssignmentWeightValid() {
        double weight = 0;
        int maxWeight = 1;

        for (Assignment assignment : assignments) {
            weight += assignment.getWeight();
        }

        if (Math.abs(weight - maxWeight) < 0.000000001) {
            return true;
        }

        return false;
    }

    /**
     * adds a student to the list of registeredStudents
     * @param student
     * @return
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);
        finalScores.add(null);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        return true;
    }

    /**
     * calculates the average weighted grade for a student
     */
    public void calcStudentsAverage() {
        //TODO: simplify in one regular for loop
        for (Student student : registeredStudents) {        //goes through each student
            double finalScore = 0;                          //each student's final score is 0 until assignment sores get added in
            int idx = registeredStudents.indexOf(student);  //gets their index which should be the same index as their assignments/scores within the assignment

            for (Assignment assignment : assignments) {     //goes through each assignment for the class
                finalScore += assignment.getScores().get(idx) * assignment.getWeight();  //score * weight should be weighted score
                finalScores.add(finalScore);
            }
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
     * displays the scores for each student for each assignment, assignment average, and final score
     */
    public void displayScores() {
        System.out.printf("Course: %s");
    }

    /**
     * simplified toString method
     * @return
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
