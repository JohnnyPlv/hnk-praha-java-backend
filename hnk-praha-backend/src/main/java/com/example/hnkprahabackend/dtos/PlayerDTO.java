package com.example.hnkprahabackend.dtos;

import com.example.hnkprahabackend.models.Player;

public class PlayerDTO {
    public final Long playerId;
    public final String firstName;
    public final String lastName;
    public final Integer jerseyNumber;
    public final String position;
    public final boolean active;
    public final String firstSeason;
    public final Integer seasonPlayed;
    public final Integer matchesPlayed;
    public final Integer goalsScored;
    public final Integer golieZeroMinutes;
    public final Integer yellowCards;
    public final Integer redCards;
    public final Integer bestPlayedCount;

    public final Double averageGoalScored;

    public PlayerDTO(Player player) {
        this.playerId = player.getId();
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();
        this.jerseyNumber = player.getJerseyNumber();
        this.position = player.getPosition().toString();
        this.active = player.isActive();
        this.firstSeason = player.getPlayerStatLeague().getFirstSeason();
        this.seasonPlayed = player.getPlayerStatLeague().getSeasonPlayed();
        this.matchesPlayed = player.getPlayerStatLeague().getMatchesPlayed();
        this.goalsScored = player.getPlayerStatLeague().getGoalsScored();
        this.golieZeroMinutes = player.getPlayerStatLeague().getGolieZeroMinutes();
        this.yellowCards = player.getPlayerStatLeague().getYellowCards();
        this.redCards = player.getPlayerStatLeague().getRedCards();
        this.bestPlayedCount = player.getPlayerStatLeague().getBestPlayedCount();
        this.averageGoalScored = player.getPlayerStatLeague().getGoalPerMatch();
    }
}
