package com.argentstew.simulator.battle.strategy;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.action.attack.XStrike;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/24/2019
 *
 * @author Craig
 */
public class RangedStrategy extends BasicStrategy {

    public RangedStrategy() {
        super();
    }

    public Double addAction(Action action) {
        if (action instanceof XStrike) {
            return super.addAction(action, 10.0);
        } else if (action instanceof AttackAction) {
            AttackAction attack = (AttackAction) action;
            if (attack.isRequiresMeleeRange()) {
                return super.addAction(action, 0.5);
            } else {
                return super.addAction(action, 1.5);
            }
        } else if (action instanceof DefenseAction) {
            return super.addAction(action, 1.0);
        } else if (action instanceof Retreat) {
            return super.addAction(action, 1.0);
        } else if (action instanceof MoveAction) {
            return super.addAction(action, 0.5);
        } else {
            return super.addAction(action, 1.0);
        }
    }
}
