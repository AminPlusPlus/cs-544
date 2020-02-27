package edu.mum.cs.cs544.exercises;

import edu.mum.cs.cs544.exercises.models.Book;
import edu.mum.cs.cs544.exercises.models.Department;
import edu.mum.cs.cs544.exercises.models.Employee;
import edu.mum.cs.cs544.exercises.models.Publisher;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class BookApp {

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

            Publisher publisher = new Publisher("Jim Cerry");
            Publisher publisher1 = new Publisher("Lee Zhang");

            Book book = new Book("Jump To Zero");
            book.addAuthor(publisher);
            book.addAuthor(publisher1);

            session.persist(book);

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

            List<Book> list = session
                    .createQuery("from Book").list();

            list.forEach(System.out::println);


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
