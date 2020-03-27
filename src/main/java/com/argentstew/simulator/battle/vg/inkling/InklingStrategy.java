package com.argentstew.simulator.battle.vg.inkling;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.attack.XStrike;
import com.argentstew.simulator.battle.strategy.BasicStrategy;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/24/2019
 *
 * @author Craig
 */
public class InklingStrategy extends BasicStrategy {

    public InklingStrategy() {
        super();
    }

    public Double addAction(Action action) {
        if (action instanceof XStrike) {
            return super.addAction(action, 6.0);
        } else if (action instanceof RefillInk) {
            return super.addAction(action, 0.1);
        } else {
            return super.addAction(action, 1.0);
        }
    }
}
