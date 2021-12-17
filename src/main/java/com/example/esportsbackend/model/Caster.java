package com.example.esportsbackend.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Caster {
    @Id
    @Column(name = "cid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "surname")
    public String surname;

    @Column(name = "date_of_birth")
    public LocalDateTime dateOfBirth;

    @Column(name = "nationality")
    public String nationality;
}
