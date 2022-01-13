package com.example.esportsbackend.representation.team;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class TeamUpdateRequestRepresentation extends TeamRequestRepresentation{
    @ApiModelProperty(name = "Team id", position = 3, example = "1")
    @JsonProperty
    public Long id;
}
