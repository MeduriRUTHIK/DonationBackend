package com.example.DonationSystem1.service;

import com.example.DonationSystem1.model.User;

public interface UserService {
    User registerUser(User user);  // Save user
    User loginUser(String email, String password);  // Validate login credentials
}
