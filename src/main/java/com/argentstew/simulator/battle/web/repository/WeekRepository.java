package com.argentstew.simulator.battle.web.repository;

import com.argentstew.simulator.battle.web.persistence.Week;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * com.argentstew.simulator.battle.web.repository
 * 12/10/2021
 *
 * @author argen
 */
public interface WeekRepository extends CrudRepository<Week, UUID> {

    List<Week> findAllBySeasonIdOrderByNumberAsc(UUID id);

    Week findBySeasonIdAndNumber(UUID id, int number);
}
