package com.example.esportsbackend.controller;

import com.example.esportsbackend.controller.representation.team.TeamRequestRepresentation;
import com.example.esportsbackend.controller.representation.team.TeamResponseRepresentation;
import com.example.esportsbackend.controller.representation.team.TeamUpdateRequestRepresentation;
import com.example.esportsbackend.handlers.exceptions.InvalidUpdateRequestException;
import com.example.esportsbackend.mapper.TeamMapper;
import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Team;
import com.example.esportsbackend.service.team.TeamService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    TeamController(TeamService teamService, TeamMapper teamMapper){
        this.teamService = teamService;
        this.teamMapper = teamMapper;
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
       Team team = teamService.findTeamByName(name);
       TeamResponseRepresentation response = teamMapper.mapToTeamResponseRepresentation(team);
       return ResponseEntity.ok(response);
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
    @GetMapping("/teamsAndGames/{gameName}")
    public ResponseEntity<List<TeamResponseRepresentation>> getTeamByGame(@PathVariable("gameName") String name){
        List<Team> team = teamService.findTeamByGame(name);
        return ResponseEntity.ok(team
                .stream()
                .map(teamMapper::mapToTeamResponseRepresentation)
                .collect(Collectors.toList()));
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
    public ResponseEntity<TeamResponseRepresentation> addTeamToPool(@RequestBody TeamRequestRepresentation teamRequestRepresentation){
        Team team = teamMapper.mapToTeam(teamRequestRepresentation);
        teamService.addATeamToThePool(team);
        TeamResponseRepresentation teamResponse = teamMapper.mapToTeamResponseRepresentation(team);
        return ResponseEntity.ok(teamResponse);
    }

    @ApiOperation(
            value = "Delete team from the pool",
            nickname = "delete_team_from_pool"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully deleted a team from the pool"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Team> deleteTeamFromPool(@PathVariable("id") Long id){
        return ResponseEntity.ok(teamService.deleteTeamFromThePool(id));
    }

    @ApiOperation(
            value = "Update a team from the pool",
            nickname = "update_a_team_from_the_pool"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully updated a team from the pool"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Team> updateATeam(@PathVariable("id")Long id, @RequestBody TeamUpdateRequestRepresentation request){
        if(id != request.id){
            throw new InvalidUpdateRequestException();
        }
        return ResponseEntity.ok(teamService.updateTeam(teamMapper.mapToTeamFromTeamUpdateRequest(request)));
    }




}
