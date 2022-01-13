package com.example.esportsbackend.controller.representation.team;

import com.example.esportsbackend.controller.representation.player.PlayerRepresentation;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class TeamRequestRepresentation {

    @ApiModelProperty(name = "team_name", position = 1, example = "Cloud9")
    @JsonProperty
    public String name;

    @ApiModelProperty(name = "Number of team members", position = 2, example = "4")
    @JsonProperty
    public Integer teamMemberNumber;

}
