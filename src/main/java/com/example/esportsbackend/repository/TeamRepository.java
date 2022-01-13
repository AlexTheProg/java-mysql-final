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
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByName(String name);
    Team deleteTeamById(Long id);
    Optional<Team> findById(Long id);

    Optional<List<Team>> findByGamesIn(List<Game> gameList);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM games_teams WHERE tid = :teamId")
    void deleteFromGamesTeams(@Param("teamId") Long teamId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE player SET tid = null WHERE tid = :tid")
    void deleteFKFromPlayerTable(@Param("tid") Long tid);


}
