package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Formation;
import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.Round;
import com.example.hnkprahabackend.repositories.FormationRepository;
import com.example.hnkprahabackend.repositories.RoundRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;
    private final PlayerService playerService;
    private final RoundService roundService;

    private final RoundRepository roundRepository;


    public FormationServiceImpl(FormationRepository formationRepository, PlayerService playerService, RoundService roundService, RoundRepository roundRepository) {
        this.formationRepository = formationRepository;
        this.playerService = playerService;
        this.roundService = roundService;
        this.roundRepository = roundRepository;
    }

    @Override
    public Formation createFormation(List<Long> playerIds, Long roundId) {
        List<Player> players = playerService.findPlayersByIds(playerIds);
        Round round = roundService.findRoundById(roundId);
        if (players == null || round == null) {
            return null;
        }
        Formation formation = new Formation(players);
        formationRepository.save(formation);
        round.setFormation(formation);
        roundRepository.save(round);
        return formation;
    }
}
