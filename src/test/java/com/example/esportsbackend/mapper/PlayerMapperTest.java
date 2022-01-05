package com.example.esportsbackend.mapper;

import com.example.esportsbackend.dto.player.PlayerDTO;
import com.example.esportsbackend.model.Player;
import com.example.esportsbackend.utils.DateUtils;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;


class PlayerMapperTest {
    private PlayerMapper mapper = Mappers.getMapper(PlayerMapper.class);

    @Test
    public void givenPlayerEntityToDTO_whenMaps_thenCorrect(){
        Player player = new Player();
        player.setId(1L);
        player.setName("John");
        player.setSurname("Doe");
        player.setDateOfBirth("11-11-11");
        player.setJoined_at(DateUtils.parseTimeStamp("11-11-2020 11:11:11"));

        PlayerDTO dto = mapper.playerToPlayerDTO(player);

        assertEquals(player.getId(), dto.getId());
        assertEquals(player.getName(), dto.getName());
        assertEquals(player.getSurname(), dto.getSurname());
        assertEquals(player.getDateOfBirth(), dto.getDob());
        assertEquals(player.getJoined_at(), dto.getJoined_at());

    }

    @Test
    public void givenPlayerDTOtoPlayerEntity_whenMaps_thenCorrect(){
        PlayerDTO dto = new PlayerDTO();
        dto.setId(1L);
        dto.setName("John");
        dto.setSurname("Doe");
        dto.setDob("11-11-11");
        dto.setJoined_at(DateUtils.parseTimeStamp("11-11-2020 11:11:11"));

        Player player = mapper.playerDTOtoPlayer(dto);

        assertEquals(player.getId(), dto.getId());
        assertEquals(player.getName(), dto.getName());
        assertEquals(player.getSurname(), dto.getSurname());
        assertEquals(player.getDateOfBirth(), dto.getDob());
        assertEquals(player.getJoined_at(), dto.getJoined_at());

    }

}