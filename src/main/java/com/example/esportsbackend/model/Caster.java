package com.example.esportsbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Caster {
    @Id
    @Column(name = "cid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    @NotBlank(message = "The caster name is mandatory")
    @Size(min = 2, max = 25)
    public String name;

    @Column(name = "surname")
    @NotBlank(message = "The caster surname is mandatory")
    @Size(min = 2, max = 25)
    public String surname;

    @Column(name = "date_of_birth")
    public LocalDateTime dateOfBirth;

    @Column(name = "nationality")
    public String nationality;

    @ManyToMany(mappedBy = "casters")
    List<Event> eventList;
}
