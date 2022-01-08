package com.example.esportsbackend.controller.representation;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "playerEntityRepresentation")
public class PlayerRepresentation {

    @ApiModelProperty(name = "id", position = 1, example = "12398761")
    @JsonProperty
    public Long id;

    @ApiModelProperty(name = "name", position = 2, example = "John")
    @JsonProperty
    public String name;

    @ApiModelProperty(name = "surname", position = 3, example = "Doe")
    @JsonProperty
    public String surname;

    @ApiModelProperty(name = "date_of_birth", position = 4, example = "11-12-2020")
    @JsonProperty
    public String dob;

    @ApiModelProperty(name = "joined_at_date", position = 5, example = "12-12-2020")
    @JsonProperty
    public String joined_at_date;
}
