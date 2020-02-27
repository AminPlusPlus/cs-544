package edu.mum.cs.cs544.exercises.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;

    Set<Laptop> laptops = new HashSet<>();

    public Employee() {
    }

    public Employee(String firstname, String lastname, Laptop laptop) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.laptops.add(laptop);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Set<Laptop> laptops) {
        this.laptops = laptops;
    }
}
