package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.Random;

@Setter
@EqualsAndHashCode
public class Assignment {
    @Getter
    private String assignmentId;
    @Getter
    private String assignmentName;
    @Getter
    private double weight;
    @Getter
    private int maxScore;
    private double assignmentAverage;
    @Getter
    private ArrayList<Integer> scores;
    @Getter
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int maxScore, int numStudents) {
        this.assignmentId = "" + nextId++;
        this.assignmentName = Util.toTitleCase(assignmentName);
        this.weight = weight;
        this.maxScore = maxScore;
        scores = new ArrayList<>(numStudents);
        calcAssignmentAverage();
    }

    /**
     * calculates the average score for a given assignment
     */
    public void calcAssignmentAverage() {
        double avg = 0;

        for (int i = 0; i < scores.size(); i++) {
            Integer score = scores.get(i);
            if (score != null) {
                avg += score;
            }
        }

        assignmentAverage = avg / scores.size();
    }

    /**
     * generates random scores for an assignment and stores them in the scores ArrayList
     */
    public void generateRandomScore() {
        Random rand = new Random();

        int numStudent = scores.size();

        for (int i = 0; i < numStudent; i++) {
            int scoreBracket = rand.nextInt(0,10 + 1);
            int score = switch (scoreBracket) {
                case 0 -> rand.nextInt(60);
                case 1, 2 -> rand.nextInt(60, 70);
                case 3, 4 -> rand.nextInt(70, 80);
                case 5, 6, 7, 8 -> rand.nextInt(80, 90);
                case 9, 10 -> rand.nextInt(90, 100 + 1);
                default -> throw new IllegalStateException("Unexpected value: " + scoreBracket);
            };
            scores.set(i, score);
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                ", maxScore=" + maxScore +
                '}';
    }

    public double getAssignmentAverage() {
        calcAssignmentAverage();
        return assignmentAverage;
    }
}
