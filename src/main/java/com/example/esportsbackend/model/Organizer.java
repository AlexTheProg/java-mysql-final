package com.example.esportsbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid")
    public Long id;

    @Column(name = "company")
    @NotBlank(message = "The organizer company is mandatory")
    @Size(min = 2, max = 25)
    public String companyName;

    @ManyToOne
    @JoinColumn(name = "eid")
    Event events;
}
