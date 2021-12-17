package com.example.esportsbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Game {
    @Id
    @Column(name = "gid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @ManyToMany
    @JoinTable(name = "games_teams",
    joinColumns = @JoinColumn(name = "gid"),
    inverseJoinColumns = @JoinColumn(name = "tid"))
    List<Team> teams;

    @ManyToMany
    @JoinTable(name = "games_publishers",
    joinColumns = @JoinColumn(name = "gid"),
    inverseJoinColumns = @JoinColumn(name = "puid"))
    List<Publisher> publishers;

    @ManyToOne
    @JoinColumn(name = "eid")
    public Event event;

    @OneToMany(mappedBy = "game")
    List<Player> players;


    public Game(){}
}
