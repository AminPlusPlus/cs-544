package edu.mum.cs.cs544.exercises;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    @OrderColumn(name = "sequence")
    @OrderBy("city desc ")
    private List<Address> address = new ArrayList<>() ;

    public User() {
    }

    public User(String name, List<Address> address) {
        this.name = name;
        this.address = address;
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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
