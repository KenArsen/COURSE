package com.example.springdatajpa.Services;

import com.example.springdatajpa.Models.Person;
import com.example.springdatajpa.Repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    private final PeopleRepository peopleRepository;
    @Autowired
    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    public Person findOne(int id){
        return peopleRepository.findById(id).orElse(null);
    }

    public void save(Person person){
        person.setCreatedAt(new Date());
        peopleRepository.save(person);
    }

    public void update(int id, Person person){
        person.setId(id);
        peopleRepository.save(person);
    }

    public void delete(int id){
        peopleRepository.deleteById(id);
    }
}
