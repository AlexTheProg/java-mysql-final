package com.example.esportsbackend.controller;

import com.example.esportsbackend.dto.player.PlayerWithGame;
import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.service.player.PlayerService;
import com.example.esportsbackend.service.player.PlayerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("")
    public List<Player> getPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/{game}")
    public ResponseEntity<List<PlayerWithGame>> getPlayersByGame(@PathVariable("game") String game){
        return ResponseEntity.ok()
    }
}
