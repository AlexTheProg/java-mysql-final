package com.example.esportsbackend.service.player;

import com.example.esportsbackend.dto.player.PlayerRepresentation;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.repository.PlayerRepository;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Player> addAPlayer(PlayerRepresentation playerRequest) {
        playerRepo.save(playerRequest.toPlayer(playerRequest));

        return null;
    }

    @Override
    public ResponseEntity<Player> updateAPlayer(PlayerRepresentation playerRequest) {
        return null;
    }


    @Override
    public Player addPlayerToTeam() {
        return null;
    }
}
