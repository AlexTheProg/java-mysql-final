package com.example.esportsbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid")
    public Long id;

    @Column(name = "company")
    public String companyName;

    @ManyToOne
    @JoinColumn(name = "eid")
    Event events;
}
