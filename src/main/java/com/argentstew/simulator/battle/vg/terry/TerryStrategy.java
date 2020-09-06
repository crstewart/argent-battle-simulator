package com.argentstew.simulator.battle.vg.terry;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.action.attack.XStrike;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.BasicStrategy;
import com.argentstew.simulator.battle.vg.inkling.RefillInk;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/24/2019
 *
 * @author Craig
 */
public class TerryStrategy extends BalancedStrategy {

    public TerryStrategy() {
        super();
    }

    public Double addAction(Action action) {
        if (action instanceof XStrike) {
            return super.addAction(action, 8.0);
        } else if (action instanceof BusterWolf || action instanceof PowerGeyser) {
            return super.addAction(action, 4.0);
        } else if (action instanceof MoveAction) {
            return super.addAction(action, 0.5);
        } else {
            return super.addAction(action, 1.0);
        }
    }
}
