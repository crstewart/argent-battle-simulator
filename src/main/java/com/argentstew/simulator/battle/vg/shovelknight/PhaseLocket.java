package com.argentstew.simulator.battle.vg.shovelknight;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.shovelknight
 * 8/24/2019
 *
 * @author Craig
 */
public class PhaseLocket extends Guard {

    private static final int MP_COST = 8;

    public PhaseLocket() {
        this.name = "Phase Locket";
        this.description = "Uses 8 SP, blocks all guardable attacks";
        this.initiateMessage = "uses the Phase Locket!";
        this.successMessage = "phased through the attack!";
        this.failureMessage = "was still struck by the attack!";
        this.speed = 1;
    }

    @Override
    public int applyDefense(int damage) {
        owner.useMagic(MP_COST);
        return 0;
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isDoable() {
        return true;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return true;
    }
}
