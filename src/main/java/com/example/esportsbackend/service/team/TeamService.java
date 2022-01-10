package com.example.esportsbackend.service.team;

import com.example.esportsbackend.controller.representation.team.TeamRequestRepresentation;
import com.example.esportsbackend.controller.representation.team.TeamResponseRepresentation;
import com.example.esportsbackend.model.Team;

import java.util.List;

public interface TeamService {
    List<TeamResponseRepresentation> findAllTeams();
    TeamResponseRepresentation findTeamByName(String name);
    List<TeamResponseRepresentation> findTeamsByGame(String game);
    TeamResponseRepresentation addATeamToThePool(Team team);
    Team deleteTeamFromThePool(Team team);
    Team updateTeam(TeamRequestRepresentation request);

}
