package edu.mum.cs.cs544.exercises;

import edu.mum.cs.cs544.exercises.models.Course;
import edu.mum.cs.cs544.exercises.models.Department;
import edu.mum.cs.cs544.exercises.models.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class DeparmentApp {
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

            Employee employee4 = new Employee("Ali");

            Department department = new Department("Technical");
            Department department1 = new Department("Hr");
            department.addEmployee(employee);
            department.addEmployee(employee1);
            department.addEmployee(employee2);

            department1.addEmployee(employee4);

            session.persist(department);
            session.persist(department1);

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
