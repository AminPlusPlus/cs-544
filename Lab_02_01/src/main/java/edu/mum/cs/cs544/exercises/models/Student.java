package edu.mum.cs.cs544.exercises.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Student {
    @Id
    @GeneratedValue
    private int studentId;
    private String firstName;
    private String lastName;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Course> courses = new ArrayList<>();


    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse (Course course) {
        this.courses.add(course);
    }

    public void removeCourse (Course course){
        this.courses.remove(course);
    }
}
