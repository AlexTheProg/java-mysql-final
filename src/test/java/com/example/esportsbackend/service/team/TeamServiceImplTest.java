//package com.example.esportsbackend.service.team;
//
//import com.example.esportsbackend.representation.team.TeamResponseRepresentation;
//import com.example.esportsbackend.mapper.TeamMapper;
//import com.example.esportsbackend.model.Game;
//import com.example.esportsbackend.model.Team;
//import com.example.esportsbackend.repository.GameRepository;
//import com.example.esportsbackend.repository.PlayerRepository;
//import com.example.esportsbackend.repository.TeamRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class TeamServiceImplTest {
//
//    @Mock
//    TeamMapper teamMapper;
//
//    @Mock
//    TeamRepository teamRepository;
//
//    @Mock
//    PlayerRepository playerRepository;
//
//    @Mock
//    GameRepository gameRepository;
//
//
//    @InjectMocks
//    TeamServiceImpl teamService;
//
//    @Test
//    @DisplayName("Get all the teams")
//    void findAllTeams() {
//        //arrange
//        Team team1 = new Team(1L, "Astralis", 5);
//        Team team2 = new Team(2L, "Cloud9", 5);
//        List<Team> teamList = List.of(team1, team2);
//        when(teamRepository.findAll()).thenReturn(teamList);
//
//        //act
//        List<TeamResponseRepresentation> existingTeamList = teamService.findAllTeams();
//
//
//
//
//    }
//
//    @Test
//    void findTeamByName() {
//        //arrange
//        Team team = new Team(1L, "Astralis", 5);
//        when(teamRepository.findByName(team.getName())).thenReturn(Optional.of(team));
//        Team existingTeam = teamRepository.findByName(team.getName()).orElse(null);
//
//        //act
//        Team result = teamService.findTeamByName(team.getName());
//
//        //assert
//        assertEquals(team.name, result.name);
//        assertEquals(team.currentMemberNumber, result.currentMemberNumber);
//        assertEquals(team.id, result.id);
//
//    }
//
//    @Test
//    void findTeamByGame() {
//        //arrange
//        when(teamRepository.findByGamesIn(any())).thenReturn(Optional.empty());
//        when(gameRepository.findGameByName(any())).thenReturn(Optional.empty());
//        Optional<Game> gameList = gameRepository.findGameByName(any());
//        Optional<List<Team>> teamList = teamRepository.findByGamesIn(gameList.stream().toList());
//
//        //act
//
//
//
//    }
//
//    @Test
//    void addATeamToThePool() {
//        //arrange
//        Team team = new Team("Astralis", 5);
//        when(teamRepository.findByName(team.getName())).thenReturn(Optional.empty());
//        Team savedTeam = new Team(1L, "Astralis", 5);
//        when(teamRepository.save(team)).thenReturn(savedTeam);
//
//        //act
//        Team result = teamService.addATeamToThePool(team);
//
//        //assert
//        assertNotNull(result);
//        assertEquals(savedTeam.id, result.id);
//        assertEquals(savedTeam.name, result.name);
//        assertEquals(savedTeam.currentMemberNumber, result.currentMemberNumber);
//
//        verify(teamRepository).findByName(team.getName());
//        verify(teamRepository).save(team);
//    }
//
//    @Test
//    void deleteTeamFromThePool() {
//    }
//
//    @Test
//    void updateTeam() {
//    }
//}