package com.example.esportsbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Location {
    @Id
    @Column(name = "lid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "capacity")
    @NotBlank(message = "The location capacity is mandatory")
    @Size(min = 2, max = 25)
    public Integer capacity;

    @Column(name = "city")
    @NotBlank(message = "The city is mandatory")
    @Size(min = 2, max = 25)
    public String city;

    @Column(name = "price")
    public Integer price;

    @OneToMany(mappedBy = "location")
    List<Event> eventList;
}
