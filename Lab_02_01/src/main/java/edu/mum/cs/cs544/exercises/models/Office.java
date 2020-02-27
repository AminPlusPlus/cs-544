package edu.mum.cs.cs544.exercises.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Office {

    @Id
    @GeneratedValue
    private int id;
    private int roomNumber;
    private String building;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Employee> employees = new HashSet<>();

    public Office() {
    }

    public Office(int roomNumber, String building) {
        this.roomNumber = roomNumber;
        this.building = building;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


    public void addEmployee(Employee employee){
        employee.setOffice(this);
        employees.add(employee);
    }

}
