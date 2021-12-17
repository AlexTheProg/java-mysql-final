package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Long, Game> {
}
