package com.example.hnkprahabackend.controllers;

import com.example.hnkprahabackend.dtos.PlayerDTO;
import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.services.MappingService;
import com.example.hnkprahabackend.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

public class RestController {
    private final PlayerService playerService;
    private final MappingService mappingService;

    @Autowired
    public RestController(PlayerService playerService, MappingService mappingService) {
        this.playerService = playerService;
        this.mappingService = mappingService;
    }



    @GetMapping("/players")
    public ResponseEntity<List<PlayerDTO>> search(){

        List<Player> players = playerService.findAll();
        List<PlayerDTO> playerDTOS = mappingService.mapPlayers(players);
        return new ResponseEntity<>(playerDTOS, HttpStatus.OK);
    }
}
