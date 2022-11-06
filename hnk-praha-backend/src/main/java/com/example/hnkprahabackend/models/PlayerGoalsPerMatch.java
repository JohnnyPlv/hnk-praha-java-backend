package com.example.hnkprahabackend.models;

import javax.persistence.*;

@Entity
public class PlayerGoalsPerMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Player player;

    @OneToOne
    private Season season;

    @OneToOne
    private Round round;

    private Integer numberOfGoals;

    public PlayerGoalsPerMatch() {
    }

    public PlayerGoalsPerMatch(Season season, Round round, Integer numberOfGoals, Player player) {
        this.season = season;
        this.round = round;
        this.numberOfGoals = numberOfGoals;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Integer getNumberOfGoals() {
        return numberOfGoals;
    }

    public void setNumberOfGoals(Integer numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
    }
}
