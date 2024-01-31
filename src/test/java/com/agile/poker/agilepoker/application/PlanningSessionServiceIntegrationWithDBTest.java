package com.agile.poker.agilepoker.application;


import com.agile.poker.agilepoker.business.PlanningSession;
import com.agile.poker.agilepoker.business.PlanningSessionRepository;
import com.agile.poker.agilepoker.repository.PlanningSessionEntityRepository;
import com.agile.poker.agilepoker.repository.PlanningSessionRepositoryImp;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PlanningSessionServiceIntegrationWithDBTest {

    @Autowired
    private PlanningSessionEntityRepository planningSessionEntityRepository;

    @Autowired
    @Qualifier("planningSessionEntityRepositoryImp") private PlanningSessionRepository planningSessionRepository;

    @BeforeEach
    void setUp() {
        planningSessionEntityRepository.deleteAll();
    }

    @Test
    public void shouldReturnAllPlanningSessionWhenCreated(){
        //give
        var planningSessionGold = PlanningSession.create("p1", "gold");
        var planningSessionSilver = PlanningSession.create("p2", "silver");

        //when
        planningSessionRepository.save(planningSessionGold);
        planningSessionRepository.save(planningSessionSilver);

        //then
        var expected = planningSessionRepository.get();

        var matchP1 = expected.stream()
                .anyMatch(planningSession -> planningSession.title().equals("p1"));

        var matchP2 = expected.stream()
                .anyMatch(planningSession -> planningSession.title().equals("p2"));

        Assertions.assertAll(
                () -> Assertions.assertEquals(2, expected.size()),
                () -> Assertions.assertTrue(matchP1),
                () -> Assertions.assertTrue(matchP2)
        );
    }
}