package com.gl.spring.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gl.spring.ecommerce.entity.User;
import com.gl.spring.ecommerce.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showHomePage() {
        return "index";  // This should map to index.html
    }

    @PostMapping("/registeruser")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";  // This should map to users.html
    }

    @GetMapping("/validateUser")
    public String validateUser(@RequestParam String username, @RequestParam String password,@RequestParam String role, Model model) {
        boolean isValid = userService.validateUser(username, password,role);
        model.addAttribute("isValid", isValid);
        return "validateResult";  // This should map to validateResult.html
    }
}

