package com.example.hnkprahabackend.repositories;

import com.example.hnkprahabackend.models.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {
}
