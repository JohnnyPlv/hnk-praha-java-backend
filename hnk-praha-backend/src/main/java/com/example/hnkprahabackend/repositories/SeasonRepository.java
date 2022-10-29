package com.example.hnkprahabackend.repositories;

import com.example.hnkprahabackend.models.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    Optional<Season> findSeasonsByYear(String year);
}
