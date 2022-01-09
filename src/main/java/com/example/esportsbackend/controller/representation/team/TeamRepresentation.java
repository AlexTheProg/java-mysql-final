package com.example.esportsbackend.controller.representation.team;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class TeamRepresentation {

    @ApiModelProperty(name = "id", position = 1, example = "1")
    @JsonProperty
    public Long id;

    @ApiModelProperty(name = "team_name", position = 2, example = "Cloud9")
    @JsonProperty
    public String name;

    @ApiModelProperty(name = "number_of_members", position = 3, example = "14")
    @JsonProperty
    public Integer currentMemeberNumber;
}
