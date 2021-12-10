package com.argentstew.simulator.battle.web.repository;

import com.argentstew.simulator.battle.web.persistence.Match;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * com.argentstew.simulator.battle.web.repository
 * 12/10/2021
 *
 * @author argen
 */
public interface MatchRepository extends CrudRepository<Match, UUID> {

    List<Match> findAllBySeasonIdOrderByStartDateAsc(UUID id);

    List<Match> findAllByHomeTeamIdOrAwayTeamIdOrderByStartDateAsc(UUID homeId, UUID awayId);

    List<Match> findAllBySeasonIdAndStartDateGreaterThanEqualAndStartDateLessThanEqualOrderByStartDateAsc(UUID id, LocalDateTime startDate, LocalDateTime endDate);

    List<Match> findAllByHomeTeamIdOrAwayTeamIdAndStartDateGreaterThanEqualAndStartDateLessThanEqualOrderByStartDateAsc(UUID homeId, UUID awayId, LocalDateTime startDate, LocalDateTime endDate);
}
