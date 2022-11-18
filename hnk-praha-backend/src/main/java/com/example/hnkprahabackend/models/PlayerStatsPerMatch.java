package com.example.hnkprahabackend.models;

import javax.persistence.*;

@Entity
public class PlayerStatsPerMatch {
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

    private Integer numberOfYellowCards;

    private Integer numberOfRedCards;

    public PlayerStatsPerMatch() {
    }

    public PlayerStatsPerMatch(Season season, Round round, Integer numberOfGoals,Integer numberOfYellowCards, Integer numberOfRedCards, Player player) {
        this.season = season;
        this.round = round;
        this.numberOfGoals = numberOfGoals;
        this.numberOfYellowCards = numberOfYellowCards;
        this.numberOfRedCards = numberOfRedCards;
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

    public Integer getNumberOfYellowCards() {
        return numberOfYellowCards;
    }

    public void setNumberOfYellowCards(Integer numberOfYellowCards) {
        this.numberOfYellowCards = numberOfYellowCards;
    }

    public Integer getNumberOfRedCards() {
        return numberOfRedCards;
    }

    public void setNumberOfRedCards(Integer numberOfRedCards) {
        this.numberOfRedCards = numberOfRedCards;
    }
}
