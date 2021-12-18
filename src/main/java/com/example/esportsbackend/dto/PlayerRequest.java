package com.example.esportsbackend.dto;

import com.example.esportsbackend.model.Player;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PlayerRequest {

    @ApiModelProperty(position = 1,example = "12345")
    public Long playerReferentialNumber; //to be generated in the service

    @ApiModelProperty(position = 2, example = "John")
    public String name;

    @ApiModelProperty(position = 3,example = "Doe")
    public String surname;
    

    public Player toPlayer(PlayerRequest request){
        Player player = new Player();
        player.setId(playerReferentialNumber);
        player.setName(name);
        player.setSurname(surname);

        return player;
    }

}
