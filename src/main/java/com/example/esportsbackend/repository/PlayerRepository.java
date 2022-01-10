package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findPlayerById(Long id);
    List<Player> findPlayersByName(String name);
    List<Player> findPlayersByTeam(Team team);
    List<Player> findPlayersByGame(Game game);

    @Query(value = "delete from Player p where p.id = :id")
    @Modifying
    void deletePlayerById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO games_teams(gid, tid) VALUES (:gid, :tid)")
    void inserIntoGames_Teams(@Param("tid") Long tid, @Param("gid") Long gid);

    @Query(nativeQuery = true, value = "SELECT gid, tid FROM games_teams WHERE tid = :tid AND gid = :gid")
    Map<Long, Long> selectFromGames_Teams(@Param("tid") Long tid, @Param("gid") Long gid);

}
