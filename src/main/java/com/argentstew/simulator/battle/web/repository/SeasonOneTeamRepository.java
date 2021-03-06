package com.argentstew.simulator.battle.web.repository;

import com.argentstew.simulator.battle.web.persistence.SeasonOneTeam;
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
public interface SeasonOneTeamRepository extends JpaRepository<SeasonOneTeam, Integer> {

    SeasonOneTeam findByName(String name);
}
