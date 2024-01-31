package com.agile.poker.agilepoker.business;

import java.util.UUID;


public record PlanningSession(UUID id,String title, String deckType) {
    public static PlanningSession create(String title, String deckType){
            return  new PlanningSession(UUID.randomUUID(), title, deckType);
    }

}
