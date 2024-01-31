package com.agile.poker.agilepoker.business;

import java.util.List;

public interface PlanningSessionRepository {

    PlanningSession save(PlanningSession planningSession);

    List<PlanningSession> get();
}
