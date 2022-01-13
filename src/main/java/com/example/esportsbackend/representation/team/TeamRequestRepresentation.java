package com.example.esportsbackend.representation.team;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel
public class TeamRequestRepresentation {

    @ApiModelProperty(name = "team_name", position = 1, example = "Cloud9")
    @JsonProperty
    @NotBlank(message = "The team name is mandatory")
    @Size(min = 2, max = 25)
    public String name;

    @ApiModelProperty(name = "Number of team members", position = 2, example = "4")
    @JsonProperty
    public Integer teamMemberNumber;

}
