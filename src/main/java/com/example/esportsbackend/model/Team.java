package com.example.esportsbackend.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Entity
public class Team {
    @Id
    @Column(name = "tid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name", unique = true)
    @NotBlank(message = "The team name is mandatory")
    @Size(min = 2, max = 25)
    public String name;

    @Column(name = "current_member_number")
    public Integer currentMemberNumber;

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

    public Integer getCurrentMemberNumber() {
        return currentMemberNumber;
    }

    public void setCurrentMemberNumber(Integer currentMemberNumber) {
        this.currentMemberNumber = currentMemberNumber;
    }

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

    public Team(Long id, String name, Integer currentMemberNumber) {
        this.id = id;
        this.name = name;
        this.currentMemberNumber = currentMemberNumber;
    }

    public Team(String name, Integer currentMemberNumber) {
        this.name = name;
        this.currentMemberNumber = currentMemberNumber;
    }

    public Team(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(name, team.name) && Objects.equals(currentMemberNumber, team.currentMemberNumber) && Objects.equals(players, team.players) && Objects.equals(matchup, team.matchup) && Objects.equals(games, team.games) && Objects.equals(sponsors, team.sponsors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, currentMemberNumber, players, matchup, games, sponsors);
    }

}
