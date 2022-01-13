package com.example.esportsbackend.mapper;

import com.example.esportsbackend.controller.representation.player.PlayerRepresentation;
import com.example.esportsbackend.model.Game;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.model.Team;
import com.example.esportsbackend.repository.GameRepository;
import com.example.esportsbackend.repository.TeamRepository;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class PlayerMapper2 {
    private TeamRepository teamRepository;
    private GameRepository gameRepository;

    public PlayerMapper2(TeamRepository teamRepository, GameRepository gameRepository){
        this.teamRepository = teamRepository;
        this.gameRepository = gameRepository;
    }


    public PlayerRepresentation mapToPlayerRepresentation(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerRepresentation playerRepresentation = new PlayerRepresentation();

        playerRepresentation.team_name = playerTeamName( player );
        playerRepresentation.game_name = playerGameName( player );
        playerRepresentation.id = player.getId();
        playerRepresentation.name = player.getName();
        playerRepresentation.surname = player.getSurname();
        playerRepresentation.dateOfBirth = player.getDateOfBirth();
        if ( player.joined_at != null ) {
            playerRepresentation.joined_at = new SimpleDateFormat().format( player.joined_at );
        }

        return playerRepresentation;
    }


    public Player mapToPlayer(PlayerRepresentation playerRepresentation) {
        if ( playerRepresentation == null ) {
            return null;
        }

        Player player = new Player();

        player.setTeam( playerRepresentationToTeam( playerRepresentation ) );
        player.setGame( playerRepresentationToGame( playerRepresentation ) );
        player.setId( playerRepresentation.id );
        player.setName( playerRepresentation.name );
        player.setSurname( playerRepresentation.surname );
        player.setDateOfBirth( playerRepresentation.dateOfBirth );
        try {
            if ( playerRepresentation.joined_at != null ) {
                player.joined_at = new SimpleDateFormat().parse( playerRepresentation.joined_at );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }

        return player;
    }

    private String playerTeamName(Player player) {
        if ( player == null ) {
            return null;
        }
        Team team = player.getTeam();
        if ( team == null ) {
            return null;
        }
        return team.getName();
    }

    private String playerGameName(Player player) {
        if ( player == null ) {
            return null;
        }
        Game game = player.getGame();
        if ( game == null ) {
            return null;
        }
        return game.getName();
    }

    protected Team playerRepresentationToTeam(PlayerRepresentation playerRepresentation) {
        if ( playerRepresentation == null ) {
            return null;
        }

        return teamRepository.findByName(playerRepresentation.team_name).orElse(null);
    }

    protected Game playerRepresentationToGame(PlayerRepresentation playerRepresentation) {
        if ( playerRepresentation == null ) {
            return null;
        }

        return gameRepository.findGameByName(playerRepresentation.game_name).orElse(null);
    }
}
