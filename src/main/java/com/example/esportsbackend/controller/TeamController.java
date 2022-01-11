package com.example.esportsbackend.controller;

import com.example.esportsbackend.controller.representation.team.TeamRequestRepresentation;
import com.example.esportsbackend.controller.representation.team.TeamResponseRepresentation;
import com.example.esportsbackend.model.Team;
import com.example.esportsbackend.service.team.TeamService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    TeamController(TeamService teamService){
        this.teamService = teamService;
    }


    @ApiOperation(
            value = "Get list of teams in the pool",
            nickname = "get_all_teams"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully retrieved a list of all the teams in the pool"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping()
    public ResponseEntity<List<TeamResponseRepresentation>> getAllTeams(){
        return ResponseEntity.ok(teamService.findAllTeams());
    }

    @ApiOperation(
            value = "Get team by team name",
            nickname = "get_team_by_name"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully retrieved a team by its name"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/{teamName}")
    public ResponseEntity<TeamResponseRepresentation> getTeamByName(@PathVariable("teamName") String name){
        return ResponseEntity.ok(teamService.findTeamByName(name));
    }

    @ApiOperation(
            value = "Get team by team name",
            nickname = "get_team_by_name"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully retrieved a team by its name"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/games/{gameName}")
    public ResponseEntity<List<TeamResponseRepresentation>> getTeamByGame(@PathVariable("gameName") String name){
        return ResponseEntity.ok(teamService.findTeamsByGame(name));
    }

    @ApiOperation(
            value = "Add a team to the pool",
            nickname = "add_team_to_pool"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully added a team to the pool"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping()
    public ResponseEntity<Team> addTeamToPool(@RequestBody TeamRequestRepresentation teamRequestRepresentation){
        return ResponseEntity.ok(teamService.addATeamToThePool(teamRequestRepresentation));
    }

    @ApiOperation(
            value = "Add a team to the pool",
            nickname = "add_team_to_pool"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully added a team to the pool"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @DeleteMapping()
    public ResponseEntity<TeamResponseRepresentation> deleteTeamFromPool(@RequestParam Long id){
        return ResponseEntity.ok(teamService.deleteTeamFromThePool(id));
    }


}
