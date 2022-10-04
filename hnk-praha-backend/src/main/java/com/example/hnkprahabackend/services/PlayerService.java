package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Player;
import org.springframework.stereotype.Service;

@Service
public interface PlayerService {
    Player addNewPlayer(Player player);
}
