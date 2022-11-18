package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.dtos.PlayerStatsPerMatchDTO;
import com.example.hnkprahabackend.models.PlayerStatsPerMatch;
import org.springframework.stereotype.Service;

@Service
public interface PlayerStatsPerMatchService {
    PlayerStatsPerMatch assignPlayerStatsPerMatch(Long roundId, Long playerId, PlayerStatsPerMatchDTO playerStatsPerMatchDTO);
    PlayerStatsPerMatch findPlayerGoalsPerMatchByRoundId(Long roundId, Long playerId);
}
