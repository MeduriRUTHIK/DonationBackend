package com.example.DonationSystem1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DonationSystem1.model.Donation;
@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {

}
