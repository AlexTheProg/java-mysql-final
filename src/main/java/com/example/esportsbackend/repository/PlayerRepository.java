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

    List<Player> getAllByTeam(String team);

//    @Query(nativeQuery = true, value = "select Player.name, Player.surname, Game.name from Player \n" +
//            "join Game on Player.gid = Game.gid" +
//            " where Game.name = :game")
//    List<Player> getAllByGame(@Param("game") String game);

    @Query("select p.name, p.surname, g.name from Player p join Game g on p.id = g.id where g.name = :game")
    List<Player> getAllByGame(@Param("game") String game);

    @Query("select p from Player p")
    List<Player> getAll();

}
