package com.example.hnkprahabackend.repositories;

import com.example.hnkprahabackend.models.PlayerGoalsPerMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerGoalsPerMatchRepository extends JpaRepository<PlayerGoalsPerMatch, Long> {
    Optional<PlayerGoalsPerMatch> findPlayerGoalsPerMatchByRoundIdAndPlayerId(Long roundId, Long playerId);
}
