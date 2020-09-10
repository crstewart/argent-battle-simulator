package com.argentstew.simulator.battle.web.repository;

import com.argentstew.simulator.battle.web.persistence.SeasonTwoFighter;
import com.argentstew.simulator.battle.web.persistence.SeasonTwoTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.argentstew.simulator.battle.web.repository
 * 5/2/2020
 *
 * @author argen
 */
@Repository
@Transactional(readOnly = true)
public interface SeasonTwoFighterRepository extends JpaRepository<SeasonTwoFighter, String> {

    List<SeasonTwoFighter> findAllByTeamOrderByName(SeasonTwoTeam team);
}
