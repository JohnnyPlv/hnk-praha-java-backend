package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.Formation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormationService {
    Formation createFormation(List<Long> playerIds, Long roundId);
}
