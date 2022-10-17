package com.example.hnkprahabackend.repositories;

import com.example.hnkprahabackend.models.HNKPraha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HNKPrahaRepository extends JpaRepository<HNKPraha,Long> {
}
