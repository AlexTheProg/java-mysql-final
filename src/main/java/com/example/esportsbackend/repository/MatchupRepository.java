package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Matchup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchupRepository extends JpaRepository<Matchup, Long> {
}
