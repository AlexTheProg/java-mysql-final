package com.example.esportsbackend.mapper;

import com.example.esportsbackend.model.Caster;
import com.example.esportsbackend.representation.caster.CasterCreateRequestRepresentation;
import com.example.esportsbackend.representation.caster.CasterResponseRepresentation;
import com.example.esportsbackend.representation.caster.CasterUpdateRequestRepresentation;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", uses = DateMapper.class)
public interface CasterMapper {

    Caster fromRequest(CasterCreateRequestRepresentation request);

    CasterResponseRepresentation fromCaster(Caster caster);




}
