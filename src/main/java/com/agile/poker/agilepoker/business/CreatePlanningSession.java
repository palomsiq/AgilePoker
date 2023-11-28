package com.agile.poker.agilepoker.business;


import org.springframework.stereotype.Component;

@Component
public class CreatePlanningSession {

    private PlanningSessionRepository planningSessionRepository;
    
    public CreatePlanningSession(PlanningSessionRepository planningSessionRepository){
        this.planningSessionRepository = planningSessionRepository;
    }

    public PlanningSession execute(PlanningSession planningSession){
        planningSessionRepository.save(planningSession);
        return planningSession;
    }
     
}
