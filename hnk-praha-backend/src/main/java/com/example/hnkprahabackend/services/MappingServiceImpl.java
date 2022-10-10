package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.dtos.PlayerDTO;
import com.example.hnkprahabackend.models.Player;
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
}
