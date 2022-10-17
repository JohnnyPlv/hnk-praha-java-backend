package com.example.hnkprahabackend.services;

import com.example.hnkprahabackend.models.HNKPraha;
import org.springframework.stereotype.Service;

@Service
public interface HNKPrahaService {
    HNKPraha addHNKPraha(HNKPraha hnkPraha);
}
