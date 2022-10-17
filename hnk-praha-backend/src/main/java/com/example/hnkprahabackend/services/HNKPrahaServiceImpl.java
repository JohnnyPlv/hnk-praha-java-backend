package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.HNKPraha;
import com.example.hnkprahabackend.repositories.HNKPrahaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HNKPrahaServiceImpl implements HNKPrahaService {

    private final HNKPrahaRepository hnkPrahaRepository;

    @Autowired
    public HNKPrahaServiceImpl(HNKPrahaRepository hnkPrahaRepository) {
        this.hnkPrahaRepository = hnkPrahaRepository;
    }

    @Override
    public HNKPraha addHNKPraha(HNKPraha hnkPraha) {
        return hnkPrahaRepository.save(hnkPraha);
    }
}
