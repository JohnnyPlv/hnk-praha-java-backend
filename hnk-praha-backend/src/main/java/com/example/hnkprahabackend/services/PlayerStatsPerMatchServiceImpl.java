package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.dtos.PlayerStatsPerMatchDTO;
import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.PlayerStatsPerMatch;
import com.example.hnkprahabackend.models.Round;
import com.example.hnkprahabackend.models.Season;
import com.example.hnkprahabackend.repositories.PlayerStatsPerMatchRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerStatsPerMatchServiceImpl implements PlayerStatsPerMatchService {

    private final PlayerStatsPerMatchRepository playerStatsPerMatchRepository;
    private final RoundService roundService;
    private final PlayerService playerService;

    public PlayerStatsPerMatchServiceImpl(PlayerStatsPerMatchRepository playerStatsPerMatchRepository, RoundService roundService, PlayerService playerService) {
        this.playerStatsPerMatchRepository = playerStatsPerMatchRepository;
        this.roundService = roundService;
        this.playerService = playerService;
    }

    @Override
    public PlayerStatsPerMatch assignPlayerStatsPerMatch(Long roundId, Long playerId, PlayerStatsPerMatchDTO playerStatsPerMatchDTO) {
        if (playerStatsPerMatchDTO == null) {
            return null;
        }
        Round round = roundService.findRoundById(roundId);
        Season season = round.getSeason();
        Player player = playerService.findPlayerById(playerId);
        if (season == null || player == null) {
            return null;
        }
        PlayerStatsPerMatch playerStatsPerMatch = playerStatsPerMatchRepository
                .findPlayerStatsPerMatchByRoundIdAndPlayerId(roundId,playerId)
                .orElse(null);
        Integer playerGoals = playerStatsPerMatchDTO.getPlayerGoalsPerMatch();
        Integer playerYellowCards = playerStatsPerMatchDTO.getPlayerYellowCardsPerMatch();
        Integer playerRedCards = playerStatsPerMatchDTO.getPlayerRedCardsPerMatch();
        if (playerStatsPerMatch == null) {
            return playerStatsPerMatchRepository.save(new PlayerStatsPerMatch(season, round, playerGoals,playerYellowCards,playerRedCards, player ));
        } else {
            playerStatsPerMatch.setSeason(season);
            playerStatsPerMatch.setPlayer(player);
            playerStatsPerMatch.setRound(round);
            playerStatsPerMatch.setNumberOfGoals(playerGoals);
            playerStatsPerMatch.setNumberOfGoals(playerYellowCards);
            playerStatsPerMatch.setNumberOfGoals(playerRedCards);
            return playerStatsPerMatchRepository.save(playerStatsPerMatch);
        }
    }

    @Override
    public PlayerStatsPerMatch findPlayerGoalsPerMatchByRoundId(Long roundId, Long playerId) {
        return playerStatsPerMatchRepository.findPlayerStatsPerMatchByRoundIdAndPlayerId(roundId, playerId).orElse(null);
    }
}
