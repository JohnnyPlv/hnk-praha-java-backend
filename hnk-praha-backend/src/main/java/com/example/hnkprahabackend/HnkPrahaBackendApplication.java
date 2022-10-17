package com.example.hnkprahabackend;

import com.example.hnkprahabackend.models.HNKPraha;
import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.PlayerStatLeague;
import com.example.hnkprahabackend.models.PlayerStatTournament;
import com.example.hnkprahabackend.repositories.HNKPrahaRepository;
import com.example.hnkprahabackend.services.PlayerService;
import com.example.hnkprahabackend.types.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HnkPrahaBackendApplication implements CommandLineRunner {

    private final PlayerService playerService;

    private final HNKPrahaRepository hnkPrahaRepository;



    @Autowired
    public HnkPrahaBackendApplication(PlayerService playerService, HNKPrahaRepository hnkPrahaRepository) {
        this.playerService = playerService;

        this.hnkPrahaRepository = hnkPrahaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HnkPrahaBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        HNKPraha hnkPraha = new HNKPraha(44,446,1331,1346);
        hnkPrahaRepository.save(hnkPraha);

        Player honzaPlavka = playerService.addNewPlayer(new Player("Jan", "Plavka", 6, Position.OBRÁNCE,true,
                new PlayerStatLeague("podzim 2010", 17, 139, 27, 0, 6, 2, 4),
                new PlayerStatTournament(20,6),
                hnkPraha));
        playerService.addNewPlayer(honzaPlavka);

        Player pavelVagner = playerService.addNewPlayer(new Player("Pavel", "Vágner", 69, Position.ZÁLOŽNÍK,true,
                new PlayerStatLeague("jaro 2008", 20, 155, 96, 0, 1, 1, 35),
                new PlayerStatTournament(27,15),
                hnkPraha));
        playerService.addNewPlayer(pavelVagner);

    }

    private void assignLeagueStats(Player player, PlayerStatLeague playerStatLeague) {
        Player player1 = playerService.findPlayerByName(player.getLastName());

        player1.setPlayerStatLeague(playerStatLeague);

        playerService.updateNewPlayer(player1);
    }
}
