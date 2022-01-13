package com.example.esportsbackend.service.player;

import com.example.esportsbackend.representation.player.PlayerRepresentation;

import java.util.List;

public interface PlayerService {
    List<PlayerRepresentation> findAllPlayers();
    List<PlayerRepresentation> findPlayersByName(String name);
    List<PlayerRepresentation> findPlayersByTeam(String team);
    List<PlayerRepresentation> findPlayersByGame(String game);
    PlayerRepresentation addPlayer(PlayerRepresentation playerRepresentation);
    PlayerRepresentation removePlayer(Long id);
    PlayerRepresentation updatePlayer(PlayerRepresentation playerRepresentation);
}
