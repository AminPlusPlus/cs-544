package edu.mum.cs.cs544.exercises.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "`Order`")
public class Order {
    @Id
    @GeneratedValue
    private long orderId;
    @Temporal(value = TemporalType.DATE)
    private Calendar calendar;

    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderLine")
    List<OrderLine> orderLines = new ArrayList<>();

    public Order() {
    }

    public Order(Calendar calendar) {
        this.calendar = calendar;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", calendar=" + calendar.getTime() +
                ", orderLines=" + orderLines +
                '}';
    }
}
