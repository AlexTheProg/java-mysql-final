package com.example.esportsbackend.controller;

import com.example.esportsbackend.controller.representation.team.TeamResponseRepresentation;
import com.example.esportsbackend.service.team.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("teams")
public class TeamController {
    private final TeamService teamService;

    TeamController(TeamService teamService){
        this.teamService = teamService;
    }


    @GetMapping()
    public ResponseEntity<List<TeamResponseRepresentation>> getAllTeams(){
        return ResponseEntity.ok(teamService.findAllTeams());
    }
}
