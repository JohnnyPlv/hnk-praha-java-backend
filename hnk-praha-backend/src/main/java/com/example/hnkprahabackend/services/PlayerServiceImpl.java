package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player addNewPlayer(Player player) {
        return playerRepository.save(player);
    }
}
