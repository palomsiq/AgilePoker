package com.agile.poker.agilepoker.application;


import com.agile.poker.agilepoker.business.PlanningSession;
import com.agile.poker.agilepoker.business.PlanningSessionRepository;
import com.agile.poker.agilepoker.repository.PlanningSessionRepositoryImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PlanningSessionServiceIntegrationTest {

    private PlanningSessionRepository planningSessionRepository = new PlanningSessionRepositoryImp();

    @Test
    public void shouldReturnAllPlanningSessionWhenCreated(){
        //give
        var planningSessionGold = PlanningSession.create("p1", "gold");
        var planningSessionSilver = PlanningSession.create("p2", "silver");

        //when
        planningSessionRepository.save(planningSessionGold);
        planningSessionRepository.save(planningSessionSilver);

        //then
        List<PlanningSession> expected = planningSessionRepository.get();

        boolean matchP1 = expected.stream()
                .anyMatch(planningSession -> planningSession.title().equals("p1"));

        boolean matchP2 = expected.stream()
                .anyMatch(planningSession -> planningSession.title().equals("p2"));


        Assertions.assertAll(
                () -> Assertions.assertEquals(2, expected.size()),
                () -> Assertions.assertTrue(matchP1),
                () -> Assertions.assertTrue(matchP2)
        );
    }
}