package com.example.DonationSystem1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DonationSystem1.model.Donation;
import com.example.DonationSystem1.repository.DonationRepository;
@Service
public class DonationServiceImpl implements DonationService {
@Autowired
private DonationRepository donationRepository;
	@Override
	public Donation saveDonation(Donation donation) {
		// TODO Auto-generated method stub
		return donationRepository.save(donation);
	}
	@Override
	public List<Donation> getAllDonations() {
		// TODO Auto-generated method stub
		return donationRepository.findAll();
	}

}
