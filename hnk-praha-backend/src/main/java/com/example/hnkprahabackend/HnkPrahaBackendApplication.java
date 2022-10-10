package com.example.hnkprahabackend;

import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.PlayerStatLeague;
import com.example.hnkprahabackend.services.PlayerService;
import com.example.hnkprahabackend.types.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HnkPrahaBackendApplication implements CommandLineRunner {

    private final PlayerService playerService;

    @Autowired
    public HnkPrahaBackendApplication(PlayerService playerService) {
        this.playerService = playerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HnkPrahaBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Player honzaPlavka = playerService.addNewPlayer(new Player("Jan", "Plavka", 6, Position.OBRÁNCE,
                new PlayerStatLeague("podzim 2010", 17, 139, 27, 0, 6, 2, 4)));
        playerService.addNewPlayer(honzaPlavka);

        Player pavelVagner = playerService.addNewPlayer(new Player("Pavel", "Vágner", 69, Position.ZÁLOŽNÍK,
                new PlayerStatLeague("jaro 2008", 20, 155, 96, 0, 1, 1, 35)));
        playerService.addNewPlayer(pavelVagner);

    }

    private void assignLeagueStats(Player player, PlayerStatLeague playerStatLeague) {
        Player player1 = playerService.findPlayerByName(player.getLastName());

        player1.setPlayerStatLeague(playerStatLeague);

        playerService.updateNewPlayer(player1);
    }
}
