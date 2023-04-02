package org.example;

import org.example.Models.Actor;
import org.example.Models.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
            .addAnnotatedClass(Actor.class)
            .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try(sessionFactory){
            session.beginTransaction();

            Actor actor1 = session.get(Actor.class, 1);
            Actor actor2 = session.get(Actor.class, 2);
            System.out.println(actor1.getMovies());
            System.out.println(actor2.getMovies());

            System.out.println(actor1.getMovies().get(1).getActors());
            System.out.println(actor2.getMovies().get(0).getActors());

            session.getTransaction().commit();
        }
    }
}
