package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findGameByName(String name);
    List<Game> findGamesByTeamsIn(Set<Team> teams);

    @Query(nativeQuery = true, value = "select g.name as name from game g inner join games_teams gt on gt.gid = g.gid" +
            " inner join team t on gt.tid = t.tid " +
            " where t.name = :name")
    List<Game> findGamesUsingTeam(@Param("name") String name);
}
