package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("select t from Team t where t.name = :name")
    Team findByName(String name);

    @Query(nativeQuery = true, value = "select t.name, g.name from team t\n" +
            "join games_teams gt on t.tid = gt.tid\n" +
            "join game g on gt.gid = g.gid\n" +
            "where g.name = :game")
    List<Team> findByGame(@Param("game") String game);

}
