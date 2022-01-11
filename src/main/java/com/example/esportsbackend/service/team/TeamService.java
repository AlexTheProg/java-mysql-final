package com.example.esportsbackend.service.team;

import com.example.esportsbackend.controller.representation.team.TeamRequestRepresentation;
import com.example.esportsbackend.controller.representation.team.TeamResponseRepresentation;
import com.example.esportsbackend.model.Team;

import java.util.List;

public interface TeamService {
    List<TeamResponseRepresentation> findAllTeams();
    TeamResponseRepresentation findTeamByName(String name);
    List<TeamResponseRepresentation> findTeamsByGame(String game);
    Team addATeamToThePool(TeamRequestRepresentation teamRequestRepresentation);
    //TeamResponseRepresentation addGameToTeam(GameRequestRepresentation gameRequestRepresentation);
    TeamResponseRepresentation deleteTeamFromThePool(Long id);
    Team updateTeam(TeamRequestRepresentation request);

}
