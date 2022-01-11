package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("select t from Team t where t.name = :name")
    Team findByName(String name);
    Team deleteTeamById(Long id);

    List<Team> findByGamesIn(List<Game> gameList);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM games_teams WHERE tid = :teamId")
    void deleteFromGamesTeams(@Param("teamId") Long teamId);


}
