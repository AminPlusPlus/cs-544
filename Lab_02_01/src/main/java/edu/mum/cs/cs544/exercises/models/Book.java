package edu.mum.cs.cs544.exercises.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int isbn;
    private String title;


    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Publisher> authors = new ArrayList<>();

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    private void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Publisher> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Publisher> authors) {
        this.authors = authors;
    }


    public void addAuthor(Publisher publisher){
        authors.add(publisher);
    }

    public void removeAuthor(Publisher publisher){
        authors.remove(publisher);
    }

}
