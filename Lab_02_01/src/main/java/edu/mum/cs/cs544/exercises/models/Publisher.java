package edu.mum.cs.cs544.exercises.models;

import javax.persistence.*;

@Entity
public class Publisher {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
