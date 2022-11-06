package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.Round;
import org.springframework.stereotype.Service;

@Service
public interface RoundService {
    Round findRoundById(Long id);

    Round assignBestPlayer(Long playerId, Long roundId);
}
