package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        return "users";
    }
    @GetMapping("/create")
    public String createUserForm(User user){
        return "create";
    }
    @PostMapping("/create")
    public String createUser(User user){
        userService.save(user);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String updateGetForm(@PathVariable Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "update";
    }
    @PostMapping("/update")
    public String update(User user){
        userService.save(user);
        return "redirect:/";
    }
}
