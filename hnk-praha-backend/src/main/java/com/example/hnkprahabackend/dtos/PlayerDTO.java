package com.example.hnkprahabackend.dtos;

import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.PlayerStatLeague;
import com.example.hnkprahabackend.models.PlayerStatTournament;

public class PlayerDTO {
    public final Long playerId;
    public final String firstName;
    public final String lastName;
    public final Integer jerseyNumber;
    public final String position;
    public final boolean active;
    public final PlayerStatLeague playerStatLeague;
    public final PlayerStatTournament playerStatTournament;


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
}
