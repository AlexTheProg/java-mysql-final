package com.example.esportsbackend.mapper;

import com.example.esportsbackend.dto.player.PlayerDTO;
import com.example.esportsbackend.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface PlayerMapper {

    @Mappings({
            @Mapping(target = "id", source ="entity.id"),
            @Mapping(target = "name", source = "entity.name"),
            @Mapping(target = "surname", source = "entity.surname"),
            @Mapping(target = "dob", source = "entity.dateOfBirth"),
            @Mapping(target = "joined_at", source = "entity.joined_at")
    })
    PlayerDTO playerToPlayerDTO(Player entity);

    @Mappings({
            @Mapping(target = "id", source ="playerDTO.id"),
            @Mapping(target = "name", source = "playerDTO.name"),
            @Mapping(target = "surname", source = "playerDTO.surname"),
            @Mapping(target = "dateOfBirth", source = "playerDTO.dob"),
            @Mapping(target = "joined_at", source = "playerDTO.joined_at")
    })
    Player playerDTOtoPlayer(PlayerDTO playerDTO);


}
