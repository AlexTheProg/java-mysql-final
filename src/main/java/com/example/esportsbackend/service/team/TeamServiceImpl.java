package com.example.esportsbackend.service.team;

import com.example.esportsbackend.controller.representation.team.TeamRequestRepresentation;
import com.example.esportsbackend.controller.representation.team.TeamResponseRepresentation;
import com.example.esportsbackend.mapper.TeamMapper;
import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Team;
import com.example.esportsbackend.repository.GameRepository;
import com.example.esportsbackend.repository.PlayerRepository;
import com.example.esportsbackend.repository.TeamRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

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
        List<Game> gameList = new ArrayList<>();
        gameList.add(gameRepository.findGameByName(game));

        List<TeamResponseRepresentation> teamList = teamRepository.findByGamesIn(gameList)
                .stream()
                .map(teamMapper::mapToTeamResponseRepresentation)
                .collect(Collectors.toList());

        if(!teamList.isEmpty()){
            gameList.clear();
        }

        return teamList;
    }

    @Override
    public Team addATeamToThePool(TeamRequestRepresentation team) {
        if(team.teamMemberNumber == null){
            team.teamMemberNumber = 0;
        }
        return teamRepository.save(teamMapper.mapToTeam(team));
    }

    @Override
    @Transactional
    public TeamResponseRepresentation deleteTeamFromThePool(Long id) {
       Team team = teamRepository.findById(id).orElse(null);
       teamRepository.deleteFromGamesTeams(team.id);
       teamRepository.delete(team);
       return teamMapper.mapToTeamResponseRepresentation(team);
    }

    @Override
    public Team updateTeam(TeamRequestRepresentation request) {
        Team oldTeam = teamRepository.findById(request.id).orElse(null);

        oldTeam.id = request.id;
        oldTeam.name = request.name;
        oldTeam.currentMemberNumber = request.teamMemberNumber;

        return teamRepository.save(oldTeam);
    }
}
