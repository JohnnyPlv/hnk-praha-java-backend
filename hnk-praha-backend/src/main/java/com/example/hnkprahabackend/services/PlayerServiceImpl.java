package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Player findPlayerById(Long playerId) {
        return playerRepository.findById(playerId).orElse(null);
    }

    @Override
    public Player updateNewPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player findPlayerByName(String name) {
        Optional<Player> player = playerRepository.findPlayerByLastName(name);
        return player.orElse(null);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> findPlayersByIds(List<Long> playersIds) {
        return playerRepository.findAllById(playersIds);
    }

}
