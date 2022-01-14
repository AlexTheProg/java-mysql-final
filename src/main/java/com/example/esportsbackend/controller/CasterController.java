package com.example.esportsbackend.controller;

import com.example.esportsbackend.handlers.exceptions.InvalidUpdateRequestException;
import com.example.esportsbackend.mapper.CasterMapper;
import com.example.esportsbackend.model.Caster;
import com.example.esportsbackend.representation.caster.CasterCreateRequestRepresentation;
import com.example.esportsbackend.representation.caster.CasterResponseRepresentation;

import com.example.esportsbackend.representation.caster.CasterUpdateRequestRepresentation;
import com.example.esportsbackend.service.caster.CasterServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
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
            value = "Get a caster from the pool by their ID",
            nickname = "get_all_teams"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully retrieved a caster from the pool"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CasterResponseRepresentation> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(casterMapper.fromCaster(casterService.findById(id)));
    }

    @ApiOperation(
            value = "Get one or more casters by their name or nationality",
            nickname = "get_all_teams"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully retrieved one caster or a list by name and/or nationality"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/searchBy")
    public List<Caster> getCastersByNameAndNationality(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String nationality){
        return casterService.findByNationalityAndOrName(name, nationality);
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
    public ResponseEntity<CasterResponseRepresentation> addCaster(@RequestBody @Valid CasterCreateRequestRepresentation request){
        Caster caster = casterMapper.fromRequest(request);
        casterService.addCaster(caster);
        CasterResponseRepresentation response = casterMapper.fromCaster(caster);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(
            value = "Update the details of one of the casters",
            nickname = "get_all_teams"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully updated a caster from the pool"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CasterResponseRepresentation> updateCaster(@PathVariable("id") Long id,
                                                                     @RequestBody @Valid CasterUpdateRequestRepresentation request){
        if(!Objects.equals(id, request.id)){
            throw new InvalidUpdateRequestException();
        }
        Caster caster = casterMapper.fromUpdateRequest(request);
        casterService.updateCaster(caster);
        return ResponseEntity.ok(casterMapper.fromCaster(caster));
    }

    @ApiOperation(
            value = "Delete a caster from the pool",
            nickname = "get_all_teams"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "You have successfully deleted a caster from the pool"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Caster> deleteCaster(@PathVariable("id") Long id){
        return ResponseEntity.ok(casterService.deleteCaster(id));
    }

}
