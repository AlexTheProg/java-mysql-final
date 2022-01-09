package com.example.esportsbackend.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "joined_at")
    public Date joined_at;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tid")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    //direct side -> Join column
    //bidirectional one-to-many or uni many-to-one in owning side => optimal way to implement one-to-many
    private Team team;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gid")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Game game;

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

    public String getSurname() {
        return surname;
    }

    public Date getJoined_at() {
        return joined_at;
    }

    public void setJoined_at(Date joined_at) {
        this.joined_at = joined_at;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(name, player.name) && Objects.equals(surname, player.surname) && Objects.equals(dateOfBirth, player.dateOfBirth) && Objects.equals(joined_at, player.joined_at) && Objects.equals(team, player.team) && Objects.equals(game, player.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, dateOfBirth, joined_at, team, game);
    }

    public Player() {}

}
