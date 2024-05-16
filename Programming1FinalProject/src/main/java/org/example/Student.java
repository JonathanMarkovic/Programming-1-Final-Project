package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    Department department;
    ArrayList<Course> registeredcourses;
    private static int nextId = 1;

    /**
     * registers the student to a given course
     * @param course the course name
     * @return true if the registration was complete
     */
    public boolean registerCourse(Course course) {
        if (registeredcourses.contains(course)) {
            return false;
        }

        //TODO: check this over after doing the course class
        registeredcourses.add(course);
        course.registerStudent(this);
        return true;
    }

    /**
     * drops a course from the list of registered courses
     * @param course the course to be dropped
     * @return true if the course was successfully dropped
     */
    public boolean dropCourse(Course course) {
        if (registeredcourses.contains(course)) {
            registeredcourses.remove(course);
        }
        return false;
    }

    /**
     * simplified toString method with only a few of the data members
     * @return the simplified string
     */
    public String toSimplifiedString() {
        return String.format("Student ID: %s,  Student Name: %s, Department Name: %s\n",
                studentId, studentName, department);
    }

    @Override
    public String toString() {
        ArrayList<String> courses = new ArrayList<>();
        for (Course course : registeredcourses) {
            courses.add(course.toSimplifiedString());
        }
        return String.format("Student {\n" +
                "Student ID: %s\n" +
                "Student Name: %s\n" +
                "Gender: %s\n" +
                "Address: %s\n" +
                "Department: %s\n" +
                "Registered Courses: {",
                studentId, studentName, gender, address, department, courses);
    }
}
