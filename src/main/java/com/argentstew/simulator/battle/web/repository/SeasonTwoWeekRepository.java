package com.argentstew.simulator.battle.web.repository;

import com.argentstew.simulator.battle.web.persistence.SeasonOneWeek;
import com.argentstew.simulator.battle.web.persistence.SeasonTwoWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.argentstew.simulator.battle.web.repository
 * 5/2/2020
 *
 * @author argen
 */
@Repository
@Transactional(readOnly = true)
public interface SeasonTwoWeekRepository extends JpaRepository<SeasonTwoWeek, Integer> {

    SeasonTwoWeek findByNumberOrderByNumber(int number);
}
