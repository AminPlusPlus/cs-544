package edu.mum.cs.cs544.exercises.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    @GeneratedValue
    private int id;
    private String doctorType;
    private String firstname;
    private String lastname;

    public Doctor() {
    }
    public Doctor(String doctorType, String firstname, String lastname) {
        this.doctorType = doctorType;
        this.firstname = firstname;
        this.lastname =lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
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

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", doctorType='" + doctorType + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
