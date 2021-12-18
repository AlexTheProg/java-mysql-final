package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Caster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasterRepository extends JpaRepository<Caster, Long> {
}
