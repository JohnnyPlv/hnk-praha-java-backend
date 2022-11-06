package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.Round;
import com.example.hnkprahabackend.repositories.RoundRepository;
import org.springframework.stereotype.Service;

@Service
public class RoundServiceImpl implements RoundService {

    private final RoundRepository roundRepository;
    private final PlayerService playerService;

    public RoundServiceImpl(RoundRepository roundRepository, PlayerService playerService) {
        this.roundRepository = roundRepository;
        this.playerService = playerService;
    }

    @Override
    public Round findRoundById(Long id) {
        if (id == null) {
            return null;
        }
        return roundRepository.findById(id).orElse(null);
    }

    @Override
    public Round assignBestPlayer(Long roundId, Long playerId) {
        Round round = roundRepository.findById(roundId).orElse(null);
        Player player = playerService.findPlayerById(playerId);
        if (round == null || player == null) {
            return null;
        }
        round.setBestPlayer(player);
        return roundRepository.save(round);
    }
}
