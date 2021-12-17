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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tid")
    //direct side -> Join column
    //bidirectional one-to-many or uni many-to-one in owning side => optimal way to implement one-to-many
    private Team team;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gid")
    private Game game;


    public Player() {}

}
