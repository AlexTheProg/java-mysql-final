package com.example.esportsbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Caster {
    @Id
    @Column(name = "cid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "surname")
    @NotBlank(message = "The caster surname is mandatory")
    @Size(min = 2, max = 25)
    public String surname;

    @Column(name = "date_of_birth")
    public Date dateOfBirth;

    @Column(name = "nationality")
    public String nationality;

    @ManyToMany(mappedBy = "casters")
    List<Event> eventList;

    public Caster() {}

    public Caster(Long id, String name, String surname, Date dateOfBirth, String nationality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    public Caster(String name, String surname, Date dateOfBirth, String nationality) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
