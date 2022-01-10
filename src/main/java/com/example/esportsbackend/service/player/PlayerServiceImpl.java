package com.example.esportsbackend.service.player;

import com.example.esportsbackend.controller.representation.player.PlayerRepresentation;

import com.example.esportsbackend.handlers.TeamGameException;
import com.example.esportsbackend.mapper.PlayerMapper2;
import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.model.Team;
import com.example.esportsbackend.repository.GameRepository;
import com.example.esportsbackend.repository.PlayerRepository;
import com.example.esportsbackend.repository.TeamRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService{
    PlayerRepository playerRepository;
    TeamRepository teamRepository;
    GameRepository gameRepository;
    PlayerMapper2 mapper;

    PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository, GameRepository gameRepository){
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.gameRepository = gameRepository;
        this.mapper = new PlayerMapper2(teamRepository, gameRepository);
    }


    @Override
    public List<PlayerRepresentation> findAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(mapper::mapToPlayerRepresentation)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlayerRepresentation> findPlayersByName(String name) {
        return playerRepository.findPlayersByName(name)
                .stream()
                .map(mapper::mapToPlayerRepresentation)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlayerRepresentation> findPlayersByTeam(String team) {
        Team teamObj = teamRepository.findByName(team);

        return playerRepository.findPlayersByTeam(teamObj)
                .stream()
                .map(mapper::mapToPlayerRepresentation)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlayerRepresentation> findPlayersByGame(String game) {
        Game gameObj = gameRepository.findGameByName(game);

        return playerRepository.findPlayersByGame(gameObj)
                .stream()
                .map(mapper::mapToPlayerRepresentation)
                .collect(Collectors.toList());
    }

    @Override
    public Player addPlayer(PlayerRepresentation playerRepresentation) {
        Team team = teamRepository.findByName(playerRepresentation.team_name);
        Game game = gameRepository.findGameByName(playerRepresentation.game_name);
        Player player = mapper.mapToPlayer(playerRepresentation);
        Map<Long, Long> games_teams = playerRepository.selectFromGames_Teams(team.id, game.id);

        if(!games_teams.isEmpty()) {
            team.currentMemberNumber++;
           return playerRepository.save(player);
        }else{
            throw new TeamGameException("The team doesnt play the game");
        }

    }

    @Override
    @Transactional
    public Player removePlayer(Long id) {
        Player player = playerRepository.findPlayerById(id);
        playerRepository.deletePlayerById(id);
        return player;
    }

    @Override
    public Player updatePlayer(PlayerRepresentation playerRepresentation) {
        Player oldPlayer = playerRepository.findPlayerById(playerRepresentation.id);
        PlayerRepresentation oldPlayerRepresentation = mapper.mapToPlayerRepresentation(oldPlayer);

        oldPlayerRepresentation.name = playerRepresentation.name;
        oldPlayerRepresentation.surname = playerRepresentation.surname;
        oldPlayerRepresentation.dateOfBirth = playerRepresentation.dateOfBirth;
        oldPlayerRepresentation.team_name = playerRepresentation.team_name;
        oldPlayerRepresentation.game_name = playerRepresentation.game_name;

        return addPlayer(oldPlayerRepresentation);
    }
}