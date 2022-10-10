package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.dtos.PlayerDTO;
import com.example.hnkprahabackend.models.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MappingService {
    List<PlayerDTO> mapPlayers (List<Player> listOfPlayers);
}
