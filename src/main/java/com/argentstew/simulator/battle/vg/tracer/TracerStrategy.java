package com.argentstew.simulator.battle.vg.tracer;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.action.attack.XStrike;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.BasicStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.vg.terry.BusterWolf;
import com.argentstew.simulator.battle.vg.terry.PowerGeyser;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/24/2019
 *
 * @author Craig
 */
public class TracerStrategy extends DefensiveStrategy {

    public TracerStrategy() {
        super();
    }

    public Double addAction(Action action) {
        if (action instanceof XStrike) {
            return super.addAction(action, 8.0);
        } else if (action instanceof PulseBomb) {
            return super.addAction(action, 5.0);
        } else if (action instanceof DefenseAction) {
            return super.addAction(action, 1.5);
        } else if (action instanceof Retreat) {
            return super.addAction(action, 0.75);
        } else if (action instanceof MoveAction) {
            return super.addAction(action, 0.5);
        } else {
            return super.addAction(action, 1.0);
        }
    }
}
