package com.agile.poker.agilepoker.business;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CreatePlanningSession {

    private final PlanningSessionRepository planningSessionRepository;
    
    public CreatePlanningSession(@Qualifier("planningSessionEntityRepositoryImp") PlanningSessionRepository planningSessionRepository){
        this.planningSessionRepository = planningSessionRepository;
    }

    public PlanningSession execute(PlanningSession planningSession){
        planningSessionRepository.save(planningSession);
        return planningSession;
    }
     
}
