package edu.mum.cs.cs544.exercises.models;

import javax.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private int id;
    private String appdate;
    @Embedded
    private Payment payment;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Patient patient;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Doctor doctor;

    public Appointment() {
    }
    public Appointment(String appdate,Payment payment, Patient patient,Doctor doctor) {
        this.appdate = appdate;
        this.payment = payment;
        this.patient = patient;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appdate='" + appdate + '\'' +
                ", patient=" + patient +
                ", payment=" + payment +
                ", doctor=" + doctor +
                '}';
    }
}
