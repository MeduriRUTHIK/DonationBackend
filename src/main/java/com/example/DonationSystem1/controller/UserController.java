package com.example.DonationSystem1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.DonationSystem1.model.User;
import com.example.DonationSystem1.repository.UserRepository;
import com.example.DonationSystem1.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")  // CORS configuration for React frontend
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository; // Injecting UserRepository

    // User Registration API
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return "User registered successfully";
    }

    // User Login API
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        Optional<User> userData = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()); // Using the injected repository
        if (userData.isPresent()) {
            User loggedInUser = userData.get();
            if ("admin".equalsIgnoreCase(loggedInUser.getUsername()) || "admin@protected.com".equalsIgnoreCase(loggedInUser.getEmail())) {
                return ResponseEntity.ok("Admin Login Successful");
            } else {
                return ResponseEntity.ok("User Login Successful");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }
}
