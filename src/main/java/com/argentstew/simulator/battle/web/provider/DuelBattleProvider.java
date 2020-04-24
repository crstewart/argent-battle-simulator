package com.argentstew.simulator.battle.web.provider;

import com.argentstew.simulator.battle.Battle;
import com.argentstew.simulator.battle.DuelBattle;
import com.argentstew.simulator.battle.arena.DuelArena;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.BattleLogger;
import org.springframework.stereotype.Component;

/**
 * com.argentstew.simulator.battle.web.provider
 * 4/23/2020
 *
 * @author argen
 */
@Component
public class DuelBattleProvider implements BattleProvider {

    @Override
    public Battle setUpBattle(Fighter fighter1, Fighter fighter2, BattleLogger logger) {
        DuelArena arena = new DuelArena();
        arena.setLeftFighter(fighter1);
        arena.setRightFighter(fighter2);

        return new DuelBattle(fighter1, fighter2, logger);
    }
}
