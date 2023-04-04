package com.exam.project_2.Repositories;

import com.exam.project_2.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByNameOrEmail(String name, String email);

    List<Person> findByNameStartingWith(String word);
}
