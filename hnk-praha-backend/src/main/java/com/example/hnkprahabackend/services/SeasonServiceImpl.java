package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Player;
import com.example.hnkprahabackend.models.Season;
import com.example.hnkprahabackend.repositories.SeasonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonServiceImpl implements SeasonService {
    private final SeasonRepository seasonRepository;

    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public Season addNewSeason(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public Season findSeasonByYear(String year) {
        Optional<Season> season = seasonRepository.findSeasonsByYear(year);
        return season.orElse(null);
    }

    @Override
    public List<Season> findAll() {
        return seasonRepository.findAll();
    }
}
