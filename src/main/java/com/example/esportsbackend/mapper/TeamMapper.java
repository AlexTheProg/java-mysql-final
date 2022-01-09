package com.example.esportsbackend.mapper;

import com.example.esportsbackend.controller.representation.team.TeamRepresentation;
import com.example.esportsbackend.model.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    Team mapToTeam(TeamRepresentation teamRepresentation);

    TeamRepresentation mapToRepresentation(Team team);
}
