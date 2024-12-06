package com.example.DonationSystem1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.DonationSystem1.model.User;
import com.example.DonationSystem1.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")  // CORS configuration for React frontend
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // User Registration API
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return "User registered successfully";
    }

    // User Login API
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        User loggedInUser = userService.loginUser(user.getEmail(), user.getPassword());
        return "Welcome, " + loggedInUser.getUsername();
    }
}
