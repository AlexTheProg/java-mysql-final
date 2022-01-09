package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("select t from Team t where t.name = :name")
    public Team findByName(String name);

}
