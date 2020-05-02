package com.argentstew.simulator.battle.web.repository;

import com.argentstew.simulator.battle.web.persistence.SeasonOneMatch;
import com.argentstew.simulator.battle.web.persistence.SeasonOneTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * com.argentstew.simulator.battle.web.repository
 * 5/2/2020
 *
 * @author argen
 */
@Repository
public interface SeasonOneMatchRepository extends JpaRepository<SeasonOneMatch, Integer> {

    List<SeasonOneMatch> findAllByOrderByMatchDateAsc();

    @Query("select m from SeasonOneMatch m where m.homeTeam = ?1 or m.awayTeam = ?1")
    List<SeasonOneMatch> findAllByTeamOrderByMatchDateAsc(SeasonOneTeam team);

    List<SeasonOneMatch> findAllByMatchDateGreaterThanEqualAndMatchDateLessThanEqualOrderByMatchDateAsc(Date startDate,
                                                                                                        Date endDate);

    @Query("select m from SeasonOneMatch m where (m.homeTeam = ?1 or m.awayTeam = ?1) and m.matchDate >= ?2 and m.matchDate <= ?3")
    List<SeasonOneMatch> findAllByTeamAndMatchDateGreaterThanEqualAndMatchDateLessThanEqualOrderByMatchDateAsc(SeasonOneTeam team,
                                                                                                               Date startDate,
                                                                                                               Date endDate);
}
