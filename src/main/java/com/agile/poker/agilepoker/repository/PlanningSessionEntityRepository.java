package com.agile.poker.agilepoker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlanningSessionEntityRepository extends CrudRepository<PlanningSessionEntity, UUID> {

}
