package com.example.esportsbackend.controller;

import com.example.esportsbackend.controller.representation.player.PlayerRepresentation;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.service.player.PlayerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("players")
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
    @GetMapping()
    public ResponseEntity<List<PlayerRepresentation>> getAllPlayers(){
        return ResponseEntity.ok(playerService.findAllPlayers());
    }

    @ApiOperation(
            value = "Add a player to a team and assign a game",
            nickname = "add_player"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully added a player"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping()
    public ResponseEntity<Player> addPlayer(@RequestBody PlayerRepresentation playerRepresentation){
        return ResponseEntity.ok(playerService.addPlayer(playerRepresentation));
    }

    @ApiOperation(
            value = "Get the list of players that have the same name",
            nickname = "add_player"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully retrieved a player"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/{name}")
    public ResponseEntity<List<PlayerRepresentation>> getPlayersByName(@PathVariable("name") String name){
        return ResponseEntity.ok(playerService.findPlayersByName(name));
    }

    @ApiOperation(
            value = "Get the list of players that play the same game",
            nickname = "add_player"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully retrieved a player"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/game/{game}")
    public ResponseEntity<List<PlayerRepresentation>> getPlayersByGame(@PathVariable("game") String game){
        return ResponseEntity.ok(playerService.findPlayersByGame(game));
    }

    @ApiOperation(
            value = "Get the list of players that play the same game",
            nickname = "add_player"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully retrieved a player"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/team/{team}")
    public ResponseEntity<List<PlayerRepresentation>> getPlayersByTeams(@PathVariable("team") String team){
        return ResponseEntity.ok(playerService.findPlayersByTeam(team));
    }

    @ApiOperation(
            value = "Delete a player from the pool",
            nickname = "delete_player"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully deleted a player"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PutMapping()
    public ResponseEntity<Player> updatePlayer(@RequestBody PlayerRepresentation playerRepresentation){
        return ResponseEntity.ok(playerService.updatePlayer(playerRepresentation));
    }

    @ApiOperation(
            value = "Delete a player from the pool",
            nickname = "delete_player"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully deleted a player"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Player> deletePlayer(@PathVariable("id") Long id){
        return ResponseEntity.ok(playerService.removePlayer(id));
    }

}
