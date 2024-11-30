package com.example.DonationSystem1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DonationSystem1.model.Donation;
import com.example.DonationSystem1.service.DonationService;


@RestController
@RequestMapping("/donation")
public class DonationController {
	@Autowired
	private DonationService donationService;
	
	   @PostMapping("/add")
	    public String add(@RequestBody Donation donation){
	        donationService.saveDonation(donation);
	        return "New Donation is added";
	    }
	   @GetMapping("/getAll")
	    public List<Donation> list(){
	        return donationService.getAllDonations();
	    }
}
