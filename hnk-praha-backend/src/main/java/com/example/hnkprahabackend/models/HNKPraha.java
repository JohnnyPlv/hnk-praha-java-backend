package com.example.hnkprahabackend.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HNKPraha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer seasonCount;
    private Integer matchesCount;
    private Integer goalScored;
    private Integer goalConceded;

    @OneToMany(mappedBy = "hnkPraha")
    private List<Player> players;

    public HNKPraha() {
    }

    public HNKPraha(Integer seasonCount, Integer matchesCount, Integer goalScored, Integer goalConceded) {
        this.seasonCount = seasonCount;
        this.matchesCount = matchesCount;
        this.goalScored = goalScored;
        this.goalConceded = goalConceded;
        this.players = new ArrayList<>();
    }

    public Integer getSeasonCount() {
        return seasonCount;
    }

    public void setSeasonCount(Integer seasonCount) {
        this.seasonCount = seasonCount;
    }

    public Integer getMatchesCount() {
        return matchesCount;
    }

    public void setMatchesCount(Integer matchesCount) {
        this.matchesCount = matchesCount;
    }

    public Integer getGoalScored() {
        return goalScored;
    }

    public void setGoalScored(Integer goalScored) {
        this.goalScored = goalScored;
    }

    public Integer getGoalConceded() {
        return goalConceded;
    }

    public void setGoalConceded(Integer goalConceded) {
        this.goalConceded = goalConceded;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
