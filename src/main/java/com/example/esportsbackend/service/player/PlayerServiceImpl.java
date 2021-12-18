package com.example.esportsbackend.service.player;

import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.model.Team;
import com.example.esportsbackend.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    PlayerRepository playerRepo;

    public PlayerServiceImpl(PlayerRepository playerRepo) {
        this.playerRepo = playerRepo;
    }


    @Override
    public List<Player> getAllPlayers() {
        return playerRepo.getAll();
    }


    @Override
    public List<Player> getAllPlayersByGame(String game) {
        return playerRepo.getAllByGame(game);
    }

    @Override
    public List<Player> getAllPlayersByTeam(String team) {
        return playerRepo.getAllByTeam(team);
    }

    @Override
    public Player addPlayerToTeam() {
        return null;
    }
}
