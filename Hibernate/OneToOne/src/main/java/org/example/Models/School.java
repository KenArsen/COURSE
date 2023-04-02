package org.example.Models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "School")
public class School implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director director;

    @Column(name = "school_name")
    private String school_name;

    public School() {
    }

    public School(String school_name) {
        this.school_name = school_name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }
}
