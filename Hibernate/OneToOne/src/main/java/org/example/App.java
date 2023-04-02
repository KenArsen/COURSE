package org.example;

import org.example.Models.Director;
import org.example.Models.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            Director director = session.get(Director.class, 1);
            session.delete(director);
//            Director director = new Director("Arsen", 22);
//            School school = new School("IT School");
//
//            director.addSchool(school);
//
//            session.save(director);


            session.getTransaction().commit();

        }finally {
            sessionFactory.close();
        }
    }
}
