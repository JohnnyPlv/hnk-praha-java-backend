package com.example.hnkprahabackend.dtos;

public class ResultDTO {
    private Integer hnkPrahaGoals;
    private Integer opponentTeamGoals;


    public ResultDTO() {
    }

    public ResultDTO(Integer hnkPrahaGoals, Integer opponentTeamGoals) {
        this.hnkPrahaGoals = hnkPrahaGoals;
        this.opponentTeamGoals = opponentTeamGoals;
    }

    public Integer getHnkPrahaGoals() {
        return hnkPrahaGoals;
    }

    public void setHnkPrahaGoals(Integer hnkPrahaGoals) {
        this.hnkPrahaGoals = hnkPrahaGoals;
    }

    public Integer getOpponentTeamGoals() {
        return opponentTeamGoals;
    }

    public void setOpponentTeamGoals(Integer opponentTeamGoals) {
        this.opponentTeamGoals = opponentTeamGoals;
    }
}
