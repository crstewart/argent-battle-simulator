package com.argentstew.simulator.battle.web.repository;

import com.argentstew.simulator.battle.web.persistence.Fighter;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * com.argentstew.simulator.battle.web.repository
 * 12/20/2021
 *
 * @author argen
 */
public interface FighterRepository extends CrudRepository<Fighter, Integer> {

    Optional<Fighter> findByName(String name);
}
