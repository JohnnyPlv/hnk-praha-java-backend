package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.PlayerStatsPerMatch;
import org.springframework.stereotype.Service;

@Service
public interface PlayerGoalsPerMatchService {
    PlayerStatsPerMatch assignPlayerGoalsPerMatch(Long roundId, Long playerId, Integer goals);
    PlayerStatsPerMatch findPlayerGoalsPerMatchByRoundId(Long roundId, Long playerId);
}
