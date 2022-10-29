package com.example.hnkprahabackend.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Player> players;

    public Formation() {
    }

    public Formation(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
