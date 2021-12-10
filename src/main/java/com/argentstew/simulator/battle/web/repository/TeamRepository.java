package com.argentstew.simulator.battle.web.repository;

import com.argentstew.simulator.battle.web.persistence.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * com.argentstew.simulator.battle.web.repository
 * 12/10/2021
 *
 * @author argen
 */
public interface TeamRepository extends CrudRepository<Team, UUID> {

    Optional<Team> getByDivisionSeasonIdAndName(UUID id, String name);

    List<Team> findAllByDivisionId(UUID id);

    List<Team> findAllByDivisionSeasonId(UUID id);
}
