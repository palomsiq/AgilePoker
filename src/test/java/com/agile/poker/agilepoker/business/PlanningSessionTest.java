package com.agile.poker.agilepoker.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanningSessionTest {

    @Test
    void shouldReturnPlanningSessionIdWhenCreated() {
        PlanningSession planningSession = PlanningSession.create("title", "silver");

        Assertions.assertNotNull(planningSession.id());
    }
}