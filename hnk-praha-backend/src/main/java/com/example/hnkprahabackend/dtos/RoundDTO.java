package com.example.hnkprahabackend.dtos;

import com.example.hnkprahabackend.models.*;

import java.util.Date;

public class RoundDTO {
    public final Long id;

    public final Date date;

    public final String result;

    public final Player bestPlayer;

    public final Playground playground;

    public final String homeTeam;
    public final OpponentTeam opponentTeam;

    public FormationDTO formation;

    public RoundDTO(Round round, FormationDTO formation) {
        this.id = round.getId();
        this.date = round.getDate();
        this.result = round.getResult();
        this.bestPlayer = round.getBestPlayer();
        this.playground = round.getPlayground();
        this.homeTeam = round.getHnkPraha().getName();
        this.opponentTeam = round.getOpponentTeam();
        this.formation = formation;
    }

    public RoundDTO(Round round) {
        this.id = round.getId();
        this.date = round.getDate();
        this.result = round.getResult();
        this.bestPlayer = round.getBestPlayer();
        this.playground = round.getPlayground();
        this.homeTeam = round.getHnkPraha().getName();
        this.opponentTeam = round.getOpponentTeam();
    }
}
