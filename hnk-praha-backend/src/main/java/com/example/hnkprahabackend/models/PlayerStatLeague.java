package com.example.hnkprahabackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlayerStatLeague {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstSeason;
    private Integer seasonPlayed;
    private Integer matchesPlayed;
    private Integer goalsScored;
    private Integer golieZeroMinutes;
    private Integer yellowCards;
    private Integer redCards;
    private Integer bestPlayedCount;


    public PlayerStatLeague() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstSeason() {
        return firstSeason;
    }

    public void setFirstSeason(String firstSeason) {
        this.firstSeason = firstSeason;
    }

    public Integer getSeasonPlayed() {
        return seasonPlayed;
    }

    public void setSeasonPlayed(Integer seasonPlayed) {
        this.seasonPlayed = seasonPlayed;
    }

    public Integer getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(Integer matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public Integer getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(Integer goalsScored) {
        this.goalsScored = goalsScored;
    }

    public Integer getGolieZeroMinutes() {
        return golieZeroMinutes;
    }

    public void setGolieZeroMinutes(Integer golieZeroMinutes) {
        this.golieZeroMinutes = golieZeroMinutes;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    public Integer getBestPlayedCount() {
        return bestPlayedCount;
    }

    public void setBestPlayedCount(Integer bestPlayedCount) {
        this.bestPlayedCount = bestPlayedCount;
    }
}
