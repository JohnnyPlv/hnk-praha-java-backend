package com.example.hnkprahabackend.dtos;

import com.example.hnkprahabackend.models.Round;
import com.example.hnkprahabackend.models.Season;

import java.util.ArrayList;
import java.util.List;

public class SeasonDTO {
    public final Long id;
    public final List<RoundDTO> rounds;

    public SeasonDTO(Season season, List<RoundDTO> roundDTOS) {
        this.id = season.getId();
        this.rounds = roundDTOS;
    }
}
