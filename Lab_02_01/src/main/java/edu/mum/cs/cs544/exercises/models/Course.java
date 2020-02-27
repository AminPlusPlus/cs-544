package edu.mum.cs.cs544.exercises.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private int id;
    private int courseNumber;
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(int courseNumber, String name) {
        this.courseNumber = courseNumber;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent (Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student)
    {
        this.students.remove(student);
    }
}
