package com.agile.poker.agilepoker.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "planning_session")
public class PlanningSessionEntity  {
    public PlanningSessionEntity() {
    }

    public PlanningSessionEntity(UUID id, String title, String deckType) {
        this.id = id;
        this.title = title;
        this.deckType = deckType;
    }

    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "title")
    private String title;
    @Column(name = "deck_type")
    private String deckType;

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDeckType() {
        return deckType;
    }
}
