package com.argentstew.simulator.battle;

import com.argentstew.simulator.battle.fighter.Fighter;

/**
 * com.argentstew.simulator.battle
 * 8/21/2019
 *
 * @author Craig
 */
public interface Battle {

    void announce();
    void start();
    Fighter determineWinner();
}
