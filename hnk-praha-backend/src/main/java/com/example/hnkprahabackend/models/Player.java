package com.example.hnkprahabackend.models;

import javax.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Integer jerseyNumber;

    private String position;

    private boolean active;

    @OneToOne
    private PlayerStatTournament playerStatTournament;

    @OneToOne
    private PlayerStatLeague playerStatLeague;

    public Player(String firstName,
                  String lastName,
                  Integer jerseyNumber,
                  String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jerseyNumber = jerseyNumber;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
