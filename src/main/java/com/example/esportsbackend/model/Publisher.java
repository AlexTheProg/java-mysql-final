package com.example.esportsbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Publisher {

    @Id
    @Column(name = "puid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    @NotBlank(message = "The publisher company is mandatory")
    @Size(min = 2, max = 25)
    public String name;

    @ManyToMany(mappedBy = "publishers")
    List<Game> games;

}
