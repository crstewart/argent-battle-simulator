package com.argentstew.simulator.battle.strategy;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.XStrike;
import com.argentstew.simulator.battle.action.move.Advance;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/24/2019
 *
 * @author Craig
 */
public class OffensiveStrategy extends BasicStrategy {

    public OffensiveStrategy() {
        super();
    }

    public void addAction(Action action) {
        if (action instanceof XStrike) {
            super.addAction(action, 12.0);
        } else if (action instanceof AttackAction || action instanceof Advance) {
            super.addAction(action, 1.5);
        } else {
            super.addAction(action, 0.5);
        }
    }
}
