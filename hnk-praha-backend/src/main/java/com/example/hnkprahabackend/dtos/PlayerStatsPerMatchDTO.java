package com.example.hnkprahabackend.dtos;

public class PlayerStatsPerMatchDTO {
    private Integer playerGoalsPerMatch;

    private Integer playerYellowCardsPerMatch;

    private Integer playerRedCardsPerMatch;

    public PlayerStatsPerMatchDTO() {
    }

    public PlayerStatsPerMatchDTO(Integer playerGoalsPerMatch, Integer playerYellowCardsPerMatch, Integer playerRedCardsPerMatch) {
        this.playerGoalsPerMatch = playerGoalsPerMatch;
        this.playerYellowCardsPerMatch = playerYellowCardsPerMatch;
        this.playerRedCardsPerMatch = playerRedCardsPerMatch;
    }

    public Integer getPlayerGoalsPerMatch() {
        return playerGoalsPerMatch;
    }

    public void setPlayerGoalsPerMatch(Integer playerGoalsPerMatch) {
        this.playerGoalsPerMatch = playerGoalsPerMatch;
    }

    public Integer getPlayerYellowCardsPerMatch() {
        return playerYellowCardsPerMatch;
    }

    public void setPlayerYellowCardsPerMatch(Integer playerYellowCardsPerMatch) {
        this.playerYellowCardsPerMatch = playerYellowCardsPerMatch;
    }

    public Integer getPlayerRedCardsPerMatch() {
        return playerRedCardsPerMatch;
    }

    public void setPlayerRedCardsPerMatch(Integer playerRedCardsPerMatch) {
        this.playerRedCardsPerMatch = playerRedCardsPerMatch;
    }
}
