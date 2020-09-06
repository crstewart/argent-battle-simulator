package com.argentstew.simulator.battle.vg.greninja;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.defense.Guard;
import com.argentstew.simulator.battle.trait.impl.Protean;

/**
 * com.argentstew.simulator.battle.vg.greninja
 * 8/27/2019
 *
 * @author Craig
 */
public class MatBlock extends Guard {

    private int uses;

    public MatBlock() {
        this.name = "Mat Block";
        this.description = "Has 10 uses, blocks all guardable attacks";
        this.initiateMessage = "protects itself!";
        this.successMessage = "successfully foiled the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1;
        this.uses = 10;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        this.uses -= 1;

        Protean trait = (Protean) this.owner.getTraits().getTraits().get(0);
        trait.setState(Protean.FIGHTING_TYPE);

        return true;
    }

    @Override
    public int applyDefense(int damage) {
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isDoable() {
        return uses > 0;
    }
}
