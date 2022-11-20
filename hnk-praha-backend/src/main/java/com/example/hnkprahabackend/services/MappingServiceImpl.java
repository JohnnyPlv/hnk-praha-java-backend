package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.dtos.*;
import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.Round;
import com.example.hnkprahabackend.models.Season;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MappingServiceImpl implements MappingService{

    @Override
    public List<PlayerDTO> mapPlayers(List<Player> listOfPlayers) {
        return listOfPlayers.stream().map(val -> new PlayerDTO(val)).collect(Collectors.toList());
    }

    @Override
    public List<PlayerDTO> mapPlayersInFormation(List<Player> listOfPlayers, Long roundId) {
        return listOfPlayers.stream().map(val -> new PlayerDTO(val, roundId)).collect(Collectors.toList());
    }

    @Override
    public List<SeasonDTO> mapSeasons(List<Season> listOfSeasons) {

        return listOfSeasons
                .stream()
                .map(val -> new SeasonDTO(val, mapRounds(val.getRounds())))
                .collect(Collectors.toList());
    }

    @Override
    public List<RoundDTO> mapRounds(List<Round> listOfRounds) {
        return listOfRounds.stream()
                .map(val -> val.getFormation() != null ? new RoundDTO(val, new FormationDTO(val.getFormation(),mapPlayersInFormation(val.getFormation().getPlayers(), val.getId())))
                        : new RoundDTO(val))
                .collect(Collectors.toList());
    }
}
