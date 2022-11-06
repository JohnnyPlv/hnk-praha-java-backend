package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.PlayerGoalsPerMatch;
import org.springframework.stereotype.Service;

@Service
public interface PlayerGoalsPerMatchService {
    PlayerGoalsPerMatch assignPlayerGoalsPerMatch(Long roundId, Long playerId, Integer goals);
    PlayerGoalsPerMatch findPlayerGoalsPerMatchByRoundId(Long roundId, Long playerId);
}
