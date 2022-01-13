package com.example.esportsbackend.representation.caster;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel
public class CasterResponseRepresentation extends CasterCreateRequestRepresentation{

    @ApiModelProperty(name = "id", position = 1, example = "1")
    @JsonProperty
    public Long id;


}
