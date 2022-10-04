package com.example.hnkprahabackend;

import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.services.PlayerService;
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
        playerService.addNewPlayer(new Player("Jan","Plavka", 6, "Obrance"));
    }
}
