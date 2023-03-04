package org.example.day2;

import java.util.ArrayList;
import java.util.List;

public class Day2Note {

}

//how to create immutable class
//        - final class
//        - private field
//        - no setter, only getter
//        - deep copy of collection
final class StudentImmutableClass {
    private final int studentId;
    private final String firstName;
    private final String lastName;
    private final List<Course> course;

    StudentImmutableClass(int studentId, String firstName, String lastName, List<Course> course) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = deepCopy(course);
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Course> getCourse() {
        List<Course> newList = deepCopy(this.course);
        return newList;
    }

    private List<Course> deepCopy(List<Course> course) {
        List<Course> newList = new ArrayList<>();
        for (Course num: course) newList.add(num);
        return newList;
    }
}
class Course {
}
