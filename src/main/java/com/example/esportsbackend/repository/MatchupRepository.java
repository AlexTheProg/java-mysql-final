package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Matchup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchupRepository extends JpaRepository<Long, Matchup> {
}
