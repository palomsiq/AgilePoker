package com.agile.poker.agilepoker.application;


import com.agile.poker.agilepoker.business.CreatePlanningSession;
import com.agile.poker.agilepoker.business.PlanningSession;
import com.agile.poker.agilepoker.business.PlanningSessionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanningSessionService {

    private final CreatePlanningSession createPlanningSession;
    private final PlanningSessionRepository planningSessionRepository;

    public PlanningSessionService(CreatePlanningSession createPlanningSession,
                                  @Qualifier("planningSessionEntityRepositoryImp") PlanningSessionRepository planningSessionRepository) {
        this.createPlanningSession = createPlanningSession;
        this.planningSessionRepository = planningSessionRepository;
    }


    public void save(InputPlanningSession inputPlanningSession){

        PlanningSession planningSession = PlanningSession.create(inputPlanningSession.title(), inputPlanningSession.deckType());
        createPlanningSession.execute(planningSession);
    }

    public List<PlanningSession> findAll(){
        return planningSessionRepository.get();
    }
}
