package com.geekbrains.controllers;

import com.geekbrains.entities.Student;
import com.geekbrains.entities.User;
import com.geekbrains.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/user")
@Transactional
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        User user = new User();
        user.setUserName("Name");
        user.setPassword("Password");
        model.addAttribute("user", user);
        return "add-user-form";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(User user) {
        userService.addUser(user);
        return "redirect:/";
    }
}
