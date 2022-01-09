package com.example.esportsbackend.controller;

import com.example.esportsbackend.controller.representation.player.PlayerRepresentation;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.service.player.PlayerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {
    private PlayerService playerService;

    PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @ApiOperation(
            value = "Get a list of all registered players",
            nickname = "get_player_list"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully retrieve the player list"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/players")
    public ResponseEntity<List<PlayerRepresentation>> getAllPlayers(){
        return ResponseEntity.ok(playerService.findAllPlayers());
    }

    @PostMapping("/players")
    public ResponseEntity<Player> addPlayer(@RequestBody PlayerRepresentation playerRepresentation){
        return ResponseEntity.ok(playerService.addPlayer(playerRepresentation));
    }
}
