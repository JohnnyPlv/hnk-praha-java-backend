package com.example.hnkprahabackend.dtos;

import com.example.hnkprahabackend.models.Formation;

import java.util.List;

public class FormationDTO {

    public final Long id;
    public final List<PlayerInFormationDTO> player;

    public FormationDTO(Formation formation, List<PlayerInFormationDTO> player) {
        this.id = formation.getId();
        this.player = player;
    }
}
