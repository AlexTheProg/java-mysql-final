package com.example.esportsbackend.model;

import javax.persistence.*;

@Entity
public class Publisher {

    @Id
    @Column(name = "puid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

}
