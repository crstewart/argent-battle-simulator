package com.argentstew.simulator.battle.web.repository;

import com.argentstew.simulator.battle.web.persistence.SeasonTwoMatch;
import com.argentstew.simulator.battle.web.persistence.SeasonTwoTeam;
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
public interface SeasonTwoMatchRepository extends JpaRepository<SeasonTwoMatch, Integer> {

    List<SeasonTwoMatch> findAllByOrderByMatchDateAsc();

    @Query("select m from SeasonTwoMatch m where m.homeTeam = ?1 or m.awayTeam = ?1 order by m.matchDate asc")
    List<SeasonTwoMatch> findAllByTeamOrderByMatchDateAsc(SeasonTwoTeam team);

    List<SeasonTwoMatch> findAllByMatchDateGreaterThanEqualAndMatchDateLessThanEqualOrderByMatchDateAsc(Date startDate,
                                                                                                        Date endDate);

    @Query("select m from SeasonTwoMatch m where (m.homeTeam = ?1 or m.awayTeam = ?1) and m.matchDate >= ?2 and m.matchDate <= ?3 order by m.matchDate asc")
    List<SeasonTwoMatch> findAllByTeamAndMatchDateGreaterThanEqualAndMatchDateLessThanEqualOrderByMatchDateAsc(SeasonTwoTeam team,
                                                                                                               Date startDate,
                                                                                                               Date endDate);
}
