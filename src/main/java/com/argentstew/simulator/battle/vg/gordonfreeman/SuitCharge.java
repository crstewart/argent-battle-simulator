package com.argentstew.simulator.battle.vg.gordonfreeman;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Guard;

/**
 * com.argentstew.simulator.battle.vg.link
 * 8/27/2019
 *
 * @author Craig
 */
public class SuitCharge extends Guard {

    public SuitCharge() {
        this.name = "Suit Charge";
        this.description = "Blocks all guardable attacks, reduces damage by 66%";
        this.initiateMessage = "charges his HEV Suit!";
        this.successMessage = "successfully defended the attack!";
        this.failureMessage = "failed to defend the attack!";
        this.speed = 1;
    }

    @Override
    protected boolean doesGuardAttack(AttackAction attack) {
        return true;
    }

    @Override
    public int applyDefense(int damage) {
        return (int) Math.round(damage * (2.0 / 3.0));
    }

    @Override
    public AttackAction doCounterAttack(AttackAction attack, int damage) {
        return null;
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
