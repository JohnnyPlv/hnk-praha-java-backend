package com.example.hnkprahabackend.repositories;

import com.example.hnkprahabackend.models.PlayerStatsPerMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerGoalsPerMatchRepository extends JpaRepository<PlayerStatsPerMatch, Long> {
    Optional<PlayerStatsPerMatch> findPlayerGoalsPerMatchByRoundIdAndPlayerId(Long roundId, Long playerId);
}
