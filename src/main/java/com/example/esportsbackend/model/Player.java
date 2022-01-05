package com.example.esportsbackend.model;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @Column(name = "joined_at")
    public Timestamp joined_at;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tid")
    //direct side -> Join column
    //bidirectional one-to-many or uni many-to-one in owning side => optimal way to implement one-to-many
    private Team team;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gid")
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

    public Timestamp getJoined_at() {
        return joined_at;
    }

    public void setJoined_at(Timestamp joined_at) {
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

    public Player() {}

}
