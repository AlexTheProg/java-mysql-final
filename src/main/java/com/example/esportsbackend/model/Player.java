package com.example.esportsbackend.model;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "surname")
    public String surname;

    @Column(name = "dob")
    public String dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tid")
    //direct side -> Join column
    //bidirectional one-to-many => optimal way to implement one-to-many
    private Team team;

    public Player() {}

}
