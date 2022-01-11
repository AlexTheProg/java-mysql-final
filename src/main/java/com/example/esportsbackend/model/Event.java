package com.example.esportsbackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event {
    @Id
    @Column(name = "eid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "prize")
    @NotBlank(message = "The event prize is mandatory")
    @Size(min = 2, max = 25)
    public Integer prize;

    @Column(name = "event_name")
    @NotBlank(message = "The event name is mandatory")
    @Size(min = 2, max = 25)
    public String eventName;

    @Column(name = "ticket_price")
    public Integer ticketPrice;

    @Column(name = "budget")
    @NotBlank(message = "The budget is mandatory")
    @Size(min = 2, max = 25)
    public Long budget;

    @Column(name = "event_date")
    public LocalDateTime event_date;

    @ManyToOne
    @JoinColumn(name = "lid")
    Location location;

    @ManyToMany
    @JoinTable(name = "events_casters",
    joinColumns = @JoinColumn(name = "eid"),
    inverseJoinColumns = @JoinColumn(name = "cid"))
    List<Caster> casters;

    //inverse side of game-event relationship
    @OneToMany(mappedBy = "event")
    List<Game> games;

    @OneToMany(mappedBy = "event")
    List<Matchup> matchups;

    @OneToMany(mappedBy = "events")
    List<Organizer> organizers;
}
