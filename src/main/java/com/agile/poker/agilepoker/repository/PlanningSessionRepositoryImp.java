package com.agile.poker.agilepoker.repository;

import com.agile.poker.agilepoker.business.PlanningSession;
import com.agile.poker.agilepoker.business.PlanningSessionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlanningSessionRepositoryImp implements PlanningSessionRepository {

    private List<PlanningSession> arrayPlanningSession = new ArrayList<>();
    @Override
    public PlanningSession save(PlanningSession planningSession) {
            arrayPlanningSession.add(planningSession);
            return planningSession;
    }
}
