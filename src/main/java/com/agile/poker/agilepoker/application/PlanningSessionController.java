package com.agile.poker.agilepoker.application;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agile.poker.agilepoker.business.CreatePlanningSession;
import com.agile.poker.agilepoker.business.PlanningSession;



@RestController
@RequestMapping("/planningSession")

public class PlanningSessionController{
    
    
    private CreatePlanningSession createPlanningSession;
    public PlanningSessionController(CreatePlanningSession createPlanningSession){
       this.createPlanningSession = createPlanningSession;
    }

    @PostMapping
    public void newSession(@RequestBody InputPlanningSession inputPlanningSession){
        
        PlanningSession planningSession = PlanningSession.create(inputPlanningSession.title(), inputPlanningSession.deckType());
        createPlanningSession.execute(planningSession);
    }


}

