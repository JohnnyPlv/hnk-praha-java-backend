package com.example.hnkprahabackend.dtos;

import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.PlayerStatLeague;
import com.example.hnkprahabackend.models.PlayerStatTournament;
import com.example.hnkprahabackend.models.PlayerStatsPerMatch;

public class PlayerDTO {
    public final Long playerId;
    public final String firstName;
    public final String lastName;
    public final Integer jerseyNumber;
    public final String position;
    public boolean active;
    public PlayerStatLeague playerStatLeague;
    public PlayerStatTournament playerStatTournament;

    public PlayerStatsPerMatchDTO playerStatsPerMatchDTO;

    // constructor for regular Player to list total stats
    public PlayerDTO(Player player) {
        this.playerId = player.getId();
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();
        this.jerseyNumber = player.getJerseyNumber();
        this.position = player.getPosition().toString();
        this.active = player.isActive();
        this.playerStatLeague = player.getPlayerStatLeague();
        this.playerStatTournament = player.getPlayerStatTournament();
    }

    // constructor which is used for stat mapping in a formation
    public PlayerDTO(Player player, Long roundId) {
        this.playerId = player.getId();
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();
        this.jerseyNumber = player.getJerseyNumber();
        this.position = player.getPosition().toString();
        this.playerStatsPerMatchDTO = assignStatsAndMapStats(player, roundId);
    }

    // helper method to to get a player stats per roundId and get correct stats
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
