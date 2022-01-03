package com.example.esportsbackend.dto.player;

import com.example.esportsbackend.model.Player;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("playerRepresentation")
public class PlayerRepresentation {

    @ApiModelProperty(name = "The id of the player",position = 1,example = "12345")
    @JsonProperty
    public Long playerReferentialNumber; //to be generated in the service

    @ApiModelProperty(position = 2, example = "John")
    @JsonProperty
    public String name;

    @ApiModelProperty(position = 3,example = "Doe")
    @JsonProperty
    public String surname;
    

    public Player toPlayer(PlayerRepresentation request){
        Player player = new Player();
        player.setId(playerReferentialNumber);
        player.setName(name);
        player.setSurname(surname);

        return player;
    }


}
