package com.example.hnkprahabackend.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String result;

    @OneToOne(cascade = CascadeType.MERGE)
    private Player bestPlayer;

    @OneToOne(cascade=CascadeType.ALL)
    private Playground playground;

    public Round() {
    }
    public Round(Date date, Playground playground,Season season, HNKPraha hnkPraha) {
        this.date = date;
        this.playground = playground;
        this.season = season;
        this.hnkPraha = hnkPraha;
    }

    @ManyToOne
    private Season season;

    @OneToOne(cascade = CascadeType.MERGE)
    private HNKPraha hnkPraha;

    @OneToOne(cascade=CascadeType.ALL)
    private OpponentTeam opponentTeam;

    @OneToOne(cascade=CascadeType.ALL)
    private Formation formation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Player getBestPlayer() {
        return bestPlayer;
    }

    public void setBestPlayer(Player bestPlayer) {
        this.bestPlayer = bestPlayer;
    }

    public Playground getPlayground() {
        return playground;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public HNKPraha getHnkPraha() {
        return hnkPraha;
    }

    public void setHnkPraha(HNKPraha hnkPraha) {
        this.hnkPraha = hnkPraha;
    }

    public OpponentTeam getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(OpponentTeam opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
