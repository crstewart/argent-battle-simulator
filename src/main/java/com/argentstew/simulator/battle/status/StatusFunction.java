package com.argentstew.simulator.battle.status;

import com.argentstew.simulator.battle.fighter.Fighter;

/**
 * com.argentstew.simulator.battle.status
 * 9/10/2021
 *
 * @author argen
 */
public interface StatusFunction {

    boolean doesResistStatus(Fighter fighter);
}
