package com.argentstew.simulator.battle.vg.illidan;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.fighter.FighterTraits;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.DemonicForm;

/**
 * com.argentstew.simulator.battle.strategy
 * 8/24/2019
 *
 * @author Craig
 */
public class IllidanStrategy extends OffensiveStrategy {

    public IllidanStrategy(FighterTraits traits) {
        super();
        DemonicForm trait = traits.getTrait(DemonicForm.class);
        if (trait != null) {
            trait.setStrategy(this);
        }
    }

    public Double addAction(Action action) {
        if (action instanceof Metamorphosis) {
            return super.addAction(action, 0.5);
        } else {
            return super.addAction(action);
        }
    }
}
