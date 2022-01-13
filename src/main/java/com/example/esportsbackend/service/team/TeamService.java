package com.example.esportsbackend.service.team;

import com.example.esportsbackend.controller.representation.team.TeamRequestRepresentation;
import com.example.esportsbackend.controller.representation.team.TeamResponseRepresentation;
import com.example.esportsbackend.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    List<TeamResponseRepresentation> findAllTeams();
    Team findTeamByName(String name);
    List<Team> findTeamByGame(String game);
    Team addATeamToThePool(Team Team);
    //TeamResponseRepresentation addGameToTeam(GameRequestRepresentation gameRequestRepresentation);
    Team deleteTeamFromThePool(Long id);
    Team updateTeam(Team team);

}
