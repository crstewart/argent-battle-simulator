package com.argentstew.simulator.battle.strategy;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.XStrike;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/24/2019
 *
 * @author Craig
 */
public class BalancedStrategy extends BasicStrategy {

    public BalancedStrategy() {
        super();
    }

    public void addAction(Action action) {
        if (action instanceof XStrike) {
            super.addAction(action, 4.0);
        } else {
            super.addAction(action, 1.0);
        }
    }
}
