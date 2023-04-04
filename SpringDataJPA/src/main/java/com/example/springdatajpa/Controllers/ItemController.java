package com.example.springdatajpa.Controllers;

import com.example.springdatajpa.Models.Item;
import com.example.springdatajpa.Models.Person;
import com.example.springdatajpa.Services.ItemService;
import com.example.springdatajpa.Services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final PersonService personService;

    @Autowired
    public ItemController(ItemService itemService, PersonService personService) {
        this.itemService = itemService;
        this.personService = personService;
    }

    @GetMapping("/")
    public String items(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "item/items";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", itemService.findOne(id));
        return "item/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("item", itemService.findOne(id));
        return "item/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("item") @Valid Item item,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) return "item/edit";
        itemService.update(id, item);
        return "redirect:/item/";
    }

    @GetMapping("/add")
    public String newItem(Model model) {
        model.addAttribute("people", personService.findAll());
        model.addAttribute("item", new Item());
        return "item/add";
    }

    @PostMapping()
    public String createItem(@ModelAttribute("item") @Valid Item item, BindingResult bindingResult,
                             @RequestParam int id,
                             Model model) {
        System.out.println(id);
        if (bindingResult.hasErrors()) return "item/edit";
        itemService.save(item);
        return "redirect:/item/";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        itemService.delete(id);
        return "redirect:/item/";
    }

}
