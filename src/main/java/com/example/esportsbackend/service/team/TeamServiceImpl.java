package com.example.esportsbackend.service.team;

import com.example.esportsbackend.representation.team.TeamResponseRepresentation;
import com.example.esportsbackend.handlers.exceptions.TeamAlreadyExistsException;
import com.example.esportsbackend.handlers.exceptions.TeamNotFoundException;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    TeamServiceImpl(PlayerRepository playerRepository, GameRepository gameRepository, TeamRepository teamRepository, TeamMapper teamMapper){
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public List<TeamResponseRepresentation> findAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(teamMapper::mapToTeamResponseRepresentation)
                .collect(Collectors.toList());
    }

    @Override
    public Team findTeamByName(String name) {
        return teamRepository.findByName(name)
                .orElseThrow(TeamNotFoundException::new);
    }

    @Override
    public List<Team> findTeamByGame(String game) {
        List<Game> gameList = new ArrayList<>();
        gameList.add(gameRepository.findGameByName(game).orElse(null));
        Optional<List<Team>> team = Optional.ofNullable(teamRepository.findByGamesIn(gameList)
                .orElseThrow(TeamNotFoundException::new));
        return team.orElseThrow(TeamNotFoundException::new);
    }

    @Override
    public Team addATeamToThePool(Team team) {
        Optional<Team> existingTeam = teamRepository.findByName(team.getName());

        if(existingTeam.isPresent()){
            throw new TeamAlreadyExistsException();
        }

       return teamRepository.save(team);
    }

    @Override
    @Transactional
    public Team deleteTeamFromThePool(Long id) {
       Team team = teamRepository.findById(id)
               .orElseThrow(TeamNotFoundException::new);

       teamRepository.deleteFKFromPlayerTable(id);
       teamRepository.deleteFromGamesTeams(team.id);

       teamRepository.delete(team);
       return team;
    }

    @Override
    public Team updateTeam(Team team) {
    Team existingTeam = teamRepository.findById(team.getId())
            .orElseThrow(TeamNotFoundException::new);

    if(!team.getName().equals(existingTeam.getName())){
        checkUniqueTeamName(team);
    }

    return teamRepository.save(team);
    }

    private void checkUniqueTeamName(Team team){
        Optional<Team> existingTeam = teamRepository.findByName(team.getName());
        if(existingTeam.isPresent()){
            throw new TeamAlreadyExistsException();
        }
    }
}
