package com.exercises_02;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String ISBN;
    private String author;
    private double price;

    @Temporal(value = TemporalType.DATE)
    private Calendar publish_date;

    public Book() {
    }

    public Book (String title, String ISBN, String author,double price, Calendar publish_date )
    {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
        this.publish_date = publish_date;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Calendar getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Calendar publish_date) {

        this.publish_date = publish_date;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publish_date=" + publish_date.getTime() +
                '}';
    }
}
