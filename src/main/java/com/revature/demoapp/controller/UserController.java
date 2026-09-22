package com.revature.demoapp.controller;

import com.revature.demoapp.models.User;
import com.revature.demoapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
//MVC -> Model View Controller
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = service.loginUser(username, password);
        if (user != null) {
            return "redirect:/users/dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        try {
            service.registerUser(user);
            return "redirect:/users/login?registered=true";
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed. Username might be taken.");
            return "register";
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "dashboard";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "redirect:/users/dashboard";
    }
}
