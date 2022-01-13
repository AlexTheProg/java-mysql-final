package com.example.esportsbackend.service.caster;

import com.example.esportsbackend.handlers.exceptions.CasterAlreadyExistsException;
import com.example.esportsbackend.handlers.exceptions.CasterNotFoundException;
import com.example.esportsbackend.model.Caster;
import com.example.esportsbackend.repository.CasterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasterServiceImpl implements CasterService{
    CasterRepository casterRepository;

    public CasterServiceImpl(CasterRepository casterRepository) {
        this.casterRepository = casterRepository;
    }

    @Override
    public Caster addCaster(Caster caster) {
        Optional<Caster> existingCaster = casterRepository.findById(caster.getId());

        if(existingCaster.isPresent()){
            throw new CasterAlreadyExistsException();
        }

        return casterRepository.save(caster);
    }

    @Override
    public List<Caster> findAll() {
        return casterRepository.findAll();
    }

    @Override
    public List<Caster> findByName(String name) {
        return casterRepository.findByName(name);
    }

    @Override
    public Caster findById(Long id) {
        return casterRepository.findById(id).orElseThrow(CasterNotFoundException::new);
    }

    @Override
    public List<Caster> findByNationality(String nationality) {
        return casterRepository.findByNationality(nationality);
    }

    @Override
    public Caster updateCaster(Caster caster) {
        return null;
    }

    @Override
    public Caster deleteCaster(Long id) {
        return null;
    }
}
