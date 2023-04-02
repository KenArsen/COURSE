package com.example.test.Controllers;

import com.example.test.Models.User;
import com.example.test.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserDAO userDAO;

    @Autowired
    public AdminController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/")
    public String addAdmin(Model model, @ModelAttribute("user")User user){
        model.addAttribute("users", userDAO.index());
        return "user/add-admin";
    }

    @PostMapping("/add")
    public String addingAdmin(@ModelAttribute("user") User user){
        System.out.println(user.getId());
        userDAO.testAdmin(user.getId());
        return "redirect:/user/";
    }
}
