package com.example.hnkprahabackend.controllers;

import com.example.hnkprahabackend.dtos.PlayerDTO;
import com.example.hnkprahabackend.dtos.PlayerStatsPerMatchDTO;
import com.example.hnkprahabackend.dtos.ResultDTO;
import com.example.hnkprahabackend.dtos.SeasonDTO;
import com.example.hnkprahabackend.models.*;
import com.example.hnkprahabackend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

public class RestController {
    private final PlayerService playerService;
    private final SeasonService seasonService;
    private final MappingService mappingService;
    private final FormationService formationService;
    private final RoundService roundService;

    private final PlayerStatsPerMatchService playerStatsPerMatchService;

    @Autowired
    public RestController(PlayerService playerService, SeasonService seasonService, MappingService mappingService, FormationService formationService, RoundService roundService, PlayerStatsPerMatchService playerStatsPerMatchService) {
        this.playerService = playerService;
        this.seasonService = seasonService;
        this.mappingService = mappingService;
        this.formationService = formationService;
        this.roundService = roundService;
        this.playerStatsPerMatchService = playerStatsPerMatchService;
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

    @PostMapping("/round/{id}/create/formation")
    public ResponseEntity<String> createFormation(@RequestBody List<Long> playerIds, @PathVariable Long id){

        try {
            Formation formation = formationService.createFormation(playerIds,id);
            if (formation == null) {
                return new  ResponseEntity<>("BAD_GATEWAY",HttpStatus.OK);
            } else {
                return new  ResponseEntity<>("OK",HttpStatus.OK);
            }
        } catch (DataAccessException e) {
            return new  ResponseEntity<>("ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/round/{roundId}/best-player/{playerId}")
    public ResponseEntity<String> assignBestPlayer(@PathVariable Long roundId, @PathVariable Long playerId){

        try {
            Round round = roundService.assignBestPlayer(roundId,playerId);
            if (round == null) {
                return new  ResponseEntity<>("BAD_GATEWAY",HttpStatus.OK);
            } else {
                return new  ResponseEntity<>("OK",HttpStatus.OK);
            }
        } catch (DataAccessException e) {
            return new  ResponseEntity<>("ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/round/{roundId}/set-result")
    public ResponseEntity<String> assignResult(@PathVariable Long roundId, @RequestBody ResultDTO resultDTO){

        try {
            Round round = roundService.assignResult(roundId,resultDTO);
            if (round == null) {
                return new  ResponseEntity<>("BAD_GATEWAY",HttpStatus.OK);
            } else {
                return new  ResponseEntity<>("OK",HttpStatus.OK);
            }
        } catch (DataAccessException e) {
            return new  ResponseEntity<>("ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/round/{roundId}/player/{playerId}/set-stats")
    public ResponseEntity<String> assignPlayerStatsPerMatch(@PathVariable Long roundId,
                                                            @PathVariable Long playerId,
                                                            @RequestBody PlayerStatsPerMatchDTO playerStatsPerMatchDTO){

        try {
            PlayerStatsPerMatch playerStatsPerMatch = playerStatsPerMatchService
                    .assignPlayerStatsPerMatch(roundId,playerId, playerStatsPerMatchDTO);
            if (playerStatsPerMatch == null) {
                return new  ResponseEntity<>("BAD_GATEWAY",HttpStatus.OK);
            } else {
                return new  ResponseEntity<>("OK",HttpStatus.OK);
            }
        } catch (DataAccessException e) {
            return new  ResponseEntity<>("ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
