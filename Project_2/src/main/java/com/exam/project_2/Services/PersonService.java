package com.exam.project_2.Services;

import com.exam.project_2.Models.Book;
import com.exam.project_2.Models.Person;
import com.exam.project_2.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> index(){
        return personRepository.findAll();
    }

    public List<Person> findAll(int page, int perPage){
        return personRepository.findAll(PageRequest.of(page, perPage, Sort.by("age"))).getContent();
    }

    public Person findOne(int id){
        return personRepository.findById(id).orElse(null);
    }

    public List<Person> findByNameStartingWith(String word){
        return personRepository.findByNameStartingWith(word);
    }
}
