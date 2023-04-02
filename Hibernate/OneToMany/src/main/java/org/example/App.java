package org.example;

import org.example.Models.Item;
import org.example.Models.Movie;
import org.example.Models.Person;
import org.example.Models.Producer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Producer.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 3);
            System.out.println("Мы получили человека");
            System.out.println(person.getName());
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
