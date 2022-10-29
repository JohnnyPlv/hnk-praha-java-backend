package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.dtos.PlayerDTO;
import com.example.hnkprahabackend.dtos.RoundDTO;
import com.example.hnkprahabackend.dtos.SeasonDTO;
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
    public List<SeasonDTO> mapSeasons(List<Season> listOfSeasons) {

        return listOfSeasons
                .stream()
                .map(val -> new SeasonDTO(val, mapRounds(val.getRounds())))
                .collect(Collectors.toList());
    }

    @Override
    public List<RoundDTO> mapRounds(List<Round> listOfRounds) {
        return listOfRounds.stream().map(val -> new RoundDTO(val)).collect(Collectors.toList());
    }
}
