package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Caster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CasterRepository extends JpaRepository<Caster, Long> {
    List<Caster> findByName(String name);
    List<Caster> findByNationality(String nationality);
    List<Caster> findByNationalityAndName(String name, String nationality);
    Caster deleteCasterById(Long id);
}
