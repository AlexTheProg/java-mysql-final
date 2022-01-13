package com.example.esportsbackend.service.caster;

import com.example.esportsbackend.model.Caster;

import java.util.List;

public interface CasterService {
    Caster addCaster(Caster caster);
    List<Caster> findAll();
    List<Caster> findByName(String name);
    Caster findById(Long id);
    List<Caster> findByNationality(String nationality);
    Caster updateCaster(Caster caster);
    Caster deleteCaster(Long id);
}
