package com.example.hnkprahabackend;

import com.example.hnkprahabackend.models.*;
import com.example.hnkprahabackend.repositories.HNKPrahaRepository;
import com.example.hnkprahabackend.services.PlayerService;
import com.example.hnkprahabackend.services.SeasonService;
import com.example.hnkprahabackend.types.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HnkPrahaBackendApplication implements CommandLineRunner {

    private final PlayerService playerService;

    private final HNKPrahaRepository hnkPrahaRepository;

    private final SeasonService seasonService;



    @Autowired
    public HnkPrahaBackendApplication(PlayerService playerService, HNKPrahaRepository hnkPrahaRepository, SeasonService seasonService) {
        this.playerService = playerService;

        this.hnkPrahaRepository = hnkPrahaRepository;
        this.seasonService = seasonService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HnkPrahaBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        HNKPraha hnkPraha = createHnkResources();

        Season season = new Season("2022");
        List<Round> rounds = new ArrayList<>();
        rounds.add(new Round(new Date(),new Playground("test","url"),season,hnkPraha));
        rounds.add(new Round(new Date(),new Playground("test2","url"),season,hnkPraha));
        rounds.add(new Round(new Date(),new Playground("test3","url"),season,hnkPraha));
        rounds.add(new Round(new Date(),new Playground("test4","url"),season,hnkPraha));
        season.setRounds(rounds);
        seasonService.addNewSeason(season);

    }

    private void assignLeagueStats(Player player, PlayerStatLeague playerStatLeague) {
        Player player1 = playerService.findPlayerByName(player.getLastName());

        player1.setPlayerStatLeague(playerStatLeague);

        playerService.updateNewPlayer(player1);
    }

    private HNKPraha createHnkResources() {
        HNKPraha hnkPraha = createHnk();

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

        Player honzaLantora = playerService.addNewPlayer(new Player("Honza", "Lantora", 99, Position.OBRÁNCE,true,
                new PlayerStatLeague("podzim 2017", 6, 44, 1, 0, 0, 0, 1),
                new PlayerStatTournament(1,2),
                hnkPraha));
        playerService.addNewPlayer(honzaLantora);

        Player michalPleva = playerService.addNewPlayer(new Player("Michal", "Pleva", 49, Position.ÚTOČNÍK,true,
                new PlayerStatLeague("jaro 2015", 5, 49, 5, 0, 1, 0, 3),
                new PlayerStatTournament(2,1),
                hnkPraha));
        playerService.addNewPlayer(michalPleva);

        return hnkPraha;
    }

    private HNKPraha createHnk() {
        HNKPraha hnkPraha = new HNKPraha("HNK Praha",44,446,1331,1346);
        return hnkPrahaRepository.save(hnkPraha);
    }
}
