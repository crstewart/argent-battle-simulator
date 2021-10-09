package com.argentstew.simulator.battle.vg.tyrael;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.tyrael
 * 8/27/2019
 *
 * @author Craig
 */
public class Sanctification extends Guard {

    public Sanctification() {
        this.name = "Sanctification";
        this.description = "Blocks all effects of attacks";
        this.initiateMessage = "becomes invulnerable!";
        this.successMessage = "negates the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
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
    public boolean isAllowed() {
        return true;
    }
}
