package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.PlayerGoalsPerMatch;
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
    public PlayerGoalsPerMatch assignPlayerGoalsPerMatch(Long roundId, Long playerId, Integer goals) {
        if (goals == null) {
            return null;
        }
        Round round = roundService.findRoundById(roundId);
        Season season = round.getSeason();
        Player player = playerService.findPlayerById(playerId);
        if (season == null || player == null) {
            return null;
        }
        PlayerGoalsPerMatch playerGoalsPerMatch = playerGoalsPerMatchRepository
                .findPlayerGoalsPerMatchByRoundIdAndPlayerId(roundId,playerId)
                .orElse(null);
        if (playerGoalsPerMatch == null) {
            return playerGoalsPerMatchRepository.save(new PlayerGoalsPerMatch(season, round, goals, player ));
        } else {
            playerGoalsPerMatch.setSeason(season);
            playerGoalsPerMatch.setPlayer(player);
            playerGoalsPerMatch.setRound(round);
            playerGoalsPerMatch.setNumberOfGoals(goals);
            return playerGoalsPerMatchRepository.save(playerGoalsPerMatch);
        }
    }

    @Override
    public PlayerGoalsPerMatch findPlayerGoalsPerMatchByRoundId(Long roundId, Long playerId) {
        return playerGoalsPerMatchRepository.findPlayerGoalsPerMatchByRoundIdAndPlayerId(roundId, playerId).orElse(null);
    }
}
