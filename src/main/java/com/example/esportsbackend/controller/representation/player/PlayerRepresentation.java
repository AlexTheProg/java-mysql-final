package com.example.esportsbackend.controller.representation.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel
public class PlayerRepresentation {

    @ApiModelProperty(name = "player_reference", position = 1, example = "1")
    @JsonProperty
    public Long id;

    @ApiModelProperty(name = "player_name", position = 2, example = "John")
    @JsonProperty
    public String name;

    @ApiModelProperty(name = "player_surname", position = 3, example = "Doe")
    @JsonProperty
    public String surname;

    @ApiModelProperty(name = "date_of_birth", position = 4, example = "11-11-2000")
    @JsonProperty
    public String dateOfBirth;

    @ApiModelProperty(name = "joined_at", position = 5, example = "11-11-2001")
    @JsonProperty
    public String joined_at;

    @ApiModelProperty(name = "team", position = 6, example = "Astralis")
    @JsonProperty
    public String team_name;

    @ApiModelProperty(name = "game", position = 7, example = "Diablo")
    @JsonProperty
    public String game_name;

}
