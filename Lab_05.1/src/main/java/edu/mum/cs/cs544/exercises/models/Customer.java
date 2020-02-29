package edu.mum.cs.cs544.exercises.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    List<Order> orderList = new ArrayList<>();

    public Customer() {
    }

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void addOrder(Order order){
        order.setCustomer(this);
        this.orderList.add(order);
    }

    public void removeOrder(Order order){
        this.orderList.remove(order);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
