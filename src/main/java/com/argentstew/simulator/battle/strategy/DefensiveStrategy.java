package com.argentstew.simulator.battle.strategy;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.attack.XStrike;
import com.argentstew.simulator.battle.action.move.Advance;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/24/2019
 *
 * @author Craig
 */
public class DefensiveStrategy extends BasicStrategy {

    public DefensiveStrategy() {
        super();
    }

    public Double addAction(Action action) {
        if (action instanceof XStrike) {
            return super.addAction(action, 6.0);
        } else if (action instanceof DefenseAction) {
            return super.addAction(action, 1.5);
        } else {
            return super.addAction(action, 1.0);
        }
    }
}
