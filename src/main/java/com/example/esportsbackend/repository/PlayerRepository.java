package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> getAllByTeam(String team);

    @Query(nativeQuery = true, value = "select p.name, p.surname, g.name from player p\n" +
            "join game g on p.gid = g.gid")
    List<Player> getAllByGame(String game);

    @Query("select p from Player p")
    List<Player> getAll();

}
