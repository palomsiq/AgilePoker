package com.agile.poker.agilepoker.repository;

import com.agile.poker.agilepoker.business.PlanningSession;
import com.agile.poker.agilepoker.business.PlanningSessionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Repository
public class PlanningSessionEntityRepositoryImp implements PlanningSessionRepository {

    private final PlanningSessionEntityRepository planningSessionEntityRepository;

    public PlanningSessionEntityRepositoryImp(PlanningSessionEntityRepository planningSessionEntityRepository) {
        this.planningSessionEntityRepository = planningSessionEntityRepository;
    }

    @Override
    public PlanningSession save(PlanningSession planningSession) {
        PlanningSessionEntity planningSessionEntity = new PlanningSessionEntity(planningSession.id(), planningSession.title(), planningSession.deckType());
        var entity = planningSessionEntityRepository.save(planningSessionEntity);
        return new PlanningSession(entity.getId(),entity.getTitle(),entity.getDeckType());
    }

    @Override
    public List<PlanningSession> get() {
        var interablePlanningSessionEntity = planningSessionEntityRepository.findAll();
        //convert interable to list
        var planningSessionEntityList = StreamSupport.stream(interablePlanningSessionEntity.spliterator(), false).toList();

        return planningSessionEntityList
                .stream()
                .map(planningSessionEntity ->
                        new PlanningSession(planningSessionEntity.getId(),
                                planningSessionEntity.getTitle(),
                                planningSessionEntity.getDeckType()))
                .toList();
    }
}
