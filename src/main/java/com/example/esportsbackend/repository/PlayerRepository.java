package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {


    @Query("select p from Player p")
    List<Player> getAll();

}
