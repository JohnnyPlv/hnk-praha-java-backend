package com.example.hnkprahabackend.repositories;

import com.example.hnkprahabackend.models.PlayerStatsPerMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerStatsPerMatchRepository extends JpaRepository<PlayerStatsPerMatch, Long> {
    Optional<PlayerStatsPerMatch> findPlayerStatsPerMatchByRoundIdAndPlayerId(Long roundId, Long playerId);
}
