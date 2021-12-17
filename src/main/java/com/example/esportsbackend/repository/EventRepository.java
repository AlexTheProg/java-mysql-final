package com.example.esportsbackend.repository;

import com.example.esportsbackend.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Long, Event> {
}
