package com.argentstew.simulator.battle.vg.joker;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.attack.XStrike;
import com.argentstew.simulator.battle.strategy.BasicStrategy;
import com.argentstew.simulator.battle.vg.tracer.PulseBomb;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/24/2019
 *
 * @author Craig
 */
public class JokerStrategy extends BasicStrategy {

    public JokerStrategy() {
        super();
    }

    public Double addAction(Action action) {
        if (action instanceof XStrike) {
            return super.addAction(action, 6.0);
        } else if (action instanceof SummonArsene || action instanceof SummonVishnu || action instanceof SummonFutsunushi) {
            return super.addAction(action, 5.0);
        } else if (action instanceof RebelsGuard) {
            return super.addAction(action, 2.5);
        } else if (action instanceof Gun || action instanceof Knife) {
            return super.addAction(action, 2.0);
        } else {
            return super.addAction(action, 1.0);
        }
    }
}
