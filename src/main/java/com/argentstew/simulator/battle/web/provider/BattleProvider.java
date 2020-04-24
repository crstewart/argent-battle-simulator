package com.argentstew.simulator.battle.web.provider;

import com.argentstew.simulator.battle.Battle;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.BattleLogger;

/**
 * com.argentstew.simulator.battle.web.provider
 * 4/23/2020
 *
 * @author argen
 */
public interface BattleProvider {

    Battle setUpBattle(Fighter fighter1, Fighter fighter2, BattleLogger logger);
}
