package edu.mum.cs.cs544.exercises.models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Flight {

    @Id
    @GeneratedValue
    private int id;
    private String flightNumber;
    @Column(name = "_from")
    private String from;
    @Column(name = "_to")
    private String to;

    @Temporal(value = TemporalType.DATE)
    private Calendar date;

    @ManyToOne
    private Passenger passenger;


    public Flight() {
    }

    public Flight(String flightNumber, String from, String to, Calendar date) {
        this.flightNumber = flightNumber;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date.getTime() +
                '}';
    }
}
