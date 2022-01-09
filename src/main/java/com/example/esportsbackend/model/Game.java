package com.example.esportsbackend.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Game {
    @Id
    @Column(name = "gid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true, name = "name")
    public String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(name, game.name) && Objects.equals(teams, game.teams) && Objects.equals(publishers, game.publishers) && Objects.equals(event, game.event) && Objects.equals(players, game.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, teams, publishers, event, players);
    }

    public Game(){}
}
