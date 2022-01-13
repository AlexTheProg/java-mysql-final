package com.example.esportsbackend.mapper;

import com.example.esportsbackend.controller.representation.player.PlayerRepresentation;
import com.example.esportsbackend.controller.representation.team.TeamRequestRepresentation;
import com.example.esportsbackend.controller.representation.team.TeamResponseRepresentation;
import com.example.esportsbackend.controller.representation.team.TeamUpdateRequestRepresentation;
import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Matchup;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.model.Team;
import com.example.esportsbackend.repository.GameRepository;
import com.example.esportsbackend.repository.PlayerRepository;
import com.example.esportsbackend.repository.TeamRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TeamMapper {
    private final TeamRepository teamRepository;
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final PlayerMapper2 playerMapper;

    public TeamMapper(TeamRepository teamRepository, GameRepository gameRepository, PlayerRepository playerRepository, PlayerMapper2 mapper){
        this.teamRepository = teamRepository;
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.playerMapper = mapper;
    }

    public TeamResponseRepresentation mapToTeamResponseRepresentation(Team team){
        if (team == null){
            return null;
        }

        TeamResponseRepresentation teamResponseRepresentation = new TeamResponseRepresentation();

        teamResponseRepresentation.id = team.getId();
        teamResponseRepresentation.name = team.getName();
        teamResponseRepresentation.currentMemberNumber = team.getCurrentMemberNumber();

        //get the player list

        teamResponseRepresentation.player_list = (HashSet<PlayerRepresentation>) playerRepository.findPlayersByTeam(team)
                .stream()
                .map(playerMapper::mapToPlayerRepresentation)
                .collect(Collectors.toSet());

        Set<Team> teamSet = new HashSet<>();
        teamSet.add(team);

        teamResponseRepresentation.game_names = (HashSet<String>) gameRepository.findGamesByTeamsIn(teamSet)
                .stream()
                .map(Game::getName)
                .collect(Collectors.toSet());
        teamSet.remove(team);

        return teamResponseRepresentation;
    }

    public Team mapToTeam(TeamRequestRepresentation teamRequestRepresentation){
        if(teamRequestRepresentation == null){
            return null;
        }


        Team team = new Team();

       team.name = teamRequestRepresentation.name;
       team.currentMemberNumber = teamRequestRepresentation.teamMemberNumber;


        return team;
    }

    public Team mapToTeamFromTeamUpdateRequest(TeamUpdateRequestRepresentation request){
        Team team = new Team();

        team.name = request.name;
        team.currentMemberNumber = request.teamMemberNumber;
        team.id = request.id;

        return team;
    }

}
