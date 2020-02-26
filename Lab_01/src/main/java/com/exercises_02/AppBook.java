package com.exercises_02;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class AppBook {

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }



    public static void main(String[] args) {

        //add 3 books
        add3Books();
        //retrieve books
        fetchBooks();
        //retrieve book update and delete next one
        retrieveABookUpdateDelete();
        //retrieve books
        fetchBooks();

    }

    //add books
    private static void add3Books() {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();

            //1st book
            Book book1 = new Book("ZeroToOne",
                    "SD3313",
                    "Peter Thiel, Blake Masters",
                    39.30,
                      new Date(2014,01,12));

            Book book2 = new Book("Nineteen Eighty-Four",
                    "00123312",
                    "George Orwell",
                    54.30,
                    new Date(1949,06,8));

            Book book3 = new Book("To Kill A Mockingbird",
                    "SD3313",
                    "Harper Lee",
                    19.30,
                    new Date(1960,07,11));


            session.persist(book1);
            session.persist(book2);
            session.persist(book3);

            tx.commit();


        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //retrieve books
    private static void  fetchBooks(){
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();

            //run query get books
            List<Book> books = session.createQuery("from Book").list();

            System.out.println("\n\nLIST BOOKS: ");
            //prints
            books.forEach(System.out::println);


            tx.commit();


        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //retrieve book update delete
    private static void retrieveABookUpdateDelete(){
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();

            //get update book
            Book book = (Book) session.get(Book.class,1);
            book.setTitle("One to Zero");
            book.setPrice(55.0);

            //get Book 3
            Book book3 = (Book) session.get(Book.class, 3);
            //delete
            session.delete(book3);

            tx.commit();


        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


}
