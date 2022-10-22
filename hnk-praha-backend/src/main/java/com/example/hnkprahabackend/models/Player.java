package com.example.hnkprahabackend.models;

import com.example.hnkprahabackend.types.Position;

import javax.persistence.*;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Integer jerseyNumber;

    private Position position;

    private boolean active;

    @ManyToOne(cascade = CascadeType.MERGE)
    private HNKPraha hnkPraha;

    @ManyToMany(mappedBy = "players", cascade = CascadeType.ALL)
    private List<Formation> formations;

    @OneToOne (cascade=CascadeType.ALL)
    private PlayerStatLeague playerStatLeague;

    @OneToOne (cascade=CascadeType.ALL)
    private PlayerStatTournament playerStatTournament;



    public Player(String firstName,
                  String lastName,
                  Integer jerseyNumber,
                  Position position,
                  boolean active,
                  PlayerStatLeague playerStatLeague,
                  PlayerStatTournament playerStatTournament,
                  HNKPraha hnkPraha) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jerseyNumber = jerseyNumber;
        this.position = position;
        this.active = active;
        this.playerStatLeague = playerStatLeague;
        this.playerStatTournament = playerStatTournament;
        this.hnkPraha = hnkPraha;
    }

    public Player() {
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public PlayerStatLeague getPlayerStatLeague() {
        return playerStatLeague;
    }

    public void setPlayerStatLeague(PlayerStatLeague playerStatLeague) {
        this.playerStatLeague = playerStatLeague;
    }

    public PlayerStatTournament getPlayerStatTournament() {
        return playerStatTournament;
    }

    public void setPlayerStatTournament(PlayerStatTournament playerStatTournament) {
        this.playerStatTournament = playerStatTournament;
    }

    public HNKPraha getHnkPraha() {
        return hnkPraha;
    }

    public void setHnkPraha(HNKPraha hnkPraha) {
        this.hnkPraha = hnkPraha;
    }
}
