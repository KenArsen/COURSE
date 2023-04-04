package com.exam.project_2.Controllers;

import com.exam.project_2.Models.Book;
import com.exam.project_2.Models.Person;
import com.exam.project_2.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<Person> printAll(@Param("page") int page,
                                 @Param("perPage")int perPage){
        return personService.findAll(page ,perPage);
    }

    @GetMapping("/{id}")
    public Person findOne(@PathVariable("id") int id){
        return personService.findOne(id);
    }

    @GetMapping("/{word}")
    public List<Person> findNameStartingWith(@PathVariable("word") String word){
        return personService.findByNameStartingWith(word);
    }

    @GetMapping()
    public List<Person> all(){
        return personService.index();
    }
}
