package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Round;
import com.example.hnkprahabackend.repositories.RoundRepository;
import org.springframework.stereotype.Service;

@Service
public class RoundServiceImpl implements RoundService {

    private final RoundRepository roundRepository;

    public RoundServiceImpl(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    @Override
    public Round findRoundById(Long id) {
        if (id == null) {
            return null;
        }
        return roundRepository.findById(id).orElse(null);
    }
}
