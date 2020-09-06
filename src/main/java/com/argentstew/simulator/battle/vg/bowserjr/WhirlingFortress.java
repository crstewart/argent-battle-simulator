package com.argentstew.simulator.battle.vg.bowserjr;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.bowserjr
 * 8/24/2019
 *
 * @author Craig
 */
public class WhirlingFortress extends Guard {

    public WhirlingFortress() {
        this.name = "Whirling Fortress";
        this.description = "Blocks all guardable attacks, reducing damage by 80%";
        this.initiateMessage = "retreats into his shell!";
        this.successMessage = "spins quickly, deflecting the attack!";
        this.failureMessage = "failed to block the attack!";
        this.speed = 1;
    }

    @Override
    public int applyDefense(int damage) {
        return (int) Math.round(damage * 0.2);
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
