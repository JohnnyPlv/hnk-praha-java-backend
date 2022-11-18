package com.example.hnkprahabackend.dtos;

import com.example.hnkprahabackend.models.Formation;

import java.util.List;

public class FormationDTO {

    public final Long id;
    public final List<PlayerDTO> playerDTOS;

    public FormationDTO(Formation formation, List<PlayerDTO> playerDTOS) {
        this.id = formation.getId();
        this.playerDTOS = playerDTOS;
    }
}
