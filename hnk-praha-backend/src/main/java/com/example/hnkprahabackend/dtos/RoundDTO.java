package com.example.hnkprahabackend.dtos;

import com.example.hnkprahabackend.models.*;

import java.util.Date;
import java.util.List;

public class RoundDTO {
    public final Long id;

    public final Date date;

    public final String result;

    public final Player bestPlayer;

    public final Playground playground;

    public final String homeTeam;
    public final OpponentTeam opponentTeam;

    public FormationDTO formationDTO;

    public RoundDTO(Round round, FormationDTO formationDTO) {
        this.id = round.getId();
        this.date = round.getDate();
        this.result = round.getResult();
        this.bestPlayer = round.getBestPlayer();
        this.playground = round.getPlayground();
        this.homeTeam = round.getHnkPraha().getName();
        this.opponentTeam = round.getOpponentTeam();
        this.formationDTO = formationDTO;
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
