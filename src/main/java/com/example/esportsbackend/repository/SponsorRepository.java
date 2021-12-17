package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepository extends JpaRepository<Long, Sponsor> {
}
