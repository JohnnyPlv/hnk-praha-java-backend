package com.example.hnkprahabackend.models;

import javax.persistence.*;

@Entity
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Season season;

    @OneToOne
    private HNKPraha hnkPraha;

    @OneToOne
    private OpponentTeam opponentTeam;

    @OneToOne
    private Formation formation;

    public Round() {
    }

    public Round(Season season, HNKPraha hnkPraha, OpponentTeam opponentTeam) {
        this.season = season;
        this.hnkPraha = hnkPraha;
        this.opponentTeam = opponentTeam;
    }
}
