package edu.mum.cs.cs544.exercises;

import edu.mum.cs.cs544.exercises.models.Flight;
import edu.mum.cs.cs544.exercises.models.Passenger;
import edu.mum.cs.cs544.exercises.models.School;
import edu.mum.cs.cs544.exercises.models.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolApp {
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

            Student student = new Student("Amin","Abdullo");
            Student student1 = new Student("Jim Kerry","Hello");
            Student student2 = new Student("Maryam","Khayom");

            School school =  new School("54",student);
            //school.setStudentMap(sts1);

            session.persist(school);


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

            List<School> departmentList = session .createQuery("from School").list();

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
