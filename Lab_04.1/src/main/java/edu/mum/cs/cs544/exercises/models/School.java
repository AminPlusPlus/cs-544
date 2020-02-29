package edu.mum.cs.cs544.exercises.models;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;;

@Entity
public class School {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "school")
    //@JoinColumn(name = "school_id")
    @MapKey(name = "id")
    Map<Integer, Student> studentMap = new HashMap<>();

    public School() {
    }

    public School(String name, Student student) {
        this.name = name;
        this.studentMap.put(student.getId(),student);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<Integer, Student> studentMap) {
        this.studentMap = studentMap;
    }

    public void addStudent(Student student){
        this.studentMap.put(student.getId(),student);
    }

    public void removeStudent(Student student){
        studentMap.remove(student);
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentMap=" + studentMap +
                '}';
    }
}
