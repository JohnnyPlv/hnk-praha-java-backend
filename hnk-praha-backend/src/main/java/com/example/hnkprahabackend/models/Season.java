package com.example.hnkprahabackend.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String year;

    @OneToMany(mappedBy = "season",cascade = CascadeType.ALL)
    private List<Round> rounds;


    public Season() {
    }

    public Season(String year, List<Round> rounds) {
        this.year = year;
        this.rounds = new ArrayList<>(rounds);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
