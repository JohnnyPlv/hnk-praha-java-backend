package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.dtos.PlayerDTO;
import com.example.hnkprahabackend.dtos.RoundDTO;
import com.example.hnkprahabackend.dtos.SeasonDTO;
import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.Round;
import com.example.hnkprahabackend.models.Season;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MappingService {
    List<PlayerDTO> mapPlayers (List<Player> listOfPlayers);
    List<SeasonDTO> mapSeasons (List<Season> listOfSeasons);
    List<RoundDTO> mapRounds (List<Round> listOfRounds);
}
