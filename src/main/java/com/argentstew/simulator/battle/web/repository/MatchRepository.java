package com.argentstew.simulator.battle.web.repository;

import com.argentstew.simulator.battle.web.persistence.Match;
import com.argentstew.simulator.battle.web.persistence.Team;
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

    List<Match> findAllByHomeTeamOrAwayTeamOrderByStartDateAsc(Team homeTeam, Team awayTeam);

    List<Match> findAllByStartDateBetweenAndSeasonIdOrderByStartDateAsc(LocalDateTime startDate, LocalDateTime endDate,
                                                                        UUID id);

    List<Match> findAllByStartDateBetweenAndHomeTeamOrStartDateBetweenAndAwayTeamOrderByStartDateAsc(
            LocalDateTime homeStartDate, LocalDateTime homeEndDate, Team homeTeam, LocalDateTime awayStartDate,
            LocalDateTime awayEndDate, Team awayTeam);
}
