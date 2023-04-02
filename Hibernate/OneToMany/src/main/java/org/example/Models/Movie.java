package org.example.Models;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private Producer producer;

    @Column(name = "movie_name")
    private String movie_name;

    public Movie() {
    }

    public Movie(Producer producer, String movie_name) {
        this.producer = producer;
        this.movie_name = movie_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", producer=" + producer +
                ", movie_name='" + movie_name + '\'' +
                '}';
    }
}
