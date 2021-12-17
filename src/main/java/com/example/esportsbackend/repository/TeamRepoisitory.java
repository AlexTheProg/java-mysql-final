package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepoisitory extends JpaRepository<Long, Team> {
}
