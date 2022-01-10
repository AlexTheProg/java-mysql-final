package com.example.esportsbackend.service.team;

import com.example.esportsbackend.controller.representation.team.TeamRequestRepresentation;
import com.example.esportsbackend.controller.representation.team.TeamResponseRepresentation;
import com.example.esportsbackend.mapper.TeamMapper;
import com.example.esportsbackend.model.Team;
import com.example.esportsbackend.repository.GameRepository;
import com.example.esportsbackend.repository.PlayerRepository;
import com.example.esportsbackend.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    private PlayerRepository playerRepository;
    private GameRepository gameRepository;
    private TeamRepository teamRepository;
    private TeamMapper teamMapper;

    TeamServiceImpl(PlayerRepository playerRepository, GameRepository gameRepository, TeamRepository teamRepository){
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
        this.teamMapper = new TeamMapper(teamRepository, gameRepository, playerRepository);
    }

    @Override
    public List<TeamResponseRepresentation> findAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(teamMapper::mapToTeamResponseRepresentation)
                .collect(Collectors.toList());
    }

    @Override
    public TeamResponseRepresentation findTeamByName(String name) {
        return teamMapper.mapToTeamResponseRepresentation(teamRepository.findByName(name));
    }

    @Override
    public List<TeamResponseRepresentation> findTeamsByGame(String game) {
        return teamRepository.findByGame(game)
                .stream()
                .map(teamMapper::mapToTeamResponseRepresentation)
                .collect(Collectors.toList());
    }

    @Override
    public TeamResponseRepresentation addATeamToThePool(Team team) {
        return null;
    }

    @Override
    public Team deleteTeamFromThePool(Team team) {
        return null;
    }

    @Override
    public Team updateTeam(TeamRequestRepresentation request) {
        return null;
    }
}
