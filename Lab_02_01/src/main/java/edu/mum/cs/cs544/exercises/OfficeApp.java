package edu.mum.cs.cs544.exercises;

import edu.mum.cs.cs544.exercises.models.Department;
import edu.mum.cs.cs544.exercises.models.Employee;
import edu.mum.cs.cs544.exercises.models.Office;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

public class OfficeApp {
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

            Employee employee = new Employee("Amin");
            Employee employee1 = new Employee("Maryam");
            Employee employee2 = new Employee("Jack");

            Department department = new Department("Technical");
            Office office = new Office(212,"Cupertino");

            department.addEmployee(employee);
            department.addEmployee(employee1);
            department.addEmployee(employee2);

            office.addEmployee(employee);
            office.addEmployee(employee2);

            session.persist(department);
            session.persist(office);


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

            List<Department> departmentList = session
                    .createQuery("from Department").list();

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
