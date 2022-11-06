package com.example.hnkprahabackend.dtos;

public class PlayerGoalsPerMatchDTO {
    private Integer playerGoalsPerMatch;

    public PlayerGoalsPerMatchDTO() {
    }

    public PlayerGoalsPerMatchDTO(Integer playerGoalsPerMatch) {
        this.playerGoalsPerMatch = playerGoalsPerMatch;
    }

    public Integer getPlayerGoalsPerMatch() {
        return playerGoalsPerMatch;
    }

    public void setPlayerGoalsPerMatch(Integer playerGoalsPerMatch) {
        this.playerGoalsPerMatch = playerGoalsPerMatch;
    }
}
