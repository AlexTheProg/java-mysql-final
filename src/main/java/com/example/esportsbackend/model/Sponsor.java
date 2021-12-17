package com.example.esportsbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    public Long id;

    @Column(name = "sponsor_name")
    public String name;

    @ManyToMany(mappedBy = "sponsors")
    List<Team> teams;
}
