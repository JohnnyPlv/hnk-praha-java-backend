package com.example.hnkprahabackend.repositories;

import com.example.hnkprahabackend.models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

}
