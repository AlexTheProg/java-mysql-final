package com.example.esportsbackend.mapper;

import com.example.esportsbackend.controller.representation.player.PlayerRepresentation;
import com.example.esportsbackend.controller.representation.team.TeamResponseRepresentation;
import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.model.Team;
import com.example.esportsbackend.repository.GameRepository;
import com.example.esportsbackend.repository.PlayerRepository;
import com.example.esportsbackend.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeamMapper {
    private final TeamRepository teamRepository;
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final PlayerMapper2 playerMapper;

    public TeamMapper(TeamRepository teamRepository, GameRepository gameRepository, PlayerRepository playerRepository){
        this.teamRepository = teamRepository;
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.playerMapper = new PlayerMapper2(teamRepository, gameRepository);
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

        teamResponseRepresentation.player_list = playerRepository.findPlayersByTeam(team)
                .stream()
                .map(playerMapper::mapToPlayerRepresentation)
                .collect(Collectors.toList());

        List<Team> teamList = new ArrayList<>();
        teamList.add(team);

        teamResponseRepresentation.game_names = gameRepository.findGamesByTeamsIn(teamList)
                .stream()
                .map(Game::getName)
                .collect(Collectors.toList());
        teamList.remove(team);

        return teamResponseRepresentation;
    }

    public Team mapToTeam(TeamResponseRepresentation teamResponseRepresentation){
        if(teamResponseRepresentation == null){
            return null;
        }

        Team team = new Team();

        team.setName(teamResponseRepresentation.name);
        team.setCurrentMemberNumber(teamResponseRepresentation.currentMemberNumber);
        team.setId(teamResponseRepresentation.id);

        return team;
    }
}
