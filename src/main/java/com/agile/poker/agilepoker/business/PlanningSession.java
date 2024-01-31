package com.agile.poker.agilepoker.business;

import java.util.UUID;


public record PlanningSession(UUID id,String title, String deckType) {
    public static PlanningSession create(String title, String deckType){
            UUID uuid = UUID.randomUUID();
            return  new PlanningSession(uuid, title, deckType);
    }

}
