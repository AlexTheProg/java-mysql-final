package com.example.esportsbackend.service.player;

import com.example.esportsbackend.controller.representation.player.PlayerRepresentation;
import com.example.esportsbackend.model.Player;

import java.util.List;

public interface PlayerService {
    List<PlayerRepresentation> findAllPlayers();
    List<PlayerRepresentation> findPlayersByName(String name);
    List<PlayerRepresentation> findPlayersByTeam(String team);
    List<PlayerRepresentation> findPlayersByGame(String game);
    Player addPlayer(PlayerRepresentation playerRepresentation);
    Player removePlayer(Long id);
    Player updatePlayer(PlayerRepresentation playerRepresentation);
}
