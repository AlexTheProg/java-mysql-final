package com.example.esportsbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    public Long id;

    @Column(name = "sponsor_name")
    @NotBlank(message = "The sponsor company is mandatory")
    @Size(min = 2, max = 25)
    public String name;

    @ManyToMany(mappedBy = "sponsors")
    List<Team> teams;
}
