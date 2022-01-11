package com.example.esportsbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Matchup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "muid")
    public Long id;

    @Column(name = "team_a_id")
    public Long team_a_id;

    @Column(name = "team_b_id")
    public Long team_b_id;

    @Column(name = "bracket")
    public String bracket;

    @ManyToOne
    @JoinColumn(name = "eid")
    Event event;


}
