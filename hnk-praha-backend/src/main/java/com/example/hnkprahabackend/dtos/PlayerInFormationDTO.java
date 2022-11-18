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
    public final PlayerStatsPerMatchDTO playerStatsPerMatchDTO;

    public PlayerInFormationDTO(Player player, Long roundId) {
        this.playerId = player.getId();
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();
        this.jerseyNumber = player.getJerseyNumber();
        this.position = player.getPosition().toString();
        this.playerStatsPerMatchDTO = assignStatsAndMapStats(player, roundId);
    }

    private PlayerStatsPerMatchDTO assignStatsAndMapStats(Player player, Long roundId) {
        PlayerStatsPerMatch playerStatsPerMatch = player.getPlayerStatsPerMatches()
                .stream()
                .filter(val -> val.getRound().getId().equals(roundId)).findFirst().orElse(null);
        if (playerStatsPerMatch == null) {
            return null;
        }
        return new PlayerStatsPerMatchDTO(playerStatsPerMatch
                .getNumberOfGoals(),playerStatsPerMatch
                .getNumberOfYellowCards(),playerStatsPerMatch
                .getNumberOfRedCards());
    }
}
