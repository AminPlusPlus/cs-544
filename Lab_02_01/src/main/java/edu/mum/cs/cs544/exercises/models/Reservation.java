package edu.mum.cs.cs544.exercises.models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private int id;
    @Temporal(value = TemporalType.DATE)
    private Calendar calendar;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Book book;

    public Reservation() {
    }

    public Reservation(Calendar calendar){
        this.calendar = calendar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", calendar=" + calendar +
                ", book="+book+
                '}';
    }
}
