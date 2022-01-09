package com.example.esportsbackend.service.player;

import com.example.esportsbackend.controller.representation.player.PlayerRepresentation;

import com.example.esportsbackend.mapper.PlayerMapper2;
import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.model.Team;
import com.example.esportsbackend.repository.GameRepository;
import com.example.esportsbackend.repository.PlayerRepository;
import com.example.esportsbackend.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return playerRepository.save(mapper.mapToPlayer(playerRepresentation));
    }

    @Override
    public Player removePlayer(Long id) {
        return null;
    }

    @Override
    public Player updatePlayer(PlayerRepresentation playerRepresentation) {
        return null;
    }
}
