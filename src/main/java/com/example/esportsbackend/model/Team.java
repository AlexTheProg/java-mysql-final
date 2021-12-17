package com.example.esportsbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    @Id
    @Column(name = "tid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "current_member_number")
    public Integer currentMemberNumber;

    @OneToMany(mappedBy = "team")
    //inverse side
    //bidirectional one-to-many
    List<Player> players;

    @ManyToOne
    @JoinColumn(name = "muid")
    Matchup matchup;

    @ManyToMany(mappedBy = "teams")
    List<Game> games;

    @ManyToMany
    @JoinTable(name = "teams_sponsors",
    joinColumns = @JoinColumn(name = "tid"),
    inverseJoinColumns = @JoinColumn(name = "sid"))
    List<Sponsor> sponsors;


    public Team() {}
}
