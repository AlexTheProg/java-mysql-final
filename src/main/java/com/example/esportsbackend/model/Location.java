package com.example.esportsbackend.model;

import javax.persistence.*;

@Entity
public class Location {
    @Id
    @Column(name = "lid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "capacity")
    public Integer capacity;

    @Column(name = "city")
    public String city;

    @Column(name = "price")
    public Integer price;
}
