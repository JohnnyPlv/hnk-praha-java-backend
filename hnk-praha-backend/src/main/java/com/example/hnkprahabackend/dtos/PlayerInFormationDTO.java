package com.example.hnkprahabackend.dtos;

import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.PlayerStatsPerMatch;

import java.util.List;

public class PlayerInFormationDTO {
    public final Long playerId;
    public final String firstName;
    public final String lastName;
    public final Integer jerseyNumber;
    public final String position;
    public final List<PlayerStatsPerMatch> playerStatsPerMatches;

    public PlayerInFormationDTO(Player player) {
        this.playerId = player.getId();
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();
        this.jerseyNumber = player.getJerseyNumber();
        this.position = player.getPosition().toString();
        this.playerStatsPerMatches = player.getPlayerStatsPerMatches();
    }

}
