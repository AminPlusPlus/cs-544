package edu.mum.cs.cs544.exercises.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class CD extends Product {

    private String artist;

    public CD() {
    }

    public CD(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "CD{" +
                "artist='" + artist + '\'' +
                '}';
    }
}
