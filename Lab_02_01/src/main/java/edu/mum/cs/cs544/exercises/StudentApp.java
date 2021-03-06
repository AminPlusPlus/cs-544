package edu.mum.cs.cs544.exercises;

import edu.mum.cs.cs544.exercises.models.Course;
import edu.mum.cs.cs544.exercises.models.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class StudentApp {

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

            Student student = new Student("James","Khan");
            Student student1 = new Student("Shiraz","Alexey");

            Course course = new Course(544,"EA");
            Course course1 = new Course(344,"MPP");
            Course course2 = new Course(244,"FPP");

            student.addCourse(course);
            student.addCourse(course1);
            student.addCourse(course2);

            student1.addCourse(course);
            student1.addCourse(course2);

            session.persist(student);
            session.persist(student1);

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

            List<Student> departmentList = session
                    .createQuery("from Student").list();

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
