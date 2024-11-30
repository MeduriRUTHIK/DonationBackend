package com.example.DonationSystem1.service;

import java.util.List;

import com.example.DonationSystem1.model.Donation;

public interface DonationService {
 public Donation saveDonation(Donation donation);
 public List<Donation> getAllDonations();
}
