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
        return casterRepository.save(caster);
    }

    @Override
    public List<Caster> findAll() {
        return casterRepository.findAll();
    }

    @Override
    public Caster findById(Long id) {
        return casterRepository.findById(id).orElseThrow(CasterNotFoundException::new);
    }

    @Override
    public List<Caster> findByNameAndNationality(String name, String nationality) {
        if(name != null){
            if(nationality != null){
               return casterRepository.findByNameAndNationality(name, nationality);
            }
            return casterRepository.findByName(name);
        }
        if(nationality != null){
            return casterRepository.findByNationality(nationality);
        }
        return casterRepository.findAll();
    }


    @Override
    public Caster updateCaster(Caster caster) {
        Optional<Caster> existingCaster = casterRepository.findById(caster.id);

        if(existingCaster.isEmpty()){
            throw new CasterNotFoundException();
        }
        return casterRepository.save(caster);
    }

    @Override
    public Caster deleteCaster(Long id) {
        Optional<Caster> existingCaster = casterRepository.findById(id);

        if(existingCaster.isEmpty()){
            throw new CasterNotFoundException();
        }
       return casterRepository.deleteCasterById(id);
    }

}
