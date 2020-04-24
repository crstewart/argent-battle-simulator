package com.argentstew.simulator.battle.factory;

import com.argentstew.simulator.battle.fighter.Fighter;

import java.util.List;

/**
 * com.argentstew.simulator.battle.factory
 * 4/23/2020
 *
 * @author argen
 */
public interface FighterFactory {

    List<String> getAllFighters();

    Fighter getFighter(String name);
}
