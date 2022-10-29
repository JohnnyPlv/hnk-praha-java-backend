package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Season;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeasonService {

    Season addNewSeason(Season season);

    Season findSeasonByYear(String year);

    List<Season> findAll();
}
