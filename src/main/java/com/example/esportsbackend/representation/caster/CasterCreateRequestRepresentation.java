package com.example.esportsbackend.representation.caster;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@ApiModel
public class CasterCreateRequestRepresentation {

    @ApiModelProperty(name = "name", position = 2, example = "Johnny")
    @JsonProperty
    @NotBlank(message = "The caster name is mandatory")
    @Size(min = 2, max = 25)
    public String name;

    @ApiModelProperty(name = "surname", position = 3, example = "Doe")
    @JsonProperty
    @NotBlank(message = "The caster surname is mandatory")
    @Size(min = 2, max = 25)
    public String surname;

    @ApiModelProperty(name = "date_of_birth", position = 4, example = "11-11-11")
    @JsonProperty
    public String dateOfBirth;

    @ApiModelProperty(name = "nationality", position = 5, example = "Lebanese")
    @JsonProperty
    public String nationality;

}
