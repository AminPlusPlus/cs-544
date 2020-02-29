package edu.mum.cs.cs544.exercises;

import edu.mum.cs.cs544.exercises.models.Flight;
import edu.mum.cs.cs544.exercises.models.Passenger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Calendar;
import java.util.List;

public class PassengerApp {

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
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Calendar calendar = Calendar.getInstance();
            calendar.set(2020,05,20);

            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(2020,05,22);

            Flight flight = new Flight("SZ233","Dushanbe","New York",calendar);
            Flight flight1 = new Flight("WF1333","Belin","Moscow",calendar);


            Passenger passenger = new Passenger("Aminjon Abdullozoda",flight);
            passenger.addFlight(flight1);

            session.persist(passenger);


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

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            List<Passenger> departmentList = session .createQuery("from Passenger").list();

            departmentList.forEach(System.out::println);



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

        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
        //System.exit(0);
    }
}
