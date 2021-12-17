package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Long, Player> {
}
