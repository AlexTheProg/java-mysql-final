package com.example.esportsbackend.dto.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class PlayerWithGame extends PlayerRepresentation{
    @ApiModelProperty(name = "The game that the player plays at a pro level", position = 1, example = "Diablo")
    @JsonProperty
    public String game;
}
