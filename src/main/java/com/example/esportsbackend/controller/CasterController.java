package com.example.esportsbackend.controller;

import com.example.esportsbackend.mapper.CasterMapper;
import com.example.esportsbackend.model.Caster;
import com.example.esportsbackend.representation.caster.CasterCreateRequestRepresentation;
import com.example.esportsbackend.representation.caster.CasterResponseRepresentation;

import com.example.esportsbackend.service.caster.CasterServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/casters")
public class CasterController {
CasterServiceImpl casterService;
CasterMapper casterMapper;

    public CasterController(CasterServiceImpl casterService, CasterMapper mapper) {
        this.casterService = casterService;
        this.casterMapper = mapper;
    }

    @ApiOperation(
            value = "Get list of casters in the pool",
            nickname = "get_all_teams"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully retrieved a list of all the casters of the pool"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping
    public List<CasterResponseRepresentation> getAllCasters(){
        return casterService.findAll()
                .stream()
                .map(casterMapper::fromCaster)
                .collect(Collectors.toList());
    }

    @ApiOperation(
            value = "Add a caster to the pool",
            nickname = "get_all_teams"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully added a caster to the pool"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<CasterResponseRepresentation> addCaster(CasterCreateRequestRepresentation request){
        Caster caster = casterMapper.fromRequest(request);
        casterService.addCaster(caster);
        return ResponseEntity.ok(casterMapper.fromCaster(caster));
    }
}
