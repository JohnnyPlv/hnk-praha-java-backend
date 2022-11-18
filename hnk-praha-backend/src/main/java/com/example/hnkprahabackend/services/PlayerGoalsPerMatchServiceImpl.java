package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.PlayerStatsPerMatch;
import com.example.hnkprahabackend.models.Round;
import com.example.hnkprahabackend.models.Season;
import com.example.hnkprahabackend.repositories.PlayerGoalsPerMatchRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerGoalsPerMatchServiceImpl implements PlayerGoalsPerMatchService{

    private final PlayerGoalsPerMatchRepository playerGoalsPerMatchRepository;
    private final RoundService roundService;
    private final PlayerService playerService;

    public PlayerGoalsPerMatchServiceImpl(PlayerGoalsPerMatchRepository playerGoalsPerMatchRepository, RoundService roundService, PlayerService playerService) {
        this.playerGoalsPerMatchRepository = playerGoalsPerMatchRepository;
        this.roundService = roundService;
        this.playerService = playerService;
    }

    @Override
    public PlayerStatsPerMatch assignPlayerGoalsPerMatch(Long roundId, Long playerId, Integer goals) {
        if (goals == null) {
            return null;
        }
        Round round = roundService.findRoundById(roundId);
        Season season = round.getSeason();
        Player player = playerService.findPlayerById(playerId);
        if (season == null || player == null) {
            return null;
        }
        PlayerStatsPerMatch playerStatsPerMatch = playerGoalsPerMatchRepository
                .findPlayerGoalsPerMatchByRoundIdAndPlayerId(roundId,playerId)
                .orElse(null);
        if (playerStatsPerMatch == null) {
            return playerGoalsPerMatchRepository.save(new PlayerStatsPerMatch(season, round, goals, player ));
        } else {
            playerStatsPerMatch.setSeason(season);
            playerStatsPerMatch.setPlayer(player);
            playerStatsPerMatch.setRound(round);
            playerStatsPerMatch.setNumberOfGoals(goals);
            return playerGoalsPerMatchRepository.save(playerStatsPerMatch);
        }
    }

    @Override
    public PlayerStatsPerMatch findPlayerGoalsPerMatchByRoundId(Long roundId, Long playerId) {
        return playerGoalsPerMatchRepository.findPlayerGoalsPerMatchByRoundIdAndPlayerId(roundId, playerId).orElse(null);
    }
}
