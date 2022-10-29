package com.example.hnkprahabackend.controllers;

import com.example.hnkprahabackend.dtos.PlayerDTO;
import com.example.hnkprahabackend.dtos.SeasonDTO;
import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.Season;
import com.example.hnkprahabackend.services.MappingService;
import com.example.hnkprahabackend.services.PlayerService;
import com.example.hnkprahabackend.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

public class RestController {
    private final PlayerService playerService;

    private final SeasonService seasonService;
    private final MappingService mappingService;

    @Autowired
    public RestController(PlayerService playerService, SeasonService seasonService, MappingService mappingService) {
        this.playerService = playerService;
        this.seasonService = seasonService;
        this.mappingService = mappingService;
    }

    @GetMapping("/players")
    public ResponseEntity<List<PlayerDTO>> searchPlayers(){

        List<Player> players = playerService.findAll();
        List<PlayerDTO> playerDTOS = mappingService.mapPlayers(players);
        return new ResponseEntity<>(playerDTOS, HttpStatus.OK);
    }

    @GetMapping("/seasons")
    public ResponseEntity<List<SeasonDTO>> searchSeasons(){

        List<Season> seasons = seasonService.findAll();
        List<SeasonDTO> seasonDTOS = mappingService.mapSeasons(seasons);
        return new ResponseEntity<>(seasonDTOS, HttpStatus.OK);
    }
}
