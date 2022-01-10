package com.example.esportsbackend.controller.representation.team;

import com.example.esportsbackend.controller.representation.player.PlayerRepresentation;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class TeamResponseRepresentation{

    @ApiModelProperty(name = "id", position = 1, example = "1")
    @JsonProperty
    public Long id;

    @ApiModelProperty(name = "team_name", position = 2, example = "Cloud9")
    @JsonProperty
    public String name;

    @ApiModelProperty(name = "number_of_members", position = 3, example = "14")
    @JsonProperty
    public Integer currentMemberNumber;

    @ApiModelProperty(name = "List of players that belong to the team", position = 4, example = "Ion ion ion")
    @JsonProperty
    public List<PlayerRepresentation> player_list;

    @ApiModelProperty(name = "Games that the team plays", position = 5, example = "Diablo, League Of Legends, Call of Duty")
    @JsonProperty
    public List<String> game_names;

//    @ApiModelProperty(name = "Rival to play in event", position = 6, example = "Fnatic")
//    @JsonProperty
//    public String rivalTeam;

}
