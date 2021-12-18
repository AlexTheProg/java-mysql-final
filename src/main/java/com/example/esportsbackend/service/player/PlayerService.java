package com.example.esportsbackend.service.player;

import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.model.Team;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PlayerService {
    List<Player> getAllPlayers();
    List<Player> getAllPlayersByGame(String game);
    List<Player> getAllPlayersByTeam(String team);
    Player addPlayerToTeam(); //this will also add a game to the newly added player
    //a new player comes in, if he has a game, the game must match the game of the team
    //if the player doesnt have a game, then he is considered a trainee and will be given
    //to the team that he applied to(?TODO: maybe add an application feature that players can do)
    //for now the played get the game if the team that he is added to if he doesnt have one
    //if the game he has doesnt match, throw exception - GameMismatchException()

}
