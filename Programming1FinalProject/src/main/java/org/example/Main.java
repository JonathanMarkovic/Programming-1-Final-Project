package org.example;

public class Main {
    public static void main(String[] args) {
        Address address = new Address(1234, "Street", "City", "Province", "H1D 1A1", "Country");
        Department department = new Department("Dep Name");
        Student student1 = new Student("Bob", Gender.MALE, address, department);
        Student student2 = new Student("Sallyt", Gender.FEMALE, address, department);
        Student student3 = new Student("Greg", Gender.MALE, address, department);

        Course course = new Course("Class", 5, department);

        course.addAssignment("Name1", 0.2, 100);
        course.addAssignment("Name2", 0.4, 100);
        course.addAssignment("Name3", 0.4, 100);

        course.registerStudent(student1);
        course.registerStudent(student2);
        course.registerStudent(student3);

        course.generateScores();
        course.displayScores();
    }
}