import org.example.Assignment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestAssignment {

    @Test
    public void testCalcAssignmentAverage() {
        Assignment assignment = new Assignment("Name", 1, 100, 3);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(50);
        scores.add(90);
        scores.add(75);
        assignment.setScores(scores);

        double result = assignment.getAssignmentAverage();
        double expectedResult = 71.66666;

        Assertions.assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testCalcAssignmentAverage2() {
        Assignment assignment = new Assignment("Name", 1, 100, 3);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(0);
        scores.add(0);
        scores.add(0);
        assignment.setScores(scores);

        double result = assignment.getAssignmentAverage();
        double expectedResult = 0;

        Assertions.assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testCalcAssignmentAverage3() {
        Assignment assignment = new Assignment("Name", 1, 100, 3);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(100);
        scores.add(100);
        scores.add(100);
        assignment.setScores(scores);

        double result = assignment.getAssignmentAverage();
        double expectedResult = 100;

        Assertions.assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testCalcAssignmentAverage4() {
        Assignment assignment = new Assignment("Name", 1, 100, 3);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(0);
        scores.add(null);
        scores.add(0);
        assignment.setScores(scores);

        double result = assignment.getAssignmentAverage();
        double expectedResult = 0;

        Assertions.assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testCalcAssignmentAverage5() {
        Assignment assignment = new Assignment("Name", 1, 100, 3);
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(null);
        scores.add(null);
        scores.add(null);
        assignment.setScores(scores);

        double result = assignment.getAssignmentAverage();
        double expectedResult = 0;

        Assertions.assertEquals(expectedResult, result, 0.0001);
    }
}
