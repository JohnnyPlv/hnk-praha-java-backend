package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    Player addNewPlayer(Player player);

    Player updateNewPlayer(Player player);

    Player findPlayerByName(String name);

    List<Player> findAll();
}
