import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestCourse {

    @Test
    public void testIsAssignmentWeightValid() {
        Course course = new Course("Name", 5, new Department("name"));
        Assignment assignment1 = new Assignment("Assignment 1", 0.2, 100, 5);
        Assignment assignment2 = new Assignment("Assignment 2", 0.8, 100, 5);
        course.addAssignment(assignment1);
        course.addAssignment(assignment2);

        boolean expectedResult = true;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentWeightValid2() {
        Course course = new Course("Name", 5, new Department("name"));
        Assignment assignment1 = new Assignment("Assignment 1", 0.5, 100, 5);
        Assignment assignment2 = new Assignment("Assignment 2", 0.5, 100, 5);
        course.addAssignment(assignment1);
        course.addAssignment(assignment2);

        boolean expectedResult = true;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentWeightValid3() {
        Course course = new Course("Name", 5, new Department("name"));
        Assignment assignment1 = new Assignment("Assignment 1", 0.2, 100, 5);
        Assignment assignment2 = new Assignment("Assignment 2", 0.2, 100, 5);
        course.addAssignment(assignment1);
        course.addAssignment(assignment2);

        boolean expectedResult = false;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentWeightValid4() {
        Course course = new Course("Name", 5, new Department("name"));
        Assignment assignment1 = new Assignment("Assignment 1", 0, 100, 5);
        Assignment assignment2 = new Assignment("Assignment 2", 0, 100, 5);
        course.addAssignment(assignment1);
        course.addAssignment(assignment2);

        boolean expectedResult = false;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentWeightValid5() {
        Course course = new Course("Name", 5, new Department("name"));
        Assignment assignment1 = new Assignment("Assignment 1", 1, 100, 5);
        Assignment assignment2 = new Assignment("Assignment 2", 1, 100, 5);
        course.addAssignment(assignment1);
        course.addAssignment(assignment2);

        boolean expectedResult = false;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsAssignmentWeightValid6() {
        Course course = new Course("Name", 5, new Department("name"));
        Assignment assignment1 = new Assignment("Assignment 1", 1, 100, 5);
        Assignment assignment2 = new Assignment("Assignment 2", 0, 100, 5);
        course.addAssignment(assignment1);
        course.addAssignment(assignment2);

        boolean expectedResult = true;
        boolean result = course.isAssignmentWeightValid();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAverage() {
        Course course = new Course("Name", 5, new Department("name"));
        Assignment assignment1 = new Assignment("Assignment 1", 0.2, 100, 5);
        Assignment assignment2 = new Assignment("Assignment 2", 0.8, 100, 5);
        course.addAssignment(assignment1);
        course.addAssignment(assignment2);

        Address address = new Address(123, "Street", "City", "Province", "H1D 2V2", "Country");
        Student student = new Student("Name", Gender.MALE, address, new Department("department"));
        Student student2 = new Student("Name", Gender.MALE, address, new Department("department"));
        Student student3 = new Student("Name", Gender.MALE, address, new Department("department"));
        course.registerStudent(student);
        course.registerStudent(student2);
        course.registerStudent(student3);

        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(50);
        scores.add(90);
        scores.add(75);
        assignment1.setScores(scores);
        assignment2.setScores(scores);

        ArrayList<Double> expectedResult = new ArrayList<>();
        expectedResult.add(50.0);
        expectedResult.add(90.0);
        expectedResult.add(75.0);

        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAverage2() {
        Course course = new Course("Name", 5, new Department("name"));
        Assignment assignment1 = new Assignment("Assignment 1", 0.2, 100, 5);
        Assignment assignment2 = new Assignment("Assignment 2", 0.8, 100, 5);
        course.addAssignment(assignment1);
        course.addAssignment(assignment2);

        Address address = new Address(123, "Street", "City", "Province", "H1D 2V2", "Country");
        Student student = new Student("Name", Gender.MALE, address, new Department("department"));
        Student student2 = new Student("Name", Gender.MALE, address, new Department("department"));
        Student student3 = new Student("Name", Gender.MALE, address, new Department("department"));
        course.registerStudent(student);
        course.registerStudent(student2);
        course.registerStudent(student3);

        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(null);
        scores.add(90);
        scores.add(75);
        assignment1.setScores(scores);
        assignment2.setScores(scores);

        ArrayList<Double> expectedResult = new ArrayList<>();
        expectedResult.add(0.0);
        expectedResult.add(90.0);
        expectedResult.add(75.0);

        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testCalcStudentAverage3() {
        Course course = new Course("Name", 5, new Department("name"));
        Assignment assignment1 = new Assignment("Assignment 1", 0.2, 100, 5);
        Assignment assignment2 = new Assignment("Assignment 2", 0.8, 100, 5);
        course.addAssignment(assignment1);
        course.addAssignment(assignment2);

        Address address = new Address(123, "Street", "City", "Province", "H1D 2V2", "Country");
        Student student = new Student("Name", Gender.MALE, address, new Department("department"));
        Student student2 = new Student("Name", Gender.MALE, address, new Department("department"));
        Student student3 = new Student("Name", Gender.MALE, address, new Department("department"));
        course.registerStudent(student);
        course.registerStudent(student2);
        course.registerStudent(student3);

        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(null);
        scores.add(null);
        scores.add(null);
        assignment1.setScores(scores);
        assignment2.setScores(scores);

        ArrayList<Double> expectedResult = new ArrayList<>();
        expectedResult.add(0.0);
        expectedResult.add(0.0);
        expectedResult.add(0.0);

        ArrayList<Double> result = course.getFinalScores();

        Assertions.assertEquals(expectedResult, result);
    }
}
