package com.example.esportsbackend.service.caster;

import com.example.esportsbackend.model.Caster;

import java.util.List;

public interface CasterService {
    Caster addCaster(Caster caster);
    List<Caster> findAll();
    Caster findById(Long id);
    List<Caster> findByNameAndNationality(String name, String nationality);
    Caster updateCaster(Caster caster);
    Caster deleteCaster(Long id);
}
