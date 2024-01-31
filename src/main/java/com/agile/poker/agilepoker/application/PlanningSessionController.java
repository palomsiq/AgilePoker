package com.agile.poker.agilepoker.application;

import com.agile.poker.agilepoker.business.PlanningSessionRepository;
import com.agile.poker.agilepoker.repository.PlanningSessionRepositoryImp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.agile.poker.agilepoker.business.CreatePlanningSession;
import com.agile.poker.agilepoker.business.PlanningSession;

import java.util.List;


@RestController
@RequestMapping("/planningSession")

public class PlanningSessionController{
    
    
    private CreatePlanningSession createPlanningSession;
    private PlanningSessionRepository planningSessionRepository;
    public PlanningSessionController(CreatePlanningSession createPlanningSession, @Qualifier("planningSessionEntityRepositoryImp") PlanningSessionRepository planningSessionRepository){
       this.createPlanningSession = createPlanningSession;
       this.planningSessionRepository = planningSessionRepository;
    }

    @PostMapping
    public void newSession(@RequestBody InputPlanningSession inputPlanningSession){
        
        PlanningSession planningSession = PlanningSession.create(inputPlanningSession.title(), inputPlanningSession.deckType());
        createPlanningSession.execute(planningSession);
    }

    @GetMapping
    public List<PlanningSession> getPlanningSessions(){
       return planningSessionRepository.get();

    }


}

