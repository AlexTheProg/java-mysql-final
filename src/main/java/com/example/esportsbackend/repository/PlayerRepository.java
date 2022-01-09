package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findPlayerById(Long id);
    List<Player> findPlayersByName(String name);
    List<Player> findPlayersByTeam(Team team);
    List<Player> findPlayersByGame(Game game);
    Player removePlayerById(Long id);
}
