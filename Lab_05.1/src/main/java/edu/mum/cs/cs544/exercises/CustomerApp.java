package edu.mum.cs.cs544.exercises;

import edu.mum.cs.cs544.exercises.models.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomerApp {
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


            //Products
            DVD irsh = new DVD("IrishMan","Bet Movice","Criminal");
            Product michal = new CD("Top 20","Best North America","Pop");
            Product jim = new Book("Best Upcoming","NYC Bestseller","Jim");


            Product irish2 = new DVD("IrishMan","Bet Movice","Criminal");



            //Customer
            Customer newCustomer = new Customer("Amin","Abdullo");
            Customer newCustomer1 = new Customer("Jim","Hey");

            //Date
            Calendar calendarDate = Calendar.getInstance();
            calendarDate.set(2020,02,28);

            Calendar calendarDate1 = Calendar.getInstance();
            calendarDate.set(2019,02,28);

            //Order
            Order newOrder = new Order(calendarDate);

            Order newOrder1 = new Order(calendarDate1);

            //orderLine
            List<OrderLine> lines = new ArrayList<>();
            lines.add(new OrderLine(5,irsh));
            lines.add(new OrderLine(4,michal));
            lines.add(new OrderLine(2,jim));

            List<OrderLine> lines1 = new ArrayList<>();
            lines.add(new OrderLine(10,irish2));

            newOrder.setOrderLines(lines);
            newCustomer.addOrder(newOrder);
            session.persist(newCustomer);

            newOrder1.setOrderLines(lines1);
            newCustomer1.addOrder(newOrder1);

            session.persist(newCustomer1);

         //  Order cust2  = (Order) session.merge(newOrder1);
          // session.delete(cust2);



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

            System.out.println("\n\nFULL LIST CUSTOMER:");
            //List<Customer> departmentList = session .createQuery("from Customer").list();
            //departmentList.forEach(System.out::println);
            System.out.println("\n\nFULL ORDERS:");
            System.out.println(session.createQuery("from Order").list());

            System.out.println("\n\nFULL ORDER LINE:");
            System.out.println(session.createQuery("from OrderLine").list());

            System.out.println("\n\nFULL PRODUCT LINE:");
            System.out.println(session.createQuery("from Product as p where p.name like 'i%'").list());



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
