package com.example.springdatajpa.Controllers;

import com.example.springdatajpa.Models.Person;
import com.example.springdatajpa.Services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String people(Model model){
        model.addAttribute("people", personService.findAll());
        return "person/people";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personService.findOne(id));
        return "person/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personService.findOne(id));
        return "person/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id")int id){
        if(bindingResult.hasErrors()) return "person/edit";
        personService.update(id, person);
        return "redirect:/people/";
    }

    @GetMapping("/add")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "person/add";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person")@Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "person/add";
        personService.save(person);
        return "redirect:/people/";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        personService.delete(id);
        return "redirect:/people/";
    }
}
